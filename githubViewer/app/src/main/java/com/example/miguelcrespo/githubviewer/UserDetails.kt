package com.example.miguelcrespo.githubviewer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetails : AppCompatActivity() {
    lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        mUser = intent.getSerializableExtra(MainActivity.USER) as User


        println(mUser.toString())

        /*val requestOption = RequestOptions()
                .centerCrop()
                .transforms(CenterCrop(), RoundedCorners(500))

        Glide.with(this).load(mUser.avatar_url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(requestOption)
                .into(image_profile)*/

        Glide.with(this).load(mUser.avatar_url)
                .into(image_profile)

        button_view_profile.setOnClickListener{v ->
            openUserProfile(v)
        }


    }

    fun openUserProfile(v: View) {
        val intent = Intent(this@UserDetails, UserProfile::class.java)

        intent.putExtra(MainActivity.USER, mUser)

        startActivity(intent)
    }
}
