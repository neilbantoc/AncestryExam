package neilbantoc.ancestry.data.models

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("link") val link: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("numberOfViews") val numberOfViews: Number,
    @SerializedName("channel") val channel: Channel
)