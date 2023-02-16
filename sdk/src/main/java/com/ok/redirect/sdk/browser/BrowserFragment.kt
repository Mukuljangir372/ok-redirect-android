package com.ok.redirect.sdk.browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.ok.redirect.sdk.databinding.FragmentBrowserBinding

internal class BrowserFragment : BaseBrowserFragment() {
    companion object {
        const val SESSION_ID = "SESSION_ID"
    }

    private var _binding: FragmentBrowserBinding? = null
    private val binding: FragmentBrowserBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getWebView(): WebView {
        return binding.webView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadWebView()
        loadInitialWebPage()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}