package be.ehb.jenne.pocketevil.controller;

/*
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import be.ehb.jenne.pocketevil.R;
import be.ehb.jenne.pocketevil.model.Hero;
import be.ehb.jenne.pocketevil.model.Profile;
import io.realm.Realm;

*/
/**
 * Created by Jenne on 8/01/2018.
 *//*


public class HeroListFragment extends ListFragment {
    private static final String ARG_PARAM1 = "profileId";
    private static final String ARG_PARAM2 = "position";

    private String profileId;
    private Profile profile;
    private int position;
    private List<Hero> herolist;

    public HeroListFragment(){

    }

    public static HeroListFragment newInstance(String profileId, int position){
        HeroListFragment fragment = new HeroListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, profileId);
        args.putInt(ARG_PARAM2, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            profileId = getArguments().getString(ARG_PARAM1);
            position = getArguments().getInt(ARG_PARAM2);
            Realm realm = Realm.getDefaultInstance();
            profile = realm.where(Profile.class).equalTo("battleTag", profileId).findFirst();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_heroes_carreer, container, false);
        ArrayList<Hero> heroList = new ArrayList<Hero>();
        for(Hero h : profile.getHeroes()){
            heroList.add(h);
        }
        herolist = heroList;
        */
/*HeroListAdapter heroListAdapter = new HeroListAdapter(heroList, this.getContext());
        setListAdapter(heroListAdapter);*//*

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        HeroListAdapter heroListAdapter = new HeroListAdapter(herolist, this.getContext());
        setListAdapter(heroListAdapter);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
*/
