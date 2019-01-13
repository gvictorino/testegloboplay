package com.globoplay.gvictorino.testegloboplay.ui.main

data class ProgramViewModel(
  var thumb : String = "",
  var favorites : Int = 0,
  var duration: String = "",
  var programName : String = "",
  var kind : String = "",
  var programType : String = "",
  var fullEpisode : Boolean = false,
  var serviceID : Int = 0,
  var programID : Int = 0,
  var videoID : Int = 0)