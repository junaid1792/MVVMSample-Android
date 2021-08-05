package com.example.mvvmsample.sessionManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences pref;
    // Editor reference for Shared preferences
    private SharedPreferences.Editor editor;

    private static final String PREFER_NAME = "MVVMPref";

    // Context
    private Context _context;
    // Shared pref mode
    private int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
}
