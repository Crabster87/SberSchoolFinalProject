package crabster.rudakov.sberschoolfinalproject.di.module

import crabster.rudakov.sberschoolfinalproject.ui.main.view.MainActivity
import crabster.rudakov.sberschoolfinalproject.ui.splashScreen.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Класс, описывающий зависимости, используемые в Activity
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    /**
     * Генерируется Injector для соответствующих типов
     * */
    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            FragmentBuildersModule::class,
        ]
    )

    /**
     * Данные модулей передаются в главный Component Dagger2 (AppComponent)
     * */
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

}