package com.sanjarbek.flixster1

import com.codepath.asynchttpclient.AsyncHttpClient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.codepath.asynchttpclient.AbsCallback
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.Headers
import org.json.JSONException
import javax.security.auth.callback.CallbackHandler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rcv_root)
        val arrayListModel = ArrayList<MovieModel>()

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)

        val url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1\n" +
                "&limit=100&page=1"
        val jsonObjectRequest: JsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, {response->
            Log.d("array", "onCreate: sdfadad${arrayListModel.size}")

            try {
                val results = response.getJSONArray("results")
                for (i in 0..results.length()){
                    val movie = results.getJSONObject(i)
                    val title = movie.getString("title")
                    val overview = movie.getString("overview")
                    val image = movie.getString("poster_path")

                    val movieModel = MovieModel(title, image, overview)
                    arrayListModel.add(movieModel)

                }
                Log.d("array", "onCreate: sdfadad${arrayListModel.size}")

            }
            catch (e: JSONException){

            }

        }, {

        })
        requestQueue.add(jsonObjectRequest)

        Log.d("array", "onCreate: ${arrayListModel.size}")
        val adapter = MovieAdapter(this, arrayListModel)
        recyclerView.adapter = adapter
    }
}