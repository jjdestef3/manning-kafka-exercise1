package com.jdallc.manning.exercise1.consumer.datasources.db.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
@Entity
class EventRequestEntity : PanacheEntity() {
    companion object: PanacheCompanion<EventRequestEntity, Long>

    lateinit var chargingSource: String
    var  processor4Temp: Int = 0
    lateinit var  deviceId: String
    var  processor2Temp: Int = 0
    var processor1Temp: Int = 0
    var charging: Int = 0
    var  currentCapacity: Int = 0
    var inverterState: Int = 0
    var  moduleLTemp: Int = 0
    var  moduleRTemp: Int = 0
    var  processor3Temp: Int = 0
    var  soCRegulator: Double = 0.0
}