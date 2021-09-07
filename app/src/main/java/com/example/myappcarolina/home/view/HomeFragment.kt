package com.example.myappcarolina.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myappcarolina.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var homeFragmentBinding : FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        homeFragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return homeFragmentBinding.root
    }
}