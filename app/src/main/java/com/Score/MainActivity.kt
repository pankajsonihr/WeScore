package com.Score
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*

//This is group project by Pankaj, Siva Sai and Mahroon Nisha

class MainActivity : AppCompatActivity(), View.OnClickListener{
    //private lateinit var binding: ActivityMainBinding
    private var engScore:Int=0
    private var engOverCounter:Int=0
    private var indScore:Int=0
    private var indOverCounter:Int=0
    private lateinit var tgbutton:ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set the title bar color
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.BLACK))

        // Set the title bar text
        supportActionBar?.title = "Score Board"
        val sharedPreferences = getSharedPreferences("ScorePrefs", Context.MODE_PRIVATE)

        // Retrieve scores and overs
        indScore = sharedPreferences.getInt("indScore", 0)
        engScore = sharedPreferences.getInt("engScore", 0)
        indOverCounter = sharedPreferences.getInt("indOvers", 0)
        engOverCounter = sharedPreferences.getInt("engOvers", 0)


        findViewById<ImageView>(R.id.Inc).setOnClickListener(this)
        findViewById<ImageView>(R.id.Dec).setOnClickListener(this)
        tgbutton = findViewById<ToggleButton>(R.id.tgbutton)
        updateDisplay()
    }



    //this will increase or decrease the score for both team based on spinner's selected score
    override fun onClick(v: View?) {

        when(v?.id){
            R.id.Inc-> scoreChange(1)
            R.id.Dec-> scoreChange(-1)
            else -> Log.e("Onclick","something went wrong")
        }
        updateDisplay()
    }
    private fun scoreChange(addRemove:Int){
        val spinner = findViewById<Spinner>(R.id.spinner1) as Spinner
        val getSelectedValue:Int = spinner.selectedItem.toString().toInt()
        if(isToggleButtonOn(tgbutton)){
            if (addRemove==-1){
                indScore -=getSelectedValue
            }
            else if (addRemove ==1){
                indScore +=getSelectedValue
            }
            indOverCounter +=1
        }
        else if(!isToggleButtonOn(tgbutton)){
            if (addRemove==-1){
                engScore -=getSelectedValue
            }
            else if (addRemove ==1){
                engScore +=getSelectedValue
            }
            engOverCounter +=1
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_xml, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.about -> {
                // Display developer names
                val message = "Developer: Siva sai, Mahroon Nisha, Pankaj"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.settings -> {
                // Open settings activity
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("indScore", indScore)
                intent.putExtra("engScore", engScore)
                intent.putExtra("indOvers", indOverCounter)
                intent.putExtra("engOvers", engOverCounter)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    //this function will update the score in our app for both teams
    private fun updateDisplay(){
        if(indScore<0){
            indScore=0
        }
        if(engScore<0){
            engScore=0
        }
        val overExtraInd = indOverCounter%6
        val overExtraEng = engOverCounter%6
        findViewById<TextView>(R.id.indiaScore).text = indScore.toString()+"/0"
        findViewById<TextView>(R.id.englandScore).text = engScore.toString()+"/0"
        findViewById<TextView>(R.id.indOvers).text = "Overs : "+indOverCounter/6+"."+overExtraInd
        findViewById<TextView>(R.id.engOvers).text = "Overs : "+engOverCounter/6+"."+overExtraEng

    }


    private fun isToggleButtonOn(toggleButton: ToggleButton): Boolean {
        return toggleButton.isChecked
    }
}


