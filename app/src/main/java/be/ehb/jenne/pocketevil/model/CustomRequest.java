package be.ehb.jenne.pocketevil.model;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jenne on 29/12/2017.
 * Code from documentation:
 * https://developer.android.com/training/volley/request-custom.html
 */

public class CustomRequest<T> extends Request<T> {
    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param headers Map of request headers
     */
    public CustomRequest(String url, Class<T> clazz, Map<String, String> headers,
                         Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            Profile profile = parseProfileRequest(json);
            Log.i("TEST5", profile.toString());
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }
    private Profile parseProfileRequest(String json){
        Profile profile = new Profile();
        Artisan blacksmith = new Artisan();
        Artisan blacksmithHardcore = new Artisan();
        Artisan blacksmithSeasonal = new Artisan();
        Artisan blacksmithSeasonalHarcore = new Artisan();
        Artisan jeweler = new Artisan();
        Artisan jewelerHardcore = new Artisan();
        Artisan jewelerSeasonal = new Artisan();
        Artisan jewelerSeasonalHardcore = new Artisan();
        Artisan mystic = new Artisan();
        Artisan mysticHardcore = new Artisan();
        Artisan mysticSeasonal = new Artisan();
        Artisan mysticSeasonalHardcore = new Artisan();
        List<ProfileSeasonal> profileSeasonal = new ArrayList<>();
        StringReader stringReader = new StringReader(json);
        JsonReader jsonReader = new JsonReader(stringReader);
        boolean documentClosed = false;
        Hero heroHelper;

        String propertyName = "";
        Log.d("Debug Parsing", "parseProfileRequest: ");
        while(!documentClosed){
            try{
                Log.d("Debug Parsing", "parseProfileRequest: peek:" + jsonReader.peek());
                switch(jsonReader.peek()){
                    case BEGIN_ARRAY:
                        Log.d("Debug Parsing", "parseProfileRequest: Begin Array");
                        jsonReader.beginArray();
                        break;
                    case BEGIN_OBJECT:
                        Log.d("Debug Parsing", "parseProfileRequest: Begin Object");
                        jsonReader.beginObject();
                        break;
                    case END_ARRAY:
                        Log.d("Debug Parsing", "parseProfileRequest: End Array");
                        jsonReader.endArray();
                        break;
                    case END_DOCUMENT:
                        Log.d("Debug Parsing", "parseProfileRequest: End Document");
                        jsonReader.close();
                        documentClosed = true;
                        break;
                    case END_OBJECT:
                        Log.d("Debug Parsing", "parseProfileRequest: End Object");
                        jsonReader.endObject();
                        break;
                    case NAME:
                        propertyName = jsonReader.nextName();
                        Log.d("Debug Parsing", "parseProfileRequest: Name: " + propertyName);
                        //region Heroes
                        if(propertyName.equals("heroes")){
                            jsonReader.beginArray();
                            List<Hero> heroList = new ArrayList<>();
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
                        break;
                    case NULL:
                        Log.d("Debug Parsing", "parseProfileRequest: Null");
                        jsonReader.nextNull();
                        break;
                    case NUMBER:
                        // I parse everything as a double as there is no way of distinguishing the type of the next number
                        double numberHelper = jsonReader.nextDouble();
                        Log.d("Debug Parsing", "parseProfileRequest: Number " + propertyName + " Value: " + numberHelper);
                        profile.numberSetter(numberHelper, propertyName);
                        break;
                    case STRING:
                        String stringHelper = jsonReader.nextString();
                        Log.d("Debug Parsing", "parseProfileRequest: String " + propertyName + " Value: " + stringHelper);
                        profile.stringSetter(stringHelper, propertyName);
                        break;
                    case BOOLEAN:
                        boolean boolHelper = jsonReader.nextBoolean();
                        Log.d("Debug Parsing", "parseProfileRequest: Boolean " + propertyName + " Value: " + boolHelper);
                        profile.boolSetter(boolHelper, propertyName);
                        break;
                }
            } catch (IOException e) {
                Log.e("JsonParseError", "parseProfileRequest: ", e);
            }
        }
        return profile;
    }
}
