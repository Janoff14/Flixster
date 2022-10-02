package com.sanjarbek.flixster1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val context: Context, val movieModelArrayList: ArrayList<MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = movieModelArrayList.get(position)
        holder.title.text = model.get_title()
        holder.description.text = model.get_description()
        val image_url = "https://image.tmdb.org/t/p/w500/" + model.get_image()

        Glide.with(context)
            .load(image_url)
            .override(300, 200)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return movieModelArrayList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.img_movie)
        val title = itemView.findViewById<TextView>(R.id.txt_title)
        val description = itemView.findViewById<TextView>(R.id.txt_description)
    }
}