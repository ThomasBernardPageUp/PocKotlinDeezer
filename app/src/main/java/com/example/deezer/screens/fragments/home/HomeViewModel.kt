package com.example.deezer.screens.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deezer.data.remote.dto.ArtistDto
import com.example.deezer.data.remote.dto.DeezerRootDto
import com.example.deezer.data.remote.services.ArtistService
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val artistService : ArtistService by KoinJavaComponent.inject(ArtistService::class.java)
    // TODO: Implement the ViewModel

    fun searchArtist(query : String, callback:(ArrayList<ArtistDto>?)->Unit){

        var result = artistService.search(query)

        viewModelScope.launch {
            result.enqueue(object : Callback<DeezerRootDto<ArtistDto>>{

                override fun onResponse(call: Call<DeezerRootDto<ArtistDto>>, response: Response<DeezerRootDto<ArtistDto>>) {
                    callback(response.body()?.data)
                }

                override fun onFailure(call: Call<DeezerRootDto<ArtistDto>>, t: Throwable) {
                    callback(null)
                }
            })
        }
    }
}