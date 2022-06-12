package crabster.rudakov.sberschoolfinalproject.data.api.`interface`

import crabster.rudakov.sberschoolfinalproject.data.model.CountryInfo
import crabster.rudakov.sberschoolfinalproject.data.model.CountryItem
import crabster.rudakov.sberschoolfinalproject.data.model.ImageList
import crabster.rudakov.sberschoolfinalproject.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Интерфейс, описывающий взаимодействие приложения(клиента) и API(сервера)
 * */
@Singleton
interface RetrofitServices {

    /**
     * Метод получает список стран по указанному API
     *
     * @return список стран мира
     * */
    @GET(Constants.LIST_URL)
    fun getCountryList(): Single<List<CountryItem>>

    /**
     * Метод получает страну из списка по её названию, используя
     * аттрибут "country" предоставляемого JSON-файла
     *
     * @param country название страны
     * @return название страны
     * */
    @GET("{country}")
    fun getCountry(@Path("country") country: String): Single<CountryInfo>

    /**
     * Метод получает флаг страны из списка по его аббревиатуре, используя
     * аттрибут "flag" предоставляемого JSON-файла
     *
     * @param flag флаг страны
     * @return флаг страны
     * */
    @Headers("Content-Type: image/svg+xml")
    @GET(Constants.FLAG_URL + "{flag}" + Constants.FLAG_FORMAT)
    fun getFlag(@Path("flag") flag: String): Single<String>

    /**
     * Метод получает список URL картинок, который выдаётся в результате
     * поискового запроса по названию страны на сайте https://api.pexels.com/
     *
     * @param order название страны
     * @return список URL изображений
     * */
    @Headers("Authorization: ${Constants.IMAGES_KEY}")
    @GET(Constants.IMAGES_API)
    fun getImages(@Query("query") order: String): Single<ImageList>

}