package com.jdallc.manning.exercide1.core.usecases

import com.jdallc.manning.exercide1.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.core.domain.model.EventResponse
import com.jdallc.manning.exercide1.core.domain.model.EventResponseEnum
import com.jdallc.manning.exercide1.core.ports.api.IProcessEventUC
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped

// File logger
private val logger = KotlinLogging.logger {}

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/9/20
 */
@ApplicationScoped
class ProcessEventuC : IProcessEventUC {

    /**
     * Process event
     */
    override fun processEvent(evtRequest: EventRequest): EventResponse {
        logger.info { evtRequest }
        return EventResponse(EventResponseEnum.OK)
    }
}