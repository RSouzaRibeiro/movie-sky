package br.com.sky.moviessky.service


import br.com.sky.moviessky.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


class Service {


    interface NoteService {

        @GET("Movies/")
        fun getAllMovies(): Call<ArrayList<Movies>>


        @GET("Movies/{id}")
        fun getMovieById(@Path("id") id: String): Call<Movies>




    }
}