package com.Score
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity(), View.OnClickListener{
    //private lateinit var binding: ActivityMainBinding my app keep crashing for this
    private var engScore:Int=0
    private var engOverCounter:Int=0
    private var indScore:Int=0
    private var indOverCounter:Int=0
    private lateinit var tgbutton:ToggleButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Hide the action bar
        supportActionBar?.hide()

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

    //this function will update the score in our app for both teams
    private fun updateDisplay(){
        if(indScore<0){
            indScore=0
        }
        if(engScore<0){
            engScore=0
        }
        var overextraInd = indOverCounter%6
        var overextraEng = engOverCounter%6
        findViewById<TextView>(R.id.indiaScore).text = indScore.toString()+"/0"
        findViewById<TextView>(R.id.englandScore).text = engScore.toString()+"/0"
        findViewById<TextView>(R.id.indOvers).text = "Overs : "+indOverCounter/6+"."+overextraInd
        findViewById<TextView>(R.id.engOvers).text = "Overs : "+engOverCounter/6+"."+overextraEng

    }
    private fun isToggleButtonOn(toggleButton: ToggleButton): Boolean {
        return toggleButton.isChecked
    }
}


