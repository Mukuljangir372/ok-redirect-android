package com.ok.redirect.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.ok.redirect.sdk.OkRedirect
import com.ok.redirect.sdk.source.RedirectSourceType

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<MaterialButton>(R.id.open_btn)
        btn.setOnClickListener {
            OkRedirect.getInstance().open(
                context = this,
                type = RedirectSourceType.Url(
                    url = ""
                )
            )
        }
    }
}