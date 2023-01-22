package com.ashtray.card.game.manager.common.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.common.helpers.CustomInputFilter
import com.ashtray.card.game.manager.common.helpers.SafeRunner

class BasicInputField(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    private var tvTitle: TextView? = null
    private var ivIcon: ImageView? = null
    private var etInputField: EditText? = null
    private var tvErrorMsg: TextView? = null

    private val textChangeListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // nothing to do
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // nothing to do
        }

        override fun afterTextChanged(p0: Editable?) {
            if (tvErrorMsg?.visibility == View.VISIBLE) {
                tvErrorMsg?.visibility = View.INVISIBLE
            }
        }
    }

    init {
        setViewAndInitializeComponents(context)
        drawComponentsForTheFirstTime(context, attrs)
        addListenersAndHandlers()
    }

    private fun setViewAndInitializeComponents(context: Context) {
        val cView = inflate(context, R.layout.custom_view_basic_input_field, this)
        tvTitle = cView.findViewById(R.id.text_view)
        ivIcon = cView.findViewById(R.id.image_view)
        etInputField = cView.findViewById(R.id.edit_text)
        tvErrorMsg = cView.findViewById(R.id.tv_error_message)
    }

    @SuppressLint("NonConstantResourceId")
    private fun drawComponentsForTheFirstTime(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BasicInputField)
        SafeRunner {
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
                    R.styleable.BasicInputField_bif_input_max_length -> {
                        val maxLen = typedArray.getInt(currentAttribute, 0)
                        addInputFilter(CustomInputFilter().getInputLengthFilter(maxLen))
                    }
                    R.styleable.BasicInputField_bif_input_type -> {
                        setInputType(typedArray.getInt(currentAttribute, 0))
                    }
                }
            }
        }
        typedArray.recycle()
    }

    private fun addListenersAndHandlers() {
        etInputField?.addTextChangedListener(textChangeListener)
    }

    private fun addInputFilter(filter: InputFilter) {
        val newList = mutableListOf<InputFilter>()
        newList.addAll(etInputField?.filters ?: emptyArray())
        newList.add(filter)
        etInputField?.filters = newList.toTypedArray()
    }

    private fun setInputType(inputType: Int) {
        when (inputType) {
            1 -> { // positive decimal number
                etInputField?.inputType =
                    InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                addInputFilter(CustomInputFilter().getPositiveNumberInputFilter())
            }
            else -> { // default input type text
                etInputField?.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            }
        }
    }

    fun getInputText(): String {
        return etInputField?.text.toString()
    }

    fun setErrorMessage(message: String?) {
        message?.let {
            tvErrorMsg?.text = it
            tvErrorMsg?.visibility = View.VISIBLE
            etInputField?.requestFocus()
        }
    }
}