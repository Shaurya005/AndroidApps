package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    var PLAYER = true
    var TURN_COUNT = 0
    var boardStatus = Array(3){IntArray(3)}

    lateinit var board : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1:Button=findViewById(R.id.button1)
        var button2:Button=findViewById(R.id.button2)
        var button3:Button=findViewById(R.id.button3)
        var button4:Button=findViewById(R.id.button4)
        var button5:Button=findViewById(R.id.button5)
        var button6:Button=findViewById(R.id.button6)
        var button7:Button=findViewById(R.id.button7)
        var button8:Button=findViewById(R.id.button8)
        var button9:Button=findViewById(R.id.button9)

        board=arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        for(i in board){
            for(button:Button in i){
                button.setOnClickListener { this }
            }
        }

        initializeBoardStatus()
        var resetBtn : Button=findViewById(R.id.resetBn)
        resetBtn.setOnClickListener {
            TURN_COUNT=0
            PLAYER=true
            initializeBoardStatus()
        }
}

    private fun initializeBoardStatus() {
       for(i in  0..2){
           for(j in 0..2){
               boardStatus[0][0]=-1
               board[0][0].isEnabled=true;
               board[0][0].text=""
           }
       }
    }

    override fun onClick(view: View) {
      when(view.id){
          R.id.button1->{
              updateValue(row=0,col=0,player=PLAYER)
          }
          R.id.button2->{
              updateValue(row=0,col=1,player=PLAYER)
          }
          R.id.button3->{
              updateValue(row=0,col=2,player=PLAYER)
          }
          R.id.button4->{
              updateValue(row=1,col=0,player=PLAYER)
          }
          R.id.button5->{
              updateValue(row=1,col=1,player=PLAYER)
          }
          R.id.button6->{
              updateValue(row=1,col=2,player=PLAYER)
          }
          R.id.button7->{
              updateValue(row=2,col=0,player=PLAYER)
          }
          R.id.button8->{
              updateValue(row=2,col=1,player=PLAYER)
          }
          R.id.button9->{
              updateValue(row=2,col=2,player=PLAYER)
          }
      }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text=if(player) "X" else "0"
        val value=if(player) 1 else 0
        board[row][col].apply{
            isEnabled=false
            setText(text)
        }
        boardStatus[row][col]=value
    }
}