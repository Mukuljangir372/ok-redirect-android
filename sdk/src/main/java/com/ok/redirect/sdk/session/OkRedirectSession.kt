package com.ok.redirect.sdk.session

import com.ok.redirect.sdk.redirect.OkRedirectOpen
import java.util.*

internal data class OkRedirectSession(
    val id: String,
    val opens: List<OkRedirectOpen>
)

internal fun generateOkRedirectSession(
    opens: List<OkRedirectOpen>
): OkRedirectSession {
    return OkRedirectSession(
        id = UUID.randomUUID().toString(),
        opens = opens
    )
}