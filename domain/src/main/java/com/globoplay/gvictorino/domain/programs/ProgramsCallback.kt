package com.globoplay.gvictorino.domain.programs

interface ProgramsCallback{
    fun onSuccess(programList: MutableList<Program>)
    fun onFailure(throwable: Throwable)
}
