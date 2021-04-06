package com.testy.users.di

import com.testy.di_core.ComponentInterface
import com.testy.di_core.DepsModule
import com.testy.di_core.FragmentScope
import com.testy.users.UserFragment
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [DepsModule::class, UserDeps::class])
interface UserComponent: ComponentInterface {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance blob: Blob): UserComponent
    }

    fun inject(userFragment: UserFragment)
}

class Blob(val i:Int)