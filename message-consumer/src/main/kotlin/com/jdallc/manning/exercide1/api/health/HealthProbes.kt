package com.jdallc.manning.exercide1.api.health

import com.jdallc.manning.exercide1.core.Config
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import org.eclipse.microprofile.health.Readiness
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 1/2/20
 */
@Liveness
@Readiness
@ApplicationScoped
class HealthProbes : HealthCheck {

    @Inject
    @field: Default
    lateinit var config: Config

    override fun call(): HealthCheckResponse =
            HealthCheckResponse
                    .named(config.name)
                    .up()
                    .build()
}