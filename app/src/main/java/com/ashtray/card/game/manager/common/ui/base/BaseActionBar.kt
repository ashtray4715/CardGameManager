package com.ashtray.card.game.manager.common.ui.base

import android.widget.RelativeLayout
import android.widget.TextView
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.apps.MyLog
import java.lang.Exception

class BaseActionBar(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    companion object {
        private const val TAG = "BaseActionBar"
    }

    private var backListener: OnClickListener? = null
    private var menuListener: OnClickListener? = null

    private var ivBack: ImageView? = null
    private var ivMenu: ImageView? = null
    private var tvTitle: TextView? = null

    init {
        setViewAndInitializeComponents(context)
        addHandlerAndListenersWhereNecessary()
        drawComponentsForTheFirstTime(context, attrs)
    }

    fun setBackListener(backListener: OnClickListener?) {
        this.backListener = backListener
    }

    fun setMenuListener(menuListener: OnClickListener?) {
        this.menuListener = menuListener
    }

    fun setActionBarTitle(title: String?) {
        tvTitle?.text = title
    }

    private fun addHandlerAndListenersWhereNecessary() {
        ivBack?.setOnClickListener { view -> backListener?.onClick(view) }
        ivMenu?.setOnClickListener { view -> menuListener?.onClick(view) }
    }

    private fun setViewAndInitializeComponents(context: Context) {
        val cView = inflate(context, R.layout.custom_view_action_bar_layout, this)
        ivBack = cView.findViewById(R.id.iv_back_button)
        ivMenu = cView.findViewById(R.id.iv_menu_item)
        tvTitle = cView.findViewById(R.id.tv_title)
    }

    @SuppressLint("NonConstantResourceId")
    private fun drawComponentsForTheFirstTime(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseActionBar)
        try {
            val paramCount = typedArray.indexCount
            for (i in 0 until paramCount) {
                when (val currentAttribute = typedArray.getIndex(i)) {
                    R.styleable.BaseActionBar_actionbar_title -> {
                        setActionBarTitle(typedArray.getString(currentAttribute))
                    }
                    R.styleable.BaseActionBar_actionbar_back_btn_visibility -> {
                        val status = typedArray.getBoolean(currentAttribute, false)
                        ivBack?.visibility = if (status) VISIBLE else GONE
                    }
                    R.styleable.BaseActionBar_actionbar_back_btn_icon -> {
                        val resId0 = typedArray.getResourceId(currentAttribute, -1)
                        val drawable0 = ContextCompat.getDrawable(context, resId0)
                        ivBack?.visibility = VISIBLE
                        ivBack?.setImageDrawable(drawable0)
                    }
                    R.styleable.BaseActionBar_actionbar_menu_item_icon -> {
                        val resId1 = typedArray.getResourceId(currentAttribute, -1)
                        val drawable1 = ContextCompat.getDrawable(context, resId1)
                        ivMenu?.visibility = VISIBLE
                        ivMenu?.setImageDrawable(drawable1)
                    }
                    R.styleable.BaseActionBar_actionbar_menu_item_visibility -> {
                        val visibility1 = typedArray.getBoolean(currentAttribute, false)
                        ivMenu?.visibility = if (visibility1) VISIBLE else GONE
                    }
                }
            }
        } catch (e: Exception) {
            MyLog.e(TAG, "drawComponentsForTheFirstTime: problem occurs $e")
            e.printStackTrace()
        } finally {
            typedArray.recycle()
        }
    }


}