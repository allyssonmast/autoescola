package com.example.auto_escola.src.presentation.customerlist

import com.example.auto_escola.src.domain.use_case.GetAllCustomersUseCase
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auto_escola.src.domain.use_case.GetCustomerByEmailUseCase
import com.example.auto_escola.src.utils.helper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.compose.runtime.State
@HiltViewModel
class CustomerListViewModel @Inject constructor(
    private val getAllCustomersUseCase: GetAllCustomersUseCase,
    private val getCustomerByEmailUseCase: GetCustomerByEmailUseCase
    ):ViewModel(){
    private  val _state = mutableStateOf(CustomerListState())
    val state: State<CustomerListState> =_state

    init {
        getCustomers()
    }

    private  fun getCustomers(){
        getAllCustomersUseCase().onEach { resource ->
            when(resource){
                is Resource.Success -> {
                    _state.value = CustomerListState(customers = resource.data?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CustomerListState(error = resource.message?:"An error occurred" )
                }
                is Resource.Loading ->{
                    _state.value = CustomerListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}