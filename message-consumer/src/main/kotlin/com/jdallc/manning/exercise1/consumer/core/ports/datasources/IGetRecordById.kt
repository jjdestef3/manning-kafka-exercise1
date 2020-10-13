package com.jdallc.manning.exercise1.consumer.core.ports.datasources

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
interface IGetRecordById {
    fun getRecordbyId(id: Long): EventRequest
}