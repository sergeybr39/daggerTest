package com.testy.di_core

interface ComponentProvider {

    fun <T : ComponentInterface> provide(com: Class<T>): T
}