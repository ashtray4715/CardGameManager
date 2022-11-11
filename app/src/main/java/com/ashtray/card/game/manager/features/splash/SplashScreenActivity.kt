package com.ashtray.card.game.manager.features.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.apps.MyApp

import com.ashtray.card.game.manager.databinding.ActivitySplashScreenBinding
import com.ashtray.card.game.manager.features.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashScreenBinding.inflate(layoutInflater) }

    private val viewModel: SplashScreenViewModel by viewModels {
        SplashScreenVMFactory((application as MyApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            delay(5000)
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }
    }

    companion object {
        private const val TAG = "SplashScreenActivity"
    }

}