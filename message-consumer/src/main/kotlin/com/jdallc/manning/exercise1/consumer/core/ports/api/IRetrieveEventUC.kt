package com.jdallc.manning.exercise1.consumer.core.ports.api

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import java.math.BigInteger


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
interface IRetrieveEventUC {
    fun getEvent(id: Long): EventRequest
}