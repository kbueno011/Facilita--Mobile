package com.exemple.facilita.sevice

import com.exemple.facilita.model.Login
import com.exemple.facilita.model.Register
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {

    @Headers("Content-Type: application/json")
    @POST("/v1/facilita/usuario/register")
    fun saveUser(@Body user: Register): Call<Register>

    @Headers("Content-Type: application/json")
    @POST("/v1/facilita/usuario/login")
    fun loginUser(@Body user: Login): Call<Login>


//    @Headers("Content-Type: application/json")
//    @PUT("user/login")
//    fun loginUser(@Body login: Login): Call<AuthenticationUser>
//
//    @Headers("Content-Type: application/json")
//    @PUT("user/{id}")
//    fun updateUser(@Path("id") id: Int, @Body user: User): Call<UserResponse>
//
//    @GET("user/{id}")
//    fun dataUser(@Path("id") id: Int): Call<UserResponse>
}


