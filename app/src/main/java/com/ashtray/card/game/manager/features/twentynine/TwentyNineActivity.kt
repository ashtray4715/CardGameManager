package com.ashtray.card.game.manager.features.twentynine

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.common.ui.activity.BaseActivity
import com.ashtray.card.game.manager.features.hazari.HazariActivity
import com.ashtray.card.game.manager.features.ninecard.NineCardActivity

class TwentyNineActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twenty_nine)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, NineCardActivity::class.java))
            }, 3000
        )
    }
}