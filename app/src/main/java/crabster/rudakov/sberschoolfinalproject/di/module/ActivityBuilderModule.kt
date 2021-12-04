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
     * Генерируется subcomponent AndroidInjector для типа MainActivity, в
     * который добавляются модули ViewModelModule и FragmentBuildersModule
     * */
    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            FragmentBuildersModule::class,
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    /**
     * Генерируется subcomponent AndroidInjector для типа SplashActivity
     * */
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

}