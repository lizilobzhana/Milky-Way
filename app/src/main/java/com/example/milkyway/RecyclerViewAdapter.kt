package com.example.milkyway

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (private val list: List<Planets>) :
    RecyclerView.Adapter<RecyclerViewAdapter.PlanetViewHolder>() {
    class PlanetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val planet_img: ImageView
        val title: TextView
        val distance: TextView
        val gravity : TextView

        init {
            planet_img = itemView.findViewById(R.id.planet_img)
            title = itemView.findViewById(R.id.title)
            distance = itemView.findViewById(R.id.distance)
            gravity = itemView.findViewById(R.id.gravity)
        }

        fun setData(planets: Planets){

            title.text = planets.name
            distance.text = planets.distance
            gravity.text = planets.speed
            planet_img.setImageResource(planets.photo)




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_view,parent, false)
        return PlanetViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planets = list[position]
        holder.setData(planets)

    }

    override fun getItemCount() = list.size

}