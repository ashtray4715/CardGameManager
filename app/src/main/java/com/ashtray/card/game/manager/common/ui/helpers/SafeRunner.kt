package com.ashtray.card.game.manager.common.ui.helpers

import com.ashtray.card.game.manager.apps.MyLog

class SafeRunner(runnable: Runnable) {

    init {
        try {
            runnable.run()
        } catch (e: Exception) {
            MyLog.e(TAG, "SafeRunner: catches error [$e]")
            e.printStackTrace()
        }
    }

    companion object {
        private const val TAG = "SafeRunner"
    }
}