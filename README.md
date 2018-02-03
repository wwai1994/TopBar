# TopBar
How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.wwai1994:TopBar:1.0.0'
	}
How to use in code：

  topBar_Main.setTitleText("标题")//设置标题文本</br>
               .setTitleTextColor(颜色)//设置标题文本颜色
               .setTitleTextSize(1f)//设置标题文本大小
               .setTitleTextisBold(true)//设置标题文本是否加粗（默认加粗，左侧和右侧文本默认不加粗）
               .setTitleTextMargins(0,0,0,0)//设置标题文本控件间距
               .setTitleTextIsShow(true)//设置标题文本是否显示（默认显示，左侧和右侧的文本也默认显示）
               .setTitleImage(图片)//设置标题图片
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
            // 左侧和右侧的文本和图片设置和标题相似，还可以get各个控件对象，一边进行各种扩展操作
