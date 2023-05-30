package com.azimzada.taskmvvm.api

import com.azimzada.taskmvvm.model.CoffeDTO
import retrofit2.Call
import retrofit2.http.GET


interface API {
    @GET("random.json")
    fun getImage() : Call<CoffeDTO>
}