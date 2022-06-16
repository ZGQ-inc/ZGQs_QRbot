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

public String troop() {
PluginMsg qwq =new PluginMsg();
qwq.type=5;
List troop=PluginProcessing.send(qwq).getMsg("troop");
int clong =troop.size();
JSONArray json= new JSONArray();
for(int i=0; i<clong; i++)
{
String k=troop.get(i).toString();
json.put(k);
}return json.toString();
}