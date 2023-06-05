package com.example.ticketease.MVVM.Event.Preferences

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Event.EventId

interface PreferencesRepository {

    suspend fun getAllEvents(): List<Catalog>

    suspend fun countSoldTicket(eventId : EventId) : Long

    suspend fun ticketRoom(eventId: EventId) : Catalog
}