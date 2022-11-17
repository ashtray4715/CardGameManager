package com.ashtray.card.game.manager.features.hazari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.apps.MyViewModelFactory
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentAddHazariGameBinding

class AddHazariGameFragment : BaseFragment() {

    private var _binding: FragmentAddHazariGameBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddHazariGameViewModel by viewModels {
        MyViewModelFactory(MyApp.repository)
    }

    override val mTAG = "AddHazariGameFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddHazariGameBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun handleBackButtonPressed(): Boolean {
        changeFragment(this, TransactionType.REMOVE_FRAGMENT)
        return true
    }

}