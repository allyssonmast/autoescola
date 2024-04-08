package com.example.auto_escola.src.domain.repository

import com.example.auto_escola.src.domain.model.Customer
import com.example.auto_escola.src.utils.helper.Resource

interface CustomerRepository {
    fun getAllCustomers(): Resource<List<Customer>>
    fun getCustomerByEmail(customerEmail: String):Resource<Customer?>
}