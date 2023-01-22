package com.ashtray.card.game.manager.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.apps.MyFactory
import com.ashtray.card.game.manager.apps.MyLog
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentHomeScreenBinding
import com.ashtray.card.game.manager.features.ninecard.AddNineCardGameFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreenFragment : BaseFragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override val mTAG = "HomeScreenFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainOptions.hazari.setCustomClickListener { handleHazariMenuClick() }

        binding.mainOptions.hearts.setCustomClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.nineCard.setCustomClickListener {
            MyLog.i(mTAG, "nine card game option clicked")
            lifecycleScope.launch {
                changeFragment(
                    fragment = AddNineCardGameFragment(),
                    transactionType = TransactionType.ADD_FRAGMENT
                )
            }
        }

        binding.mainOptions.twentyNine.setCustomClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.spades.setCustomClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.biciKata.setCustomClickListener {
            lifecycleScope.launch {

            }
        }
    }

    private fun handleHazariMenuClick() = lifecycleScope.launch {
        changeFragment(
            fragment = MyFactory.getHazariGameListFragment(),
            transactionType = TransactionType.ADD_FRAGMENT
        )
    }

}