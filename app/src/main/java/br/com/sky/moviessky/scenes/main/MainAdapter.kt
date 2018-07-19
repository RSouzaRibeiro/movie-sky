package br.com.sky.moviessky.scenes.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.sky.moviessky.R
import br.com.sky.moviessky.model.Movies
import br.com.sky.moviessky.scenes.details.DetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MainAdapter(val context: Context, val  listMovies: ArrayList<Movies>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var movie = listMovies[position]

        holder.itemView.nameMovieTXT.text = movie.title

        Picasso.with(context)
                .load(movie.coverUrl)
                .placeholder(R.drawable.movie_placeholder)
                .into(holder.itemView.movieIMG)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.MOVIE_ID, movie.id)
            context.startActivity(intent)


        }
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}