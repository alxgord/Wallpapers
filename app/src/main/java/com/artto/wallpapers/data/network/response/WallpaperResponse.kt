package com.artto.wallpapers.data.network.response

import com.fasterxml.jackson.annotation.JsonProperty

data class WallpaperResponse(

	@field:JsonProperty("hits")
	val hits: List<HitsItem>,

	@field:JsonProperty("total")
	val total: Int,

	@field:JsonProperty("totalHits")
	val totalHits: Int
)