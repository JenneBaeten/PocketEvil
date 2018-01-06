package be.ehb.jenne.pocketevil.controller;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import be.ehb.jenne.pocketevil.R;

public class OverviewProfileActivity extends AppCompatActivity {
    private final String TAG = "OverviewProfileActivity";
    private String profileId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_profile);

        profileId = getIntent().getStringExtra("PROFILE_ID");

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpViewPager);
        ProfileFragmentPagerAdapter profileFragmentPagerAdapter = new ProfileFragmentPagerAdapter(getSupportFragmentManager(), this, profileId);
        viewPager.setAdapter(profileFragmentPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tlTabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
