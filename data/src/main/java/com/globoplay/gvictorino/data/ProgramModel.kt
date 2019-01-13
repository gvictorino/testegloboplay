package com.globoplay.gvictorino.data

import com.google.gson.annotations.SerializedName

data class ProgramModel(
    @SerializedName("servide_id")
    var serviceID: Int,
    @SerializedName("program_id")
    var programID: Int,
    @SerializedName("duration")
    var duration: Int,
    @SerializedName("description")
    var description: String,
    @SerializedName("favorites")
    var favorites: Int,
    @SerializedName("full_episode")
    var fullEpisode: Boolean,
    @SerializedName("kind")
    var kind: String,
    @SerializedName("program_type")
    var programType: String,
    @SerializedName("programName")
    var programName: String,
    @SerializedName("thumb")
    var thumb: String
)