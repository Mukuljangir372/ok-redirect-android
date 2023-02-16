package com.ok.redirect.sdk.redirect

/**
 * Specifies which url should redirect to which app (by package)
 */
data class OkRedirectOpen(
    val source: OkRedirectSource,
    val target: OkRedirectTarget
)