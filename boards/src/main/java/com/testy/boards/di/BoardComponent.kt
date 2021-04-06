package com.testy.boards.di

import com.testy.boards.BoardActivity
import com.testy.boards.ui.main.BoardFragment
import com.testy.di_core.ComponentFactoryInterface
import com.testy.di_core.ComponentInterface
import com.testy.di_core.DepsModule
import com.testy.di_core.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [DepsModule::class, DocModule::class])
interface BoardComponent: ComponentInterface {

    @Subcomponent.Factory
    interface Factory: ComponentFactoryInterface {
        fun create(@BindsInstance activity:BoardActivity): BoardComponent
    }

    fun docComponent():DocSubComponent.Factory

    fun inject(activity: BoardActivity)

    fun inject(activity: BoardFragment)
}

class Blip(val i:Int)