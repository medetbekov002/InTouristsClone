package com.dev.intourist.data.remote.authenticator

import com.dev.intourist.data.local.preferences.UserDataPreferences
import com.dev.intourist.data.remote.authenticator.AuthenticatorApiService
import com.dev.intourist.data.remote.authenticator.RefreshToken
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val userData: UserDataPreferences,
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val tokens = service.refreshToken(
                RefreshToken(userData.refreshToken)
            ).execute()

            return when {
                tokens.isSuccessful && tokens.body() != null -> {
                    with(userData) {
                        accessToken = tokens.body()!!.accessToken
                        refreshToken = tokens.body()!!.refreshToken
                    }

                    response
                        .request
                        .newBuilder()
                        .header("Authorization", "Bearer ${userData.accessToken}")
                        .build()
                }

                else -> {
                    null
                }
            }
        }
    }
}