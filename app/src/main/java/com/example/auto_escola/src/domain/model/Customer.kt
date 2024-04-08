package com.example.auto_escola.src.domain.model

import java.time.LocalDate

data class Customer(
    val id: Long,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val dateOfBirth: LocalDate,
    val imageUrl: String
)
