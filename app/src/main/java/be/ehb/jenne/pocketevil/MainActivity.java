package be.ehb.jenne.pocketevil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import be.ehb.jenne.pocketevil.model.CustomRequest;
import be.ehb.jenne.pocketevil.model.Profile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TESTCODE
//        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
//        String url = "https://eu.api.battle.net/d3/profile/Jentonic-21485/?locale=en_GB&apikey=nxu7d9qkgrf7hdctfq9xek26m57gcjaz";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
//            @Override
//            public void onResponse(String response){
//                Log.d("Test", "onResponse: " + response);
//            }
//        }, new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error){
//                Log.d("Error", "onErrorResponse: " + error.toString());
//            }
//        });
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//
//        Log.d("RemoveMe", "removeme ");

        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        String url = "https://eu.api.battle.net/d3/profile/Jentonic-21485/?locale=en_GB&apikey=nxu7d9qkgrf7hdctfq9xek26m57gcjaz";
        CustomRequest customRequest = new CustomRequest(url, Profile.class, null, new Response.Listener<Profile>(){
            @Override
            public void onResponse(Profile response){
                Log.d("Test", "onResponse: " + response.toString());
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.d("Error", "onErrorResponse: " + error.toString());
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(customRequest);

    }

}
