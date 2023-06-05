package com.example.ticketease.MVVM.Person.Buyer.Catalog

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Event.EventId
import com.example.ticketease.DataClasses.Person.Cities
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface CatalogRepository {
    suspend fun getAllEvents(): List<Catalog>

    suspend fun preferencesRoom() : List<Catalog>

    suspend fun selectEventByBuyer() : List<Long>

    suspend fun countSoldTicket(eventId : EventId) : Long

    suspend fun ticketRoom(eventId: EventId) : Catalog
}

