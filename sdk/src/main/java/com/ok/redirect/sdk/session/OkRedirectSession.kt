package com.ok.redirect.sdk.session

import java.util.*

internal data class OkRedirectSession(
    val id: String,
    val initialWebUrl: String,
)

internal fun generateOkRedirectSession(
    initialWebUrl: String,
): OkRedirectSession {
    return OkRedirectSession(
        id = UUID.randomUUID().toString(),
        initialWebUrl = initialWebUrl,
    )
}