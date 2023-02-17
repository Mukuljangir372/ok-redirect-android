package com.ok.redirect.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.ok.redirect.sdk.OkRedirect

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.open_btn).setOnClickListener {
            openRedirect()
        }
    }

    private fun openRedirect() {
        OkRedirect.open(
            context = this,
            initialWebUrl = "https://api.whatsapp.com/send?phone=8708433038",
//            initialWebUrl = "https://wa.me/15551234567",
        )
    }
}