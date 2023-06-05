package com.example.ticketease.MVVM.Person.Buyer.Catalog

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Event.EventId
import com.example.ticketease.DataClasses.Event.EventIdCount
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCatalog @Inject constructor(
    private val repository: CatalogRepository,
    private val prefs: SharedPreferences
) : ViewModel() {
    var state = mutableStateOf(Gson().fromJson(prefs.getString("catalog",null)!!,
        Array<Catalog>::class.java).toList())

    fun createPreference(){
        viewModelScope.launch {
            val listTicket = repository.selectEventByBuyer().size
            val listPrefs = if (listTicket<5){
                repository.getAllEvents()
            }else {
                repository.preferencesRoom()
            }
            prefs.edit().putString("preferences",Gson().toJson(listPrefs)).apply()
        }
    }

    fun countTickets(eventId : Long){
        viewModelScope.launch {
            val count = repository.countSoldTicket(EventId(eventId))
            val listTickets = Gson().fromJson(prefs.getString("cart",null)!!,
                Array<EventIdCount>::class.java).toMutableList()
            listTickets.add(EventIdCount(eventId, count))
            prefs.edit().putString("cart",Gson().toJson(listTickets)).apply()
        }
    }

    fun putTicketToCart(eventId : Long) {
        viewModelScope.launch {
            val listTickets = Gson().fromJson(
                prefs.getString("ticketCart", null)!!,
                Array<Catalog>::class.java
            ).toMutableList()
            listTickets.add(repository.ticketRoom(EventId(eventId)))
            prefs.edit().putString("ticketCart",Gson().toJson(listTickets)).apply()
        }
    }
}