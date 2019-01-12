package com.artto.wallpapers.di

import android.content.Context
import ua.corteva.data.network.WallpaperRepository
import ua.corteva.data.network.api.WallpaperApi
import ua.corteva.data.network.api.WallpaperApiConstants
import ua.corteva.data.network.api.WallpaperApiMethods
import com.artto.wallpapers.ui.categories.CategoriesInteract
import com.artto.wallpapers.ui.categories.CategoriesPresenter
import com.artto.wallpapers.ui.wallpapers.WallpapersInteract
import com.artto.wallpapers.ui.wallpapers.WallpapersPresenter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import ua.corteva.data.network.api.CacheInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

val uiModule = module {
    factory { CategoriesPresenter(get() as CategoriesInteract) }
    factory { WallpapersPresenter(get() as WallpapersInteract) }
}

val dataModule = module {
    single { CategoriesInteract(get() as WallpaperRepository) }
    single { WallpapersInteract(get() as WallpaperRepository) }

    single { createOkHttpClient(createCache(androidContext())) }
    single { createObjectMapper() }
    single { createApiMethods<WallpaperApiMethods>(get() as OkHttpClient, get() as ObjectMapper) }
    single { WallpaperApi(get() as WallpaperApiMethods) }
    single { WallpaperRepository(get() as WallpaperApi) }
}

fun createCache(context: Context): Cache = Cache(
    File(context.cacheDir, "http-cache"),
    WallpaperApiConstants.RESPONSE_CACHE_MB * 1024L * 1024L
)

fun createOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .addNetworkInterceptor(
        CacheInterceptor(
            CacheControl.Builder()
                .maxAge(WallpaperApiConstants.RESPONSE_CACHE_MAX_AGE_HOURS, TimeUnit.HOURS)
                .build()
        )
    )
    .cache(cache)
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