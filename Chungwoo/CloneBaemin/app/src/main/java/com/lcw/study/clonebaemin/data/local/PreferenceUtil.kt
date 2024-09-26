package com.lcw.study.clonebaemin.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import org.json.JSONArray
import org.json.JSONException


class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun getList(key: String): ArrayList<String>? {
        val json = prefs.getString(key, null)
        val urls = ArrayList<String>()
        if (json != null) {
            try {
                val a = JSONArray(json)
                for (i in 0 until a.length()) {
                    val url = a.optString(i)
                    urls.add(url)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return urls
    }

    fun setStringArrayPref(key: String, values: ArrayList<String>): Boolean {
        var editor = prefs.edit()
        var a = JSONArray()
        for (i in 0 until getStringArrayPref(key).size) {
            a.put(getStringArrayPref(key)[i])
        }

        for (i in 0 until values.size) {
            a.put(values[i])
        }
        if (values.isNotEmpty()) {
            editor.putString(key, a.toString())
        } else {
            editor.putString(key, null)
        }
        return editor.commit()

    }

    fun getStringArrayPref(key: String): ArrayList<String> {
        val json = prefs.getString(key, "")
        val urls = ArrayList<String>()
        if (json != null) {
            try {
                val a = JSONArray(json)
                Log.d("search","a length : ${a.length()}")
                for (i in 0 until a.length()) {
                    val url = a.optString(i)
                    urls.add(url)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }
        return urls

    }

    fun removeKey(key:String){
        prefs.edit().remove(key).apply()
    }
}

