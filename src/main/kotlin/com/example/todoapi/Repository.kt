package com.example.todoapi
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Repository : JpaRepository<TodoItem, Int> {
    fun findAllById(id: Int): List<TodoItem>
}