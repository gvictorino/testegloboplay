package com.globoplay.gvictorino.testegloboplay

import android.app.Activity
import android.content.Intent
import com.globoplay.gvictorino.testegloboplay.ui.main.MainActivity

class Navigator(var activity: Activity) {
    fun goToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(intent)
        activity.finish()
    }
}

