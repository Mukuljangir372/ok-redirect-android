package com.ok.redirect.sdk.storage

import com.ok.redirect.sdk.session.OkRedirectSession
import java.util.*

internal interface BaseSessionManager {
    fun getSession(id: String): OkRedirectSession?
    fun saveSession(session: OkRedirectSession)
    fun removeSession(id: String): Boolean
    fun clearAllSession()
}

internal class SessionManager : BaseSessionManager {
    companion object {
        private var instance: SessionManager? = null
        fun getInstance(): SessionManager {
            if (instance != null) return instance!!
            synchronized(this) {
                if (instance == null) {
                    instance = SessionManager()
                }
            }
            return instance!!
        }
    }

    private var sessions = Collections.newSetFromMap(HashMap<OkRedirectSession, Boolean>())

    override fun getSession(id: String): OkRedirectSession? {
        return sessions.firstOrNull { session ->
            session.id == id
        }
    }

    override fun saveSession(session: OkRedirectSession) {
        val oldSession = getSession(session.id)
        if (oldSession != null) {
            sessions.remove(oldSession)
        }
        sessions.add(session)
    }

    override fun removeSession(id: String): Boolean {
        return sessions.removeIf { session ->
            session.id == id
        }
    }

    override fun clearAllSession() {
        return sessions.clear()
    }
}