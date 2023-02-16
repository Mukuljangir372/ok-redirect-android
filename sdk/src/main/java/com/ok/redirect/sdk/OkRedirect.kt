package com.ok.redirect.sdk

import android.content.Context
import android.content.Intent
import com.ok.redirect.sdk.redirect.OkRedirectOpen
import com.ok.redirect.sdk.session.generateOkRedirectSession
import com.ok.redirect.sdk.storage.SessionManager

/**
 * To Use OkRedirect -
 * val opens = listOf(OkRedirectOpen(
 * ))
 * OkRedirect().open(context, opens)
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
    fun open(context: Context, opens: List<OkRedirectOpen>) {
        val manager = SessionManager.getInstance()
        val session = generateOkRedirectSession(opens = opens)
        manager.saveSession(session)

        val intent = Intent(context, OkRedirectActivity::class.java)
        context.startActivity(intent)
    }
}