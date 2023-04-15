package com.example.devmobilebarillecas

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
        println("toto")

        fun setHeaderTitle( title:String?){
            val textViewTitle= findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.setText(title)
        }

        fun showBack(){
            val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
            imageViewBack.visibility= View.VISIBLE
            imageViewBack.setOnClickListener(View.OnClickListener {
                finish()
            })
        }

        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView)
        categoriesRecyclerView.layoutManager = LinearLayoutManager(this)

        setHeaderTitle("Rayons")
        showBack()
        fetchData()

        println("fetch")
    }

    private fun fetchData() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://www.ugarit.online/epsi/categories.json")
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