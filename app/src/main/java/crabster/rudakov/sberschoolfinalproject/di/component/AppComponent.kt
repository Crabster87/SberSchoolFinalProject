package crabster.rudakov.sberschoolfinalproject.di.component

import android.app.Application
import crabster.rudakov.sberschoolfinalproject.App
import crabster.rudakov.sberschoolfinalproject.di.module.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Создаётся Component для получения зависимостей
 * */
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
    ]
)

/**
 * Интерфейс выполняет Inject элемента типа Android
 * */
interface AppComponent : AndroidInjector<App> {

    /**
     * Конструктор компонента
     * */
    @Component.Factory
    interface Builder {
        /**
         * Метод привязывает экземпляр к типу Builder
         * */
        fun create(@BindsInstance application: Application): AppComponent
    }

    /**
     * Метод выполняет Inject экзепляра класса App
     * */
    override fun inject(app: App)

}