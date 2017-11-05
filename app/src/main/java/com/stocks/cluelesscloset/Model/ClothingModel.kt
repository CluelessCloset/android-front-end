package com.stocks.cluelesscloset.Model

import com.stocks.cluelesscloset.POKO.AllOutfits
import com.stocks.cluelesscloset.POKO.BaseResponse
import com.stocks.cluelesscloset.POKO.Outfit
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ClothingModel {
    @Multipart
    @POST("/user/add_clothes")
    fun addArticle(@Part image: MultipartBody.Part,
                   @Part("name") name: RequestBody,
                   @Part("article_name") article_name: String,
                   @Part("email") email: String,
                   @Part("water_resistant") waterResistant: Boolean,
                   @Part("warmth_rating") warmthRating: Int,
                   @Part("clothing_type") articleType: String): Call<BaseResponse>

    @GET("/getclothes")
    fun getOutfit(@Query("email") token: String,
                  @Query("latitude") latitude: Double,
                  @Query("longitude") longitude: Double,
                  @Query("custom") custom: String = ""): Call<Outfit>

    @GET("/getallclothes")
    fun getAllOutfits(@Query("email") email: String): Call<AllOutfits>

}