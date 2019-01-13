package com.globoplay.gvictorino.domain.details

import com.globoplay.gvictorino.domain.programs.Program

interface DetailsCallback{
    fun onSuccess(program : Program)
    fun onFailure(throwable: Throwable)
}