package com.ok.redirect.sdk

import android.content.Context
import android.content.Intent
import com.ok.redirect.sdk.source.RedirectSourceType

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