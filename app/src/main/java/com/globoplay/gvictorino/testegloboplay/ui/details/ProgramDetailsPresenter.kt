package com.globoplay.gvictorino.testegloboplay.ui.details

class ProgramDetailsPresenter(private val view: ProgramDetailsView){
    private var isPaused : Boolean = false
    private var isLoading : Boolean = false

   fun onCreateView(){
       view.showLoad()
       isLoading = true
       view.addProgramDetails()
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
        view.addProgramDetails()
    }
}

