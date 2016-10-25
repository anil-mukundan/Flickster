package com.mukundan.www.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amukund on 10/24/16.
 */

public class Movie {
    String posterPath;
    String originalTitle;
    String overview;

    public Movie (JSONObject movieJson) throws JSONException {
        this.posterPath = movieJson.getString("poster_path");
        this.originalTitle = movieJson.getString("original_title");
        this.overview = movieJson.getString("overview");
    }

    public static ArrayList<Movie> fromJsonArray(JSONArray movies) {
        ArrayList<Movie> results = new ArrayList<>();
        for (int i = 0; i < movies.length(); i++) {
            try {
                results.add(new Movie(movies.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }
}
