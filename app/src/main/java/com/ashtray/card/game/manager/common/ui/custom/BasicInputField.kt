package com.ashtray.card.game.manager.common.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.apps.MyLog

class BasicInputField(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    private var tvTitle: TextView? = null
    private var ivIcon: ImageView? = null
    private var etInputField: EditText? = null

    init {
        setViewAndInitializeComponents(context)
        drawComponentsForTheFirstTime(context, attrs)
    }

    private fun setViewAndInitializeComponents(context: Context) {
        val cView = inflate(context, R.layout.custom_view_basic_input_field, this)
        tvTitle = cView.findViewById(R.id.text_view)
        ivIcon = cView.findViewById(R.id.image_view)
        etInputField = cView.findViewById(R.id.edit_text)
    }

    @SuppressLint("NonConstantResourceId")
    private fun drawComponentsForTheFirstTime(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BasicInputField)
        try {
            val paramCount = typedArray.indexCount
            for (i in 0 until paramCount) {
                when (val currentAttribute = typedArray.getIndex(i)) {
                    R.styleable.BasicInputField_bif_title -> {
                        tvTitle?.text = typedArray.getString(currentAttribute)
                    }
                    R.styleable.BasicInputField_bif_title_visibility -> {
                        val visibility1 = typedArray.getBoolean(currentAttribute, false)
                        tvTitle?.visibility = if (visibility1) VISIBLE else GONE
                    }
                    R.styleable.BasicInputField_bif_text -> {
                        etInputField?.setText(typedArray.getString(currentAttribute))
                    }
                    R.styleable.BasicInputField_bif_hint -> {
                        etInputField?.hint = typedArray.getString(currentAttribute)
                    }
                    R.styleable.BasicInputField_bif_image -> {
                        val resId1 = typedArray.getResourceId(currentAttribute, -1)
                        val drawable1 = ContextCompat.getDrawable(context, resId1)
                        ivIcon?.setImageDrawable(drawable1)
                    }
                    R.styleable.BasicInputField_bif_image_visibility -> {
                        val visibility2 = typedArray.getBoolean(currentAttribute, false)
                        ivIcon?.visibility = if (visibility2) VISIBLE else GONE
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

    fun getInputText(): String {
        return etInputField?.text.toString()
    }

    companion object {
        private const val TAG = "VerticalMenuItem"
    }
}