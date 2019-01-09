package ua.corteva.data.network.request.parameter

class ImageTypeParameter(override val value: String = ALL, override val key: String = "image_type") :
    BaseWallpaperRequestParameter {

    companion object {
        const val ALL = "all"
        const val PHOTO = "photo"
        const val ILLUSTRATION = "illustration"
        const val VECTOR = "vector"
    }

}