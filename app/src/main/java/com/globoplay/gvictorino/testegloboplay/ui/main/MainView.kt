package com.globoplay.gvictorino.testegloboplay.ui.main

interface MainView{
    fun addProgramsList(programViewModel : MutableList<ProgramViewModel>)
    fun showError()
    fun showLoad()
    fun removeLoad()
}