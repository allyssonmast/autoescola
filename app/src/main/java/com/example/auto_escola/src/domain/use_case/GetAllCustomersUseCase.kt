package com.example.auto_escola.src.domain.use_case

import com.example.auto_escola.src.domain.model.Customer
import com.example.auto_escola.src.domain.repository.CustomerRepository
import com.example.auto_escola.src.utils.helper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCustomersUseCase @Inject constructor(private val customerRepository: CustomerRepository) {
    operator fun invoke(): Flow<Resource<List<Customer>>> = flow {
        try {
            emit(Resource.Loading())
            val customersResource = customerRepository.getAllCustomers()

            val customers: List<Customer> = customersResource.data ?: emptyList()

            emit(Resource.Success(customers))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Check internet connection"))
        }
    }
}
