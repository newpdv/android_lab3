package com.example.lab3

import com.example.lab3.Models.Films
import retrofit2.Call
import retrofit2.http.GET

interface FilmsApi {
    @GET("/movie?token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06&field=year&search=2021&field=typeNumber&search=1&sortField=votes.kp&sortType=-1&limit=30")
    fun getFilms(): Call<Films>
}