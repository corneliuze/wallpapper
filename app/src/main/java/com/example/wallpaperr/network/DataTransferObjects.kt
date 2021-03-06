package com.example.wallpaperr.network


import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.DatabaseImages
import com.google.gson.annotations.SerializedName


data class Hit(
    @SerializedName("id")
    val id: Int,
    @SerializedName("previewURL")
    val previewImageUrl: String,
    @SerializedName("imageURL")
    val fullImage: String
)


fun Hit.asDomainModel(): Images {
    return Images(
        id,
        previewImageUrl,
        fullImage
    )

}

fun List<Hit>.asDatabaseModel(): Array<DatabaseImages> {
    return map {
        DatabaseImages(
            id = it.id,
            previewImageUrl = it.previewImageUrl,
            fullImage = it.fullImage
        )
    }.toTypedArray()
}