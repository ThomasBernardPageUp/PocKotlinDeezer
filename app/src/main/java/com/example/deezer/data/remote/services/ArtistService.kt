package com.example.deezer.data.remote.services

import com.example.deezer.data.remote.dto.ArtistDto
import com.example.deezer.data.remote.dto.DeezerRootDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistService {

    @GET("search/artist?")
    fun search(@Query(value = "q") query : String) : Call<DeezerRootDto<ArtistDto>>
}