package com.testy.myapplication.di

import com.testy.di_core.ComponentFactoryInterface
import com.testy.users.IPojoProvider
import com.testy.users.IPojoProviderCreator
import com.testy.users.Pojo
import com.testy.users.di.UserComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [UserComponent::class])
class UserDependenciesModule {
    companion object{
        var i = 0
    }

    @Provides
    fun userComponentProvider(ucf: UserComponent.Factory): ComponentFactoryInterface = ucf

    @Provides
    fun pojoProviderCreator(): IPojoProviderCreator {
        return PojoProviderCreator(i++)
    }

}

class PojoProviderCreator(val i :Int) : IPojoProviderCreator {

    override fun create(): IPojoProvider {
        return PojoProvider(i)
    }

    class PojoProvider (val i :Int) : IPojoProvider {
        override fun providePojo(): Pojo {
            return Pojo("Sergey", i)
        }
    }

}