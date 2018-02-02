package com.ww.topbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ww.apptopbar.OnTopBarClickListenner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

   private fun initView(){

        topBar_Main.setLeftImage(R.drawable.svg_left_white_40dp)
                .setLeftText(getString(R.string.left)).setTitleText(getString(R.string.title)).setRightText(getString(R.string.right))
                .setOnTopBarClickListenner(object :OnTopBarClickListenner{
            override fun onClickLeft(view: View) {
               Toast.makeText(this@MainActivity,getString(R.string.left),Toast.LENGTH_SHORT).show()
            }

            override fun onClickRight(view: View) {
                Toast.makeText(this@MainActivity,getString(R.string.right),Toast.LENGTH_SHORT).show()
            }

            override fun onClickTitle(view: View) {
                Toast.makeText(this@MainActivity,getString(R.string.title),Toast.LENGTH_SHORT).show()
            }
        })

    }


}
