package com.testy.boards.di

import com.testy.di_core.ComponentFactoryInterface
import dagger.Module
import dagger.Provides

@Module(subcomponents = [DocSubComponent::class])
class DocModule {

    @Provides
    fun docComponentProvider(ucf: DocSubComponent.Factory): ComponentFactoryInterface = ucf

}