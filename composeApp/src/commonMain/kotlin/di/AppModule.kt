package di

import core.presentation.splash.SplashViewModel
import loggings.KermitLogger
import loggings.Logger
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    factoryOf<Logger>(::KermitLogger)
    singleOf(::SplashViewModel)
}