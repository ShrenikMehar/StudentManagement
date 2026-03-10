package org.one2n.util

import org.one2n.dto.StudentRequest

object StudentTestData {

    fun studentRequest(
        name: String = "Alice",
        age: Int = 20,
        email: String = "alice@test.com"
    ): StudentRequest {
        return StudentRequest(
            name = name,
            age = age,
            email = email
        )
    }
}
