package com.testy.users.di

import com.testy.di_core.ComponentFactoryInterface
import com.testy.di_core.ComponentInterface
import com.testy.di_core.DepsModule
import com.testy.di_core.FragmentScope
import com.testy.users.UserFragment
import dagger.BindsInstance
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [DepsModule::class, UserDeps::class])
interface UserComponent: ComponentInterface {

    @Subcomponent.Factory
    interface Factory: ComponentFactoryInterface {
        fun create(@BindsInstance fragment:UserFragment): UserComponent
    }

    fun inject(userFragment: UserFragment)
}

