package com.example.todoapi

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class Controller(
    private val repository: Repository
) {
    private val log = LoggerFactory.getLogger(Controller::class.java)

    @GetMapping("/todos/{id}")
    fun getById(
        @PathVariable id: Int
    ) = repository.findById(id)

    @GetMapping("/todos")
    fun getAll() = repository.findAll()

    @GetMapping("/users/{userId}/todos")
    fun getByUserId(
        @PathVariable userId: Int
    ) = repository.findAllById(userId)

    @PutMapping("/todos/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody todoItem: TodoItem
    ): TodoItem {
        require(todoItem.id == id)
        return repository.saveAndFlush(todoItem)
    }

    @PostMapping("/todos")
    fun create(
        @RequestBody todoItem: TodoItem
    ): TodoItem {
        require(todoItem.id == null)
        return repository.saveAndFlush(todoItem)
    }

    @DeleteMapping("/todos/{id}")
    fun delete(@PathVariable id: Int) = repository.deleteById(id)
}