package be.ehb.jenne.pocketevil.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Jenne on 29/12/2017.
 */

public class Hero extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    @Ignore
    private HeroClass heroClass;
    // Realm does not support enums, heroClassString is used for Realm instead of heroClass
    private String heroClassString;
    private int gender;
    private int level;
    private double eliteKills;
    private int paragonLevel;
    private boolean hardcore;
    private boolean seasonal;
    private boolean dead;
    private String lastUpdated;

    public Hero() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        this.heroClassString = heroClass.getClassName();
    }

    public String getHeroClassString() {
        return heroClassString;
    }

    public void setHeroClassString(String heroClassString) {
        this.heroClassString = heroClassString;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getEliteKills() {
        return eliteKills;
    }

    public void setEliteKills(double eliteKills) {
        this.eliteKills = eliteKills;
    }

    public int getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public void setHardcore(boolean hardcore) {
        this.hardcore = hardcore;
    }

    public boolean isSeasonal() {
        return seasonal;
    }

    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", heroClass=" + heroClass +
                ", gender=" + gender +
                ", level=" + level +
                ", eliteKills=" + eliteKills +
                ", paragonLevel=" + paragonLevel +
                ", hardcore=" + hardcore +
                ", seasonal=" + seasonal +
                ", dead=" + dead +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
