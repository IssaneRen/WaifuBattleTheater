package com.issane.waifubattletheater.battleground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.issane.waifubattletheater.R
import com.issane.waifubattletheater.utils.setStatusBarAfterLollipop
import kotlinx.android.synthetic.main.including_toolbar_with_title_menu.*

abstract class BaseBattleGroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_battle_ground)
        tv_toolbar_center?.text = "PCR 竞技场"
        setStatusBarAfterLollipop(this, false, true)
    }
}