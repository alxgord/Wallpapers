package com.artto.wallpapers.data.network.response

import com.fasterxml.jackson.annotation.JsonProperty

data class HitsItem(

	@field:JsonProperty("webformatHeight")
	val webFormatHeight: Int,

	@field:JsonProperty("imageWidth")
	val imageWidth: Int,

	@field:JsonProperty("favorites")
	val favorites: Int,

	@field:JsonProperty("webformatURL")
	val webFormatURL: String,

	@field:JsonProperty("previewHeight")
	val previewHeight: Int,

	@field:JsonProperty("userImageURL")
	val userImageURL: String,

	@field:JsonProperty("comments")
	val comments: Int,

	@field:JsonProperty("previewURL")
	val previewURL: String,

	@field:JsonProperty("type")
	val type: String,

	@field:JsonProperty("imageHeight")
	val imageHeight: Int,

	@field:JsonProperty("tags")
	val tags: String,

	@field:JsonProperty("previewWidth")
	val previewWidth: Int,

	@field:JsonProperty("user_id")
	val userId: Int,

	@field:JsonProperty("downloads")
	val downloads: Int,

	@field:JsonProperty("largeImageURL")
	val largeImageURL: String,

	@field:JsonProperty("pageURL")
	val pageURL: String,

	@field:JsonProperty("id")
	val id: Int?,

	@field:JsonProperty("imageSize")
	val imageSize: Int,

	@field:JsonProperty("webformatWidth")
	val webFormatWidth: Int,

	@field:JsonProperty("user")
	val user: String,

	@field:JsonProperty("views")
	val views: Int,

	@field:JsonProperty("likes")
	val likes: Int
)