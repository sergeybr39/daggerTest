package com.testy.myapplication.di

import com.testy.di_core.ComponentInterface
import com.testy.users.di.UserComponent
import dagger.Component

@Component(modules = [UserDependenciesModule::class, CompModule::class])
interface AppComponent {
    fun userComponent():UserComponent.Factory
    fun comp(): MutableMap<Class<out ComponentInterface>, ComponentInterface>
}