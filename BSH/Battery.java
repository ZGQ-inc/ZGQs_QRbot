
import java.io.*;
import java.lang.reflect.*;
import android.icu.text.*;
import android.icu.util.*;
import com.QR.MsgApi.*;
import com.QR.QRDic.Plugin.*;
import java.util.*;
import java.util.TimerTask;
import android.icu.util.Calendar;
import com.QR.QRDic.Plugin.PluginProcessing;
import com.QR.QRDic.Plugin.*;
import android.os.*;
import android.content.*;

	public static final String LimitName="Battery_Limit";


	public static String StartBatteryTask()
	{
		if (PluginProcessing.OsList.indexOf(LimitName) == -1)
		{
			PluginProcessing.OsList.add(LimitName);

			PluginProcessing.log("电池广播注册成功");
			
			try
			{
				interpreter.getClassManager().setClassPath(new URL[]{new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"/QR/QRDic/BSH/Battery.jar").toURL()});
			}
			catch (UtilEvalError e)
			{}
			
			IntentFilter mIntentFilter = new IntentFilter();
			mIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
			context.registerReceiver(new BatteryReceiver(), mIntentFilter);
			
		}
		return "";
	}
	
	public static String getLevel()
	{
		
		return PluginProcessing.OsMapObj.get("level")+"";
	}
	
	public static String getTemperature()
	{
		
		return ((float)PluginProcessing.OsMapObj.get("temperature")/10)+"";
	}
	
	
	
	
	public static String getnVoltage()
	{
		
		return PluginProcessing.OsMapObj.get("nVoltage")+"";
	}

private static int POWER_SUPPLY_CURRENT_NOW;
public int getCurrent() {
BatteryManager batteryManager=null;
batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (POWER_SUPPLY_CURRENT_NOW == 0) {
            POWER_SUPPLY_CURRENT_NOW = batteryManager.getIntProperty(2);
        }
        return (0 - POWER_SUPPLY_CURRENT_NOW) / 1000;
    }
    
    



