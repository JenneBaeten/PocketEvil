package be.ehb.jenne.pocketevil.model;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Jenne on 30/12/2017.
 */

public class ProfileRequest extends Request<Profile> {
    private final Gson gson = new Gson();
    private final Map<String, String> headers;
    private final Response.Listener<Profile> listener;

    public ProfileRequest(String url, Map<String, String> headers, Response.Listener<Profile> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError{
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(Profile response){
        listener.onResponse(response);
    }

    @Override
    protected Response<Profile> parseNetworkResponse(NetworkResponse response){
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, Profile.class),HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
