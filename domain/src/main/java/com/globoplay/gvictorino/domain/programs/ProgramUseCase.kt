package com.globoplay.gvictorino.domain.programs

import com.globoplay.gvictorino.domain.UseCase

class ProgramUseCase(programContract: ProgramContract) : UseCase<Unit>(),ProgramsCallback {
    private val programs = programContract
    private lateinit var callback : ProgramsCallback

    fun with(callback: ProgramsCallback){
        this.callback = callback
    }

    override fun onSuccess(programList: List<Program>) {
        callback.onSuccess(programList)
    }

    override fun onFailure(throwable: Throwable) {
        callback.onFailure(throwable)
    }

    override fun execute() {
        programs.getPrograms(this)
    }
}