package neilbantoc.ancestry.data.models

import com.google.gson.annotations.SerializedName

data class Video (
    @SerializedName("name") val name: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("number") val number: Number,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("link") val link: String
)