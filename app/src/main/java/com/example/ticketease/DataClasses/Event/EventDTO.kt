package com.example.ticketease.DataClasses.Event

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable

@Serializable
data class EventDTO(
    @JsonProperty("id")
    val id: Long?=null,
    @JsonProperty("placeTimeId")

    val placeTimeId: Long? =null,
    @JsonProperty("organizerId")

    val organizerId: Long?=null,
    @JsonProperty("name")

    val name: String="",
    @JsonProperty("genre")

    val genre: String? =null,
    @JsonProperty("type")

    val type: String? =null,
    @JsonProperty("status")

    val status: StatusEvent = StatusEvent.CREATE,
    @JsonProperty("nameGroup")

    val nameGroup: String? = null,
    @JsonProperty("description")

    val description: String? = null)

@Serializable
data class EventId(
    @JsonProperty("id")
    val id: Long)

@Serializable
data class EventIdCount(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("count")
    val count : Long)

