package com.example.auto_escola.src.domain.model

import java.util.Date

data class Lesson(
    val id:Long,
    val date:Date,
    val instructorName:String,
    val studentName: String,
    val durationMinutes: Int,
    val videlUrl:String,
)
