package br.com.sky.moviessky.scenes.details

import br.com.sky.moviessky.model.Movies
import br.com.sky.moviessky.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsPresenter(val view: DetailsInterface.View): DetailsInterface.Presenter {

    override fun getMovieById(id: String) {
        val call = RetrofitInitializer().movieService().getMovieById(id)

        call.enqueue(object : Callback<Movies>{
            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                view.emitError(t!!.localizedMessage)
            }

            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                if(response!!.isSuccessful){
                    var movie = response.body()
                    if(movie!=null){
                        view.getMovieSuccess(movie!!)
                    }

                }
            }

        })
    }
}