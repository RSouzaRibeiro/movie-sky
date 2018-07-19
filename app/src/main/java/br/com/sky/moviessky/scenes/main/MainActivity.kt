package br.com.sky.moviessky.scenes.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.widget.Toast
import br.com.sky.moviessky.R
import br.com.sky.moviessky.model.Movies
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainInterface.View {


    private var inFilter = false
    private var searchView: SearchView? = null

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        swipeRefreshConfig()
        getMovies()

    }

    private fun initToolbar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

    }

    private fun swipeRefreshConfig() {

        swipeRefresh.setOnRefreshListener {
            if (!inFilter) getMovies()
            else swipeRefresh.isRefreshing = false
        }
    }

    private fun getMovies() {
        presenter.getMovies()
    }

    private fun initRecycleView(result: ArrayList<Movies>) {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MainAdapter(this, result)


    }


    override fun getMoviesSuccess(movies: ArrayList<Movies>) {
        initRecycleView(movies)
        swipeRefresh.isRefreshing = false
    }

    override fun emitError(message: String) {
        Toast.makeText(this, getString(R.string.message_erro_request)+"\n"+message, Toast.LENGTH_LONG).show()
        swipeRefresh.isRefreshing = false
    }
}
