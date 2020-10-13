package com.jdallc.manning.exercise1.consumer.datasources.db

import com.jdallc.manning.exercise1.consumer.core.domain.exceptions.MessageProcessingException
import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.IGetRecordById
import com.jdallc.manning.exercise1.consumer.datasources.db.model.EventRequestEntity
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped

/**
 * Logger
 */
private val logger = KotlinLogging.logger {}

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
@ApplicationScoped
class GetRecord : IGetRecordById {

    override fun getRecordbyId(id: Long): EventRequest {
        val v = EventRequestEntity.findById(id)
        val v2 = v?.to() ?: throw MessageProcessingException("Record for ID= $id not found")
        return v2
    }

}

fun EventRequestEntity.to(): EventRequest =
        EventRequest(
                chargingSource = this@to.chargingSource,
                processor4Temp = this@to.processor4Temp,
                deviceId = this@to.deviceId,
                processor2Temp = this@to.processor2Temp,
                processor1Temp = this@to.processor1Temp,
                charging = this@to.charging,
                currentCapacity = this@to.currentCapacity,
                inverterState = this@to.inverterState,
                moduleLTemp = this@to.moduleLTemp,
                moduleRTemp = this@to.moduleRTemp,
                processor3Temp = this@to.processor3Temp,
                soCRegulator = this@to.soCRegulator)