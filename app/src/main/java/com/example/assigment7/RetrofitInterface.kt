package com.example.assigment7

import com.example.assigment7.patterns.ListJson
import com.example.assigment7.patterns.SingleJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/api/users?page=1")
    suspend fun getUsers() : Response<ListJson>

    @GET("/api/users/{id}}")
    suspend fun getUser(@Path("id") id: Int?) : Response<SingleJson>
}