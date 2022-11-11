package com.ashtray.card.game.manager.apps

import android.util.Log

object MyLog {

    private const val TAG = "MG"

    fun i(tag: String, message: String) {
        Log.i("[$TAG]", "[$tag] $message")
    }

    fun e(tag: String, message: String) {
        Log.e("[$TAG]", "[$tag] $message")
    }
}