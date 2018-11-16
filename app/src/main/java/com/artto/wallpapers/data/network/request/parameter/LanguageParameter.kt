package com.artto.wallpapers.data.network.request.parameter

class LanguageParameter(override val value: String = EN, override val key: String = "lang") :
    BaseWallpaperRequestParameter {

    companion object {
        const val CS = "cs"
        const val DA = "da"
        const val DE = "de"
        const val EN = "en"
        const val ES = "es"
        const val FR = "fr"
        const val ID = "id"
        const val HU = "hu"
        const val NL = "nl"
        const val NO = "no"
        const val PL = "pl"
        const val PT = "pt"
        const val RO = "ro"
        const val SK = "sk"
        const val FI = "fi"
        const val SV = "sv"
        const val TR = "tr"
        const val VI = "vi"
        const val TH = "th"
        const val BG = "bg"
        const val RU = "ru"
        const val EL = "el"
        const val JA = "ja"
        const val KO = "ko"
        const val ZH = "zh"
    }

}