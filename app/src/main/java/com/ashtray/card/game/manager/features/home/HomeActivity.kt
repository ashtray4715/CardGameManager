package com.ashtray.card.game.manager.features.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.common.ui.activity.BaseActivity
import com.ashtray.card.game.manager.databinding.ActivityHomeBinding
import com.ashtray.card.game.manager.features.bnr.BackupActivity
import com.ashtray.card.game.manager.features.hazari.HazariActivity
import com.ashtray.card.game.manager.features.hearts.HeartsActivity
import com.ashtray.card.game.manager.features.ninecard.NineCardActivity
import com.ashtray.card.game.manager.features.spades.SpadesActivity
import com.ashtray.card.game.manager.features.twentynine.TwentyNineActivity
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val viewModel: HomeViewModel by viewModels {
        HomeVMFactory((application as MyApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.mainOptions.hazari.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, HazariActivity::class.java))
            }
        }

        binding.mainOptions.hearts.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, HeartsActivity::class.java))
            }
        }

        binding.mainOptions.nineCard.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, NineCardActivity::class.java))
            }
        }

        binding.mainOptions.twentyNine.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, TwentyNineActivity::class.java))
            }
        }

        binding.mainOptions.spades.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, SpadesActivity::class.java))
            }
        }

        binding.mainOptions.biciKata.setOnClickListener {
            lifecycleScope.launch {
                startActivity(Intent(this@HomeActivity, BackupActivity::class.java))
            }
        }
    }

    companion object {
        private const val TAG = "HomeActivity"
    }
}