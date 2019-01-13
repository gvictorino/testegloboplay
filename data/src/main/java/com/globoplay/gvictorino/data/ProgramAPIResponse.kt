package com.globoplay.gvictorino.data

import com.google.gson.annotations.SerializedName

class ProgramAPIResponse {
    @SerializedName("content")
    var programsList: List<ProgramModel> = listOf()
}
