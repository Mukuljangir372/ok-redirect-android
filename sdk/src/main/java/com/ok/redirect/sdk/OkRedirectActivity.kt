package com.ok.redirect.sdk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ok.redirect.sdk.databinding.ActivityOkredirectBinding

internal class OkRedirectActivity : AppCompatActivity() {
    private var _binding: ActivityOkredirectBinding? = null
    private val binding: ActivityOkredirectBinding get() = _binding!!

    private val target: OkRedirectActivity get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView<ActivityOkredirectBinding?>(
            this,
            R.layout.activity_okredirect
        ).apply {
            lifecycleOwner = target
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}