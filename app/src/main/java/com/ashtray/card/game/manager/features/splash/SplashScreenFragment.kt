package com.ashtray.card.game.manager.features.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.common.ui.activity.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentSplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment() {

    private val viewModel: SplashScreenViewModel by viewModels {
        SplashScreenVMFactory(MyApp.repository)
    }

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    override val mTAG = "SplashScreenFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}