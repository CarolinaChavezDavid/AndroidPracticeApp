package com.example.myappcarolina.movies

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappcarolina.R
import com.example.myappcarolina.movies.model.MovieModel

class MoviesAdapter(private var movieList: List<MovieModel>, var context: Context):
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    fun setData(list: List<MovieModel>){
        movieList = list
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var poster: ImageView = itemView.findViewById(R.id.movie_poster)
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var ratingBar: RatingBar = itemView.findViewById(R.id.movie_ratingBar)
        var cardView : CardView = itemView.findViewById(R.id.item_card_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MovieViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val element = movieList[position]
        var colorRes = Color.parseColor("#FF6D00")
        when(position % 5){

            1 -> colorRes = Color.parseColor("#70D6FF")
            2 -> colorRes = Color.parseColor("#FF70A6")
            3 -> colorRes = Color.parseColor("#FF9770")
            4 -> colorRes = Color.parseColor("#FFD670")
            5 -> colorRes = Color.parseColor("#E9FF70")
        }
        holder.title.text = element.title
        holder.ratingBar.rating = element.rating.toFloat()
        holder.cardView.setCardBackgroundColor(colorRes)

        Glide.with(context)
            .load(movieList[position].poster)
            .fitCenter()
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}


