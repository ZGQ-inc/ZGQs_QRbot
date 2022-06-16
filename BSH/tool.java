import java.io.*;
import java.util.*;
import org.json.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.graphics.*;
import android.os.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.math.*;
import java.net.*;
import com.dou.*;
import com.QR.MsgApi.*;
import com.QR.QRDic.Plugin.*;
//import com.QR.tool.*;
//import com.QR.tool.Utils.*;


public static String onLand(String text)
{
	PluginProcessing.log(text);
	return "";
}
private List face1= pluginMsg.getMsg("face");
private List facenew2=pluginMsg.getMsg("facenew");
private List img4=pluginMsg.getMsg("img");
private List fimg=pluginMsg.getMsg("fimg");
private List facepro3=pluginMsg.getMsg("facepro");
private List say=pluginMsg.getMsg("msg");
private List json=pluginMsg.getMsg("json");

public String img()
{
String img1 = pick(img4,"img");
return img1;
}
public String face()
{
String face1 = jx(face1,"face");
return face1;
}
public String facenew()
{
String face2 = jx(facenew2,"facenew");
return face2;
}
public String facepro()
{
String face3 = jx(facepro3,"facepro");
return face3;
}
public String msg()
{
String say = jx(say,"msg");
return say;
}
public String fimg()
{
String fimg1 =jx(fimg,"fimg");
return fimg1;
}
public String json()
{
String jons=jx(json,"json");
return jons;
}

public String jx(List msg ,String type) {
int clong =msg.size();
if(clong==0)
{
return "";
}else{
JSONArray json= new JSONArray();
for(int i=0; i<clong; i++){
String k=pluginMsg.getMsg(type).get(i).toString();
json.put(k);
}return json.toString();
}
}

public String pick(List msg ,String type) {
int clong =msg.size();
if(clong==0)
{
return "";
}else{
JSONArray json=new JSONArray();
for(int i=0; i<clong; i++){
String k=pluginMsg.getMsg(type).get(i).toString();
json.put(k.replaceAll("/.*-|[^\\dA-Z]",""));
}return json.toString();
}
}

public String bub(List msg)
{
int clong =msg.size()-1;
if(clong==0)
{
return null;
}
else
{
String k ="";
for(int i=0; i<clong; i++){
k+=msg.get(i).toString();
k+="\n";
}
return k;
}
}


