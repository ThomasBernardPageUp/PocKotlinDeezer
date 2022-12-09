package com.example.deezer.screens.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.deezer.R
import com.example.deezer.data.remote.dto.ArtistDto
import com.squareup.picasso.Picasso

class ArtistAdapter(var myContext: Context, var values: ArrayList<ArtistDto>)
    :ArrayAdapter<ArtistDto>(myContext, R.layout.item_artist, values)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var artist = values[position]
        val itemView = LayoutInflater.from(myContext).inflate(R.layout.item_artist, parent, false)

        val artistImageView : ImageView = itemView.findViewById(R.id.artistImageView)
        val artistNameTextView : TextView = itemView.findViewById(R.id.artistNameTextView)

        artistNameTextView.text = artist.name
        Picasso.get().load(artist.picture_medium).into(artistImageView)


        return itemView
    }
}