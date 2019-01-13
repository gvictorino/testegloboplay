package com.globoplay.gvictorino.testegloboplay.ui.main

import com.globoplay.gvictorino.domain.programs.Program

class ProgramViewModelMapper{
    companion object {
        fun from(program: Program) = ProgramViewModel(
            thumb = program.thumb,
            favorites = program.favorites,
            duration = program.duration,
            programName = program.programName,
            kind = program.kind,
            programType = program.programType,
            fullEpisode = program.fullEpisode,
            serviceID = program.serviceID,
            videoID = program.videoID,
            programID = program.programID,
            description = program.description
       )
    }
}