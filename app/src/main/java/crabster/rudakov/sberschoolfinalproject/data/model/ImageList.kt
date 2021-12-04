package crabster.rudakov.sberschoolfinalproject.data.model

import com.google.gson.annotations.SerializedName

/**
 * Класс, хранящий список всех URL изображений по стране
 *
 * @param hits список URL
 * */
data class ImageList(
    val hits: List<Hits>?
)

/**
 * Класс, хранящий URL изображения по стране
 *
 * @param webFormatURL URL картинки
 * */
data class Hits(
    @SerializedName("webformatURL")
    val webFormatURL: String
)