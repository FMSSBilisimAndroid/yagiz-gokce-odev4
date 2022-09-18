package com.yagizgokce.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yagizgokce.myapplication.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {
    private lateinit var binding: FragmentGetStartedBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGetStartedBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            startedButton.setOnClickListener{
                startMenu(view)
            }
        }
    }

    fun startMenu(view: View){
        findNavController().navigate(R.id.action_getStartedFragment_to_menuFragment)
    }

}