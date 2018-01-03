package be.ehb.jenne.pocketevil.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jenne on 29/12/2017.
 */

public class Profile {
    private String battleTag;
    private int paragonLevel;
    private int paragonLevelHardcore;
    private int paragonLevelSeason;
    private int paragonLevelSeasonHardcore;
    private String guildName;
    private List<Hero> heroes;
    private String lastHeroPlayed;
    private String lastUpdated;
    private double killsMonsters;
    private double killsElites;
    private double killsMonstersHardcore;
    private int highestHardcoreLevel;
    private double timePlayedBarbarian;
    private double timePlayedCrusader;
    private double timePlayedDemonHunter;
    private double timePlayedMonk;
    private double timePlayedNecromancer;
    private double timePlayedWitchDoctor;
    private double timePlayedWizard;
    private boolean progressionAct1;
    private boolean progressionAct2;
    private boolean progressionAct3;
    private boolean progressionAct4;
    private boolean progressionAct5;
    private List<Hero> fallenHeroes;
    private Artisan blacksmith;
    private Artisan blacksmithHardcore;
    private Artisan blacksmithSeason;
    private Artisan blacksmithSeasonHardcore;
    private Artisan jeweler;
    private Artisan jewelerHardcore;
    private Artisan jewelerSeason;
    private Artisan jewelerSeasonHardcore;
    private Artisan mystic;
    private Artisan mysticHardcore;
    private Artisan mysticSeason;
    private Artisan mysticSeasonHardcore;
    private List<ProfileSeasonal> profileSeasonal;

    public Profile() {
    }

