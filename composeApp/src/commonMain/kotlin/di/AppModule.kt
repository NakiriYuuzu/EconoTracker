package di

import core.data.source.remote.AdhdApi
import core.data.source.remote.KtorfitFactory
import de.jensklingenberg.ktorfit.Ktorfit
import logging.KermitLogger
import logging.Logger
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    factoryOf<Logger>(::KermitLogger)
    single<Ktorfit> { KtorfitFactory().build() }
    single<AdhdApi> { get<Ktorfit>().create() }
}

//val appModules = listOf(
//    appModule,
//)