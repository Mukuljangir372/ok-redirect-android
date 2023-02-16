package com.ok.redirect.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.ok.redirect.sdk.OkRedirect
import com.ok.redirect.sdk.redirect.OkRedirectOpen
import com.ok.redirect.sdk.redirect.OkRedirectSource
import com.ok.redirect.sdk.redirect.OkRedirectTarget

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.open_btn).setOnClickListener {
            openRedirect()
        }
    }

    private fun openRedirect() {
        val open = OkRedirectOpen(
            source = OkRedirectSource.Url(
                url = "https://www.google.com"
            ),
            target = OkRedirectTarget.AppPackage(
                name = "com.whatsapp"
            )
        )
        OkRedirect().open(
            context = this,
            initialWebUrl = "https://www.google.com",
            opens = listOf(open)
        )
    }
}