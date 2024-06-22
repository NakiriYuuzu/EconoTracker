package di

import MainViewModel
import com.russhwolf.settings.Settings
import core.data.repository.SettingRepositoryImpl
import core.domain.source.EconoSource
import core.data.source.preference.PreferenceSourceImpl
import core.data.source.remote.AdhdApi
import core.data.source.remote.KtorfitFactory
import core.domain.repository.SettingRepository
import core.presentation.setting.SettingViewModel
import core.presentation.setting.validator.SettingValidator
import de.jensklingenberg.ktorfit.Ktorfit
import logging.KermitLogger
import logging.Logger
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    factoryOf(::PreferenceSourceImpl).bind(EconoSource.Preference::class)
}

//val networkModule = module {
//    single<Ktorfit> { KtorfitFactory().build() }
//    single<AdhdApi> { get<Ktorfit>() }
//}

val serviceModule = module {
    factoryOf<Logger>(::KermitLogger)
    factoryOf<Settings>(::Settings)
}

val repositoryModule = module {
    singleOf(::SettingValidator)
    single<SettingRepository> { SettingRepositoryImpl(get()) }
}

val viewModelModule = module {
    singleOf(::MainViewModel)
    factoryOf(::SettingViewModel)
}

val appModules = listOf(
    appModule,
    platformModule(),
//    networkModule,
    serviceModule,
    repositoryModule,
    viewModelModule
)