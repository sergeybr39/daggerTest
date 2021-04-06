package com.testy.di_core

import android.app.Activity
import androidx.fragment.app.Fragment

interface ComponentProvider {

    fun <T : ComponentFactoryInterface> provide(com: Class<T>): T
}

inline fun <reified T:ComponentFactoryInterface> Fragment.provideComponent():T{
    return (requireActivity().applicationContext as ComponentProvider).provide(com = T::class.java)
}
inline fun <reified T:ComponentFactoryInterface> Activity.provideComponent():T{
    return (applicationContext as ComponentProvider).provide(com = T::class.java)
}