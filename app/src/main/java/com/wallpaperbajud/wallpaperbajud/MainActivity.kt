package com.wallpaperbajud.wallpaperbajud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperbajud.R
import com.example.wallpaperbajud.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallpaperAdapter
    var auth = "keBaYx2UQfDBEKqMwbzvnD5lkgN0fx7E1mDsnpa6QBD5OQZkSDTNJ0B2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter()

        binding.btnSubmit.setOnClickListener {
            callApi()
        }

    }

    private fun callApi() {
        var txt = binding.edtSearch.text.toString()

        var api: ApiInterface? = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.getphotos(auth,txt)?.enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                if (response.isSuccessful){
                    var photos = response.body()?.photos
                    adapter.setPhotos(photos)

                    binding.rcvView.layoutManager = GridLayoutManager(this@MainActivity,2)
                    binding.rcvView.adapter = adapter

                }
            }

            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {

            }

        })

    }
}