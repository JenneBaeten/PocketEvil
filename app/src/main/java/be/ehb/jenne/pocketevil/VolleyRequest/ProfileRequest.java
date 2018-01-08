package be.ehb.jenne.pocketevil.VolleyRequest;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import be.ehb.jenne.pocketevil.model.Artisan;
import be.ehb.jenne.pocketevil.model.ArtisanClass;
import be.ehb.jenne.pocketevil.model.Hero;
import be.ehb.jenne.pocketevil.model.HeroClass;
import be.ehb.jenne.pocketevil.model.Profile;
import be.ehb.jenne.pocketevil.model.ProfileSeasonal;
import io.realm.RealmList;

/**
 * Created by Jenne on 29/12/2017.
 * Code from documentation:
 * https://developer.android.com/training/volley/request-custom.html
 */

public class ProfileRequest extends Request<Profile> {
    private final String TAG = "ProfileRequest";
    private final Gson gson = new Gson();
    private final Map<String, String> headers;
    private final Response.Listener<Profile> listener;

    public ProfileRequest(String url, Map<String, String> headers, Response.Listener<Profile> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(Profile response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<Profile> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    parseProfileRequest(json),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (VolleyError volleyError) {
            return Response.error(volleyError);
        }
    }
    private Profile parseProfileRequest(String json) throws VolleyError{
        Profile profile = new Profile();
        StringReader stringReader = new StringReader(json);
        JsonReader jsonReader = new JsonReader(stringReader);
        boolean documentClosed = false;
        String propertyName = "";
        Log.d(TAG, "parseProfileRequest json: " + json);
        while(!documentClosed){
            try{
                Log.v(TAG, "parseProfileRequest: peek:" + jsonReader.peek());
                switch(jsonReader.peek()){
                    case BEGIN_ARRAY:
                        Log.v(TAG, "parseProfileRequest: Begin Array");
                        jsonReader.beginArray();
                        break;
                    case BEGIN_OBJECT:
                        Log.v(TAG, "parseProfileRequest: Begin Object");
                        jsonReader.beginObject();
                        break;
                    case END_ARRAY:
                        Log.v(TAG, "parseProfileRequest: End Array");
                        jsonReader.endArray();
                        break;
                    case END_DOCUMENT:
                        Log.v(TAG, "parseProfileRequest: End Document");
                        jsonReader.close();
                        documentClosed = true;
                        break;
                    case END_OBJECT:
                        Log.v(TAG, "parseProfileRequest: End Object");
                        jsonReader.endObject();
                        break;
                    case NAME:
                        propertyName = jsonReader.nextName();
                        Log.v(TAG, "parseProfileRequest: Name: " + propertyName);
                        //region Heroes
                        if(propertyName.equals("heroes")){
                            jsonReader.beginArray();
                            RealmList<Hero> heroList = new RealmList<>();
                            profile.setHeroes(heroList);
                            while(jsonReader.peek() != JsonToken.END_ARRAY){
                                Hero helperHero = new Hero();
                                jsonReader.beginObject();
                                // id
                                jsonReader.nextName();
                                helperHero.setId(jsonReader.nextString());
                                // name
                                jsonReader.nextName();
                                helperHero.setName(jsonReader.nextString());
                                // class
                                jsonReader.nextName();
                                helperHero.setHeroClass(HeroClass.get(jsonReader.nextString()));
                                // gender
                                jsonReader.nextName();
                                helperHero.setGender(jsonReader.nextInt());
                                // level
                                jsonReader.nextName();
                                helperHero.setLevel(jsonReader.nextInt());
                                // elite kills
                                jsonReader.nextName();
                                jsonReader.beginObject();
                                jsonReader.nextName();
                                helperHero.setEliteKills(jsonReader.nextDouble());
                                jsonReader.endObject();
                                // paragonlevel
                                jsonReader.nextName();
                                helperHero.setParagonLevel(jsonReader.nextInt());
                                // hardcore
                                jsonReader.nextName();
                                helperHero.setHardcore(jsonReader.nextBoolean());
                                // seasonal
                                jsonReader.nextName();
                                helperHero.setSeasonal(jsonReader.nextBoolean());
                                // dead
                                jsonReader.nextName();
                                helperHero.setDead(jsonReader.nextBoolean());
                                // last updated
                                jsonReader.nextName();
                                helperHero.setLastUpdated(jsonReader.nextString());

                                jsonReader.endObject();
                                profile.getHeroes().add(helperHero);
                            }
                        }
                        //endregion
                        //region Artisans
                        if(propertyName.equals("blacksmith") || propertyName.equals("blacksmithHardcore") || propertyName.equals("blacksmithSeason") || propertyName.equals("blacksmithSeasonHardcore") ||
                                propertyName.equals("jeweler") || propertyName.equals("jewelerHardcore") || propertyName.equals("jewelerSeason") || propertyName.equals("jewelerSeasonHardcore") ||
                                propertyName.equals("mystic") || propertyName.equals("mysticHardcore") || propertyName.equals("mysticSeason") || propertyName.equals("mysticSeasonHardcore")){
                            Artisan helperArtisan = new Artisan();
                            jsonReader.beginObject();
                            // slug
                            jsonReader.nextName();
                            helperArtisan.setArtisanClass(ArtisanClass.get(jsonReader.nextString()));
                            //level
                            jsonReader.nextName();
                            helperArtisan.setLevel(jsonReader.nextInt());
                            //stepcurrent
                            jsonReader.nextName();
                            helperArtisan.setStepCurrent(jsonReader.nextInt());
                            //stepMax
                            jsonReader.nextName();
                            helperArtisan.setStepMax(jsonReader.nextInt());
                            jsonReader.endObject();
                            switch(propertyName){
                                case("blacksmith"):
                                    profile.setBlacksmith(helperArtisan);
                                    break;
                                case("blacksmithHardcore"):
                                    profile.setBlacksmithHardcore(helperArtisan);
                                    break;
                                case("blacksmithSeason"):
                                    profile.setBlacksmithSeason(helperArtisan);
                                    break;
                                case("blacksmithSeasonHardcore"):
                                    profile.setBlacksmithSeasonHardcore(helperArtisan);
                                    break;
                                case("jeweler"):
                                    profile.setJeweler(helperArtisan);
                                    break;
                                case("jewelerHardcore"):
                                    profile.setJewelerHardcore(helperArtisan);
                                    break;
                                case("jewelerSeason"):
                                    profile.setJewelerSeason(helperArtisan);
                                    break;
                                case("jewelerSeasonHardcore"):
                                    profile.setJewelerSeasonHardcore(helperArtisan);
                                    break;
                                case("mystic"):
                                    profile.setMystic(helperArtisan);
                                    break;
                                case("mysticHardcore"):
                                    profile.setMysticHardcore(helperArtisan);
                                    break;
                                case("mysticSeason"):
                                    profile.setMysticSeason(helperArtisan);
                                    break;
                                case("mysticSeasonHardcore"):
                                    profile.setMysticSeasonHardcore(helperArtisan);
                                    break;
                            }
                        }
                        //endregion
                        //region SeasonalProfiles
                        if(propertyName.equals("seasonalProfiles")){
                            jsonReader.beginObject();
                            RealmList<ProfileSeasonal> profileSeasonalList = new RealmList<>();
                            profile.setProfileSeasonal(profileSeasonalList);
                            boolean isEndOfSeasonalProfileArray = false;
                            while(!isEndOfSeasonalProfileArray){
                                ProfileSeasonal profileSeasonal = new ProfileSeasonal();
                                jsonReader.nextName();
                                jsonReader.beginObject();
                                //seasonId
                                jsonReader.nextName();
                                profileSeasonal.setId(jsonReader.nextString());
                                //paragonLevel
                                jsonReader.nextName();
                                profileSeasonal.setParagonLevel(jsonReader.nextInt());
                                //paragonlevelhardcore
                                jsonReader.nextName();
                                profileSeasonal.setParagonLevelHardcore(jsonReader.nextInt());
                                //kills
                                jsonReader.nextName();
                                jsonReader.beginObject();
                                //kills monsters
                                jsonReader.nextName();
                                profileSeasonal.setKillsMonsters(jsonReader.nextDouble());
                                //kills elites
                                jsonReader.nextName();
                                profileSeasonal.setKillsElites(jsonReader.nextDouble());
                                //kills hardcore
                                jsonReader.nextName();
                                profileSeasonal.setKillsMonstersHardcore(jsonReader.nextDouble());
                                jsonReader.endObject();
                                //timePlayed
                                jsonReader.nextName();
                                jsonReader.beginObject();
                                //timePlayed barbarian
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedBarbarian(jsonReader.nextDouble());
                                //timePlayed crusader
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedCrusader(jsonReader.nextDouble());
                                //timePlayed demon-hunter
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedDemonHunter(jsonReader.nextDouble());
                                //timePlayed monk
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedMonk(jsonReader.nextDouble());
                                //timePlayed necromancer
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedNecromancer(jsonReader.nextDouble());
                                //timePlayed witch-doctor
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedWitchDoctor(jsonReader.nextDouble());
                                //timePlayed wizard
                                jsonReader.nextName();
                                profileSeasonal.setTimePlayedWizard(jsonReader.nextDouble());
                                jsonReader.endObject();
                                //highestHardcoreLevel
                                jsonReader.nextName();
                                profileSeasonal.setHighestHardcoreLevel(jsonReader.nextInt());
                                //progression
                                jsonReader.nextName();
                                jsonReader.beginObject();
                                //act1
                                jsonReader.nextName();
                                profileSeasonal.setProgressionAct1(jsonReader.nextBoolean());
                                //act2
                                jsonReader.nextName();
                                profileSeasonal.setProgressionAct2(jsonReader.nextBoolean());
                                //act3
                                jsonReader.nextName();
                                profileSeasonal.setProgressionAct3(jsonReader.nextBoolean());
                                //act4
                                jsonReader.nextName();
                                profileSeasonal.setProgressionAct4(jsonReader.nextBoolean());
                                //act5
                                jsonReader.nextName();
                                profileSeasonal.setProgressionAct5(jsonReader.nextBoolean());

                                profile.getProfileSeasonal().add(profileSeasonal);
                                jsonReader.endObject();
                                jsonReader.endObject();
                                // if next is endArray, it means the end of the seasonProfile array. In that case we need to exit the while loop
                                if(jsonReader.peek() == JsonToken.END_OBJECT){
                                    isEndOfSeasonalProfileArray = true;
                                }
                            }

                        }
                        //endregion
                        //region Code
                        //used when user makes a wrong request
                        if(propertyName.equals("code")){
                            jsonReader.nextString();
                            jsonReader.nextName();
                            throw new VolleyError(jsonReader.nextString());
                        }
                        //endregion
                        break;
                    case NULL:
                        Log.v(TAG, "parseProfileRequest: Null");
                        jsonReader.nextNull();
                        break;
                    case NUMBER:
                        // I parse everything as a double as there is no way of distinguishing the type of the next number
                        double numberHelper = jsonReader.nextDouble();
                        Log.v(TAG, "parseProfileRequest: Number " + propertyName + " Value: " + numberHelper);
                        profile.numberSetter(numberHelper, propertyName);
                        break;
                    case STRING:
                        String stringHelper = jsonReader.nextString();
                        Log.v(TAG, "parseProfileRequest: String " + propertyName + " Value: " + stringHelper);
                        profile.stringSetter(stringHelper, propertyName);
                        break;
                    case BOOLEAN:
                        boolean boolHelper = jsonReader.nextBoolean();
                        Log.v(TAG, "parseProfileRequest: Boolean " + propertyName + " Value: " + boolHelper);
                        profile.boolSetter(boolHelper, propertyName);
                        break;
                }
            } catch (IOException e) {
                Log.e(TAG, "parseProfileRequest: ", e);
            }
        }
        return profile;
    }
}
