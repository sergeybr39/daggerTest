package com.testy.di_core

import dagger.Module
import dagger.Provides

@Module
class DepsModule {

    @Provides
    fun depTest():DepTest = DepTest()
}