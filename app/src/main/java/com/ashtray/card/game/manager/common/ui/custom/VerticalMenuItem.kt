package com.ashtray.card.game.manager.common.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.apps.MyLog

class VerticalMenuItem(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    private var mainLayout: RelativeLayout? = null
    private var imageView: ImageView? = null
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
        val cView = inflate(context, R.layout.custom_view_vertical_menu_item, this)
        mainLayout = cView.findViewById(R.id.main_layout)
        imageView = cView.findViewById(R.id.image_view)
        textView = cView.findViewById(R.id.text_view)
    }

    @SuppressLint("NonConstantResourceId")
    private fun drawComponentsForTheFirstTime(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerticalMenuItem)
        try {
            val paramCount = typedArray.indexCount
            for (i in 0 until paramCount) {
                when (val currentAttribute = typedArray.getIndex(i)) {
                    R.styleable.VerticalMenuItem_vmi_text -> {
                        textView?.text = typedArray.getString(currentAttribute)
                    }
                    R.styleable.VerticalMenuItem_vmi_image -> {
                        val resId0 = typedArray.getResourceId(currentAttribute, -1)
                        val drawable0 = ContextCompat.getDrawable(context, resId0)
                        imageView?.setImageDrawable(drawable0)
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
        private const val TAG = "VerticalMenuItem"
    }

}