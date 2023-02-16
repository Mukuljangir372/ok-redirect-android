package com.ok.redirect.sdk.browser

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ok.redirect.sdk.storage.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal interface BrowserView {
    fun loadWebView()
}

internal abstract class BaseBrowserFragment : Fragment(), BrowserView {
    abstract fun getWebView(): WebView
    internal val sessionManager = SessionManager.getInstance()

    @SuppressLint("SetJavaScriptEnabled")
    override fun loadWebView() {
        lifecycleScope.launch(Dispatchers.Main) {
            val view = getWebView().also {
                it.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                it.settings.apply {
                    javaScriptEnabled = true
                }
            }
            view.webViewClient = getWebViewClient()
        }
    }

    private fun getWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return false
            }
        }
    }
}