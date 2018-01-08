package be.ehb.jenne.pocketevil.model;

import android.util.Log;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Jenne on 29/12/2017.
 */

public class Profile extends RealmObject {
    @PrimaryKey
    private String battleTag;
    private int paragonLevel;
    private int paragonLevelHardcore;
    private int paragonLevelSeason;
    private int paragonLevelSeasonHardcore;
    private String guildName;
    private RealmList<Hero> heroes;
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
    private RealmList<Hero> fallenHeroes;
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
    private RealmList<ProfileSeasonal> profileSeasonal;

    public Profile() {
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

    public RealmList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(RealmList<Hero> heroes) {
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

    public double getTimePlayedNecromancer() {
        return timePlayedNecromancer;
    }

    public void setTimePlayedNecromancer(double timePlayedNecromancer) {
        this.timePlayedNecromancer = timePlayedNecromancer;
    }

    public double getTimePlayedWitchDoctor() {
        return timePlayedWitchDoctor;
    }

    public void setTimePlayedWitchDoctor(double timePlayedWitchDoctor) {
        this.timePlayedWitchDoctor = timePlayedWitchDoctor;
    }

    public double getTimePlayedWizard() {
        return timePlayedWizard;
    }

    public void setTimePlayedWizard(double timePlayedWizard) {
        this.timePlayedWizard = timePlayedWizard;
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

    public RealmList<Hero> getFallenHeroes() {
        return fallenHeroes;
    }

    public void setFallenHeroes(RealmList<Hero> fallenHeroes) {
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

    public Artisan getBlacksmithSeasonHardcore() {
        return blacksmithSeasonHardcore;
    }

    public void setBlacksmithSeasonHardcore(Artisan blacksmithSeasonHardcore) {
        this.blacksmithSeasonHardcore = blacksmithSeasonHardcore;
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

    public Artisan getJewelerSeasonHardcore() {
        return jewelerSeasonHardcore;
    }

    public void setJewelerSeasonHardcore(Artisan jewelerSeasonHardcore) {
        this.jewelerSeasonHardcore = jewelerSeasonHardcore;
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

    public Artisan getMysticSeasonHardcore() {
        return mysticSeasonHardcore;
    }

    public void setMysticSeasonHardcore(Artisan mysticSeasonHardcore) {
        this.mysticSeasonHardcore = mysticSeasonHardcore;
    }

    public RealmList<ProfileSeasonal> getProfileSeasonal() {
        return profileSeasonal;
    }

    public void setProfileSeasonal(RealmList<ProfileSeasonal> profileSeasonal) {
        this.profileSeasonal = profileSeasonal;
    }

    public void stringSetter(String value, String propertyName){
        switch(propertyName) {
            case ("battleTag"):
                this.battleTag = (String)value;
                break;
            case("guildName"):
                this.guildName = value;
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
            case("lastHeroPlayed"):
                Integer valLastHeroPlayed = (int)value;
                this.lastHeroPlayed = valLastHeroPlayed.toString();
                break;
            case("lastUpdated"):
                Integer valLastUpdated = (int)value;
                this.lastUpdated = valLastUpdated.toString();
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

    public double getPercentagePlayed(double input) {
        return input / (timePlayedBarbarian + timePlayedCrusader + timePlayedDemonHunter + timePlayedMonk + timePlayedNecromancer + timePlayedWitchDoctor + timePlayedWizard);
    }
}

