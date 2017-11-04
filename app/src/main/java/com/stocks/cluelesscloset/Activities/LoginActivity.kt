package com.stocks.cluelesscloset.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.stocks.cluelesscloset.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startActivity(Intent(this, OutfitActivity::class.java))
        auth_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                auth_title_view.text = getString(R.string.register)
                switch_text.text = getString(R.string.login)
                register_details.visibility = View.VISIBLE
            } else {
                auth_title_view.text = getString(R.string.login)
                switch_text.text = getString(R.string.register)
                register_details.visibility = View.GONE
            }
        }

        continue_button.setOnClickListener {
            if (auth_switch.isChecked) {
                registerUser(email_input.text.toString(),
                        password_input.text.toString(),
                        first_name_input.text.toString(),
                        last_name_input.text.toString())
            } else {
                loginUser(email_input.text.toString(),
                        password_input.text.toString())
            }
        }
    }

    /**
     * @param username User's username.
     * @param password User's password.
     */
    fun loginUser(username: String, password: String) {

    }

    /**
     * @param username User's username.
     * @param password User's password.
     * @param firstName User's first name.
     * @param lastName User's last name.
     */
    fun registerUser(username: String, password: String, firstName: String, lastName: String) {

    }
}
