package com.globoplay.gvictorino.domain.programs

import org.junit.Test
import org.mockito.Mockito

class ProgramUseCaseTest{
    companion object {
        private const val DELAY = 200L
        private val contract = Mockito.mock(ProgramContract::class.java)
    }
    @Test
    fun getProgramsSuccess(){
        val throwable = Throwable("teste")
        val programs = ArrayList<Program>()
        val callback = Mockito.mock(ProgramsCallback::class.java)

        ProgramUseCase(contract).with(callback).onSuccess(programs)

        Mockito.verify(callback,Mockito.timeout(DELAY).times(1)).onSuccess(programs)
        Mockito.verify(callback,Mockito.timeout(DELAY).times(0)).onFailure(throwable)
    }

    @Test
    fun getProgramsFailure(){
        val throwable = Throwable("teste")
        val programs = ArrayList<Program>()
        val callback = Mockito.mock(ProgramsCallback::class.java)

        ProgramUseCase(contract).with(callback).onFailure(throwable)

        Mockito.verify(callback,Mockito.timeout(DELAY).times(0)).onSuccess(programs)
        Mockito.verify(callback,Mockito.timeout(DELAY).times(1)).onFailure(throwable)
    }
}
