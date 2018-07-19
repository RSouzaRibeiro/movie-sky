package br.com.sky.moviessky.scenes.main

import br.com.sky.moviessky.model.Movies

interface MainInterface {

    interface View{
        fun getMoviesSuccess(movies: ArrayList<Movies>)
        fun emitError(message: String)

    }

    interface Presenter{
        fun getMovies()
    }
}