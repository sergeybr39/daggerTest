package com.testy.boards.di

import com.testy.boards.BoardActivity
import com.testy.boards.ui.main.DocFragment
import com.testy.di_core.ComponentFactoryInterface
import com.testy.di_core.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent



@Subcomponent(modules = [DocDeps::class])
interface DocSubComponent {

    @Subcomponent.Factory
    interface Factory:ComponentFactoryInterface {
        fun create(@BindsInstance fragment: DocFragment): DocSubComponent
    }

    fun inject(fragment: DocFragment)
}