package com.globoplay.gvictorino.data

import com.globoplay.gvictorino.domain.programs.Program

class ProgramModelMapper{
    companion object {
        fun from(programModel : ProgramModel) = Program(
            serviceID = programModel.serviceID,
            videoID = programModel.programID,
            programName = programModel.programName,
            favorites = programModel.favorites,
            duration = programModel.duration,
            thumb = programModel.thumb
      )
    }
}