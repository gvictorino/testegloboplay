package com.globoplay.gvictorino.data

import android.util.Log
import com.globoplay.gvictorino.domain.programs.Program
import com.globoplay.gvictorino.domain.programs.ProgramContract
import com.globoplay.gvictorino.domain.programs.ProgramsCallback

class ProgramManager(private val apiClient: ProgramAPIClient) : ProgramContract{
    private lateinit var programsCallback: ProgramsCallback

    override fun getPrograms(callback: ProgramsCallback) {
        this.programsCallback = callback
        Log.d(TAG,"getting programs list")
        apiClient.getProgramsList(object : ProgramAPICallback {
            override fun onResponse(response: ProgramAPIResponse) {
                val programsList = mutableListOf<Program>()
                for(program in response.programsList)
                    programsList.add(ProgramModelMapper.from(program))
                callback.onSuccess(programsList)
            }
            override fun onFailure(throwable: Throwable) {
                callback.onFailure(throwable)
            }
        })
    }

    companion object {
        private val TAG = "ProgramManager"
    }
}
