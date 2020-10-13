package com.jdallc.manning.exercise1.consumer.api.exceptionmappings

import io.quarkus.runtime.annotations.RegisterForReflection

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 3/17/20
 */
@RegisterForReflection
data class ErrorResponse(var errType: String? = "",
                         var cause: String? = "",
                         var code: Int? = 0,
                         var errMsg: String? = "",
                         var trace: MutableList<String?>? = mutableListOf())