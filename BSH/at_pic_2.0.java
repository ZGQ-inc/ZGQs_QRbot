//艾特作图2.0.java
//作者尹志平
//感叹号大概是接口暂时坏掉，等站长修复就好了

import java.util.*;
import java.lang.*;
import java.text.*;
public static final Map tumap = new HashMap();
static {//看起来高端一点
//收录接口也很辛苦的好吗
List 爬了=Arrays.asList(new String[]{"http://ovooa.com/API/pa/api.php?QQ=","https://yysk.yitzu.cn.qingf.top/api/xb/api/pa.php?qq="});
String 爬=爬了.get(new Random().nextInt(爬了.size()));
List 想了=Arrays.asList(new String[]{"http://ovooa.com/API/face_thsee/?QQ=","http://yysk.yitzu.cn.qingf.top/api/xb/api/xiang_2.php?qq="});
String 想=想了.get(new Random().nextInt(想了.size()));//两个接口不一样哦
tumap.put("看这个","https://api.xingzhige.com/API/Lookatthis/?qq=");
tumap.put("抱","https://api.xingzhige.com/API/baororo/?qq=");
tumap.put("咬","https://api.xingzhige.com/API/bite/?qq=");
tumap.put("吞","https://bg.suol.cc/API/chi/?uin=");
tumap.put("拍","https://api.xingzhige.com/API/paigua/?qq=");
tumap.put("抓","https://api.xingzhige.com/API/grab/?qq=");
tumap.put("顶","https://api.xingzhige.com/API/dingqiu/?qq=");
tumap.put("一起笑","https://api.xingzhige.com/API/LaughTogether/?qq=");
tumap.put("搂","https://api.xingzhige.com/API/FortuneCat/?qq=");
tumap.put("摇","https://api.xingzhige.com/API/DanceChickenLeg/?qq=");
tumap.put("捣","https://api.xingzhige.com/API/pound/?qq=");
tumap.put("撕","http://ovooa.com/API/si/?QQ=");
tumap.put("加框","http://ovooa.com/API/head/?QQ=");
tumap.put("赞","http://ovooa.com/API/zan/api.php?QQ=");
tumap.put("丢","http://ovooa.com/API/diu/api.php?QQ=");
tumap.put("爬",爬);
tumap.put("遗照","http://lkaa.top/API/yi/?QQ=");
tumap.put("牵","http://api.tangdouz.com/wz/qian.php?q="+MyUin+"&qq=");
tumap.put("需要","http://yysk.yitzu.cn.qingf.top/api/xb/api/need.php?qq=");
tumap.put("鄙视","http://xiaobai.klizi.cn/API/ce/bishi.php?qq=");
tumap.put("比心","http://xiaobai.klizi.cn/API/ce/xin.php?qq=");
tumap.put("跟我处对象","http://api.klizi.cn/API/ce/xie.php?qq=");
tumap.put("圈钱跑路","http://xiaobai.klizi.cn/API/ce/pao.php?qq=");
tumap.put("膜拜","http://ovooa.com/API/face_worship/?QQ=");
tumap.put("摸","http://ovooa.com/API/face_petpet/?QQ=");
tumap.put("想",想);
tumap.put("吃掉","http://ovooa.com/API/face_bite/?QQ=");
tumap.put("抱着哭","https://yysk.yitzu.cn.qingf.top/api/xb/api/ku.php?qq=");
tumap.put("精神支柱","https://yysk.yitzu.cn.qingf.top/api/xb/api/jingshenzhizhu.php?qq=");
tumap.put("看完干活","http://xiaobapi.top/api/xb/api/back_to_work.php?qq=");
tumap.put("舔","https://yysk.yitzu.cn.qingf.top/api/xb/api/tian.php?qq=");
tumap.put("遮脸","https://yysk.yitzu.cn.qingf.top/api/xb/api/cover_face.php?qq=");
tumap.put("疑问","https://yysk.yitzu.cn.qingf.top/api/xb/api/wenhao.php?qq=");
tumap.put("上电视","https://yysk.yitzu.cn.qingf.top/api/xb/api/kandianshi.php?qq=");
tumap.put("这像画吗","https://yysk.yitzu.cn.qingf.top/api/xb/api/hua.php?qq=");
tumap.put("推","http://yysk.yitzu.cn.qingf.top/api/xb/api/roll.php?qq=");
tumap.put("垃圾","https://api.klizi.cn/API/gif/garbage.php?qq=");
tumap.put("为什么艾特我","https://yysk.yitzu.cn.qingf.top/api/xb/api/whyatme.php?qq=");
tumap.put("墙纸","https://yysk.yitzu.cn.qingf.top/api/xb/api/wallpaper.php?qq=");
tumap.put("黑化","http://yysk.yitzu.cn.qingf.top/api/xb/api/h.php?qq=");
tumap.put("快逃","http://xiaobai.klizi.cn/API/gif/escape.php?qq=");


}









