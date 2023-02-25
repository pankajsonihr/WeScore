package com.Score
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener{
    //private lateinit var binding: ActivityMainBinding my app keep crashing for this
    private var engScore:Int=0
    private var indScore:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.indDec).setOnClickListener(this)
        findViewById<ImageView>(R.id.indInc).setOnClickListener(this)
        findViewById<ImageView>(R.id.engDec).setOnClickListener(this)
        findViewById<ImageView>(R.id.engInc).setOnClickListener(this)
        updateDisplay()
    }
    //this will increase or decrease the score for both team based on spinner's selected score
    override fun onClick(v: View?) {
        val spinner = findViewById<Spinner>(R.id.spinner1) as Spinner
        val getSelectedValue:Int = spinner.selectedItem.toString().toInt()
        when(v?.id){
            R.id.engInc-> engScore+= getSelectedValue
            R.id.engDec-> engScore-= getSelectedValue
            R.id.indInc-> indScore+= getSelectedValue
            R.id.indDec-> indScore-= getSelectedValue
            else -> Log.e("Onclick","something went wrong")
        }
        updateDisplay()
    }
    //this function will update the score in our app for both teams
    private fun updateDisplay(){
        if(indScore<0){
            indScore=0
        }
        if(engScore<0){
            engScore=0
        }
        findViewById<TextView>(R.id.indScore).text = indScore.toString()
        findViewById<TextView>(R.id.engScore).text = engScore.toString()
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.indDec.setOnClickListener(this)
        binding.indInc.setOnClickListener(this)
        binding.engDec.setOnClickListener(this)
        binding.engInc.setOnClickListener(this)
        updateDisplay()
    }
    override fun onClick(v: View?) {
        val getSelectedValue:Int=binding.spinner1.selectedItem.toString().toInt()
        when(v?.id){
            R.id.engInc-> engScore+= getSelectedValue
            R.id.engDec-> engScore-= getSelectedValue
            R.id.indInc-> indScore+= getSelectedValue
            R.id.indDec-> indScore-= getSelectedValue
            else -> Log.e("Onclick","something went wrong")
        }
        updateDisplay()
    }
    private fun updateDisplay(){
        binding.indScore.text = indScore.toString()
        binding.engScore.text = engScore.toString()
    }*/
}


