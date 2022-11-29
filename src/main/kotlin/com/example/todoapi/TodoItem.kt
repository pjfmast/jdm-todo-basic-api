package com.example.todoapi

import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@NoArgsConstructor
data class TodoItem(

    @Id
    @GeneratedValue
    var id: Int?,

    val userId: Int,

    val title: String,

    val completed: Boolean

)