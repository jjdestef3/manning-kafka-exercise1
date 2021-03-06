package com.jdallc.manning.exercide1.producer.core.ports.datasources

import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.MessageProcessingResult



/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/11/20
 */
interface ISaveMessage {
    fun saveMessage(evtRequest: EventRequest): MessageProcessingResult
}