//类似的使用接口的一言之类都可以使用这种写法
Set keys=tumap.keySet();
public String kk(String a,Set list){//如果以key开始则返回key值
String result="";
for(String b:list){
if(a.startsWith(b)){
result=b;
break;}
}
return result;
}
public static boolean iss(String str){//判断是否数字
for (int i = str.length();--i>=0;){
 if (!Character.isDigit(str.charAt(i))){
return false;
}
}
return true;
}

AddItem("开启/关闭限制","开关",PluginID);

public void 开关(String qun,String qqq,int type)
{
	if("1".equals(getString(qun,"脚本"))||"1".equals(getString(qqq,"脚本")))
	{
	putString(qun, "脚本", null);putString(qqq,"脚本",null);
      Toast("限制已开启,本聊天仅自己可用");
	}
	else{
	putString(qun,"脚本","1");putString(qqq,"脚本","1");
	Toast("限制已关闭,本聊天他人也可使用");
	}
}




public void onMsg(Object msg)
{
String text=msg.MessageContent;
String qq=msg.UserUin;
String qun=msg.GroupUin;
public void sendpic(p){
if(msg.IsGroup){sendPic(qun,"",p);}
else{sendPic("",msg.msg.frienduin,p);}}
public void fc(String s,String q){//匹配key值,获取相应接口
new Thread(new Runnable(){//新线程防止延迟过长
public void run()
{sendpic(tumap.get(s)+q);
}}).start();
}

if(msg.IsSend||"1".equals(getString(qun,"脚本"))||"1".equals(getString(GetFriendUin(),"脚本"))){//限制
if(!"".equals(kk(text,keys))){
String s=kk(text,keys);//指令key值
String uin=text.replace(s,"");//非key值部分
if(uin.equals("我")){
try{//使用快捷方式
fc(s,qq);}catch(e){return;}
}
if(iss(uin)){
try{//输入了qq号
fc(s,uin);}catch(e){return;}
}
if(msg.IsGroup)
{//群聊且艾特
if(msg.mAtList.size()>=1){
try{String q=msg.mAtList.get(0);
fc(s,q);}catch(e){return;}
}}
if(!msg.IsGroup){
try{//私聊
String q=MyUin;
if(iss(uin))return;
if(uin.equals("我")){q=qq;}
if(uin.equals("你")){if(qq.equals(MyUin))q=msg.msg.frienduin;else q=MyUin; }
fc(s,q);}catch(e){return;}
}}//如果不是萌新说我还不知道有msg.msg.frienduin这个东西
if(text.equals("功能")){
sendMsg(qun,GetFriendUin(),"功能列表：\n⭐"+keys.toString().replace(",","+@ ⭐").replaceAll("[\\[\\]]","")+"+@\n\n快捷方式\n+我 例：摸我 \n+qq 例：摸10001\n"+"\n👆私聊把@换成你或我👆");}}}
Toast("发送 功能 查看功能\n三杠可控制是否他人可用");