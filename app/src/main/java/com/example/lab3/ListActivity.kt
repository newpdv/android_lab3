package com.example.lab3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.ArrayAdapter
import com.example.lab3.Models.Films
import com.example.lab3.Services.FilmService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        getFilms()
    }

    fun getFilms() {
        listView = findViewById(R.id.films_list)

        val context: Context = this

        val callListFilms = FilmService.instance?.filmsApi?.getFilms()
        val callback = object : Callback<Films> {
            override fun onResponse(call: Call<Films>, response: Response<Films>) {
                val filmList: Films? = response.body()
                val filmListResult: MutableList<String> = mutableListOf()

                filmList?.films?.forEach {
                    filmListResult.add("${it.name} (${it.year})")
                }

                val adapter: ArrayAdapter<String?> = ArrayAdapter(
                    context,
                    android.R.layout.simple_list_item_1,
                    filmListResult as List<String?>,
                )

                listView.adapter = adapter
            }

            override fun onFailure(call: Call<Films>, t: Throwable) {
                Log.w("Something went wrong", t.message.toString())
            }
        }

        callListFilms?.enqueue(callback)
    }
}