package be.ehb.jenne.pocketevil.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import be.ehb.jenne.pocketevil.R;

/**
 * Created by Jenne on 6/01/2018.
 */

public class ProfileFragmentPagerAdapter extends FragmentPagerAdapter{
    final int PAGE_COUNT = 2;
    private Context mContext;
    private String profileId;

    public ProfileFragmentPagerAdapter(FragmentManager fm, Context context, String profileId) {
        super(fm);
        this.mContext = context;
        this.profileId = profileId;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case(0):
                fragment = ProfileCarreerFragment.newInstance(profileId, position);
                break;
            case(1):
                fragment = ProfileHeroFragment.newInstance(profileId, position);
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return mContext.getString(R.string.tab_name_overview_profile_carreer);
        else
            return mContext.getString(R.string.tab_name_overview_profile_heroes);
    }
}
