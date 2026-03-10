package org.one2n.dto

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
data class StudentResponse(
    val id: UUID,
    val name: String,
    val age: Int,
    val email: String,
)
