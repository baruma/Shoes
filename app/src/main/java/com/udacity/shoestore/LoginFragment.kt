package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreate(savedInstanceState)

    binding = FragmentLoginBinding.inflate(inflater, container, false)

    return binding.root
}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.loginButton).setOnClickListener { view ->
            view.findNavController().navigate(R.id.onboardingFragment)
            findNavController().navigate(R.id.onboardingFragment)
        }

        view.findViewById<Button>(R.id.signUpButton).setOnClickListener {
            view.findNavController().navigate(R.id.onboardingFragment)
            findNavController().navigate(R.id.onboardingFragment)
        }
    }
}