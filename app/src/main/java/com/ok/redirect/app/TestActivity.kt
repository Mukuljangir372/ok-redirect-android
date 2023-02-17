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
            initialWebUrl = "https://scogo.page.link/?link=https://dev.cloud.scogo.in/referral-signup/23z09t&apn=com.scogo.superapp",
//            initialWebUrl = "https://api.whatsapp.com/send?phone=8708433038",
//            initialWebUrl = "https://wa.me/15551234567",
        )
    }
}