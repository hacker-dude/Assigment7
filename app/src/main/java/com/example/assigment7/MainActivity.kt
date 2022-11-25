package com.example.assigment7

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment7.patterns.ListJson
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var userApi: UserApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userApi = RetrofitHelper.getInstance().create(UserApi::class.java)
        val recyclerview = findViewById<RecyclerView>(R.id.recView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val result = getUsers()
            recyclerview.adapter = CustomAdapter(result.body()!!.data){
                switchActivities(it)
            }.apply {
                notifyDataSetChanged()
            }
        }


    }

    private suspend fun getUsers(): retrofit2.Response<ListJson> {
        return userApi.getUsers()
    }

    private fun switchActivities(id : String) {
        val switchActivityIntent = Intent(this, DetailActivity::class.java).putExtra("id",id)
        startActivity(switchActivityIntent)
    }
}