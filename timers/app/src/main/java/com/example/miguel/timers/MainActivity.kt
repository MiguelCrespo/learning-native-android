package com.example.miguel.timers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textview_progress.translationY

        textview_progress.text = initialTextViewTranslationY.toString()

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                textview_progress.text = progress.toString()

                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textview_progress.animate().translationY(translationDistance)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        button_reset.setOnClickListener{v ->
            seekBar.progress = 0

            textview_progress.animate().setDuration(500).rotationXBy(360f).translationY(initialTextViewTranslationY)
        }

    }
}
