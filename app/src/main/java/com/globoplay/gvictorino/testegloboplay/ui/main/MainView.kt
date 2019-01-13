package com.globoplay.gvictorino.testegloboplay.ui.main

import android.view.View
import com.globoplay.gvictorino.domain.programs.Program

interface MainView{
    fun addProgramsList(programViewModel : MutableList<ProgramViewModel>)
    fun showError()
    fun goToProgramDetails(program: Program, sharedElement: View)
    fun showLoad()
    fun removeLoad()
}