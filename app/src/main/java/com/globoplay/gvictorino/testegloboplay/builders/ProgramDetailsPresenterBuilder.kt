package com.globoplay.gvictorino.testegloboplay.builders

import android.app.Activity
import com.globoplay.gvictorino.testegloboplay.ui.details.ProgramDetailsPresenter
import com.globoplay.gvictorino.testegloboplay.ui.details.ProgramDetailsView

object ProgramDetailsPresenterBuilder{
    fun create(view : ProgramDetailsView) : ProgramDetailsPresenter{
        return ProgramDetailsPresenter(view)
    }
}