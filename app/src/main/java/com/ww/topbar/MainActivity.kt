package com.ww.topbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
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


       topBar_Main.setTitleText("标题")//设置标题文本
             //  .setTitleTextColor(颜色)//设置标题文本颜色
               .setTitleTextSize(1f)//设置标题文本大小
               .setTitleTextisBold(true)//设置标题文本是否加粗（默认加粗，左侧和右侧文本默认不加粗）
               .setTitleTextMargins(0,0,0,0)//设置标题文本控件间距
               .setTitleTextIsShow(true)//设置标题文本是否显示（默认显示，左侧和右侧的文本也默认显示）
             //  .setTitleImage(图片)//设置标题图片
               .setTitleImageHeight(1)//设置标题图片高（默认15dp）
               .setTitleImageWidth(1)//设置标题图片宽（默认15dp）
               .setTitleImageViewIsShow(true)//设置标题图片是否显示（默认显示，左侧的也默认显示，右侧的默认隐藏）
               .setTitleImageScaleType(ImageView.ScaleType.CENTER_CROP)//设置标题图片显示方式
               .setTitleImageMargins(0,0,0,0)//设置标题图片控件间距
               .setTopBarWidth(0)//设置整个控件的宽
               .setTopBarHeight(0)//设置整个控件的高
               .setTopBarMargins(0,0,0,0)//设置整个控件的边距
               .setStatusImmersive(true)//设置或取消沉浸式状态栏
               .setFullScreen(true)//设置全屏
               .setOnTopBarClickListenner(object :OnTopBarClickListenner{

                   override fun onClickLeft(view: View) {
                       super.onClickLeft(view)
                   }

                   override fun onClickRight(view: View) {
                       super.onClickRight(view)
                   }

                   override fun onClickTitle(view: View) {
                       super.onClickTitle(view)
                   }
               })
            // 左侧和右侧的文本和图片设置和标题相似，还可以get各个控件对象，一边进行各种扩展操作
    }


}
