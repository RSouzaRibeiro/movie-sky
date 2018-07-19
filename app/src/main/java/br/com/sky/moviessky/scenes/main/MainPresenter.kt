package br.com.sky.moviessky.scenes.main

import br.com.sky.moviessky.model.Movies
import br.com.sky.moviessky.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainInterface.View) : MainInterface.Presenter {


    override fun getMovies() {
        val call = RetrofitInitializer().movieService().getAllMovies()

        call.enqueue(object : Callback<ArrayList<Movies>> {
            override fun onFailure(call: Call<ArrayList<Movies>>?, t: Throwable?) {
                view.emitError(t!!.localizedMessage)
            }

            override fun onResponse(call: Call<ArrayList<Movies>>?, response: Response<ArrayList<Movies>>?) {
                if (response!!.isSuccessful) {
                    val movies = response.body()
                    if (movies != null) view.getMoviesSuccess(movies)
                }
            }


        })
    }
}