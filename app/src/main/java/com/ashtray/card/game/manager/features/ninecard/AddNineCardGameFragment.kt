package com.ashtray.card.game.manager.features.ninecard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.apps.MyViewModelFactory
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.databinding.FragmentAddNineCardGameBinding

class AddNineCardGameFragment : BaseFragment() {

    private var _binding: FragmentAddNineCardGameBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddNineCardGameViewModel by viewModels {
        MyViewModelFactory(MyApp.repository)
    }

    override val mTAG = "AddNineCardGameFragment"

    override fun handleBackButtonPressed(): Boolean {
        changeFragment(this, TransactionType.REMOVE_FRAGMENT)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNineCardGameBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionBar.setBackListener { handleBackButtonPressed() }
        binding.cancelButton.setCustomClickListener { handleBackButtonPressed() }
        binding.saveButton.setCustomClickListener { saveButtonPressed() }
    }

    private fun saveButtonPressed() {

    }
}