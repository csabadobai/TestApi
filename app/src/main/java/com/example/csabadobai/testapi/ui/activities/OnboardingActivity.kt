package com.example.csabadobai.testapi.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.csabadobai.testapi.R
import com.example.csabadobai.testapi.api.commands.SignInCommand
import kotlinx.android.synthetic.main.activity_onboarding.*
import org.jetbrains.anko.toast

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val signInCommand = SignInCommand()
        signInCommand.setOnResponseListener(object : SignInCommand.OnResponseListener {
            override fun onSuccess() {
                goToNextActivity()
            }

            override fun onError() {
                showError()
            }

        })

        signInView.setOnClickListener({
            signInCommand.login(userNameView.text.toString(), passwordView.text.toString())
        })
    }

    private fun showError() {
        toast( "Incorrect username or password" )
    }

    private fun goToNextActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
