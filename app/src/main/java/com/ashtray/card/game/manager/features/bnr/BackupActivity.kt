package com.ashtray.card.game.manager.features.bnr

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ashtray.card.game.manager.R
import com.ashtray.card.game.manager.common.ui.activity.BaseActivity
import com.ashtray.card.game.manager.features.hazari.HazariActivity

class BackupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backup)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, RestoreActivity::class.java))
            }, 3000
        )
    }
}