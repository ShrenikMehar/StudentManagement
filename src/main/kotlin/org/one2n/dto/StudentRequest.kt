package org.one2n.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StudentRequest(
    val name: String,
    val age: Int,
    val email: String
)
