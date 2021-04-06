package com.testy.myapplication.di

import com.testy.di_core.ComponentFactoryInterface
import com.testy.di_core.ComponentInterface
import com.testy.users.di.UserComponent
import dagger.Component

@Component(modules = [UserDependenciesModule::class,BoardDependenciesModule::class, CompModule::class])
interface AppComponent {

    fun comp(): MutableMap<Class<out ComponentFactoryInterface>, ComponentFactoryInterface>
}