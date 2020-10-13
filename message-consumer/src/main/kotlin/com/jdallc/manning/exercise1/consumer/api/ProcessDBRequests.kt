package com.jdallc.manning.exercise1.consumer.api

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.api.IRetrieveEventUC
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/9/20
 */
@Path("db-requests")
class ProcessDBRequests {

    @Inject
    @field: Default
    lateinit var retrieveEventUC: IRetrieveEventUC

    @GET
    @Path("/process/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getEventById(@PathParam("id") id: Long): EventRequest =
            retrieveEventUC.getEvent(id)

}