package com.dhananjay.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dhananjay.testapplication.databinding.ActivityMainBinding
import com.dhananjay.testapplication.view.MainAdapter
import com.dhananjay.testapplication.viewmodel.ListViewModel
import com.dhananjay.testapplication.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: ListViewModel
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.shimmerLayout.startShimmer()
        setContentView(binding.root)
        (application as DemoApplication).mApplicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)
        binding.recyclerview.adapter = adapter
        mainViewModel.productsLiveData.observe(this, Observer {
            binding.shimmerLayout.visibility = View.GONE
            binding.shimmerLayout.stopShimmer()
            adapter.setMovieList(it)
        })
    }

}