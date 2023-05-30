package com.azimzada.taskmvvm.retrofit

import android.provider.SyncStateContract
import com.azimzada.taskmvvm.Constant
import com.azimzada.taskmvvm.api.API
import com.azimzada.taskmvvm.model.CoffeDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        var instance : RetrofitClient? = null
        lateinit var api : API
        fun getRetrofitInstance(): RetrofitClient? {
            if (instance == null) {
                instance = RetrofitClient()
                val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create<API>(API::class.java)
            }
            return instance
        }
    }

    fun getApi(): API? {
        return api
    }
}