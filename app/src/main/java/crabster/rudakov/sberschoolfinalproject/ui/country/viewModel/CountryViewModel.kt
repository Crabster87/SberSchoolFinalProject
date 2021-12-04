package crabster.rudakov.sberschoolfinalproject.ui.country.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import crabster.rudakov.sberschoolfinalproject.data.model.CountryInfo
import crabster.rudakov.sberschoolfinalproject.data.model.Hits
import crabster.rudakov.sberschoolfinalproject.data.repository.RetrofitRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Класс View Model 2-ого экрана
 * */
class CountryViewModel
@Inject constructor(private val retrofitRepository: RetrofitRepository) : ViewModel() {

    private var countryInfo: MutableLiveData<CountryInfo> = MutableLiveData()
    private var exception: MutableLiveData<String> = MutableLiveData()
    private val coordinates: MutableLiveData<List<Float>> = MutableLiveData()
    private val flag: MutableLiveData<String> = MutableLiveData()
    private val images: MutableLiveData<List<Hits>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * Метод возвращает объект, хранящий информацию о стране
     *
     * @return LiveData<CountryInfo>
     * */
    fun countryInfo(): LiveData<CountryInfo> {
        return countryInfo
    }

    /**
     * Метод возвращает строковое представление исключения
     *
     * @return LiveData<String>
     * */
    fun exception(): LiveData<String> {
        return exception
    }

    /**
     * Метод возвращает объект 'LiveData'
     *
     * @return LiveData<List<Float>>
     * */
    fun coordinates(): LiveData<List<Float>> {
        return coordinates
    }

    /**
     * Метод возвращает флаг
     *
     * @return LiveData<String>
     * */
    fun flag(): LiveData<String> {
        return flag
    }

    /**
     * Метод возвращает список URL изображений
     *
     * @return LiveData<List<Hits>>
     * */
    fun images(): LiveData<List<Hits>> {
        return images
    }

    /**
     * Метод единожды возвращает объект 'CountryInfo', полученный по
     * переданному названию страны, отдельно сохраняя координаты страны
     * и обрабатывая исключения.
     *
     * @param country название страны
     * @return Single<CountryInfo>
     * */
    fun getCountry(country: String) {
        countryInfo.value = null
        compositeDisposable.add(
            retrofitRepository.getCountry(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    countryInfo.value = it
                    setCoordinates(
                        listOf(
                            it?.maps?.lat,
                            it?.maps?.long
                        ) as List<Float>
                    )
                }, {
                    exception.value = it.toString()
                })
        )
    }

    /**
     * Метод единожды возвращает объект 'Single<String>', полученный по
     * переданной аббревиатуре флага, обрабатывая исключения.
     *
     * @param flag аббревиатура флага
     * @return Single<String>
     * */
    fun getFlag(flag: String) {
        compositeDisposable.add(
            retrofitRepository.getFlag(flag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.flag.value = it
                }, {
                    exception.value = it.toString()
                })
        )
    }

    /**
     * Метод единожды возвращает объект 'Single<ImageList>', полученный по
     * переданному названию страны, обрабатывая исключения.
     *
     * @param country название страны
     * @return Single<ImageList>
     * */
    fun getImages(country: String) {
        compositeDisposable.add(
            retrofitRepository.getImages(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    images.value = it.hits
                }, {
                    exception.value = it.toString()
                })
        )
    }

    /**
     * Метод устанавливает переданный список со значениями широты
     * и долготы в объект 'LiveData'
     *
     * @param coordinates список из 2-х элементов(широта и долгота)
     * */
    private fun setCoordinates(coordinates: List<Float>) {
        this.coordinates.value = coordinates
    }

    /**
     * В методе помимо основного функционала производится
     * удаление подписки
     * */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}