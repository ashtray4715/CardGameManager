package com.ashtray.card.game.manager.features.hazari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentGameListHazariBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HazariGameListFragment : BaseFragment() {

    private var _binding: FragmentGameListHazariBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HazariGameListViewModel by viewModels()

    override val mTAG = "HazariGameListFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameListHazariBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun handleBackButtonPressed(): Boolean {
        changeFragment(this, TransactionType.REMOVE_FRAGMENT)
        return true
    }

}