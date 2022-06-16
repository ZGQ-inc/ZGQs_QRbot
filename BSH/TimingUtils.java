
import android.icu.text.*;
import android.icu.util.*;
import com.QR.MsgApi.*;
import com.QR.QRDic.Plugin.*;
import java.util.*;
import java.util.TimerTask;
import android.icu.util.Calendar;
import com.QR.QRDic.Plugin.PluginProcessing;
	


	public static final String LimitName="Timing_Limit";

	public static final String InformShut="Timing_InformShut";


	public static String StartTimingTask()
	{
		if (PluginProcessing.OsList.indexOf(LimitName) == -1)
		{
			PluginProcessing.OsList.add(LimitName);

			PluginProcessing.log("报时开启成功");

			Runnable run=new Runnable(){

				public void run()
				{	

					boolean flag = false;


					while (true)
					{

						synchronized (new Object())
						{
							//关闭
							if (PluginProcessing.OsList.indexOf(InformShut) > -1)
							{
								PluginProcessing.log("报时关闭成功");
								return;
							}

							//每次都是重新定义 可以免去删去一直拼接的情况
							//使时间都拼接成字符串的形式
							StringBuffer sb = new StringBuffer();
							String str = null;
							//获取当前的时间
							Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
							int year = c.get(Calendar.YEAR);
							int month = c.get(Calendar.MONTH);
							int date = c.get(Calendar.DATE);
							int hour = c.get(Calendar.HOUR_OF_DAY);
							int minute = c.get(Calendar.MINUTE);//分
							int second = c.get(Calendar.SECOND);//秒
							//setTime.setForeground(Color.BLACK);

							SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String dateformatstr=(dateFormat.format(c.getTime()));


							//如果没有整点就不显示

							//分，秒都等于0 时就是整点
							if (minute == 0 && second == 0 && flag == false)
							{
								flag = true;//改变flag的状态
								str = sb.append(hour).append("时").toString();
								//显示时间 并报时
								//PluginProcessing.log("整点报时" + str + "到了");

								StringBuffer sb2=new StringBuffer();

								sb2.append("Test Dic Timing\n");

								sb2.append("整点报时\n");
								sb2.append(dateformatstr+"\n");

								sb2.append("禁止以一切形式泄露他人个人隐私");
								GroupSend(sb2.toString());
							}
							else
							{
								flag = false;//改变flag的状态
							}

							try
							{
								Thread.sleep(1000);
								//间隔一秒
							}
							catch (InterruptedException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}


			};

			new Thread(run).start();

		}
		return "";
	}
	public static String TimingOpen()
	{
		PluginProcessing.OsList.remove(LimitName);
		
		PluginProcessing.OsList.remove(InformShut);
		
		return "";
	}

	public static String TimingShut()
	{
		
		PluginProcessing.OsList.add(LimitName);
		
		PluginProcessing.OsList.add(InformShut);
		
		return "";
	}


	public static void GroupSend(String msg)
	{
		List list=getGroupList();

		for (String str:list)
		{
			long groupid=Long.parseLong(str);

			if (getGroupBool(groupid))
			{
				SendGroupMsg(groupid, msg);

			}
		}

	}
	public static void SendGroupMsg(long groupid, String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.type = PluginMsg.TYPE_GROUP_MSG;

		pluginMsg.groupid = groupid;

		pluginMsg.addMsg("msg", msg);

		PluginProcessing.send(pluginMsg);

	}

	public static List getGroupList()
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.type = PluginMsg.TYPE_GET_GROUP_LIST;

		PluginMsg pm=PluginProcessing.send(pluginMsg);

		List list= pm.getMsg("troop");

		return list;
	}

	public static boolean getGroupBool(long groupid)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.type = PluginMsg.TYPE_GET_GROUP_SELECT;

		pluginMsg.groupid = groupid;

		PluginMsg pm=PluginProcessing.send(pluginMsg);

		return pm.value == 1 ?true: false;
	}


	public static String getDatewu(long time)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateName = df.format(time);

		return dateName;
	}





