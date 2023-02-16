package com.ok.redirect.sdk

class OkRedirect {
    companion object {
        private var instance: OkRedirect? = null
        fun getInstance(): OkRedirect {
            if(instance != null) return instance!!
            synchronized(this) {
                if(instance == null) {
                    instance = OkRedirect()
                }
            }
            return instance!!
        }
    }


}