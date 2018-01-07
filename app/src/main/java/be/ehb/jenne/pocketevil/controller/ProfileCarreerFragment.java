package be.ehb.jenne.pocketevil.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

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
            profile = realm.where(Profile.class).equalTo("battleTag", profileId).findFirst();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_carreer, container, false);
        NumberFormat doubleToPercentageFormat = NumberFormat.getPercentInstance();
        doubleToPercentageFormat.setMinimumFractionDigits(1);

        //region STATS
        TextView tvLifetimeKills = (TextView) view.findViewById(R.id.killsLifetimeValue);
        tvLifetimeKills.setText(String.format("%.0f", profile.getKillsMonsters()));

        TextView tvEliteKills = (TextView) view.findViewById(R.id.killsEliteValue);
        tvEliteKills.setText(String.format("%.0f", profile.getKillsElites()));

        TextView tvParagonLevel = (TextView) view.findViewById(R.id.paragonLevelValue);
        tvParagonLevel.setText(Integer.toString(profile.getParagonLevel()));
        //endregion
        //region TIME PLAYED BY CLASS
        TextView tvBarbarianTime= (TextView) view.findViewById(R.id.tvBarbarianValue);
        tvBarbarianTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedBarbarian())));

        TextView tvCrusaderTime= (TextView) view.findViewById(R.id.tvCrusaderValue);
        tvCrusaderTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedCrusader())));

        TextView tvDemonHunterTime= (TextView) view.findViewById(R.id.tvDemonHunterValue);
        tvDemonHunterTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedDemonHunter())));

        TextView tvMonkTime= (TextView) view.findViewById(R.id.tvMonkValue);
        tvMonkTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedMonk())));

        TextView tvNecromancerTime= (TextView) view.findViewById(R.id.tvNecromancerValue);
        tvNecromancerTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedNecromancer())));

        TextView tvWitchDoctorTime= (TextView) view.findViewById(R.id.tvWitchDoctorValue);
        tvWitchDoctorTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedWitchDoctor())));

        TextView tvWizardTime= (TextView) view.findViewById(R.id.tvWizardValue);
        tvWizardTime.setText(doubleToPercentageFormat.format(profile.getPercentagePlayed(profile.getTimePlayedWizard())));
        //endregion
        //region PROGRESSION
        TextView tvAct1 = (TextView) view.findViewById(R.id.tvAct1Value);
        if(profile.isProgressionAct1()) {
            tvAct1.setText(getResources().getString(R.string.fragment_carreer_act_completed));
            Log.i("test", getResources().getString(R.string.fragment_carreer_act_completed));
        }
        else
            tvAct1.setText(getResources().getString(R.string.fragment_carreer_act_uncompleted));

        TextView tvAct2 = (TextView) view.findViewById(R.id.tvAct2Value);
        if(profile.isProgressionAct1())
            tvAct2.setText(getResources().getString(R.string.fragment_carreer_act_completed));
        else
            tvAct2.setText(getResources().getString(R.string.fragment_carreer_act_uncompleted));

        TextView tvAct3 = (TextView) view.findViewById(R.id.tvAct3Value);
        if(profile.isProgressionAct3())
            tvAct3.setText(getResources().getString(R.string.fragment_carreer_act_completed));
        else
            tvAct3.setText(getResources().getString(R.string.fragment_carreer_act_uncompleted));

        TextView tvAct4 = (TextView) view.findViewById(R.id.tvAct4Value);
        if(profile.isProgressionAct4())
            tvAct4.setText(getResources().getString(R.string.fragment_carreer_act_completed));
        else
            tvAct4.setText(getResources().getString(R.string.fragment_carreer_act_uncompleted));

        TextView tvAct5 = (TextView) view.findViewById(R.id.tvAct5Value);
        if(profile.isProgressionAct1())
            tvAct5.setText(getResources().getString(R.string.fragment_carreer_act_completed));
        else
            tvAct5.setText(getResources().getString(R.string.fragment_carreer_act_uncompleted));
        //endregion
        //region ARTISANS
        TextView tvBlacksmith = (TextView) view.findViewById(R.id.tvBlacksmithValue);
        tvBlacksmith.setText(Integer.toString(profile.getBlacksmith().getLevel()));

        TextView tvBlacksmithHardcore = (TextView) view.findViewById(R.id.tvBlacksmithHardcoreValue);
        tvBlacksmithHardcore.setText(Integer.toString(profile.getBlacksmithHardcore().getLevel()));

        TextView tvJeweler = (TextView) view.findViewById(R.id.tvJewelerValue);
        tvJeweler.setText(Integer.toString(profile.getJeweler().getLevel()));

        TextView tvJewelerHardcore = (TextView) view.findViewById(R.id.tvJewelerHardcoreValue);
        tvJewelerHardcore.setText(Integer.toString(profile.getJewelerHardcore().getLevel()));

        TextView tvMystic = (TextView) view.findViewById(R.id.tvMysticValue);
        tvMystic.setText(Integer.toString(profile.getMystic().getLevel()));

        TextView tvMysticHardcore = (TextView) view.findViewById(R.id.tvMysticHardcoreValue);
        tvMysticHardcore.setText(Integer.toString(profile.getMysticHardcore().getLevel()));
        //endregion

        return view;
    }

}
