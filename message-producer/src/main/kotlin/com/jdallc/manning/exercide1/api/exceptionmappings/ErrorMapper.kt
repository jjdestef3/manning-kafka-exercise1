package com.jdallc.manning.exercide1.api.exceptionmappings

import com.jdallc.manning.exercide1.core.domain.exceptions.MessageProcessingException
import mu.KLogging
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

/**
 * Responsibility: </br>
 * 1. Handles Runtime exceptions such as WebApplicationException
 * 2. </br>
 * Created By: johndestefano
 * Date: 3/17/20
 */
@Provider
class ErrorMapper : ExceptionMapper<Exception> {
    companion object: KLogging()

    override fun toResponse(ex: Exception): Response {
        logger.error(ex) { }

        // Status code
        val code = ex.mapWebAppExceptionStatusCode()

        // Map response
        return Response.status(code)
                .entity(ex.errorResponseOf(code))
                .build()
    }
}

@Provider
class MessageProcessingErrorMapper : ExceptionMapper<MessageProcessingException> {

    companion object: KLogging()

    override fun toResponse(ex: MessageProcessingException): Response {
        logger.error(ex) { }

        // Status code
        val code = 500

        // Map response
        return Response.status(code)
                .entity(ex.errorResponseOf(code))
                .build()
    }
}