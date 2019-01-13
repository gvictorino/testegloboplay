package com.globoplay.gvictorino.testegloboplay

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.globoplay.gvictorino.testegloboplay.ui.details.ProgramDetailsActivity
import com.globoplay.gvictorino.testegloboplay.ui.main.MainActivity

class Navigator(var activity: Activity) {
    fun goToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(intent)
        activity.finish()
    }

    fun goToProgramDetails(activity: Activity, videoID: Int, programName: String, thumb: String, trasitionView: View?) {
        val intent = Intent(activity, ProgramDetailsActivity::class.java)
        // intent.putExtra(ProgramDetailsActivity.SPECIAL_ID, id)
        // intent.putExtra(ProgramDetailsActivity.SPECIAL_NAME, name)
        //intent.putExtra(ProgramDetailsActivity.SPECIAL_IMG, img)
        if (trasitionView != null) {
            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                trasitionView,
                activity.getString(R.string.transitionImage)
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.startActivity(intent, optionsCompat.toBundle())
            }
        } else
            activity.startActivity(intent)
    }
}

