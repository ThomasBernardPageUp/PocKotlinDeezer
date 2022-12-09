package com.example.deezer.screens.fragments.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import com.example.deezer.R
import com.example.deezer.screens.adapters.ArtistAdapter

class HomeFragment : Fragment() {

    var searchView : SearchView? = null
    var artistsListView : ListView? = null

    val currentContext  by lazy { this.context  }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel


        searchView = this.view?.findViewById(R.id.homeSearchView)
        artistsListView = this.view?.findViewById(R.id.artistsListView)


        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewModel.searchArtist(p0 ?: "", {
                    val artistAdapter = ArtistAdapter(currentContext!!, it!!)
                    artistsListView?.adapter = artistAdapter
                })

                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })

    }

}