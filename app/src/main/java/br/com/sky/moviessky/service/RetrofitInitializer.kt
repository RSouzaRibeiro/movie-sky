package br.com.sky.moviessky.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    companion object {
        val BASE_URL = "https://sky-exercise.herokuapp.com/api/"
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun movieService(): Service.NoteService {
        return retrofit.create(Service.NoteService::class.java)
    }
}