package com.ok.redirect.sdk.exts

import android.content.Context
import android.content.Intent
import android.net.Uri

internal fun Context.openUrl(url: String) {
    openUri(Uri.parse(url))
}

internal fun Context.openUri(uri: Uri) {
    startActivity(Intent(Intent.ACTION_VIEW, uri).also {
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    })
}