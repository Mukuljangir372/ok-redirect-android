package com.ok.redirect.sdk.source

sealed interface RedirectSourceType {
    data class Url(val url: String): RedirectSourceType
}