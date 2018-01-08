package be.ehb.jenne.pocketevil.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import be.ehb.jenne.pocketevil.R;
import be.ehb.jenne.pocketevil.model.Hero;
import be.ehb.jenne.pocketevil.model.HeroClass;

/**
 * Created by Jenne on 8/01/2018.
 */

public class HeroListAdapter extends ArrayAdapter<String> {
    private List<Hero> heroList;
    private Context mContext;

    public HeroListAdapter(List<Hero> heroList, Context mContext){
        super(mContext, R.layout.listview_hero_row_layout);
        this.heroList = heroList;
        this.mContext = mContext;
    }

    public View getView(int position, View view, ViewGroup viewGroup){
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_hero_row_layout, viewGroup, false);
        }
        ImageView crest = (ImageView) view.findViewById(R.id.ivCrest);
        TextView tvHeroName = (TextView) view.findViewById(R.id.tvHeroName);
        TextView tvHeroClass = (TextView) view.findViewById(R.id.tvHeroClass);
        TextView tvHeroLevel = (TextView) view.findViewById(R.id.tvHeroLevelValue);

        Hero hero = heroList.get(position);
        //crest
        switch (HeroClass.get(hero.getHeroClassString())) {
            case BARBARIAN:
                crest.setImageResource(R.drawable.barbarian_crest_icon);
                break;
            case CRUSADER:
                crest.setImageResource(R.drawable.crusader_crest_icon);
                break;
            case DEMONHUNTER:
                crest.setImageResource(R.drawable.demon_hunter_crest_icon);
                break;
            case MONK:
                crest.setImageResource(R.drawable.monk_crest_icon);
                break;
            case NECROMANCER:
                crest.setImageResource(R.drawable.necro_crest_icon);
                break;
            case WITCHDOCTOR:
                crest.setImageResource(R.drawable.witch_doctor_crest_icon);
                break;
            case WIZARD:
                crest.setImageResource(R.drawable.wizard_crest_icon);
                break;
        }


        tvHeroName.setText(hero.getName());
        tvHeroClass.setText(hero.getHeroClassString());
        tvHeroLevel.setText(Integer.toString(hero.getLevel()));

        return view;
    }

    @Override
    public int getCount(){
        return heroList.size();
    }
}
