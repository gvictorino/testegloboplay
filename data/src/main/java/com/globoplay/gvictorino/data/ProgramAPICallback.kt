package com.globoplay.gvictorino.data

interface ProgramAPICallback {
    fun onResponse(response: ProgramAPIResponse)
    fun onFailure(throwable: Throwable)
}
