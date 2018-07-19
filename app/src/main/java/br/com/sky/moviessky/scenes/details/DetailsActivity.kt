package br.com.sky.moviessky.scenes.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import br.com.sky.moviessky.R
import br.com.sky.moviessky.model.Movies
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), DetailsInterface.View {


    private val presenter = DetailsPresenter(this)
    var movie = Movies()

    companion object {
        var MOVIE_ID = "movieId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        intent.extras.get(MOVIE_ID)?.let {
            presenter.getMovieById(it.toString())
        }

        initToolbar()

    }

    private fun initToolbar() {

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun initView(movie: Movies) {
        setPoster(movie.backdropsUrl?.get(0)!!)
        titleTXT.text = movie.title
        sinopeseTXT.text = movie.overview
        dateReleaseTXT.text = movie.releaseYear


    }

    private fun setPoster(urlPath: String) {
        Picasso.with(this)
                .load(urlPath)
                .placeholder(R.drawable.movie_placeholder)
                .into(posterMovieIMG)


    }

    override fun getMovieSuccess(movie: Movies) {
        initView(movie)
        progressBar.visibility = View.GONE
    }

    override fun emitError(message: String) {
        Toast.makeText(this, getString(R.string.message_erro_request)+"\n"+message, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }

}
