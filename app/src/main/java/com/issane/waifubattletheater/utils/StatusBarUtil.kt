package com.issane.waifubattletheater.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi

private val isZUK = Build.MODEL != null && Build.MODEL.contains("ZUK")

fun setStatusBarAfterLollipop(activity: Activity?, fullScreen: Boolean, blackFontColor: Boolean) =
    setStatusBarAfterLollipop(
        activity,
        fullScreen,
        blackFontColor,
        if (fullScreen) Color.TRANSPARENT else Color.WHITE
    )

fun setStatusBarAfterLollipop(
    activity: Activity?, fullScreen: Boolean
    , blackFontColor: Boolean, statusBarColor: Int
) {
    if (activity == null)
        return

    try {
        val window = activity.window
        var flag = window.decorView.systemUiVisibility
        val tempFlag = flag
        flag = when {
            fullScreen -> flag or (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            else -> flag and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !isZUK) {
            flag = when {
                blackFontColor -> flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                else -> flag and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        } else {
            flag = flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.decorView.systemUiVisibility = flag
            return
        }
        if (tempFlag != flag) {
            window.decorView.systemUiVisibility = flag
        }
        setStatusBarColor(window, statusBarColor)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
private fun setStatusBarColor(window: Window, color: Int) {
    if (window.statusBarColor == color) {
        return
    }
    window.statusBarColor = color
}