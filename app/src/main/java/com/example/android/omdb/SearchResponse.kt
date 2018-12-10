package com.example.android.omdb

import com.google.gson.annotations.SerializedName

class SearchResponse {

    @SerializedName("Search")//////"Search" from online & "result" is coming from old program thats y i used Serialized
    var result: List<MoviesClass> = listOf()
}