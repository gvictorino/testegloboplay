package com.globoplay.gvictorino.domain.programs

interface ProgramContract{
    fun getPrograms(callback: ProgramsCallback)
}