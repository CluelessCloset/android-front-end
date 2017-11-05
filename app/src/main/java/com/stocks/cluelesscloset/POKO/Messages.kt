package com.stocks.cluelesscloset.POKO

public data class RegisterData(val email: String, val password: String, val first_name: String, val last_name: String)

public data class LoginData(val email: String, val password: String)

public data class AddArticle(val token: String, val article_name: String, val type: String)

public data class Customize(val token: String, val adjective: String)

