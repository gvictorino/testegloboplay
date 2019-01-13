package com.globoplay.gvictorino.domain.programs

import com.globoplay.gvictorino.domain.UseCase

class ProgramUseCase(private val programContract: ProgramContract) : UseCase<Unit>(),ProgramsCallback {
    private lateinit var callback : ProgramsCallback
    private lateinit var contract : ProgramContract

    fun with(programsCallback: ProgramsCallback): ProgramUseCase {
        this.callback = programsCallback
        return this
    }

    override fun onSuccess(programList: MutableList<Program>) {
        callback.onSuccess(programList)
    }

    override fun onFailure(throwable: Throwable) {
        callback.onFailure(throwable)
    }

    override fun execute() {
        this.contract = programContract
        contract.getPrograms(callback)
    }
}