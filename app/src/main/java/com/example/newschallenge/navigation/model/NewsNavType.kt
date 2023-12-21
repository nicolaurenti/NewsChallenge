package com.example.newschallenge.navigation.model

/**import com.example.domain.News
import com.google.gson.Gson

class NewsArgType : JsonNavType<News>() {

 override fun fromJsonParse(value: String): News = Gson().fromJson(value, News::class.java)

 override fun News.getJsonParse(): String = Gson().toJson(this)

}
**/
