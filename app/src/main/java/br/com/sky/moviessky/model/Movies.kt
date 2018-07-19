package br.com.sky.moviessky.model

import com.google.gson.annotations.SerializedName

class Movies {


    @SerializedName("id")
    val id: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("duration")
    val duration: String? = null

    @SerializedName("release_year")
    val releaseYear: String? = null

    @SerializedName("cover_url")
    val coverUrl: String? = null

    @SerializedName("backdrops_url")
    val backdropsUrl: ArrayList<String>? = null
}