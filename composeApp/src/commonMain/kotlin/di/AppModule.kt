package di

import core.data.source.remote.KtorfitFactory
import de.jensklingenberg.ktorfit.Ktorfit
import loggings.KermitLogger
import loggings.Logger
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    factoryOf<Logger>(::KermitLogger)
    single<Ktorfit> { KtorfitFactory().build() }

}

//val appModules = listOf(
//    appModule,
//)