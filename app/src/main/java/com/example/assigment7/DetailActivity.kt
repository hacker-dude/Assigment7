package com.example.assigment7

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.assigment7.patterns.SingleJson
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var userApi: UserApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        userApi = RetrofitHelper.getInstance().create(UserApi::class.java)

        val id = intent.getStringExtra("id").toString()

        val image = findViewById<ImageView>(R.id.image1)
        val name = findViewById<TextView>(R.id.name1)
        val lastName = findViewById<TextView>(R.id.last1)
        var imageLink = ""
        lifecycleScope.launch {
            val data = getUser(id.toInt()).body()!!.data
            imageLink = data?.avatar!!
            name.text = data.firstName!!
            lastName.text = data.lastName!!
        }
        Picasso.with(this).load(imageLink).into(image)
    }

    private suspend fun getUser(id: Int): retrofit2.Response<SingleJson> {
        return userApi.getUser(id)
    }
}