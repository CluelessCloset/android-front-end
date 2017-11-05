package com.stocks.cluelesscloset.POKO

import com.squareup.moshi.Json

public data class TokenResponse(val token: String)

public data class BaseResponse(val message: String)

@Json(name = "")
public data class AllOutfits(val accessories_list: MutableList<Accessory>, val tops_list: MutableList<Top>, val bottoms_list: MutableList<Bottom>)

public data class Outfit(val accessory: Accessory,
                         val tops: Top,
                         val bottoms: Bottom)

public data class Accessory(val _id: String, val name: String, val clothing_type: String, val image: String, val owner_email: String, val __v: Int, val rain_resistant: Boolean, val warmth: Int)

public data class Top(val _id: String, val name: String, val clothing_type: String, val image: String, val owner_email: String, val __v: Int, val rain_resistant: Boolean, val warmth: Int)

public data class Bottom(val _id: String, val name: String, val clothing_type: String, val image: String, val owner_email: String, val __v: Int, val rain_resistant: Boolean, val warmth: Int)

public data class ClientResponse(val message: String, val data: String)
