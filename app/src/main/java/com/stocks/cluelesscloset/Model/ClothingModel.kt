package com.stocks.cluelesscloset.Model

import com.stocks.cluelesscloset.POKO.BaseResponse
import com.stocks.cluelesscloset.POKO.Outfit
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ClothingModel {
    @Multipart
    @POST("/user/add_clothes")
    @FormUrlEncoded
    fun addArticle(@Part image: MultipartBody.Part,
                   @Part("name") name: RequestBody,
                   @Field("article_name") article_name: String,
                   @Field("email") email: String,
                   @Field("water_resistant") waterResistant: Boolean,
                   @Field("warmth_rating") warmthRating: Int,
                   @Field("clothing_type") articleType: String): Call<BaseResponse>

    @POST("/getoutfit")
    @FormUrlEncoded
    fun getOutfit(@Field("email") token: String,
                  @Field("latitude") latitude: Double,
                  @Field("longitude") longitude: Double,
                  @Field("custom") custom: String = ""): Call<Outfit>

    @GET("/getallclothes")
    fun getAllOutfits(@Query("email") token: String): Call<List<Outfit>>

}