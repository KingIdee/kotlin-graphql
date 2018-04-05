package com.example.android.kotlingraphql

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.provider.AuthCallback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials


class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val auth0 = Auth0(this)
        WebAuthProvider.init(auth0)
                .withScheme("demo")
                .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
                .start(this@LoginActivity, object : AuthCallback {
                    override fun onFailure(dialog: Dialog) {
                        // Show error Dialog to user
                    }

                    override fun onFailure(exception: AuthenticationException) {
                        // Show error to user
                    }

                    override fun onSuccess(credentials: Credentials) {
                        // Store credentials
                        // Navigate to your main activity
                        startActivity(Intent(this@LoginActivity,MoviesListActivity::class.java))
                    }
                })
    }
}
