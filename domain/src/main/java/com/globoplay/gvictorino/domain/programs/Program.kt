package com.globoplay.gvictorino.domain.programs

class Program(
    val serviceID : Int = 0,
    val videoID : Int = 0,
    val programID : Int = 0,
    val fullEpisode : Boolean = false,
    val kind : String = "",
    val programType : String = "",
    val programName : String = "",
    val favorites : Int = 0,
    val duration: String = "",
    val thumb : String = "",
    val description : String = ""
)