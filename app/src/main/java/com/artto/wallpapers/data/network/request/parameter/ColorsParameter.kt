package com.artto.wallpapers.data.network.request.parameter

class ColorsParameter(override val value: String, override val key: String = "colors") : BaseWallpaperRequestParameter {

    companion object {
        const val GRAYSCALE = "grayscale"
        const val TRANSPARENT = "transparent"
        const val RED = "red"
        const val ORANGE = "orange"
        const val YELLOW = "yellow"
        const val GREEN = "green"
        const val TURQUOISE = "turquoise"
        const val BLUE = "blue"
        const val LILAC = "lilac"
        const val PINK = "pink"
        const val WHITE = "white"
        const val GRAY = "gray"
        const val BLACK = "black"
        const val BROWN = "brown"
    }

}