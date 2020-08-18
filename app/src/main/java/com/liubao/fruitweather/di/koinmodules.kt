package com.liubao.fruitweather.di

import com.liubao.fruitweather.datasource.DataSourceImpl
import com.liubao.fruitweather.datasource.IDataSource
import com.liubao.fruitweather.repository.IRepository
import com.liubao.fruitweather.repository.RepositoryImpl
import com.liubao.fruitweather.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val HOME_VIEW_MODEL = "HOME_VIEW_MODEL"

val weatherModule = module {
    single<IDataSource>() { DataSourceImpl() }
    single<IRepository>() { RepositoryImpl(get()) }
    viewModel() {
        HomeViewModel(get())
    }
}