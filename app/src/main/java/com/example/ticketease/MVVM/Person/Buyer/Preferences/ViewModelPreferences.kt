package com.example.ticketease.MVVM.Event.Preferences

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class ViewModelPreferences @Inject constructor(
 private val repository: PreferencesRepository,
 private val prefs : SharedPreferences
) : ViewModel() {
 var state = mutableStateOf(
  Gson().fromJson(prefs.getString("preferences",null)!!,
  Array<Catalog>::class.java).toList())

 fun createCatalog() {
  viewModelScope.launch {
   val result = repository.getAllEvents()
   prefs.edit().putString("catalog",Gson().toJson(result)).apply()
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