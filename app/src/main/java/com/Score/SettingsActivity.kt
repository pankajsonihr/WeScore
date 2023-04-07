package com.Score

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.Switch

class SettingsActivity : AppCompatActivity() {

    private lateinit var notificationSwitch: Switch
    private lateinit var volumeSeekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // Set the title bar color
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.BLACK))

        // Set the title bar text
        supportActionBar?.title = "Score Board Settings"

        // Get references to UI components
        notificationSwitch = findViewById(R.id.notification_switch)
        volumeSeekBar = findViewById(R.id.volume_seekbar)

        // Set up event handlers
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle notification switch change
            if (isChecked) {
                // Enable notifications
            } else {
                // Disable notifications
            }
        }

        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Handle volume seekbar change
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not used in this example
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not used in this example
            }
        })
    }
}
