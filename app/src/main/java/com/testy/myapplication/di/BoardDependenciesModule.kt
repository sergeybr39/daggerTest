package com.testy.myapplication.di

import com.testy.boards.di.BoardComponent
import com.testy.di_core.ComponentFactoryInterface
import dagger.Module
import dagger.Provides

@Module(subcomponents = [BoardComponent::class])
class BoardDependenciesModule {
    companion object{
        var i = 0
    }

    @Provides
    fun boardComponentProvider(ucf: BoardComponent.Factory): ComponentFactoryInterface = ucf

}