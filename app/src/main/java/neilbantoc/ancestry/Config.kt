package neilbantoc.ancestry

enum class Config(val baseUrl: String) {
    PROD("https://api.letsbuildthatapp.com/youtube/");

    companion object {
        val currentConfig: Config = PROD
    }
}