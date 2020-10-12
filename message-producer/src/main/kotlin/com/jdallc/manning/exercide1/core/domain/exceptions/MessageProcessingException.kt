package com.jdallc.manning.exercide1.core.domain.exceptions

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/11/20
 */
class MessageProcessingException(message: String, ex: Exception? = null) : Exception(message, ex)