package com.example.auto_escola.src.domain.use_case

import com.example.auto_escola.src.domain.model.Customer
import com.example.auto_escola.src.domain.repository.CustomerRepository
import com.example.auto_escola.src.utils.helper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCustomerByEmailUseCase(private val customerRepository: CustomerRepository) {
    fun execute(customerEmail: String): Flow<Resource<Customer?>> = flow {
        try {
            emit(Resource.Loading())
            val customerResource = customerRepository.getCustomerByEmail(customerEmail)

            emit(Resource.Success(customerResource.data))
        } catch (e: Exception) {
            emit(Resource.Error("Failed to retrieve customer with email $customerEmail: ${e.message}"))
        }
    }
}