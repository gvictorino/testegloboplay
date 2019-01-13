package com.globoplay.gvictorino.data

import retrofit2.Call
import retrofit2.http.GET

interface ProgramAPIService{
    @GET("videos")
    fun getPrograms(): Call<ProgramAPIResponse>
}