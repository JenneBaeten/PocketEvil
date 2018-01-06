package be.ehb.jenne.pocketevil.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.ehb.jenne.pocketevil.R;
import be.ehb.jenne.pocketevil.model.Profile;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileCarreerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileCarreerFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "profileId";
    private static final String ARG_PARAM2 = "position";

    // TODO: Rename and change types of parameters
    private String profileId;
    private Profile profile;
    private int position;

    public ProfileCarreerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param profileId The Id of the displayed profile
     * @return A new instance of fragment ProfileCarreerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileCarreerFragment newInstance(String profileId, int position) {
        ProfileCarreerFragment fragment = new ProfileCarreerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, profileId);
        args.putInt(ARG_PARAM2, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileId = getArguments().getString(ARG_PARAM1);
            position = getArguments().getInt(ARG_PARAM2);
            Realm realm = Realm.getDefaultInstance();
            try {
                profile = realm.where(Profile.class).equalTo("battleTag", profileId).findFirst();
            } finally {
                realm.close();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_carreer, container, false);
        return view;
    }

}
