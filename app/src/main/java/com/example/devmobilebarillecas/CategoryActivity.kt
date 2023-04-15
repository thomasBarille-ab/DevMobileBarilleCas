package com.example.devmobilebarillecas

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

data class CategoryItem(
    val category_id: String,
    val title: String,
    val products_url: String
)

class CategoryActivity : AppCompatActivity() {
    private lateinit var categoriesRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun fetchData() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://www.ugarit.online/epsi/categories.json%22")
            .build()

        println("data")

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val jsonData = response.body!!.string()

                    val jsonObject = JSONObject(jsonData)
                    val itemsJson = jsonObject.getJSONArray("items").toString()

                    val gson = Gson()
                    val type = object : TypeToken<List<CategoryItem>>() {}.type
                    val categoryItems: List<CategoryItem> = gson.fromJson(itemsJson, type)

                    runOnUiThread {
                        displayCategories(categoryItems)
                    }
                }
            }
        })
    }

    private fun displayCategories(categoryItems: List<CategoryItem>) {
        val adapter = CategoryAdapter(categoryItems)
        categoriesRecyclerView.adapter = adapter
    }

}