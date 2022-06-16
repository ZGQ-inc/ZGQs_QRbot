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
private List facea= pluginMsg.getMsg("face");
private List facenewb=pluginMsg.getMsg("facenew");
private List imgc=pluginMsg.getMsg("img");
private List fimge=pluginMsg.getMsg("fimg");
private List faceprod=pluginMsg.getMsg("facepro");

public String img1()
{
String img1 = pick(imgc,"img");
return img1;
}
public String face1()
{
String face1 = jx(facea,"face");
return face1;
}
public String facenew1()
{
String face2 = jx(facenewb,"facenew");
return face2;
}
public String facepro1()
{
String face3 = jx(faceprod,"facepro");
return face3;
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


