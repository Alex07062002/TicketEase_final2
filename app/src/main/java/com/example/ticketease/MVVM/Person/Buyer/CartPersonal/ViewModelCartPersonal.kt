package com.example.ticketease.MVVM.Person.Buyer.CartPersonal

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketease.DataClasses.Catalog
import com.example.ticketease.DataClasses.Ticket.TicketDTO
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCartPersonal @Inject constructor(
    private val repository: CartPersonalRepository,
    private val prefs : SharedPreferences
) : ViewModel(){
    var state = mutableStateOf(
        Gson().fromJson(prefs.getString("ticketCart",null)!!,
        Array<Catalog>::class.java).toList())

    fun createPreference(){
        viewModelScope.launch {
            val listTicket = repository.selectEventByBuyer().size
            val listPrefs = if (listTicket<5){
                repository.getAllEvents()
            }else {
                repository.preferencesRoom()
            }
            prefs.edit().putString("preferences", Gson().toJson(listPrefs)).apply()
        }
    }
    fun createCatalog() {
        viewModelScope.launch {
            val result = repository.getAllEvents()
            prefs.edit().putString("catalog",Gson().toJson(result)).apply()
        }
    }

    fun updateTicket(ticketDTO: TicketDTO) {
        viewModelScope.launch {
            val ticket = repository.updateTicket(ticketDTO)
        }
    }
}