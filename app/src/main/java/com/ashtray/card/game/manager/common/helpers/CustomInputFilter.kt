package com.ashtray.card.game.manager.common.helpers

import android.text.InputFilter
import android.text.Spanned

class CustomInputFilter {

    fun getPositiveNumberInputFilter(): InputFilter {
        return object : InputFilter {
            override fun filter(
                string: CharSequence,
                start: Int,
                end: Int,
                spanned: Spanned?,
                dStart: Int,
                dEnd: Int
            ): CharSequence? {
                for (i in start until end) {
                    if (string[i] in '0'..'9') {
                        continue
                    }
                    return ""
                }
                return null
            }
        }
    }

    fun getInputLengthFilter(maxLen: Int): InputFilter {
        return InputFilter.LengthFilter(maxLen)
    }
}