package be.ehb.jenne.pocketevil.controller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import be.ehb.jenne.pocketevil.R;
import be.ehb.jenne.pocketevil.VolleySingleton;
import be.ehb.jenne.pocketevil.VolleyRequest.ProfileRequest;
import be.ehb.jenne.pocketevil.model.Profile;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class SearchProfileActivity extends AppCompatActivity {
    private final String TAG = "SearchProfileActivity";

    private Context mContext;

    //private Toolbar toolbar;
    private EditText editText;
    private Button button;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_profile);

        mContext = getApplicationContext();
        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        editText = findViewById(R.id.profileTextInput);
        spinner = findViewById(R.id.progressBar);
        button = findViewById(R.id.profileSearchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().equals("") || editText.getText().toString() == null){
                    Snackbar.make(findViewById(R.id.svScrollView), R.string.search_battle_tag_empty, Snackbar.LENGTH_SHORT).show();
                }
                else {
                    ApplicationInfo applicationInfo = null;
                    try {
                        applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bundle bundle = applicationInfo.metaData;
                    final String apiKey = bundle.getString("blizzard_api_key");
                    String url = "https://eu.api.battle.net/d3/profile/" + editText.getText() + "/?locale=en_GB&apikey=" + apiKey;
                    spinner.setVisibility(View.VISIBLE);
                    ProfileRequest profileRequest = new ProfileRequest(url,null, new Response.Listener<Profile>() {
                        @Override
                        public void onResponse(Profile response) {
                            if(response != null && !response.getBattleTag().equals("")) {
                                Realm realm = Realm.getDefaultInstance();
                                try {
                                    realm.beginTransaction();
                                    realm.insertOrUpdate(response);
                                    realm.commitTransaction();
                                    Intent intent = new Intent(getBaseContext(), OverviewProfileActivity.class);
                                    intent.putExtra("PROFILE_ID", response.getBattleTag());
                                    spinner.setVisibility(View.GONE);
                                    startActivity(intent);
                                } catch (IllegalStateException e){
                                    Log.e(TAG, "profileRequest onResponse: ", e);
                                } catch (RealmPrimaryKeyConstraintException e) {
                                    Log.i(TAG, "profileRequest onResponse: ", e);
                                } finally {
                                    realm.close();
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            //Toast toast = Toast.makeText(mContext, error.toString().replaceFirst("com.android.volley.VolleyError: ", ""), Toast.LENGTH_SHORT);
                            //toast.show();
                            spinner.setVisibility(View.GONE);
                            Snackbar.make(findViewById(R.id.svScrollView), error.toString().replaceFirst("com.android.volley.VolleyError: ", ""), Snackbar.LENGTH_SHORT).show();
                            Log.d(TAG, "onErrorResponse: " + error.toString());
                        }
                    });
                    VolleySingleton.getInstance(mContext).addToRequestQueue(profileRequest);
                }
            }
        });
        spinner.setVisibility(View.GONE);
        //toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_search_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.diablo3_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }


}
