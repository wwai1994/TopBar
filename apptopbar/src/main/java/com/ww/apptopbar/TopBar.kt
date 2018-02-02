package com.ww.apptopbar

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.ww.apptopbar.R.layout.topbar
import kotlinx.android.synthetic.main.topbar.view.*

/**
 * Created by WangWei on 2018/1/31.
 */
class TopBar(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : RelativeLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)


    private var listenner: OnTopBarClickListenner? = null
    private var originalHeight = 0//用来记录TopBar初始的高
    private var statusShowTopBarHeight = 0//用来记录TopBar状态栏显示时的高

    init {
        LayoutInflater.from(context).inflate(topbar, this)
        view_left.setOnClickListener { listenner?.onClickLeft(view_left) }
        view_title.setOnClickListener { listenner?.onClickTitle(view_title) }
        view_right.setOnClickListener { listenner?.onClickRight(view_right) }

    }

    fun setOnTopBarClickListenner(onTopBarClickListenner: OnTopBarClickListenner) {
        listenner = onTopBarClickListenner
    }


    fun getTopBarView(): RelativeLayout = view_top_bar   //获取TopBar的全体布局对象
    fun getLeftView(): LinearLayout = view_left   //获取TopBar的左侧布局对象
    fun getTitleView(): LinearLayout = view_title   //获取TopBar的标题布局对象
    fun getRightView(): LinearLayout = view_right   //获取TopBar的右侧布局对象
    fun getLeftTextParentView(): RelativeLayout = view_tv_left   //获取TopBar的左侧布局中文本父容器对象
    fun getTitleTextParentView(): RelativeLayout = view_tv_title   //获取TopBar的标题布局中文本父容器对象
    fun getRightTextParentView(): RelativeLayout = view_tv_right     //获取TopBar的右侧布局中文本父容器对象
    fun getLeftImageViewParentView(): RelativeLayout = view_iv_left   //获取TopBar的左侧布局中图片父容器对象
    fun getTitleImageViewParentView(): RelativeLayout = view_iv_title   //获取TopBar的标题布局中图片父容器对象
    fun getRightImageViewParentView(): RelativeLayout = view_iv_right   //获取TopBar的右侧布局中图片父容器对象
    fun getLeftTextView(): TextView = tv_left   //获取TopBar的左侧文本对象
    fun getTitleTextView(): TextView = tv_title   //获取TopBar的标题文本对象
    fun getRightTextView(): TextView = tv_right    //获取TopBar的右侧文本对象
    fun getLeftImageView(): ImageView = iv_left   //获取TopBar的左侧图片对象
    fun getTitleImageView(): ImageView = iv_title   //获取TopBar的标题图片对象
    fun getRightImageView(): ImageView = iv_right   //获取TopBar的右侧图片对象

    fun setStatusImmersive(flag: Boolean): TopBar {//只有api19及以上才能生效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (flag) {
                //透明状态栏
                (context as Activity).window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                //透明导航栏
                // (context as Activity).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                if (originalHeight == 0)
                    originalHeight = layoutParams.height
                //获取status_bar_height资源的ID
                var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
                if (resourceId > 0) {
                    var statusHeight = resources.getDimensionPixelSize(resourceId)
                    view_place.layoutParams.height = statusHeight
                    if (statusShowTopBarHeight == 0)
                        statusShowTopBarHeight = statusHeight + originalHeight
                    layoutParams.height = statusShowTopBarHeight
                }

            } else {

                //透明状态栏
                (context as Activity).window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                layoutParams.height = originalHeight
                view_place.layoutParams.height = 0
            }
        }

        return this
    }

    fun setFullScreen(flag: Boolean):TopBar{//设置全屏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(flag)
            //透明状态栏
            (context as Activity).window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            else   (context as Activity).window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
                return this
    }

    fun setTopBackGroundColor(color: Int): TopBar {    //设置TopBar的背景颜色
        view_top_bar.setBackgroundColor(color)
        return this
    }

    fun setTopBackGroundDrawable(drawable: Drawable): TopBar {    //设置TopBar的背景图片
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view_top_bar.setBackground(drawable)
        } else view_top_bar.setBackgroundDrawable(drawable)
        return this
    }

    fun setTopBarHeight(height: Int): TopBar {  //设置TopBar的高度
        layoutParams.height = height
        return this
    }

    fun setTopBarWidth(width: Int): TopBar {    //设置TopBar的高度
        layoutParams.width = width
        return this
    }

    fun setTopBarMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置TopBar边距
        (view_top_bar.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    //左侧区域
    fun setLeftText(str: String): TopBar {//设置左侧文本
        tv_left.text = str
        return this
    }

    fun setLeftTextSize(size: Float): TopBar {//设置左侧文本大小
        tv_left.textSize = size
        return this
    }

    fun setLeftTextColor(color: Int): TopBar {//设置左侧文本颜色
        tv_left.setTextColor(color)
        return this
    }

    fun setLeftTextisBold(isBold: Boolean): TopBar {//设置左侧文本是否加粗
        tv_left.paint.isFakeBoldText = isBold
        return this
    }

    fun setLeftTextIsShow(isShow: Boolean): TopBar {//设置左侧文本是否显示
        if (isShow)
            tv_left.visibility = View.VISIBLE
        else tv_left.visibility = View.GONE
        return this
    }

    fun setLeftTextMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置左侧文本边距
        (tv_left.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    fun setLeftImageViewIsShow(isShow: Boolean): TopBar {//设置左侧图片是否显示
        if (isShow)
            iv_left.visibility = View.VISIBLE
        else iv_left.visibility = View.GONE
        return this
    }

    fun setLeftImage(drawable: Drawable): TopBar {//设置左侧图片
        iv_left.setImageDrawable(drawable)

        return this
    }

    fun setLeftImage(drawable: Int): TopBar {//设置左侧图片

        iv_left.setImageResource(drawable)

        return this
    }

    fun setLeftImageScaleType(scaleType: ImageView.ScaleType): TopBar {//设置左侧图片显示方式
        iv_left.scaleType = scaleType
        return this
    }

    fun setLeftImageHeight(height: Int): TopBar {//设置左侧图片的高
        iv_left.layoutParams.height = height
        return this
    }

    fun setLeftImageWidth(width: Int): TopBar {//设置左侧图片的宽
        iv_left.layoutParams.width = width
        return this
    }

    fun setLeftImageMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置左侧图片边距
        (iv_left.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    //标题区域
    fun setTitleText(str: String): TopBar {//设置标题文本
        tv_title.text = str
        return this
    }

    fun setTitleTextSize(size: Float): TopBar {//设置标题文本大小
        tv_title.textSize = size
        return this
    }


    fun setTitleTextColor(color: Int): TopBar {//设置标题文本颜色
        tv_title.setTextColor(color)
        return this
    }

    fun setTitleTextisBold(isBold: Boolean): TopBar {//设置标题文本是否加粗
        tv_title.paint.isFakeBoldText = isBold
        return this
    }

    fun setTitleTextIsShow(isShow: Boolean): TopBar {//设置标题文本是否显示
        if (isShow)
            tv_title.visibility = View.VISIBLE
        else tv_title.visibility = View.GONE
        return this
    }

    fun setTitleTextMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置标题文本边距
        (tv_title.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    fun setTitleImageViewIsShow(isShow: Boolean): TopBar {//设置标题图片是否显示
        if (isShow)
            iv_title.visibility = View.VISIBLE
        else iv_title.visibility = View.GONE
        return this
    }

    fun setTitleImage(drawable: Drawable): TopBar {//设置标题图片
        iv_title.setImageDrawable(drawable)

        return this
    }

    fun setTitleImage(drawable: Int): TopBar {//设置标题图片

        iv_title.setImageResource(drawable)

        return this
    }

    fun setTitleImageScaleType(scaleType: ImageView.ScaleType): TopBar {//设置标题图片显示方式
        iv_title.scaleType = scaleType
        return this
    }

    fun setTitleImageHeight(height: Int): TopBar {//设置标题图片的高
        iv_title.layoutParams.height = height
        return this
    }

    fun setTitleImageWidth(width: Int): TopBar {//设置标题图片的宽
        iv_title.layoutParams.width = width
        return this
    }

    fun setTitleImageMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置标题图片边距
        (iv_title.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    //右侧区域
    fun setRightText(str: String): TopBar {//设置右侧文本
        tv_right.text = str
        return this
    }

    fun setRightTextSize(size: Float): TopBar {//设置右侧文本大小
        tv_right.textSize = size
        return this
    }


    fun setRightTxtColor(color: Int): TopBar {//设置右侧文本颜色
        tv_right.setTextColor(color)
        return this
    }

    fun setRightTextisBold(isBold: Boolean): TopBar {//设置右侧文本是否加粗
        tv_right.paint.isFakeBoldText = isBold
        return this
    }

    fun setRightTextIsShow(isShow: Boolean): TopBar {//设置右侧文本是否显示
        if (isShow)
            tv_right.visibility = View.VISIBLE
        else tv_right.visibility = View.GONE
        return this
    }

    fun setRightTextMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置右侧文本边距
        (tv_right.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

    fun setRightImageViewIsShow(isShow: Boolean): TopBar {//设置右侧图片是否显示
        if (isShow)
            iv_right.visibility = View.VISIBLE
        else iv_right.visibility = View.GONE
        return this
    }

    fun setRightImage(drawable: Drawable): TopBar {//设置右侧图片
        iv_right.setImageDrawable(drawable)

        return this
    }

    fun setRightImage(drawable: Int): TopBar {//设置右侧图片

        iv_right.setImageResource(drawable)

        return this
    }

    fun setRightImageScaleType(scaleType: ImageView.ScaleType): TopBar {//设置右侧图片显示方式
        iv_right.scaleType = scaleType
        return this
    }

    fun setRightImageHeight(height: Int): TopBar {//设置右侧图片的高
        iv_right.layoutParams.height = height
        return this
    }

    fun setRightImageWidth(width: Int): TopBar {//设置右侧图片的宽
        iv_right.layoutParams.width = width
        return this
    }

    fun setRightImageMargins(left: Int, top: Int, right: Int, bottom: Int): TopBar {//设置右侧图片边距
        (iv_right.layoutParams as RelativeLayout.LayoutParams).setMargins(left, top, right, bottom)
        return this
    }

}