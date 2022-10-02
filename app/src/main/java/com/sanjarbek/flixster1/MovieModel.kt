package com.sanjarbek.flixster1

import android.util.EventLogTags

class MovieModel {
    private lateinit var original_title: String
    private lateinit var poster_path: String
    private lateinit var overview: String

    constructor(original_title: String, poster_path: String, overview: String) {
        this.original_title = original_title
        this.poster_path = poster_path
        this.overview = overview
    }

    fun get_title(): String{
        return original_title
    }

    fun get_image(): String{
        return poster_path
    }

    fun get_description(): String{
        return overview
    }

}