package com.example.auto_escola.src.presentation.customerlist

import com.example.auto_escola.src.domain.model.Customer

data class CustomerListState(
    val isLoading: Boolean = false,
    val customers: List<Customer> = emptyList(),
    val error: String = ""
)
