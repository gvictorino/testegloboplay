package com.globoplay.gvictorino.domain.programs

interface ProgramsCallback{
    fun onSuccess(programList: List<Program>)
    fun onFailure(throwable: Throwable)
}
