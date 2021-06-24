package com.lanky.androidutils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ClassName SharedPreferenceUtil
 * @Description 轻量级存储工具
 * @Author LankyBin
 * @Date 2021/6/24 14:10
 * @Version 1.0
 */
public class SharedPreferenceUtil {
    private Context mContext;
    private static SharedPreferenceUtil mSharedPreference = null;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private SharedPreferenceUtil(Context context){
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences("com_lanky_android_utils", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferenceUtil getInstance(Context context){
        if (mSharedPreference == null) {
            mSharedPreference = new SharedPreferenceUtil(context);
        }
        return mSharedPreference;
    }

    public void setInt(String key, int value){
        editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void setString(String key, String value){
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void setBoolean(String key,boolean bool){
        editor = sharedPreferences.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    public int getInt(String key,int defValue){
        return sharedPreferences.getInt(key, defValue);
    }

    public boolean getBoolean(String key,Boolean defValue){
        return sharedPreferences.getBoolean(key, defValue);
    }

    public String getString(String key,String defValue){
        return sharedPreferences.getString(key, defValue);
    }
}
