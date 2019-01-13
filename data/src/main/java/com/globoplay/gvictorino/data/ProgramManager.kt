package com.globoplay.gvictorino.data

import android.util.Log
import com.globoplay.gvictorino.domain.programs.Program
import com.globoplay.gvictorino.domain.programs.ProgramContract
import com.globoplay.gvictorino.domain.programs.ProgramsCallback

class ProgramManager(private val apiClient: ProgramAPIClient) : ProgramContract {
    private lateinit var callback: ProgramsCallback

    override fun getPrograms(callback: ProgramsCallback) {
        this.callback = callback
        Log.d(TAG,"getting programs list")
        apiClient.getPrograms(object : ProgramAPICallback {
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
