package ge.nlatsabidze.gallery.login

import android.content.SharedPreferences
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.R
import ge.nlatsabidze.gallery.databinding.LoginFragmentBinding


class LoginFragment : BaseFragment<LoginFragmentBinding>(LoginFragmentBinding::inflate) {


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var preferences: SharedPreferences

    private lateinit var switchToTextView: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun start() {
        initPrivateVariables()
    }

    private fun initPrivateVariables() {
        firebaseAuth = FirebaseAuth.getInstance()
        preferences = requireContext().getSharedPreferences("", AppCompatActivity.MODE_PRIVATE)

        emailEditText = binding.emailEditText
        passwordEditText = binding.passworEditText
        loginButton = binding.loginButton
        registerTextView = binding.registerTextView

        loginButton.setOnClickListener { loginButtonClicked() }
        registerTextView.setOnClickListener { registerTextViewClicked() }
    }

    private fun loginButtonClicked() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {

            val task = firebaseAuth.signInWithEmailAndPassword(email, password)
            task.addOnCompleteListener {
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
                    binding.emailEditText.text?.clear()
                    binding.passworEditText.text?.clear()
                    Toast.makeText(
                        requireContext(),
                        "Login completed successfully!",
                        Toast.LENGTH_LONG
                    )
                        .show()
                } else {
                    Toast.makeText(requireContext(), task.exception!!.message, Toast.LENGTH_LONG)
                        .show()
                    binding.emailEditText.text?.clear()
                    binding.passworEditText.text?.clear()
                }
            }
        } else {
            Toast.makeText(requireContext(), "Please Fill in your Information", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun registerTextViewClicked() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        binding.emailEditText.text?.clear()
        binding.passworEditText.text?.clear()
    }
}