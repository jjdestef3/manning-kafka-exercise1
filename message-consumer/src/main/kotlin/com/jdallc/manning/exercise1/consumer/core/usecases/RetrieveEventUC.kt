package com.jdallc.manning.exercise1.consumer.core.usecases

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.api.IRetrieveEventUC
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.IGetRecordById
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

/**
 * File logger
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
class RetrieveEventUC : IRetrieveEventUC {

    @Inject
    @field: Default
    lateinit var getRecordById: IGetRecordById

    /**
     * Retrieve an event by id
     */
    override fun getEvent(id: Long): EventRequest = getRecordById.getRecordbyId(id)
}