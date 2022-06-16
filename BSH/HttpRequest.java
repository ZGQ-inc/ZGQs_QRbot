package HttpRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpRequest {
    public static String get(String url){
        return get(url,null,null);
    }
    public static String get(String url,String cookies){
        return get(url,cookies,null);
    }
    public static String get(String url,String cookies,HashMap<String,String> requestMap){
        if(url==null || url.equalsIgnoreCase(""))
            return "";
        BufferedReader reader=null;
        try{
            URL url1=new URL(url);
            URLConnection connection=url1.openConnection();
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if(cookies!=null)
                connection.setRequestProperty("Cookie",cookies);
            if(requestMap!=null){
                Iterator iterator=requestMap.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<String,String> entry=(Map.Entry<String, String>) iterator.next();
                    connection.setRequestProperty(entry.getKey(),entry.getValue());
                }
            }
            connection.connect();
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb=new StringBuffer();
            String temp=null;
            while((temp=reader.readLine())!=null){
                sb.append(temp);
            }
            return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static String post(String url){
        return post(url,null,null,null,null);
    }
    public static String post(String url,String param){
        return post(url,param,null,null,null);
    }
    public static String post(String url,String param,String cookies){
        return post(url,param,cookies,null,null);
    }
    public static String post(String url,String param,String cookies,HashMap<String,String> requestMap){
        return post(url,param,cookies,requestMap,null);
    }
    public static String post(String url,String param,String cookies,HashMap<String,String> requestMap,byte[] bytes){
        if(url==null || url.equals(""))
            return "";
        BufferedReader reader=null;
        try{
            URL url1=new URL(url);
            URLConnection connection=url1.openConnection();
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if(cookies!=null)
                connection.setRequestProperty("Cookie",cookies);
            if(requestMap!=null){
                Iterator iterator=requestMap.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<String,String> entry=(Map.Entry<String, String>) iterator.next();
                    connection.setRequestProperty(entry.getKey(),entry.getValue());
                }
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            PrintWriter out=new PrintWriter(connection.getOutputStream());

            if(param!=null){
                out.print(param);
                out.flush();
            }
            if(bytes!=null){
                DataOutputStream dataOut=new DataOutputStream(connection.getOutputStream());
                //每次发送1024字节，防止一次性发送给软件增加负载
                if(bytes.length>=1024){
                    int n=bytes.length/1024;
                    int r=bytes.length%1024;
                    if(r>0) n++;
                    for(int i=0;i<n;i++){
                        if(i==n-1){
                            dataOut.write(bytes,1024*i,r);
                        }else{
                            dataOut.write(bytes,1024*i,1024);
                        }
                    }
                }
                dataOut.flush();
            }
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb=new StringBuffer();
            String temp=null;
            while((temp=reader.readLine())!=null){
                sb.append(temp);
            }
            return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
