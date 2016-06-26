# receiveSMS
分别用广播(BroadcastReceiver)和内容提供者(ContentObserver)获取短信验证码

## 注意广播模式下短信权限关闭是获取不到短信的，而且也提供不了提示；
## 内容提供者则可以在短信权限关闭时捕捉到异常，提示用户自己打开权限，然后可以获取到短信
<div align="center">
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/0.png" width = "300" height = "500" alt="图片1" align=center />
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/1.png" width = "300" height = "500" alt="图片2" align=center />
</div>
<div align="center">
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/2.png" width = "300" height = "500" alt="图片3" align=center />
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/3.png" width = "300" height = "500" alt="图片4" align=center />
</div>
<div align="center">
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/4.png" width = "300" height = "500" alt="图片2" align=center />
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/5.png" width = "300" height = "500" alt="图片3" align=center />
</div>
<div align="center">
<img src="https://github.com/DyncKathline/receiveSMS/blob/master/screenshots/6.png" width = "300" height = "500" alt="图片4" align=center />
</div>
