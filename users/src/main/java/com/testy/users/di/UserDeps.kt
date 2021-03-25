package com.testy.users.di

import android.content.Context
import com.testy.users.IPojoProvider
import com.testy.users.IPojoProviderCreator
import dagger.Module
import dagger.Provides

@Module
class UserDeps {

    @Provides
    fun providePojo(pojoProviderCreator: IPojoProviderCreator): IPojoProvider = pojoProviderCreator.create()


}