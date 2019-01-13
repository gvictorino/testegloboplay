package com.globoplay.gvictorino.testegloboplay.builders

import com.globoplay.gvictorino.data.ProgramAPIClient
import com.globoplay.gvictorino.data.ProgramManager
import com.globoplay.gvictorino.domain.programs.ProgramUseCase

object ProgramUseCaseBuilder{
    fun create() : ProgramUseCase {
       return ProgramUseCase(ProgramManager(
           ProgramAPIClient()))
    }
}