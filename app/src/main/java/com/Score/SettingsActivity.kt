package com.Score

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Switch

class SettingsActivity : AppCompatActivity() {

    private lateinit var notificationSwitch: Switch
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // Set the title bar color
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.BLACK))

        // Set the title bar text
        supportActionBar?.title = "Score Board Settings"

        // Get references to UI components
        notificationSwitch = findViewById(R.id.notification_switch)
        saveButton = findViewById(R.id.save)

        var indScore = intent.getIntExtra("indScore",0)
        var engScore = intent.getIntExtra("engScore",0)
        var indOvers = intent.getIntExtra("indOvers",0)
        var engOvers = intent.getIntExtra("engOvers",0)

        // Set up event handlers
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle notification switch change
            if (isChecked) {
                // Enable notifications
            } else {
                // Disable notifications
            }
        }
        saveButton.setOnClickListener {
            // Get shared preferences
            val sharedPreferences = getSharedPreferences("ScorePrefs", Context.MODE_PRIVATE)

            // Get editor for shared preferences
            val editor = sharedPreferences.edit()

            // Save scores and overs
            editor.putInt("indScore", indScore)
            editor.putInt("engScore", engScore)
            editor.putInt("indOvers", indOvers)
            editor.putInt("engOvers", engOvers)

            // Commit changes to shared preferences
            editor.apply()
        }



    }
}
