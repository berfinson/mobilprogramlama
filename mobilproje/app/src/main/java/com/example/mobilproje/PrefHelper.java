package com.example.mobilproje;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class PrefHelper {
    static PrefHelper instance;
    static SharedPreferences preferences;
    static Context ctx;

    public static PrefHelper getInstance(Context context) {
        ctx = context;
        if (instance == null) {
            instance = new PrefHelper();
            preferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());

        }
        return instance;
    }

    public String getString(String key) {
        return preferences.getString(key, null);
    }

    public void saveString(String key, String value) {

        preferences.edit().putString(key, value).apply();
    }

    public void showMessage(String message) {

        Toast.makeText(ctx.getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

}
