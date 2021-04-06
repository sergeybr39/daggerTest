package com.testy.users.di

import com.testy.di_core.Blob
import com.testy.users.IPojoProvider
import com.testy.users.IPojoProviderCreator
import com.testy.users.UserFragment
import dagger.Module
import dagger.Provides

@Module
class UserDeps {

    @Provides
    fun providePojo(pojoProviderCreator: IPojoProviderCreator): IPojoProvider =
        pojoProviderCreator.create()


    @Provides
    fun provideBlob(userFragment: UserFragment): Blob {
        val i = userFragment.arguments?.getInt(UserFragment.EXTRA_KEY_TEAM_ID) ?: -1
        return Blob(i)
    }

}