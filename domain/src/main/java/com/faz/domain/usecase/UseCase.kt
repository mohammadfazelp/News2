package com.faz.domain.usecase

import com.faz.domain.Configuration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

abstract class UseCase<T : UseCase.Request, R : UseCase.Response>(private val config: Configuration) {

    interface Request

    interface Response

    internal abstract fun process(request: T): Flow<R>

    fun execute(request: T) = process(request).map {
        Result.Success(it) as Result<R>
    }.flowOn(config.dispatcher).catch {
        emit(Result.Error(UseCaseException.createFromThrowable(it)))
    }
}