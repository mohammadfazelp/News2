package com.faz.news.data.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: NewsDispatchers)

enum class NewsDispatchers {
    IO
}
