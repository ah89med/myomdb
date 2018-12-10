package com.example.android.omdb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                search(s.toString())
            }

        })


    }

    fun search(searchQuery: String) {
        val apikey= Consts.KEY_ID
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieInterface = retrofit.create(MovieInterface::class.java)

        movieInterface.searchMovie(apikey,searchQuery)
            .enqueue(object : Callback<SearchResponse> {
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {

                    Log.i("", "${response.raw()}")
                    response.body()?.let {
                        prepareRecyclerView(it.result)
                    }
                }

            })

    }

    private fun prepareRecyclerView(movieList: List<MoviesClass>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movieList)
    }
}



