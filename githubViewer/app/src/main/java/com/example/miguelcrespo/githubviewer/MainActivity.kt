package com.example.miguelcrespo.githubviewer

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.io.Serializable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        val USER = "MainActivity.user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search_github.setOnClickListener{ v ->
            this.handleGithubSearch(v)
        }
    }

    fun handleGithubSearch(v: View) {
        val client = OkHttpClient()

        val url = "https://api.github.com/users/"+textview_github_user.text

        val request = Request.Builder().url(url).build()

        val progress = ProgressDialog(this)
        progress.setTitle("Searching in Github")
        progress.show()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("Fuck an error!!")

                runOnUiThread{
                    Toast.makeText(this@MainActivity, "An error has ocurred", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call?, response: Response?) {

                val body = response?.body()?.string()

                val gson = GsonBuilder().create()

                val user = gson.fromJson(body, User::class.java)

                runOnUiThread{
                    progress.hide()

                    onUserLoad(user)
                }

                println(body)
            }

        })
    }

    fun onUserLoad(user: User) {
        val intent = Intent(this@MainActivity, UserDetails::class.java)
        intent.putExtra(USER, user)

        startActivity(intent)
    }
}

class User(val id : Int, val login : String, val avatar_url : String, val name: String, val followers : Int, val following : Int) : Serializable {

}