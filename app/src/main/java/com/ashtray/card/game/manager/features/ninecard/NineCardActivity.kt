package com.ashtray.card.game.manager.features.ninecard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.common.ui.activity.BaseActivity
import com.ashtray.card.game.manager.features.bnr.BackupActivity
import com.ashtray.card.game.manager.features.hazari.HazariActivity

class NineCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine_card)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, BackupActivity::class.java))
            }, 3000
        )
    }
}