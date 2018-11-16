package com.artto.wallpapers.data.network.request.parameter

class OrientationParameter(override val value: String = ALL, override val key: String = "orientation") :
    BaseWallpaperRequestParameter {

    companion object {
        const val ALL = "all"
        const val HORIZONTAL = "horizontal"
        const val VERTICAL = "vertical"
    }

}