package com.ashtray.card.game.manager.common.ui.base

import android.content.Context
import android.graphics.Point
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ashtray.card.game.manager.common.helpers.SafeRunner

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

    protected fun showToastMessage(message: String?) {
        message?.let { callBacks?.showToastMessage(it) }
    }

    protected fun hideSystemKeyboardIfPossible() {
        SafeRunner {
            val wToken = activity?.currentFocus?.windowToken
            val service = context?.getSystemService(Context.INPUT_METHOD_SERVICE)
            val immService = service as InputMethodManager?
            immService?.hideSoftInputFromWindow(wToken, 0)
        }
    }

    protected fun scrollToView(scrollViewParent: ScrollView, view: View) {
        val childOffset = Point()
        getDeepChildOffset(scrollViewParent, view.parent, view, childOffset)
        scrollViewParent.smoothScrollTo(0, childOffset.y)
    }

    private fun getDeepChildOffset(
        mainParent: ViewGroup,
        parent: ViewParent,
        child: View,
        accumulatedOffset: Point
    ) {
        val parentGroup = parent as ViewGroup
        accumulatedOffset.x += child.left
        accumulatedOffset.y += child.top
        if (parentGroup == mainParent) {
            return
        }
        getDeepChildOffset(mainParent, parentGroup.parent, parentGroup, accumulatedOffset)
    }
}