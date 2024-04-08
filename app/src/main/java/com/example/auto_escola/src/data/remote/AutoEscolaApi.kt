package com.example.auto_escola.src.data.remote

import com.example.auto_escola.src.data.remote.dto.CustomerDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface AutoEscolaApi {
    @GET("customers.bak")
    fun getAllCustomers(): List<CustomerDTO>

    @GET("customers/{email}")
    fun getCustomerByEmail(@Path("email") email: String): CustomerDTO

    companion object {
        const val BASE_URL = "http://localhost:8000/v1/"
    }
}