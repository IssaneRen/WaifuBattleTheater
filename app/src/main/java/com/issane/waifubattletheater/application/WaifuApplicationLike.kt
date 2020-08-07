package com.issane.waifubattletheater.application

import android.app.Application

class WaifuApplicationLike: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: WaifuApplicationLike? = null
    }
}