    public Profile(String battleTag, int paragonLevel, int paragonLevelHardcore, int paragonLevelSeason, int paragonLevelSeasonHardcore, String guildName, ArrayList<Hero> heroes, String lastHeroPlayed, String lastUpdated, double killsMonsters, double killsElites, double killsMonstersHardcore, int highestHardcoreLevel, double timePlayedBarbarian, double timePlayedCrusader, double timePlayedDemonHunter, double timePlayedMonk, double timePlayedWitchDoctor, boolean progressionAct1, boolean progressionAct2, boolean progressionAct3, boolean progressionAct4, boolean progressionAct5, ArrayList<Hero> fallenHeroes, Artisan blacksmith, Artisan blacksmithHardcore, Artisan blacksmithSeason, Artisan jeweler, Artisan jewelerHardcore, Artisan jewelerSeason, Artisan mystic, Artisan mysticHardcore, Artisan mysticSeason, ArrayList<ProfileSeasonal> profileSeasonal) {
        this.battleTag = battleTag;
        this.paragonLevel = paragonLevel;
        this.paragonLevelHardcore = paragonLevelHardcore;
        this.paragonLevelSeason = paragonLevelSeason;
        this.paragonLevelSeasonHardcore = paragonLevelSeasonHardcore;
        this.guildName = guildName;
        heroes = heroes;
        this.lastHeroPlayed = lastHeroPlayed;
        this.lastUpdated = lastUpdated;
        this.killsMonsters = killsMonsters;
        this.killsElites = killsElites;
        this.killsMonstersHardcore = killsMonstersHardcore;
        this.highestHardcoreLevel = highestHardcoreLevel;
        this.timePlayedBarbarian = timePlayedBarbarian;
        this.timePlayedCrusader = timePlayedCrusader;
        this.timePlayedDemonHunter = timePlayedDemonHunter;
        this.timePlayedMonk = timePlayedMonk;
        this.timePlayedWitchDoctor = timePlayedWitchDoctor;
        this.progressionAct1 = progressionAct1;
        this.progressionAct2 = progressionAct2;
        this.progressionAct3 = progressionAct3;
        this.progressionAct4 = progressionAct4;
        this.progressionAct5 = progressionAct5;
        this.fallenHeroes = fallenHeroes;
        this.blacksmith = blacksmith;
        this.blacksmithHardcore = blacksmithHardcore;
        this.blacksmithSeason = blacksmithSeason;
        this.jeweler = jeweler;
        this.jewelerHardcore = jewelerHardcore;
        this.jewelerSeason = jewelerSeason;
        this.mystic = mystic;
        this.mysticHardcore = mysticHardcore;
        this.mysticSeason = mysticSeason;
        this.profileSeasonal = profileSeasonal;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public int getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public int getParagonLevelHardcore() {
        return paragonLevelHardcore;
    }

    public void setParagonLevelHardcore(int paragonLevelHardcore) {
        this.paragonLevelHardcore = paragonLevelHardcore;
    }

    public int getParagonLevelSeason() {
        return paragonLevelSeason;
    }

    public void setParagonLevelSeason(int paragonLevelSeason) {
        this.paragonLevelSeason = paragonLevelSeason;
    }

    public int getParagonLevelSeasonHardcore() {
        return paragonLevelSeasonHardcore;
    }

    public void setParagonLevelSeasonHardcore(int paragonLevelSeasonHardcore) {
        this.paragonLevelSeasonHardcore = paragonLevelSeasonHardcore;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getLastHeroPlayed() {
        return lastHeroPlayed;
    }

    public void setLastHeroPlayed(String lastHeroPlayed) {
        this.lastHeroPlayed = lastHeroPlayed;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getKillsMonsters() {
        return killsMonsters;
    }

    public void setKillsMonsters(double killsMonsters) {
        this.killsMonsters = killsMonsters;
    }

    public double getKillsElites() {
        return killsElites;
    }

    public void setKillsElites(double killsElites) {
        this.killsElites = killsElites;
    }

    public double getKillsMonstersHardcore() {
        return killsMonstersHardcore;
    }

    public void setKillsMonstersHardcore(double killsMonstersHardcore) {
        this.killsMonstersHardcore = killsMonstersHardcore;
    }

    public int getHighestHardcoreLevel() {
        return highestHardcoreLevel;
    }

    public void setHighestHardcoreLevel(int highestHardcoreLevel) {
        this.highestHardcoreLevel = highestHardcoreLevel;
    }

    public double getTimePlayedBarbarian() {
        return timePlayedBarbarian;
    }

    public void setTimePlayedBarbarian(double timePlayedBarbarian) {
        this.timePlayedBarbarian = timePlayedBarbarian;
    }

    public double getTimePlayedCrusader() {
        return timePlayedCrusader;
    }

    public void setTimePlayedCrusader(double timePlayedCrusader) {
        this.timePlayedCrusader = timePlayedCrusader;
    }

    public double getTimePlayedDemonHunter() {
        return timePlayedDemonHunter;
    }

    public void setTimePlayedDemonHunter(double timePlayedDemonHunter) {
        this.timePlayedDemonHunter = timePlayedDemonHunter;
    }

    public double getTimePlayedMonk() {
        return timePlayedMonk;
    }

    public void setTimePlayedMonk(double timePlayedMonk) {
        this.timePlayedMonk = timePlayedMonk;
    }

    public double getTimePlayedWitchDoctor() {
        return timePlayedWitchDoctor;
    }

    public void setTimePlayedWitchDoctor(double timePlayedWitchDoctor) {
        this.timePlayedWitchDoctor = timePlayedWitchDoctor;
    }

    public boolean isProgressionAct1() {
        return progressionAct1;
    }

    public void setProgressionAct1(boolean progressionAct1) {
        this.progressionAct1 = progressionAct1;
    }

    public boolean isProgressionAct2() {
        return progressionAct2;
    }

    public void setProgressionAct2(boolean progressionAct2) {
        this.progressionAct2 = progressionAct2;
    }

    public boolean isProgressionAct3() {
        return progressionAct3;
    }

    public void setProgressionAct3(boolean progressionAct3) {
        this.progressionAct3 = progressionAct3;
    }

    public boolean isProgressionAct4() {
        return progressionAct4;
    }

    public void setProgressionAct4(boolean progressionAct4) {
        this.progressionAct4 = progressionAct4;
    }

    public boolean isProgressionAct5() {
        return progressionAct5;
    }

    public void setProgressionAct5(boolean progressionAct5) {
        this.progressionAct5 = progressionAct5;
    }

    public List<Hero> getFallenHeroes() {
        return fallenHeroes;
    }

    public void setFallenHeroes(ArrayList<Hero> fallenHeroes) {
        this.fallenHeroes = fallenHeroes;
    }

    public Artisan getBlacksmith() {
        return blacksmith;
    }

    public void setBlacksmith(Artisan blacksmith) {
        this.blacksmith = blacksmith;
    }

    public Artisan getBlacksmithHardcore() {
        return blacksmithHardcore;
    }

    public void setBlacksmithHardcore(Artisan blacksmithHardcore) {
        this.blacksmithHardcore = blacksmithHardcore;
    }

    public Artisan getBlacksmithSeason() {
        return blacksmithSeason;
    }

    public void setBlacksmithSeason(Artisan blacksmithSeason) {
        this.blacksmithSeason = blacksmithSeason;
    }

    public Artisan getJeweler() {
        return jeweler;
    }

    public void setJeweler(Artisan jeweler) {
        this.jeweler = jeweler;
    }

    public Artisan getJewelerHardcore() {
        return jewelerHardcore;
    }

    public void setJewelerHardcore(Artisan jewelerHardcore) {
        this.jewelerHardcore = jewelerHardcore;
    }

    public Artisan getJewelerSeason() {
        return jewelerSeason;
    }

    public void setJewelerSeason(Artisan jewelerSeason) {
        this.jewelerSeason = jewelerSeason;
    }

    public Artisan getMystic() {
        return mystic;
    }

    public void setMystic(Artisan mystic) {
        this.mystic = mystic;
    }

    public Artisan getMysticHardcore() {
        return mysticHardcore;
    }

    public void setMysticHardcore(Artisan mysticHardcore) {
        this.mysticHardcore = mysticHardcore;
    }

    public Artisan getMysticSeason() {
        return mysticSeason;
    }

    public void setMysticSeason(Artisan mysticSeason) {
        this.mysticSeason = mysticSeason;
    }

    public List<ProfileSeasonal> getProfileSeasonal() {
        return profileSeasonal;
    }

    public void setProfileSeasonal(List<ProfileSeasonal> profileSeasonal) {
        this.profileSeasonal = profileSeasonal;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "battleTag='" + battleTag + '\'' +
                ", paragonLevel=" + paragonLevel +
                ", paragonLevelHardcore=" + paragonLevelHardcore +
                ", paragonLevelSeason=" + paragonLevelSeason +
                ", paragonLevelSeasonHardcore=" + paragonLevelSeasonHardcore +
                ", guildName='" + guildName + '\'' +
                ", Heroes=" + heroes +
                ", lastHeroPlayed='" + lastHeroPlayed + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", killsMonsters=" + killsMonsters +
                ", killsElites=" + killsElites +
                ", killsMonstersHardcore=" + killsMonstersHardcore +
                ", highestHardcoreLevel=" + highestHardcoreLevel +
                ", timePlayedBarbarian=" + timePlayedBarbarian +
                ", timePlayedCrusader=" + timePlayedCrusader +
                ", timePlayedDemonHunter=" + timePlayedDemonHunter +
                ", timePlayedMonk=" + timePlayedMonk +
                ", timePlayedWitchDoctor=" + timePlayedWitchDoctor +
                ", progressionAct1=" + progressionAct1 +
                ", progressionAct2=" + progressionAct2 +
                ", progressionAct3=" + progressionAct3 +
                ", progressionAct4=" + progressionAct4 +
                ", progressionAct5=" + progressionAct5 +
                ", blacksmith=" + blacksmith +
                ", blacksmithHardcore=" + blacksmithHardcore +
                ", blacksmithSeason=" + blacksmithSeason +
                ", jeweler=" + jeweler +
                ", jewelerHardcore=" + jewelerHardcore +
                ", jewelerSeason=" + jewelerSeason +
                ", mystic=" + mystic +
                ", mysticHardcore=" + mysticHardcore +
                ", mysticSeason=" + mysticSeason +
                ", profileSeasonal=" + profileSeasonal +
                '}';
    }
    public void stringSetter(String value, String propertyName){
        switch(propertyName) {
            case ("battleTag"):
                this.battleTag = (String)value;
                break;
            case("guildName"):
                this.guildName = value;
                break;
            case("lastHeroPlayed"):
                this.lastHeroPlayed = value;
                break;
            case("lastUpdated"):
                this.lastUpdated = value;
                break;
            default:
                Log.d("ProfileSetter", "stringSetter: unsupported propertyname: " + propertyName);
        }
    }
    public void numberSetter(double value, String propertyName){
        switch(propertyName){
            case ("paragonLevel"):
                this.paragonLevel = (int)value;
                break;
            case("paragonLevelHardcore"):
                this.paragonLevelHardcore = (int)value;
                break;
            case("paragonLevelSeason"):
                this.paragonLevelSeason = (int)value;
                break;
            case("paragonLevelSeasonHardcore"):
                this.paragonLevelSeasonHardcore = (int)value;
                break;
            case("monsters"):
                this.killsMonsters = value;
                break;
            case("elites"):
                this.killsElites = value;
                break;
            case("hardcoreMonsters"):
                this.killsMonstersHardcore = value;
                break;
            case("highestHardcoreLevel"):
                this.highestHardcoreLevel = (int)value;
                break;
            case("barbarian"):
                this.timePlayedBarbarian = value;
                break;
            case("crusader"):
                this.timePlayedCrusader = value;
                break;
            case("demon-hunter"):
                this.timePlayedDemonHunter = value;
                break;
            case("monk"):
                this.timePlayedMonk = value;
                break;
            case("necromancer"):
                this.timePlayedNecromancer = value;
                break;
            case("witch-doctor"):
                this.timePlayedWitchDoctor = value;
                break;
            case("wizard"):
                this.timePlayedWizard = value;
                break;
            default:
                Log.d("ProfileSetter", "numberSetter: unsupported propertyname: " + propertyName);
        }
    }
    public void boolSetter(boolean value, String propertyName) {
        switch (propertyName) {
            case ("act1"):
                this.progressionAct1 = value;
                break;
            case ("act2"):
                this.progressionAct2 = value;
                break;
            case ("act3"):
                this.progressionAct3 = value;
                break;
            case ("act4"):
                this.progressionAct4 = value;
                break;
            case ("act5"):
                this.progressionAct5 = value;
                break;
            default:
                Log.d("ProfileSetter", "invokeSetter: unsupported propertyname: " + propertyName);
        }
    }
}

