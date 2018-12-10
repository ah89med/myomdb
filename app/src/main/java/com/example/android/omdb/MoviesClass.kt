package com.example.android.omdb

import com.google.gson.annotations.SerializedName

class MoviesClass {
    @SerializedName("Title")
    val title:String = ""
    @SerializedName("Year")
    val year : String = ""
    @SerializedName("imdbID")
    var imdbid: String = " "
    @SerializedName("Type")
    var type: String = ""
    @SerializedName("Poster")
    var imageURL : String = ""
    var url: String="https://www.google.com/"
}