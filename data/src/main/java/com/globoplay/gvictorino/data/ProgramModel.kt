package com.globoplay.gvictorino.data

import com.google.gson.annotations.SerializedName

data class ProgramModel(
    @SerializedName("service_id")
    var serviceID: Int,
    @SerializedName("videoId")
    var programID: Int,
    @SerializedName("duration")
    var duration: String,
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