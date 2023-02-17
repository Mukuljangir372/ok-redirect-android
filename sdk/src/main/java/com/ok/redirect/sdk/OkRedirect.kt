package com.ok.redirect.sdk

import android.content.Context
import android.content.Intent
import com.ok.redirect.sdk.browser.BrowserFragment.Companion.SESSION_ID
import com.ok.redirect.sdk.session.generateOkRedirectSession
import com.ok.redirect.sdk.storage.SessionManager

/**
 * To Use OkRedirect -
 * OkRedirect.open(context, initialWebUrl)
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
object OkRedirect {
    fun open(
        context: Context,
        initialWebUrl: String,
    ) {
        val manager = SessionManager.getInstance()
        val session = generateOkRedirectSession(
            initialWebUrl = initialWebUrl,
        )
        manager.saveSession(session)

        val intent = Intent(context, OkRedirectActivity::class.java).also {
            it.putExtra(SESSION_ID, session.id)
        }
        context.startActivity(intent)
    }
}