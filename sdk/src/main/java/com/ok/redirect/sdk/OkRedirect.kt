package com.ok.redirect.sdk

import android.content.Context
import android.content.Intent
import com.ok.redirect.sdk.source.RedirectSourceType

/**
 * To Use OkRedirect -
 * OkRedirect.getInstance().open(context, type)
 *
 * PRECAUTIONS -
 * Before using OkRedirect -
 * 1. Enable view/data binding feature in your project
 * - build.gradle.app :
 *     buildFeatures {
 *        dataBinding true
 *        viewBinding true
 *    }
 *
 * 2. Enable These Permissions In Your Project -
 * - AndroidManifest.xml :
 *    <uses-permission android:name="android.permission.INTERNET"/>
 *    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 */
class OkRedirect {
    companion object {
        private var instance: OkRedirect? = null
        fun getInstance(): OkRedirect {
            if (instance != null) return instance!!
            synchronized(this) {
                if (instance == null) {
                    instance = OkRedirect()
                }
            }
            return instance!!
        }
    }

    fun open(context: Context, type: RedirectSourceType) {
        val intent = Intent(context, OkRedirectActivity::class.java)
        context.startActivity(intent)
    }
}