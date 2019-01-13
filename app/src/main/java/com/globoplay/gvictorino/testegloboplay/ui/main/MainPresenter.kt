package com.globoplay.gvictorino.testegloboplay.ui.main

import android.view.View
import com.globoplay.gvictorino.domain.programs.Program
import com.globoplay.gvictorino.domain.programs.ProgramUseCase
import com.globoplay.gvictorino.domain.programs.ProgramsCallback

class MainPresenter(
    private val view: MainView,
    private val getPrograms: ProgramUseCase) : ProgramsCallback, ProgramClickListener {

    private var isPaused = false
    private var mIsLoading = false
    private var programsList = listOf<Program>()

    fun onCreateView() {
        view.showLoad()
        mIsLoading = true
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
            mIsLoading = false
            view.addProgramsList(programList.map {ProgramViewModelMapper.from(it) }.toMutableList())
            this.programsList = programsList
        }
    }

    override fun onFailure(throwable: Throwable) {
        if (!isPaused) {
            view.showError()
        }
    }

    override fun onClickProgram(position: Int, sharedElement: View) {
        if (!isPaused) {
            val program = programsList[position]
            view.goToProgramDetails(program,sharedElement)
        }
    }
}
