package com.globoplay.gvictorino.testegloboplay.builders

import android.app.Activity
import com.globoplay.gvictorino.testegloboplay.ui.main.MainPresenter
import com.globoplay.gvictorino.testegloboplay.ui.main.MainView

object MainPresenterBuilder{
    fun create(activity: Activity, view : MainView) : MainPresenter{
        return MainPresenter(view, ProgramUseCaseBuilder.create())
    }
}