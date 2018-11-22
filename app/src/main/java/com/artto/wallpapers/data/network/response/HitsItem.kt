package com.artto.wallpapers.data.network.response

import com.fasterxml.jackson.annotation.JsonProperty

data class HitsItem(

	@field:JsonProperty("webformatHeight")
	val webformatHeight: Int = 0,

	@field:JsonProperty("imageWidth")
	val imageWidth: Int = 0,

	@field:JsonProperty("favorites")
	val favorites: Int = 0,

	@field:JsonProperty("previewHeight")
	val previewHeight: Int = 0,

	@field:JsonProperty("webformatURL")
	val webformatURL: String = "",

	@field:JsonProperty("userImageURL")
	val userImageURL: String = "",

	@field:JsonProperty("previewURL")
	val previewURL: String = "",

	@field:JsonProperty("comments")
	val comments: Int = 0,

	@field:JsonProperty("type")
	val type: String = "",

	@field:JsonProperty("imageHeight")
	val imageHeight: Int = 0,

	@field:JsonProperty("tags")
	val tags: String = "",

	@field:JsonProperty("previewWidth")
	val previewWidth: Int = 0,

	@field:JsonProperty("fullHDURL")
	val fullHDURL: String = "",

	@field:JsonProperty("downloads")
	val downloads: Int = 0,

	@field:JsonProperty("user_id")
	val userId: Int = 0,

	@field:JsonProperty("largeImageURL")
	val largeImageURL: String = "",

	@field:JsonProperty("imageURL")
	val imageURL: String = "",

	@field:JsonProperty("pageURL")
	val pageURL: String = "",

	@field:JsonProperty("id")
	val id: Int = 0,

	@field:JsonProperty("imageSize")
	val imageSize: Int = 0,

	@field:JsonProperty("webformatWidth")
	val webformatWidth: Int = 0,

	@field:JsonProperty("user")
	val user: String = "",

	@field:JsonProperty("views")
	val views: Int = 0,

	@field:JsonProperty("likes")
	val likes: Int = 0
)