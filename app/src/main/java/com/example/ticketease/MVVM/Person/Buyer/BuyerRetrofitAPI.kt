package com.example.ticketease.MVVM.Person.Buyer

import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.CatalogResponce
import com.example.ticketease.DataClasses.Event.EventDTO
import com.example.ticketease.DataClasses.Event.EventId
import com.example.ticketease.DataClasses.Person.*
import com.example.ticketease.DataClasses.PlaceTime.PlaceDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceId
import com.example.ticketease.DataClasses.PlaceTime.PlaceTimeDTO
import com.example.ticketease.DataClasses.PlaceTime.PlaceType
import com.example.ticketease.DataClasses.Ticket.TicketDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface BuyerRetrofitAPI {
    @POST("/buyers/create")
   suspend fun postBuyer(@Body dataModel: Buyer?): BuyerWithoutPswd

    @POST("/buyers/signIn")
    suspend fun avtorize(@Body dataModel: BuyerRequest?): BuyerWithoutPswd

    @POST("/buyers/token")
   suspend  fun buyerByToken(@Body dataModel: BuyerResponse?):  BuyerWithoutPswd

    @PUT("/buyers/update")
    suspend  fun buyerUpdate(@Body dataModel: BuyerWithoutPswd):  BuyerWithoutPswd

    @POST("/buyers/updateCity")
     suspend  fun buyerUpdateCity(@Body dataModel: BuyerUpdateCity?):Boolean


    @POST("/organizers/create")
    suspend fun singInOrg(@Body dataModel: Organizer?): OrganizerWithoutPswd


    @PUT("/organizers/signIn")
    suspend fun avtorizeOrg(@Body dataModel: OrganizerRequest): OrganizerWithoutPswd


    @POST("/organizers/token")
    suspend fun orgByToken(@Body dataModel: OrganizerResponse?):  OrganizerWithoutPswd


 @POST("/organizers/updateCity")
 suspend  fun organizersUpdateCity(@Body dataModel: OrganizerUpdateCity?):Boolean

 @PUT("/organizers/update")
 suspend  fun orgUpdate(@Body dataModel: OrganizerWithoutPswd?):  OrganizerWithoutPswd

 @POST("/places/type")
 suspend fun getPlace(@Body dataModel: PlaceType?):  List<PlaceDTO>

 @POST("/placeTimes/select/placeId")
 suspend fun getTime(@Body dataModel: PlaceId?):  List<PlaceTimeDTO>


 @POST("/room/catalog")
 suspend fun getAllEvents(@Body city : City): List<Catalog>

 @POST("/room/preferences")
 suspend fun preferencesRoom(@Body buyer :  BuyerUpdateCity): List<Catalog>

 @POST("tickets/buyerId")
 suspend fun selectEventByBuyer(@Body buyer : BuyerId) : List<Long>

 @POST("tickets/eventId/soldTicket")
 suspend fun countSoldTicket(@Body eventId : EventId) : Long

 @POST("/room/ticket")
 suspend fun ticketRoom(@Body eventId: EventId) : Catalog

 @PUT("/tickets/update")
 suspend fun updateTicket(@Body ticket : TicketDTO) : TicketDTO
}