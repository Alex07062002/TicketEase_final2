package com.example.ticketease.MVVM.Person.Buyer.CartPersonal

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Ticket.TicketDTO

interface CartPersonalRepository {

    suspend fun getAllEvents(): List<Catalog>

    suspend fun preferencesRoom() : List<Catalog>

    suspend fun selectEventByBuyer() : List<Long>

    suspend fun updateTicket(ticketDTO: TicketDTO): TicketDTO
}