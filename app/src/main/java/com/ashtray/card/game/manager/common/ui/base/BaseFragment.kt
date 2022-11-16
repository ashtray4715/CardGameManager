package com.ashtray.card.game.manager.common.ui.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.apps.MyLog.e

abstract class BaseFragment : Fragment() {

    abstract val mTAG: String

    interface CallBacks {
        fun changeFragment(fragment: BaseFragment, transactionType: TransactionType)
        fun showToastMessage(message: String)
    }

    enum class TransactionType {
        ADD_FRAGMENT, REMOVE_FRAGMENT, SINGLE_FRAGMENT
    }

    protected val mCustomViewScope
        get() = try {
            viewLifecycleOwner.lifecycleScope
        } catch (e: Exception) {
            null
        }


    private var callBacks: CallBacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callBacks = when (context is CallBacks) {
            true -> context
            else -> throw RuntimeException("Must implement GPFragment.CallBacks")
        }
    }

    override fun onDetach() {
        callBacks = null
        super.onDetach()
    }

    open fun handleBackButtonPressed(): Boolean {
        return false
    }

    protected fun changeFragment(fragment: BaseFragment, transactionType: TransactionType) {
        callBacks?.changeFragment(fragment, transactionType)
    }

    protected fun showToastMessage(message: String) {
        callBacks?.showToastMessage(message)
    }

    protected fun hideSystemKeyboardIfPossible() {
        try {
            val wToken = activity?.currentFocus?.windowToken
            val service = context?.getSystemService(Context.INPUT_METHOD_SERVICE)
            val immService = service as InputMethodManager?
            immService?.hideSoftInputFromWindow(wToken, 0)
        } catch (e: Exception) {
            e(mTAG, "hideSystemKeyboardIfPossible: exception occurs $e")
            e.printStackTrace()
        }
    }
}