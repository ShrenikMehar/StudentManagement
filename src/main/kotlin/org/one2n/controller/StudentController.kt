package org.one2n.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.one2n.dto.StudentResponse

@Controller("/api/v1/students")
class StudentController {

    @Get
    fun getAllStudents(): List<StudentResponse> {
        return emptyList()
    }
}
