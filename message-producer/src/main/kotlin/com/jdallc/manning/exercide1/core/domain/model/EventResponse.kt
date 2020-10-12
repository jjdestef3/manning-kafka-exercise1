package com.jdallc.manning.exercide1.core.domain.model

import io.quarkus.runtime.annotations.RegisterForReflection

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/9/20
 */
@RegisterForReflection
class EventResponse(val status: EventResponseEnum = EventResponseEnum.OK,
                    val detail: String? = null)

@RegisterForReflection
enum class EventResponseEnum {
    OK, ERROR
}