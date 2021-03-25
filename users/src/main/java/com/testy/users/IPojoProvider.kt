package com.testy.users

interface IPojoProvider {
    fun providePojo():Pojo
}

interface IPojoProviderCreator {
    fun create(): IPojoProvider
}