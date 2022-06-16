import com.QR.MsgApi.*;
import com.QR.QRDic.Plugin.PluginProcessing;
import java.util.*;
import java.lang.*;
import org.json.*;

    /*
public static String Message(){
    JSONArray Array = new JSONArray();
    int value = pluginMsg.value;
    int status = pluginMsg.status;
    long Uin = pluginMsg.uin;
    long Group = pluginMsg.groupid;
    String Skey = pluginMsg.skey;
    String GroupName = pluginMsg.groupName;
    String UinName = pluginMsg.uinName;
    String Pskey = pluginMsg.json.getString("pskey").toString().replace("\"", "\\\"");
    for(Object Object : pluginMsg.getData()){
        if(!Object.get("index").get(0).toString().equals("bub")){
            String str = "{\"type\": \""+Object.get("index").get(0).toString()+"\",\"Message\":\""+Object.get(Object.get("index").get(0).toString()).get(0).toString().replace("\"", "\\\"")+"\"}";
            JSONObject JSON = new JSONObject(str);
            Array.put(JSON);
        }
    }
    JSONObject JSONs = new JSONObject("{\"Uin\":\""+Uin+"\",\"Group\":\""+Group+"\",\"GroupName\":\""+GroupName+"\",\"UinName\":\""+UinName+"\",\"Skey\":\""+Skey+"\",\"Pskey\":\""+Pskey+"\",\"Status\":\""+status+"\",\"Value\":\""+value+"\",\"Msgbar\":\""+pluginMsg.msgbar+"\",\"Message\":"+Array+"}");
    //PluginProcessing.log(JSONs.toString()+"");
    return JSONs.toString();
    */
public static String Message(){
    JSONArray Array = new JSONArray();
    int value = pluginMsg.value;
    int status = pluginMsg.status;
    long Uin = pluginMsg.uin;
    long Group = pluginMsg.groupid;
    String Skey = pluginMsg.skey;
    String GroupName = pluginMsg.groupName;
    String UinName = pluginMsg.uinName;
    String Pskey = pluginMsg.json.getString("pskey").toString().replace("\"", "\\\"");
    String Title = pluginMsg.title;
   JSONArray Array = new JSONArray();   
     for(Object Object : pluginMsg.getData()){
        if(!Object.get("index").get(0).toString().equals("bub")){
            JSONObject JSON = new JSONObject();
            JSON.put("type",Object.get("index").get(0).toString());
            JSON.put("Message",Object.get(Object.get("index").get(0).toString()).get(0).toString().replace("\"", "\\\""));
            Array.put(JSON);     
        }          
    }
   JSONObject JSONObject = new JSONObject();
   JSONObject.put("Uin", Uin);
   JSONObject.put("Group", Group);
   JSONObject.put("GroupName", GroupName);
   JSONObject.put("UinName",UinName);
   JSONObject.put("Status",status);
   JSONObject.put("Value",value);
   JSONObject.put("Msgbar",pluginMsg.msgbar);
   JSONObject.put("Skey",Skey);
   JSONObject.put("Pskey",Pskey);
   JSONObject.put("Title", Title);
   JSONObject.put("Message",Array);
   return JSONObject.toString(3);
}

