package crabster.rudakov.sberschoolfinalproject.data.model

import com.google.gson.annotations.SerializedName

/**
 * Класс, хранящий список всех URL изображений по стране
 *
 * @param photos список URL
 * */
data class ImageList(
    @SerializedName("photos")
    val photos: List<Hits>?
)

/**
 * Класс, хранящий объект, содержащий в переменных URL
 * изображения по стране с различными характеристиками
 *
 * @param src объект-хранилище для каждой картинки
 * */
data class Hits(
    @SerializedName("src")
    val src: Parameters
)

/**
 * Класс, хранящий URL одиночного изображения
 *
 * @param tiny наиболее маловесный URL картинки
 * */
data class Parameters(
    @SerializedName("tiny")
    val tiny: String
)