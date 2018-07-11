package com.example.miguelcrespo.githubviewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetails : AppCompatActivity() {
    lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        mUser = intent.getSerializableExtra(MainActivity.USER) as User


        println(mUser.toString())


        Glide.with(this).load(mUser.avatar_url).into(image_profile)
    }
}
