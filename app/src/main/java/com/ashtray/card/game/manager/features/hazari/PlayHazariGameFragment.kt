package com.ashtray.card.game.manager.features.hazari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentPlayHazariGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayHazariGameFragment : BaseFragment() {

    private var _binding: FragmentPlayHazariGameBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayHazariGameViewModel by viewModels()

    override val mTAG = "PlayHazariGameFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayHazariGameBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun handleBackButtonPressed(): Boolean {
        changeFragment(this, TransactionType.REMOVE_FRAGMENT)
        return true
    }
}