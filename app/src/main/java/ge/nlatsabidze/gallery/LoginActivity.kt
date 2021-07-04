package ge.nlatsabidze.gallery

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import android.content.SharedPreferences
import android.content.res.Configuration
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var preferences: SharedPreferences

    private lateinit var switchToTextView: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initPrivateVariables()
    }

    override fun onResume() {
        super.onResume()
        updateMode(false)
    }

    private fun initPrivateVariables() {
        firebaseAuth = FirebaseAuth.getInstance()
        preferences = getPreferences(MODE_PRIVATE)

        switchToTextView = findViewById(R.id.switchToTextView)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passworEditText)
        loginButton = findViewById(R.id.loginButton)
        registerTextView = findViewById(R.id.registerTextView)

        switchToTextView.setOnClickListener { updateMode(true) }
        loginButton.setOnClickListener { loginButtonClicked() }
        registerTextView.setOnClickListener { registerTextViewClicked() }
    }

    private fun updateMode(switch: Boolean) {
        var defaultNightMode = preferences.getInt("defaultNightMode", 404)
        if (defaultNightMode == 404) {
            val uiMode = resources.configuration.uiMode
            if (uiMode.and(Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
                defaultNightMode = AppCompatDelegate.MODE_NIGHT_YES
            } else {
                defaultNightMode = AppCompatDelegate.MODE_NIGHT_NO
            }
        }

        if (switch) {
            if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                defaultNightMode = AppCompatDelegate.MODE_NIGHT_NO
            } else {
                defaultNightMode = AppCompatDelegate.MODE_NIGHT_YES
            }

            with(preferences.edit()) {
                putInt("defaultNightMode", defaultNightMode)
                apply()
            }
        }

        AppCompatDelegate.setDefaultNightMode(defaultNightMode)
        if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            switchToTextView.text = "   Switch to light"
        } else {
            switchToTextView.text = "   Switch to dark"
        }
    }

    private fun loginButtonClicked() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        val task = firebaseAuth.signInWithEmailAndPassword(email, password)
        task.addOnCompleteListener {
            if (task.isSuccessful) {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            } else {
                Toast.makeText(applicationContext, task.exception!!.message, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun registerTextViewClicked() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        val task = firebaseAuth.createUserWithEmailAndPassword(email, password)
        task.addOnCompleteListener {
            if (task.isSuccessful) {
                Toast.makeText(
                    applicationContext,
                    "Registration completed successfully!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(applicationContext, task.exception!!.message, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

}


