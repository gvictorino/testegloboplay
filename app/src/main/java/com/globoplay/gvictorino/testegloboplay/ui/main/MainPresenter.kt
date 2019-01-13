package com.globoplay.gvictorino.testegloboplay.ui.main

import android.app.Activity
import android.view.View
import com.globoplay.gvictorino.domain.programs.Program
import com.globoplay.gvictorino.domain.programs.ProgramUseCase
import com.globoplay.gvictorino.domain.programs.ProgramsCallback
import com.globoplay.gvictorino.testegloboplay.Navigator

class MainPresenter(
    private val view: MainView,
    private val getPrograms: ProgramUseCase,
    private val navigator: Navigator, private val activity: Activity) : ProgramsCallback, ProgramClickListener {

    private var isPaused = false
    private var isLoading = false
    private var programs = listOf<Program>()

    fun onCreateView() {
        view.showLoad()
        isLoading = true
        getPrograms.with(this).execute()
    }

    fun onResume() {
        isPaused = false
        view.removeLoad()
    }

    fun onViewPaused() {
        isPaused = true
    }

    fun onClickTryAgain() {
        view.showLoad()
        getPrograms.with(this).execute()
    }

    override fun onSuccess(programList: MutableList<Program>) {
        if (!isPaused) {
            isLoading = false
            view.addProgramsList(programList.map {ProgramViewModelMapper.from(it) }.toMutableList())
            this.programs = programList
        }
    }

    override fun onFailure(throwable: Throwable) {
        if (!isPaused) {
            view.showError()
        }
    }

    override fun onClickProgram(position: Int, sharedElement: View) {
        if (!isPaused) {
            val program = programs[position]
            navigator.goToProgramDetails(activity,
                program.programID,
                program.programName,
                program.thumb,
                program.serviceID,
                program.videoID,
                program.programType,
                program.kind,
                program.fullEpisode,
                program.favorites,
                program.duration,
                program.description,
                sharedElement)
        }
    }
}
