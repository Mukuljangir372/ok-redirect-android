package com.ok.redirect.sdk.session

import com.ok.redirect.sdk.redirect.OkRedirectOpen
import java.util.*

internal data class OkRedirectSession(
    val id: String,
    val initialWebUrl: String,
    val opens: List<OkRedirectOpen>
)

internal fun generateOkRedirectSession(
    initialWebUrl: String,
    opens: List<OkRedirectOpen>
): OkRedirectSession {
    return OkRedirectSession(
        id = UUID.randomUUID().toString(),
        initialWebUrl = initialWebUrl,
        opens = opens
    )
}