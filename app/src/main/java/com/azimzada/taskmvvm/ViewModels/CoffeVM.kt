package com.azimzada.taskmvvm.ViewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimzada.taskmvvm.model.CoffeDTO
import com.azimzada.taskmvvm.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoffeVM : ViewModel() {

    var coffeeImage = MutableLiveData<String>()
    fun getCoffeeImage(context : Context) {
        val call: Call<CoffeDTO>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getImage()
        call?.enqueue(object : Callback<CoffeDTO?> {
            override fun onResponse(call: Call<CoffeDTO?>?, response: Response<CoffeDTO?>) {
                val coffeeImage: CoffeDTO? = response.body()
                this@CoffeVM.coffeeImage.postValue(coffeeImage?.file)
            }
            override fun onFailure(call: Call<CoffeDTO?>?, t: Throwable?) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    fun observeCoffeeImage() : LiveData<String>{
        return coffeeImage
    }

}