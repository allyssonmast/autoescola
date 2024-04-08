package com.example.auto_escola

sealed class Routers(val route: String){
    object CustomerListScreen: Routers("customer_list_screen")
    object CustomerDetailScreen: Routers("customer_detail_screen")
}
