package ge.nlatsabidze.gallery.register

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log.d
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import ge.nlatsabidze.gallery.BaseFragment
import ge.nlatsabidze.gallery.R
import ge.nlatsabidze.gallery.databinding.RegisterFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment: BaseFragment<RegisterFragmentBinding>(RegisterFragmentBinding::inflate) {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun start() {
        initPrivateVariables()
    }

    private fun initPrivateVariables() {
        firebaseAuth = FirebaseAuth.getInstance()
        binding.registerButton.setOnClickListener { registerButtonClicked() }
    }

    private fun registerButtonClicked() {

        val email = binding.emailEditText.text.toString()
        val password = binding.passworEditText.text.toString()

        val task = firebaseAuth.createUserWithEmailAndPassword(email, password)
        task.addOnCompleteListener {
            if (task.isSuccessful) {
                Toast.makeText(
                    requireContext(),
                    "Registration completed successfully!",
                    Toast.LENGTH_LONG
                ).show()
                binding.emailEditText.text?.clear()
                binding.passworEditText.text?.clear()
                findNavController().navigate(R.id.action_registerFragment_to_menuFragment)
            } else {
                Toast.makeText(requireContext(), task.exception!!.message, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}