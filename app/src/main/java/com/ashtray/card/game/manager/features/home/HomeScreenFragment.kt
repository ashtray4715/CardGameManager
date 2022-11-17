package com.ashtray.card.game.manager.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.apps.MyViewModelFactory
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentHomeScreenBinding
import kotlinx.coroutines.launch

class HomeScreenFragment : BaseFragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels {
        MyViewModelFactory(MyApp.repository)
    }

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

        binding.mainOptions.hazari.setCustomClickListener {
            lifecycleScope.launch {
                changeFragment(
                    fragment = MyApp.fragmentFactory.getAddHazariGameFragment(),
                    transactionType = TransactionType.ADD_FRAGMENT
                )
            }
        }

        binding.mainOptions.hearts.setOnClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.nineCard.setOnClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.twentyNine.setOnClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.spades.setOnClickListener {
            lifecycleScope.launch {

            }
        }

        binding.mainOptions.biciKata.setOnClickListener {
            lifecycleScope.launch {

            }
        }


    }

    companion object {
        private const val TAG = "HomeActivity"
    }
}