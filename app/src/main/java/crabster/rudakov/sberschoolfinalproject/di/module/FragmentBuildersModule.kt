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
     * Генерируется subcomponent AndroidInjector для типа ListFragment
     * */
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    /**
     * Генерируется subcomponent AndroidInjector для типа CountryFragment
     * */
    @ContributesAndroidInjector
    abstract fun contributeCountryFragment(): CountryFragment

}