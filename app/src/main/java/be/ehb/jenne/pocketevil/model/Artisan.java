package be.ehb.jenne.pocketevil.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Jenne on 29/12/2017.
 */

public class Artisan extends RealmObject{
    @Ignore
    private ArtisanClass artisanClass;
    // Realm does not support enums, artisanClassString is used for Realm instead of artisanClass
    private String artisanClassString;
    private int level;
    private int stepCurrent;
    private int stepMax;

    public Artisan() {
    }

    public ArtisanClass getArtisanClass() {
        return artisanClass;
    }

    public void setArtisanClass(ArtisanClass artisanClass) {
        this.artisanClass = artisanClass;
        this.artisanClassString = artisanClass.getClassName();
    }

    public String getArtisanClassString() {
        return artisanClassString;
    }

    public void setArtisanClassString(String artisanClassString) {
        this.artisanClassString = artisanClassString;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStepCurrent() {
        return stepCurrent;
    }

    public void setStepCurrent(int stepCurrent) {
        this.stepCurrent = stepCurrent;
    }

    public int getStepMax() {
        return stepMax;
    }

    public void setStepMax(int stepMax) {
        this.stepMax = stepMax;
    }

    @Override
    public String toString() {
        return "Artisan{" +
                "artisanClass=" + artisanClass +
                ", level=" + level +
                ", stepCurrent=" + stepCurrent +
                ", stepMax=" + stepMax +
                '}';
    }
}
