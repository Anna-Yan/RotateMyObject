package com.example.anna.myrotateobjectapp

import android.graphics.Matrix
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.rotateImage
import kotlinx.android.synthetic.main.activity_main.informText
import kotlinx.android.synthetic.main.activity_main.mLayout
import java.util.*
import android.graphics.Bitmap
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.graphics.BitmapFactory
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth









class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val matrix = Matrix()



        rotateImage.setOnTouchListener { v:View, m:MotionEvent ->

            handleTouch(m,matrix)
            true
        }

    }

    private fun handleTouch(m: MotionEvent, mMatrix: Matrix) {
        val pointerCount = m.pointerCount
        for (i in 0 until pointerCount){
            val x = m.getX(i)
            val y = m.getY(i)
           // val id = m.getPointerId(i)
            val action = m.actionMasked
            var resultText : String
            var actionString : String

            when(action){
                MotionEvent.ACTION_DOWN -> actionString="DOWN↓"

                MotionEvent.ACTION_UP -> actionString= "UP↑"

                MotionEvent.ACTION_MOVE ->{
                    actionString = "MOVE"
                    mMatrix.postRotate(rotateImage.pivotY-y,rotateImage.pivotX,rotateImage.pivotY)
                    rotateImage.scaleType = ImageView.ScaleType.MATRIX
                    rotateImage.imageMatrix = mMatrix

                }

                else -> actionString = ""
            }



            resultText = "Your action: $actionString , Your touch coordinates: X= $x , Y=$y : " +
                    "Your image coordinates:Y=${rotateImage.pivotY} ,Y teqman ankyun=${rotateImage.pivotY-y} "
            informText.text = resultText
        }
    }


    fun otherExample(){

        mLayout.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View, m: MotionEvent): Boolean {


                return true
            }
        })
    }



}
