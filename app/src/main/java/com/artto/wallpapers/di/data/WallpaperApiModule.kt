package com.artto.wallpapers.di.data

import com.artto.wallpapers.data.network.WallpaperRepository
import com.artto.wallpapers.data.network.api.WallpaperApi
import com.artto.wallpapers.data.network.api.WallpaperApiConstants
import com.artto.wallpapers.data.network.api.WallpaperApiMethods
import com.artto.wallpapers.di.scope.ApplicationScope
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class WallpaperApiModule {

    @Provides
    @ApplicationScope
    fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    @Provides
    @ApplicationScope
    fun objectMapper(): ObjectMapper =
        ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    @Provides
    @ApplicationScope
    fun converterFactory(objectMapper: ObjectMapper): JacksonConverterFactory =
        JacksonConverterFactory.create(objectMapper)

    @Provides
    @ApplicationScope
    fun retrofit(client: OkHttpClient, converterFactory: JacksonConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl(WallpaperApiConstants.BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @ApplicationScope
    fun apiMethods(retrofit: Retrofit): WallpaperApiMethods =
        retrofit.create<WallpaperApiMethods>(WallpaperApiMethods::class.java)

    @Provides
    @ApplicationScope
    fun api(methods: WallpaperApiMethods): WallpaperApi = WallpaperApi(methods)

    @Provides
    @ApplicationScope
    fun repository(api: WallpaperApi): WallpaperRepository = WallpaperRepository(api)

}