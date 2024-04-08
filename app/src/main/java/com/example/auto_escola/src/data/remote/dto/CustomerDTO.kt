package com.example.auto_escola.src.data.remote.dto
import com.example.auto_escola.src.domain.model.Customer
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class CustomerDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("dateOfBirth") val dateOfBirth: LocalDate,
    @SerializedName("imageUrl") val imageUrl: String
){
    fun toCustomer(): Customer {
        return Customer(
            id = this.id,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber,
            dateOfBirth = this.dateOfBirth,
            imageUrl = this.imageUrl
        )
    }
}
