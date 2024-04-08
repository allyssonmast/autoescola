package com.example.auto_escola.src.data.repository
import java.io.IOException
import com.example.auto_escola.src.data.remote.AutoEscolaApi
import com.example.auto_escola.src.domain.model.Customer
import com.example.auto_escola.src.domain.repository.CustomerRepository
import com.example.auto_escola.src.utils.helper.Resource
import javax.inject.Inject

class CustomerRepositoryImp @Inject constructor(
    private val api: AutoEscolaApi
):CustomerRepository{
    override fun getAllCustomers(): Resource<List<Customer>> {
        return try {
            val customers = api.getAllCustomers()
            Resource.Success(customers)
            Resource.Success(customers.map { it.toCustomer() })
        } catch (e: IOException) {
            Resource.Error(message = "Check internet connection")
        } catch (e: Exception) {
            Resource.Error(message = "Failed to retrieve customers: ${e.message}")
        }
    }

    override fun getCustomerByEmail(customerEmail: String): Resource<Customer?> {
        return  try {
            val customer = api.getCustomerByEmail(customerEmail)
            Resource.Success(customer.toCustomer())
        } catch (e: IOException) {
            Resource.Error(message = "Check internet connection")
        } catch (e: Exception) {
            Resource.Error(message = "Failed to retrieve customers: ${e.message}")
        }
    }
}