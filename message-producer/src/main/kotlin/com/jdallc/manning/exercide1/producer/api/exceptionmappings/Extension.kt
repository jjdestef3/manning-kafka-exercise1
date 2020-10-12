package com.jdallc.manning.exercide1.producer.api.exceptionmappings

import java.io.PrintWriter
import java.io.StringWriter
import javax.ws.rs.WebApplicationException

/**
 * Print out a stacktrace for an error message
 */
fun Throwable.stackTraceString(): String {
    val sw = StringWriter()
    this.printStackTrace(PrintWriter(sw))
    val str = sw.toString()
    return sw.toString()
}

/**
 * Collect list of strings from stacktrace
 */
fun Throwable.stackTraceToStringList(): MutableList<String?>? =
        when (this.stackTrace) {
            null -> mutableListOf()
            else -> {
                this.stackTrace.map {
                    it.toString()
                }.toMutableList()
            }
        }

/**
 * Create an error response message
 */
fun Throwable.errorResponseMessage(): String =
        when (this.message) {
            null -> ""
            else -> {
                "Exception class: ${this.javaClass.name}  Exception message: ${this.message ?: ""}"
            }
        }

/**
 * Return an ErrorResponse
 */
fun Throwable.errorResponseOf(code: Int, printTrace: Boolean = false): ErrorResponse =
        ErrorResponse(
                this.javaClass.typeName ?: "",
                this.cause?.message ?: "",
                code,
                this.message,
                if (printTrace) this.stackTraceToStringList() else null)

/**
 * Check if the exception is a WebApplicationException and return an appropriate code
 */
fun Throwable.mapWebAppExceptionStatusCode(): Int =
    if (this is WebApplicationException) this.response.status else 500
