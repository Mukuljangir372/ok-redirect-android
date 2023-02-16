package com.ok.redirect.sdk.browser

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal interface BrowserView {
    fun loadWebView()
}

internal abstract class BaseBrowserFragment : Fragment(), BrowserView {
    abstract fun getWebView(): WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun loadWebView() {
        lifecycleScope.launch(Dispatchers.IO) {
            val view = getWebView()
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            view.settings.apply {
                javaScriptEnabled = true
            }
        }
    }
}