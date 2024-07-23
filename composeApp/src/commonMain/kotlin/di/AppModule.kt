package di

import MainViewModel
import com.russhwolf.settings.Settings
import core.data.repository.SettingRepositoryImpl
import core.domain.source.EconoSource
import core.data.source.preference.PreferenceSourceImpl
import core.domain.repository.SettingRepository
import core.presentation.setting.SettingViewModel
import core.domain.validator.SettingValidator
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

val validatorModule = module {
    singleOf(::SettingValidator)
}

val repositoryModule = module {
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
    validatorModule,
    repositoryModule,
    viewModelModule
)