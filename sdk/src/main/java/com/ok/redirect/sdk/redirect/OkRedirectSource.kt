package com.ok.redirect.sdk.redirect

sealed interface OkRedirectSource {
    data class Url(val url: String) : OkRedirectSource
}