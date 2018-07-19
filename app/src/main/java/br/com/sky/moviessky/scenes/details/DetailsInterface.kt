package br.com.sky.moviessky.scenes.details

import br.com.sky.moviessky.model.Movies

interface DetailsInterface {

    interface View{
        fun getMovieSuccess(movie: Movies)
        fun emitError(message: String)
    }

    interface Presenter {
        fun getMovieById(id: String)
    }
}
