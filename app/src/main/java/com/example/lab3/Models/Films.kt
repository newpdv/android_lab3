package com.example.lab3.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Films {
    @SerializedName("docs")
    @Expose
    var films: List<FilmInfo>? = null
}

class FilmInfo {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("year")
    @Expose
    var year: Int? = null
}