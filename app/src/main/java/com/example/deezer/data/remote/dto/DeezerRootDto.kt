package com.example.deezer.data.remote.dto

class DeezerRootDto<T> {
    var data: ArrayList<T>? = null
    var total = 0
    var next: String? = null
}