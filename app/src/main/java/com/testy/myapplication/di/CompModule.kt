package com.testy.myapplication.di

import com.testy.boards.di.BoardComponent
import com.testy.di_core.ComponentFactoryInterface
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
    @ComponentKey(UserComponent.Factory::class)
    abstract fun userComponentFactory(co: UserComponent.Factory): ComponentFactoryInterface

    @Binds
    @IntoMap
    @ComponentKey(BoardComponent.Factory::class)
    abstract fun boardComponentFactory(co: BoardComponent.Factory): ComponentFactoryInterface

}