package com.azimzada.taskmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.azimzada.taskmvvm.ViewModels.CoffeVM
import com.azimzada.taskmvvm.databinding.ActivityMainBinding
import com.azimzada.taskmvvm.model.CoffeDTO
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var spinner : ProgressBar
    private lateinit var viewModel : CoffeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CoffeVM::class.java]

        spinner = findViewById(R.id.progressBar)
        spinner.visibility = View.GONE

        binding.button.setOnClickListener {
            spinner.visibility = View.VISIBLE
            viewModel.getCoffeeImage(this)
        }

        viewModel.observeCoffeeImage().observe(this, Observer { coffeImage ->
            Picasso.get().load(coffeImage).into(binding.imageView)
            spinner.visibility = View.GONE
        })

    }





}