package com.testy.myapplication.di

import com.testy.di_core.ComponentInterface
import com.testy.users.di.UserComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class CompModule {

    @Binds
    @IntoMap
    @ComponentKey(UserComponent::class)
    abstract fun userComponent(co: UserComponent): ComponentInterface

}