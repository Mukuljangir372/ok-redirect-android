package com.ok.redirect.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ok.redirect.sdk.OkRedirect
import com.ok.redirect.sdk.source.RedirectSourceType

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OkRedirect.getInstance().open(
            context = this,
            type = RedirectSourceType.Url(
                url = ""
            )
        )
    }
}