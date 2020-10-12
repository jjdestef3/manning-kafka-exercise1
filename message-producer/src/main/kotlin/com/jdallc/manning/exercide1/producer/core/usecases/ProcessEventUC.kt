package com.jdallc.manning.exercide1.producer.core.usecases

import com.jdallc.manning.exercide1.producer.core.domain.exceptions.MessageProcessingException
import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.EventResponse
import com.jdallc.manning.exercide1.producer.core.domain.model.EventResponseEnum
import com.jdallc.manning.exercide1.producer.core.ports.api.IProcessEventUC
import com.jdallc.manning.exercide1.producer.datasources.SaveMessgeToKafkaa
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

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

    @Inject
    @field: Default
    lateinit var saveMessage: SaveMessgeToKafkaa

    /**
     * Process event
     */
    override fun processEvent(evtRequest: EventRequest): EventResponse =
            saveMessage.saveMessage(evtRequest).let {
                when (it.result) {
                    false -> throw MessageProcessingException(it.message!!)
                    else -> EventResponse(EventResponseEnum.OK)
                }
            }
}