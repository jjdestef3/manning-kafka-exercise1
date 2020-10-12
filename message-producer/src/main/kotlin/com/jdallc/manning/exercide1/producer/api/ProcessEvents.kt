package com.jdallc.manning.exercide1.producer.api

import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.EventResponse
import com.jdallc.manning.exercide1.producer.core.ports.api.IProcessEventUC
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
@Path("events")
class ProcessEvents {

    @Inject
    @field: Default
    lateinit var processEventUC: IProcessEventUC

    @POST
    @Path("/process/{guid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun processEvent(@PathParam("guid") guid: String, eventRequest: EventRequest): EventResponse =
        processEventUC.processEvent(eventRequest)
}