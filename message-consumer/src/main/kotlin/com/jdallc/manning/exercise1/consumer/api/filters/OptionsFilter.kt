package com.jdallc.manning.exercise1.consumer.api.filters

import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.PreMatching
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 3/22/20
 */
@Provider
@PreMatching
class OptionsFilter: ContainerRequestFilter {
    override fun filter(requestContext: ContainerRequestContext) {
        if (requestContext.method == "OPTIONS") {
            requestContext.abortWith(Response.status(Response.Status.NO_CONTENT).build())
        }
    }
}