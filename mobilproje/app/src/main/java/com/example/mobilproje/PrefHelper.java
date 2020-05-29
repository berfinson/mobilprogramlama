package com.example.mobilproje;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefHelper {
   static PrefHelper instance;
    static SharedPreferences preferences;
    public static PrefHelper getInstance (Context context) {
        if (instance == null) {
            instance = new PrefHelper();
            preferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());

        }
        return instance;
    }
    public String getString (String key ){
        return preferences.getString(key,null);
    }
    public void saveString (String key,String value){

        preferences.edit().putString(key,value).apply();
    }

}
