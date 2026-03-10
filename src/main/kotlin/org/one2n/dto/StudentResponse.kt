package org.one2n.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StudentResponse(
    val id: Long,
    val name: String,
    val age: Int,
    val email: String
)
