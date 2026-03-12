package org.one2n.dto

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Serdeable
data class StudentRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    @field:Min(value = 1, message = "Age must be greater than 0")
    val age: Int,
    @field:Email(message = "Email must be valid")
    @field:NotBlank(message = "Email must not be blank")
    val email: String,
)
