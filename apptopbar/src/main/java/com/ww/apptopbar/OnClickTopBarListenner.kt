package com.ww.apptopbar

import android.view.View

/**
 * Created by WangWei on 2018/2/1.
 */
 interface OnTopBarClickListenner {


         fun onClickLeft(view: View){}
           fun onClickRight(view: View){}
          fun onClickTitle(view: View){}

}