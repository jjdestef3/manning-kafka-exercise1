package com.jdallc.manning.exercise1.consumer.datasources.db

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.domain.model.MessageProcessingResult
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.ISaveEventMessage
import com.jdallc.manning.exercise1.consumer.datasources.db.model.EventRequestEntity
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

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
class SaveEventMessage : ISaveEventMessage {

    @Transactional
    override fun saveEventMessage(evtRequest: EventRequest): MessageProcessingResult =
            try {
                evtRequest.to().persist()
                MessageProcessingResult(true)
            } catch (ex: Exception) {
                logger.error(ex) { "Error processing record to database" }
                MessageProcessingResult(false, ex.message)
            }
    }

fun EventRequest.to(): EventRequestEntity =
        EventRequestEntity().apply {
            chargingSource = this@to.chargingSource ?: ""
            processor4Temp = this@to.processor4Temp ?: 0
            deviceId = this@to.deviceId ?: ""
            processor2Temp = this@to.processor2Temp ?: 0
            processor1Temp = this@to.processor1Temp ?: 0
            charging = this@to.charging ?: 0
            currentCapacity = this@to.currentCapacity ?: 0
            inverterState = this@to.inverterState ?: 0
            moduleLTemp = this@to.moduleLTemp ?: 0
            moduleRTemp = this@to.moduleRTemp ?: 0
            processor3Temp = this@to.processor3Temp ?: 0
            soCRegulator = this@to.soCRegulator ?: 0.0
        }