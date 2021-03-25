package com.testy.myapplication.di

import com.testy.users.IPojoProvider
import com.testy.users.IPojoProviderCreator
import com.testy.users.Pojo
import com.testy.users.di.UserComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [UserComponent::class])
class UserDependenciesModule {

    @Provides
    fun userComponentProvider(ucf: UserComponent.Factory): UserComponent = ucf.create()

    @Provides
    fun pojoProviderCreator(): IPojoProviderCreator {
        return PojoProviderCreator()
    }

}

class PojoProviderCreator : IPojoProviderCreator {

    override fun create(): IPojoProvider {
        return PojoProvider()
    }

    class PojoProvider : IPojoProvider {
        override fun providePojo(): Pojo {
            return Pojo("Sergey", 30)
        }
    }

}