package ua.corteva.data.network.request.parameter

class CategoryParameter(override val value: String, override val key: String = "category") :
    BaseWallpaperRequestParameter {

    companion object {
        const val FASHION = "fashion"
        const val NATURE = "nature"
        const val BACKGROUNDS = "backgrounds"
        const val SCIENCE = "science"
        const val EDUCATION = "education"
        const val PEOPLE = "people"
        const val FEELINGS = "feelings"
        const val RELIGION = "religion"
        const val HEALTH = "health"
        const val PLACES = "places"
        const val ANIMALS = "animals"
        const val INDUSTRY = "industry"
        const val FOOD = "food"
        const val COMPUTER = "computer"
        const val SPORTS = "sports"
        const val TRANSPORTATION = "transportation"
        const val TRAVEL = "travel"
        const val BUILDINGS = "buildings"
        const val BUSINESS = "business"
        const val MUSIC = "music"
    }

}