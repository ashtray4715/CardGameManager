package com.ashtray.card.game.manager.common.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.apps.MyLog

class StrokedSingleButton(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    private var mainLayout: RelativeLayout? = null
    private var textView: TextView? = null

    private var clickListener: OnClickListener? = null

    init {
        setViewAndInitializeComponents(context)
        addHandlerAndListenersWhereNecessary()
        drawComponentsForTheFirstTime(context, attrs)
    }

    fun setCustomClickListener(backListener: OnClickListener?) {
        this.clickListener = backListener
    }

    private fun addHandlerAndListenersWhereNecessary() {
        mainLayout?.setOnClickListener { view -> clickListener?.onClick(view) }
    }

    private fun setViewAndInitializeComponents(context: Context) {
        val cView = inflate(context, R.layout.custom_view_stroked_single_button, this)
        mainLayout = cView.findViewById(R.id.main_layout)
        textView = cView.findViewById(R.id.tv_title)
    }

    @SuppressLint("NonConstantResourceId")
    private fun drawComponentsForTheFirstTime(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StrokedSingleButton)
        try {
            val paramCount = typedArray.indexCount
            for (i in 0 until paramCount) {
                when (val currentAttribute = typedArray.getIndex(i)) {
                    R.styleable.StrokedSingleButton_ssb_text -> {
                        textView?.text = typedArray.getString(currentAttribute)
                    }
                }
            }
        } catch (e: Exception) {
            MyLog.e(TAG, "drawComponentsForTheFirstTime: problem occurs")
            e.printStackTrace()
        } finally {
            typedArray.recycle()
        }
    }

    companion object {
        private const val TAG = "StrokedSingleButton"
    }
}