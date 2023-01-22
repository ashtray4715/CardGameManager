package com.ashtray.card.game.manager.features.hazari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ashtray.card.game.manager.apps.MyFactory
import com.ashtray.card.game.manager.common.helpers.CustomInputFilter
import com.ashtray.card.game.manager.common.ui.base.BaseFragment
import com.ashtray.card.game.manager.database.entities.HazariGameInfo
import com.ashtray.card.game.manager.databinding.FragmentAddHazariGameBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddHazariGameFragment : BaseFragment() {

    private var _binding: FragmentAddHazariGameBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddHazariGameViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionBar.setBackListener { handleBackButtonPressed() }
        binding.cancelButton.setCustomClickListener { handleBackButtonPressed() }
        binding.saveButton.setCustomClickListener { saveButtonPressed() }

        viewModel.isGameInsertionDone.observe(viewLifecycleOwner) { handleGameInsertionUpdate(it) }
    }

    private fun saveButtonPressed() = mCustomViewScope?.launch {
        hideSystemKeyboardIfPossible()
        delay(200)


        val gameName = try {
            CustomInputFilter.checkGameName(binding.gameNameField.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        val creationTime = System.currentTimeMillis()

        val finalScore = try {
            CustomInputFilter.checkHazariGameFinalScore(binding.targetScoreField.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        val playerName1 = try {
            CustomInputFilter.checkPlayerName(binding.playerNameField1.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        val playerName2 = try {
            CustomInputFilter.checkPlayerName(binding.playerNameField2.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        val playerName3 = try {
            CustomInputFilter.checkPlayerName(binding.playerNameField3.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        val playerName4 = try {
            CustomInputFilter.checkPlayerName(binding.playerNameField4.getInputText())
        } catch (e: Exception) {
            showToastMessage(e.message)
            return@launch
        }

        viewModel.insertNewHazariGame(
            HazariGameInfo(
                gameId = creationTime,
                gameName = gameName,
                creationTime = creationTime,
                playerName1 = playerName1,
                playerName2 = playerName2,
                playerName3 = playerName3,
                playerName4 = playerName4,
                targetScore = finalScore
            )
        )
    }

    private fun handleGameInsertionUpdate(gameId: Long) = mCustomViewScope?.launch {
        if (gameId != -1L) {
            delay(100)
            showToastMessage("New hazari game created")
            changeFragment(
                fragment = MyFactory.getPlayHazariGameFragment(gameId),
                transactionType = TransactionType.ADD_FRAGMENT
            )
            delay(100)
            changeFragment(
                fragment = this@AddHazariGameFragment,
                transactionType = TransactionType.REMOVE_FRAGMENT
            )
        }
    }
}