package com.ok.redirect.sdk.redirect

sealed interface OkRedirectTarget {
    data class AppPackage(val name: String) : OkRedirectTarget
}