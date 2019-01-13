package com.globoplay.gvictorino.testegloboplay.ui.details

import android.app.Activity
import android.os.Bundle
import com.globoplay.gvictorino.testegloboplay.R

class ProgramDetailsActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

    }


    companion object {
    val PROGRAM_ID = "ProgramID"
    val PROGRAM_NAME = "ProgramName"
    val PROGRAM_THUMB = "ProgramThumb"
    }
}
