package com.ashtray.card.game.manager.features.hazari

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.common.ui.activity.BaseActivity
import com.ashtray.card.game.manager.features.twentynine.TwentyNineActivity

class HazariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hazari)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, TwentyNineActivity::class.java))
            }, 3000
        )
    }
}