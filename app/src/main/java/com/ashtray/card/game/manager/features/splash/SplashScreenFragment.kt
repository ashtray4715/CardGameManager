package com.ashtray.card.game.manager.features.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

    private val handler = Handler(Looper.getMainLooper())

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

    override fun onResume() {
        super.onResume()
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed({
            changeFragment(
                fragment = MyApp.fragmentFactory.getSplashScreenFragment(),
                transactionType = TransactionType.ADD_FRAGMENT
            )
        }, 2000)
    }

    override fun onPause() {
        handler.removeCallbacksAndMessages(null)
        super.onPause()
    }
}