package com.example.ticketease.MVVM.Person.Buyer

import com.example.ticketease.DataClasses.Person.Buyer
import com.example.ticketease.DataClasses.Person.BuyerRequest
import com.example.ticketease.DataClasses.Person.BuyerResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface BuyerRetrofitAPI {
    @POST("/buyers/create")
   suspend fun postBuyer(@Body dataModel: Buyer?): BuyerResponse


    @PUT("/buyers/signIn")
    suspend fun Avtorize(@Body dataModel: BuyerRequest?): BuyerResponse
}