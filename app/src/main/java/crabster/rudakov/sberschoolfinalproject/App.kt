package crabster.rudakov.sberschoolfinalproject

import crabster.rudakov.sberschoolfinalproject.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Класс, запускающий приложения с целью внедрения зависимостей
 * с помощью Dagger2 перед стартом главной Activity
 * */
class App : DaggerApplication() {

    /**
     * Метод создаёт Component из класса AppComponent
     * */
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .factory()
            .create(this)
    }

}