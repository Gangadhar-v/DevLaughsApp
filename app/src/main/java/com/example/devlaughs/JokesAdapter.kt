package com.example.devlaughs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class JokesAdapter(val jokes: ArrayList<String>):Adapter<JokesAdapter.JokesViewHolder>() {

    inner class JokesViewHolder(view: View):ViewHolder(view){
        val tv = view.findViewById<TextView>(R.id.joketv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.joke_item,parent,false)

        return JokesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return jokes.size
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {

        var joke = jokes.get(position)

        holder.tv.text = joke
    }
}