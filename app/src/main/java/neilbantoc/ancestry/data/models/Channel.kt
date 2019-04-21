package neilbantoc.ancestry.data.models

import com.google.gson.annotations.SerializedName

data class Channel (
    @SerializedName("name") val name: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String,
    @SerializedName("numberOfSubscribers") val numberOfSubscribers: Number
)