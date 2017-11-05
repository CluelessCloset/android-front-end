package com.stocks.cluelesscloset.POKO

public data class TokenResponse(val token: String)

public data class BaseResponse(val message: String)

public data class Outfit(val accessory: ClothingData,
                         val top: ClothingData,
                         val bottom: ClothingData)

public data class ClientResponse(val message: String, val data: String)
