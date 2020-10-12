package com.jdallc.manning.exercide1.producer.core.ports.api

import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.EventResponse


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/9/20
 */
interface IProcessEventUC {
    fun processEvent(evtRequest: EventRequest): EventResponse
}