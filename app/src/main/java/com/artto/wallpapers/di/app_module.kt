package com.artto.wallpapers.di

import ua.corteva.data.network.WallpaperRepository
import ua.corteva.data.network.api.WallpaperApi
import ua.corteva.data.network.api.WallpaperApiConstants
import ua.corteva.data.network.api.WallpaperApiMethods
import com.artto.wallpapers.ui.main.MainInteract
import com.artto.wallpapers.ui.main.MainPresenter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

val uiModule = module {
    factory { MainPresenter(get() as MainInteract) }
}

val dataModule = module {
    single { MainInteract(get() as WallpaperRepository) }

    single { createOkHttpClient() }
    single { createObjectMapper() }
    single { createApiMethods<WallpaperApiMethods>(get() as OkHttpClient, get() as ObjectMapper) }
    single { WallpaperApi(get() as WallpaperApiMethods) }
    single { WallpaperRepository(get() as WallpaperApi) }
}

fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

fun createObjectMapper(): ObjectMapper = ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

inline fun <reified T> createApiMethods(client: OkHttpClient, objectMapper: ObjectMapper): T =
    Retrofit.Builder()
        .baseUrl(WallpaperApiConstants.BASE_URL)
        .client(client)
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(T::class.java)