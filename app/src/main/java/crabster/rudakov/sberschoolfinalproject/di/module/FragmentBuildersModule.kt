package crabster.rudakov.sberschoolfinalproject.di.module

import crabster.rudakov.sberschoolfinalproject.ui.country.view.CountryFragment
import crabster.rudakov.sberschoolfinalproject.ui.list.view.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Класс, описывающий возможные используемые Fragment
 * */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    /**
     * Генерируется Injector для ListFragment
     * */
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    /**
     * Генерируется Injector для CountryFragment
     * */
    @ContributesAndroidInjector
    abstract fun contributeCountryFragment(): CountryFragment

}