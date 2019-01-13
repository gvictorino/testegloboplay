package com.globoplay.gvictorino.domain.details

import com.globoplay.gvictorino.domain.UseCase
import com.globoplay.gvictorino.domain.programs.Program

class DetailsUseCase(private var detailsContract: DetailsContract) : UseCase<Unit>(),DetailsCallback {
    private lateinit var callback : DetailsCallback
    private lateinit var contract : DetailsContract

    fun with(detailsCallback: DetailsCallback): DetailsUseCase {
        this.callback = detailsCallback
        return this
    }

    override fun execute() {
        this.contract = detailsContract
        contract.getProgramDetail(callback)
    }

    override fun onSuccess(program: Program) {
        callback.onSuccess(program)
    }

    override fun onFailure(throwable: Throwable) {
        callback.onFailure(throwable)
    }
}