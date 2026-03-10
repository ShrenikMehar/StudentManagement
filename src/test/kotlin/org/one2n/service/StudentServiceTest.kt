package org.one2n.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.one2n.util.StudentTestData

class StudentServiceTest {

    private val studentService = StudentService()

    @Test
    fun `should return empty list when no students exist`() {
        val students = studentService.getAllStudents()

        assertTrue(students.isEmpty())
    }

    @Test
    fun `should create student`() {
        val request = StudentTestData.studentRequest()

        val student = studentService.createStudent(request)

        assertNotNull(student.id)
        assertEquals("Alice", student.name)
        assertEquals(20, student.age)
        assertEquals("alice@test.com", student.email)
    }
}
