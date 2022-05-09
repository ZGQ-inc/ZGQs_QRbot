import android.app.*;
import android.content.*;
import android.os.*;
public static String getDevicePower()
{
    BatteryManager manager = (BatteryManager) interpreter.context.getSystemService(interpreter.context.BATTERY_SERVICE);
    int currentLevel = manager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
    return String.valueOf(currentLevel);
}
    /**
     * 获取可用内存和总内存
     *
     * @param context
     * @return
     */
public static String getAvailMeTotalMemoryInfo()
{
    // 获取活动管理器
    ActivityManager am = (ActivityManager)(interpreter.context.getSystemService(Context.ACTIVITY_SERVICE));
    ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
    // 参1 内存信息
    am.getMemoryInfo(outInfo);
    return getPrintSize(outInfo.availMem) + "可用 | 共" + getPrintSize(outInfo.totalMem); // 可用内存
}
public static String getPrintSize(long size)
{
    //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义  
    if(size < 1024)
    {
        return String.valueOf(size) + "B";
    }
    else
    {
        size = size / 1000;
    }
    //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位  
    //因为还没有到达要使用另一个单位的时候  
    //接下去以此类推  
    if(size < 1024)
    {
        return String.valueOf(size) + "KB";
    }
    else
    {
        size = size / 1024;
    }
    if(size < 1024)
    {
        //因为如果以MB为单位的话，要保留最后1位小数，  
        //因此，把此数乘以100之后再取余  
        size = size * 100;
        return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
    }
    else
    {
        //否则如果要以GB为单位的，先除于1024再作同样的处理  
        size = size * 100 / 1024;
        return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
    }
}

public static String getBootTimeStr()
{
    return formatDateTime((SystemClock.elapsedRealtimeNanos() / 1000000) / 1000);
    //return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtimeNanos() / 1000000);
}

public static String getPhone()
{
    String phone = Build.MODEL;
    return phone;
}

 /**
     * 获取指定字段信息
     * @return
*/
public static String getDeviceInfo(){
    StringBuffer sb =new StringBuffer();
    sb.append("硬件制造商："+Build.MANUFACTURER);
    sb.append("\n硬件名称："+Build.HARDWARE);
    sb.append("\nCPU指令集："+Build.CPU_ABI);
    //sb.append("\nSOC："+Build.BOARD);
    //sb.append("\n系统启动程序版本号："+ Build.BOOTLOADER);
    //sb.append("\n系统定制商："+Build.BRAND);
    //sb.append("\ncpu指令集2："+Build.CPU_ABI2);
    //sb.append("\n设置参数："+Build.DEVICE);
    //sb.append("\n显示屏参数："+Build.DISPLAY);
    //sb.append("\n无线电固件版本："+Build.getRadioVersion());
    //sb.append("\n硬件识别码："+Build.FINGERPRINT);
    //sb.append("\nHOST:"+Build.HOST);
    //sb.append("\n修订版本列表："+Build.ID);
    //sb.append("\n版本："+Build.MODEL);
    //sb.append("\n硬件序列号："+Build.SERIAL);
    //sb.append("\n硬件制造商："+Build.PRODUCT);
    //sb.append("\n描述Build的标签："+Build.TAGS);
    //sb.append("\nTIME:"+Build.TIME);
    //sb.append("\nbuilder类型："+Build.TYPE);
    //sb.append("\nUSER:"+Build.USER);
    return sb.toString();
}
    /**
     * 通过反射获取所有的字段信息
     * @return
     */
public String getDeviceInfo2(){
    StringBuilder sbBuilder = new StringBuilder();
    Field[] fields = Build.class.getDeclaredFields();
    for(Field field:fields){
        field.setAccessible(true);
        try {
        sbBuilder.append("\n"+field.getName()+":"+field.get(null).toString());
        } catch (IllegalArgumentException e) {
        e.printStackTrace();
        } catch (IllegalAccessException e) {
        e.printStackTrace();
        }
    }
    return sbBuilder.toString();
}

public static String formatDateTime(String mss)
{
    return formatDateTime(Long.parseLong(mss));
}

public static String formatDateTime(long mss)
{
    String DateTimes = null;
    long days = mss / (60 * 60 * 24);
    long hours = (mss % (60 * 60 * 24)) / (60 * 60);
    long minutes = (mss % (60 * 60)) / 60;
    long seconds = mss % 60;
    if(days > 0)
    {
        DateTimes = days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
    }
    else if(hours > 0)
    {
        DateTimes = hours + "小时" + minutes + "分钟" + seconds + "秒";
    }
    else if(minutes > 0)
    {
        DateTimes = minutes + "分钟" + seconds + "秒";
    }
    else
    {
        DateTimes = seconds + "秒";
    }
    return DateTimes;
}

