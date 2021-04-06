package com.testy.boards.di

import com.testy.boards.ui.main.DocFragment
import com.testy.di_core.Blob
import dagger.Module
import dagger.Provides

@Module
class DocDeps {


    @Provides
    fun provideBlob(fragment: DocFragment): Blob {
        val i = fragment.arguments?.getInt(DocFragment.EXTRA_KEY_TEAM_ID) ?: -1
        return Blob(i)
    }
}