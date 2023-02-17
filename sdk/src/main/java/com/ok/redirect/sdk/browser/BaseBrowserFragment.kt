package com.ok.redirect.sdk.browser

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ok.redirect.sdk.browser.BrowserFragment.Companion.SESSION_ID
import com.ok.redirect.sdk.session.OkRedirectSession
import com.ok.redirect.sdk.storage.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal interface BrowserView {
    fun loadWebView()
    fun loadWebPage(url: String)
    fun loadInitialWebPage()
}

internal abstract class BaseBrowserFragment : Fragment(), BrowserView {
    abstract fun getWebView(): WebView

    private val sessionManager: SessionManager = SessionManager.getInstance()
    private var currentSession: OkRedirectSession? = null

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

    override fun loadWebPage(url: String) {
        getWebView().loadUrl(url)
    }

    override fun loadInitialWebPage() {
        loadWebPage(getCurrentSession().initialWebUrl)
    }

    private fun getWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            @Deprecated("Deprecated in Java", ReplaceWith("true"))
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                /**
                 * return false -
                 * don't redirect anywhere (load url here same web view)
                 *
                 * return true -
                 * redirect to anywhere (e.g other browser like chrome)
                 */
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
    }

    private fun getCurrentSession(): OkRedirectSession {
        if (currentSession != null) return currentSession!!
        val sessionId = arguments?.getString(SESSION_ID)
        if (sessionId.isNullOrEmpty()) {
            throw IllegalArgumentException("Session Id - $sessionId can't null or empty")
        }
        currentSession = sessionManager.getSession(sessionId)
        if (currentSession == null) {
            throw IllegalArgumentException("Init/Save Session Before Use")
        }
        return currentSession!!
    }
}