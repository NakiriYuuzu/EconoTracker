package di

import MainViewModel
import com.russhwolf.settings.Settings
import core.data.source.EconoSource
import core.data.source.preference.PreferenceSourceImpl
import core.data.source.remote.AdhdApi
import core.data.source.remote.KtorfitFactory
import core.presentation.setting.SettingViewModel
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

val serviceModule = module {
    factoryOf<Logger>(::KermitLogger)
    factoryOf<Settings>(::Settings)
    single<Ktorfit> { KtorfitFactory().build() }
    single<AdhdApi> { get<Ktorfit>().create() }
}

val viewModelModule = module {
    singleOf(::MainViewModel)
    singleOf(::SettingViewModel)
}

val appModules = listOf(
    appModule,
    serviceModule,
    viewModelModule
)