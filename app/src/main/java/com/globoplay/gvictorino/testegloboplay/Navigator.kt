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

    fun goToProgramDetails(activity: Activity,
                           programID: Int,
                           programName: String,
                           thumb: String,
                           serviceID : Int,
                           videoID : Int,
                           programType : String,
                           kind : String,
                           fullEpisode : Boolean,
                           favorites : Int,
                           duration: String,
                           description : String,
                           trasitionView: View?) {

        val intent = Intent(activity, ProgramDetailsActivity::class.java).apply {
            putExtra(ProgramDetailsActivity.PROGRAM_ID, programID)
            putExtra(ProgramDetailsActivity.PROGRAM_NAME, programName)
            putExtra(ProgramDetailsActivity.PROGRAM_THUMB, thumb)
            putExtra(ProgramDetailsActivity.PROGRAM_SERVICEID, serviceID)
            putExtra(ProgramDetailsActivity.PROGRAM_VIDEOID, videoID)
            putExtra(ProgramDetailsActivity.PROGRAM_TYPE,programType)
            putExtra(ProgramDetailsActivity.PROGRAM_KIND, kind)
            putExtra(ProgramDetailsActivity.PROGRAM_FULL_EPISODE,fullEpisode)
            putExtra(ProgramDetailsActivity.PROGRAM_FAVORITES, favorites)
            putExtra(ProgramDetailsActivity.PROGRAM_DURATION, duration)
            putExtra(ProgramDetailsActivity.PROGRAM_DESCRIPTION, description)
        }

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

