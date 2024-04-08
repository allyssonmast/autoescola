package com.example.auto_escola.src.di

import com.example.auto_escola.src.data.remote.AutoEscolaApi
import com.example.auto_escola.src.data.repository.CustomerRepositoryImp
import com.example.auto_escola.src.domain.repository.CustomerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofit(): AutoEscolaApi {
        return Retrofit.Builder()
            .baseUrl(AutoEscolaApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AutoEscolaApi::class.java)
    }
    @Provides
    @Singleton//just one instance
    fun provideAutoCustomerRepository(api: AutoEscolaApi):CustomerRepository{
        return CustomerRepositoryImp(api)
    }
}