package com.ashtray.card.game.manager.common.ui.base

import android.os.Bundle

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.apps.MyApp
import com.ashtray.card.game.manager.apps.MyLog.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.ashtray.card.game.manager.common.ui.base.BaseFragment.TransactionType
import com.ashtray.card.game.manager.common.helpers.SafeRunner

class BaseActivity : AppCompatActivity(), BaseFragment.CallBacks {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            handleBackButtonPressed()
        }
    }

    companion object {
        private const val TAG = "BaseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_layout)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        changeFragment(
            fragment = MyApp.fragmentFactory.getSplashScreenFragment(),
            transactionType = TransactionType.SINGLE_FRAGMENT
        )
    }

    override fun changeFragment(fragment: BaseFragment, transactionType: TransactionType) {
        lifecycleScope.launch {
            when (transactionType) {
                TransactionType.ADD_FRAGMENT -> changeFragmentAdd(fragment)
                TransactionType.REMOVE_FRAGMENT -> changeFragmentRemove(fragment)
                TransactionType.SINGLE_FRAGMENT -> changeFragmentSingle(fragment)
            }
        }
    }

    override fun showToastMessage(message: String) {
        lifecycleScope.launch(Dispatchers.Main) {
            Toast.makeText(this@BaseActivity, message, Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun changeFragmentAdd(fragment: BaseFragment) {
        i(TAG, "changeFragment: add, ${fragment.mTAG}")
        withContext(Dispatchers.Main) {
            SafeRunner {
                supportFragmentManager.commit {
                    setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top)
                    add(R.id.fragment_container, fragment, fragment.mTAG)
                }
            }
        }
    }

    private suspend fun changeFragmentRemove(fragment: BaseFragment) {
        i(TAG, "changeFragment: remove, ${fragment.mTAG}")
        withContext(Dispatchers.Main) {
            SafeRunner {
                supportFragmentManager.commit {
                    setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom)
                    remove(fragment)
                }
            }
        }
    }

    private suspend fun changeFragmentSingle(fragment: BaseFragment) {
        i(TAG, "changeFragment: clear_all_and_add_new, ${fragment.mTAG}")
        withContext(Dispatchers.Main) {
            SafeRunner {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, fragment, fragment.mTAG)
                }
            }
        }
    }

    private fun handleBackButtonPressed() {
        val unRef = supportFragmentManager.findFragmentById(R.id.fragment_container)
        val fragment = unRef as BaseFragment?
        if (fragment == null || !fragment.handleBackButtonPressed()) {
            i(TAG, "fragment can't handle back press [CLOSING_APP]")
            finish()
        }
    }
}