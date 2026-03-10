package org.one2n.entity

import java.util.UUID

data class Student(
    val id: UUID?,
    val name: String,
    val age: Int,
    val email: String,
)
