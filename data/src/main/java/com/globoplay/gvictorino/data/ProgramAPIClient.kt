package com.globoplay.gvictorino.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProgramAPIClient {
    private val apiService: ProgramAPIService

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        this.apiService = retrofit.create<ProgramAPIService>(ProgramAPIService::class.java)
    }

    fun getPrograms(callback: ProgramAPICallback) {
        apiService.getPrograms(callback).enqueue(object : Callback<ProgramAPIResponse> {
            override fun onResponse(call: Call<ProgramAPIResponse>, response: Response<ProgramAPIResponse>) {
                if (response.isSuccessful && response.body() != null)
                    callback.onResponse(response.body() as ProgramAPIResponse)
                else
                    callback.onFailure(Throwable("Não completou requisição ou body nulo"))
            }

            override fun onFailure(call: Call<ProgramAPIResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    companion object {
        private val BASE_URL = "http://private-95c9d-testegloboplay.apiary-mock.com/"
    }

}
