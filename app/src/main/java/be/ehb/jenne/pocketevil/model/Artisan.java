package be.ehb.jenne.pocketevil.model;

/**
 * Created by Jenne on 29/12/2017.
 */

class Artisan {
    private ArtisanClass artisanClass;
    private int level;
    private int stepCurrent;
    private int stepMax;

    public ArtisanClass getArtisanClass() {
        return artisanClass;
    }

    public void setArtisanClass(ArtisanClass artisanClass) {
        this.artisanClass = artisanClass;
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
