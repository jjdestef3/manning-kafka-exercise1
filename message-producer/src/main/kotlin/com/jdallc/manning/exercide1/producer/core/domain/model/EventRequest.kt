package com.jdallc.manning.exercide1.producer.core.domain.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.runtime.annotations.RegisterForReflection

/**
 *
 */
@RegisterForReflection
data class EventRequest(
    @JsonProperty("charging_source")
    val chargingSource: String? = null,
    @JsonProperty("processor4_temp")
    val processor4Temp: Int? = null,
    @JsonProperty("device_id")
    val deviceId: String? = null,
    @JsonProperty("processor2_temp")
    val processor2Temp: Int? = null,
    @JsonProperty("processor1_temp")
    val processor1Temp: Int? = null,
    @JsonProperty("charging")
    val charging: Int? = null,
    @JsonProperty("current_capacity")
    val currentCapacity: Int? = null,
    @JsonProperty("inverter_state")
    val inverterState: Int? = null,
    @JsonProperty("moduleL_temp")
    val moduleLTemp: Int? = null,
    @JsonProperty("moduleR_temp")
    val moduleRTemp: Int? = null,
    @JsonProperty("processor3_temp")
    val processor3Temp: Int? = null,
    @JsonProperty("SoC_regulator")
    val soCRegulator: Double? = null
)