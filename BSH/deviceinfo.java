import java.net.InetAddress;
import java.util.Set;
import java.util.TreeSet;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

/**
 * 设备信息工具类
 * 
 * @author gjjiang
 * 
 */
public class DeviceUtils
{
   /** sigar对象，用于获得设备信息 **/
   private Sigar sigar = null;

   /**
    * 初始化方法
    */
   public DeviceUtils()
   {
      sigar = new Sigar();
   }

   /**
    * 关闭，释放sigar相关资源
    */
   public void close()
   {
      sigar.close();
   }

   /**
    * 获得CPU信息
    * 
    * @return
    * @throws SigarException
    */
   public CpuInfo[] getCpuInfo() throws SigarException
   {
      return sigar.getCpuInfoList();
   }

   /**
    * 获得内存信息
    * 
    * @return
    * @throws SigarException
    */
   public Mem getMem() throws SigarException
   {
      return sigar.getMem();
   }

   /**
    * 获得系统页面文件交换区信息
    * 
    * @return
    * @throws SigarException
    */
   public Swap getSwap() throws SigarException
   {
      return sigar.getSwap();
   }

   /**
    * 取到当前操作系统的名称
    * 
    * @return
    */
   public String getHostName()
   {
      String hostname = "";
      try
      {
         hostname = InetAddress.getLocalHost().getHostName();
      }
      catch (Exception exc)
      {
         try
         {
            hostname = sigar.getNetInfo().getHostName();
         }
         catch (SigarException e)
         {
            hostname = "unknown";
         }
      }
      return hostname;
   }

   /**
    * 获得操作系统信息
    * 
    * @return
    */
   public OperatingSystem getOSInfo()
   {
      return OperatingSystem.getInstance();
   }

   /**
    * 获取文件系统信息
    * 
    * @throws SigarException
    */
   public FileSystem[] getFileSystemInfo() throws SigarException
   {
      return sigar.getFileSystemList();
      // FileSystem fs = fslist[i];
      // // 分区的盘符名称
      // print("fs.getDevName() = " + fs.getDevName());
      // // 分区的盘符名称
      // print("fs.getDirName() = " + fs.getDirName());
      // print("fs.getFlags() = " + fs.getFlags());//
      // // 文件系统类型，比如 FAT32、NTFS
      // print("fs.getSysTypeName() = " + fs.getSysTypeName());
      // // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
      // print("fs.getTypeName() = " + fs.getTypeName());
      // // 文件系统类型
      // print("fs.getType() = " + fs.getType());
      // FileSystemUsage usage = null;
      // try {
      // usage = sigar.getFileSystemUsage(fs.getDirName());
      // } catch (SigarException e) {
      // if (fs.getType() == 2)
      // throw e;
      // continue;
      // }
      // switch (fs.getType()) {
      // case 0: // TYPE_UNKNOWN ：未知
      // break;
      // case 1: // TYPE_NONE
      // break;
      // case 2: // TYPE_LOCAL_DISK : 本地硬盘
      // // 文件系统总大小
      // print(" Total = " + usage.getTotal() + "KB");
      // // 文件系统剩余大小
      // print(" Free = " + usage.getFree() + "KB");
      // // 文件系统可用大小
      // print(" Avail = " + usage.getAvail() + "KB");
      // // 文件系统已经使用量
      // print(" Used = " + usage.getUsed() + "KB");
      // double usePercent = usage.getUsePercent() * 100D;
      // // 文件系统资源的利用率
      // print(" Usage = " + usePercent + "%");
      // break;
      // case 3:// TYPE_NETWORK ：网络
      // break;
      // case 4:// TYPE_RAM_DISK ：闪存
      // break;
      // case 5:// TYPE_CDROM ：光驱
      // break;
      // case 6:// TYPE_SWAP ：页面交换
      // break;
      // }
   }

   public FileSystemUsage getFileSystemUsage(String dirName)
         throws SigarException
   {
      return sigar.getFileSystemUsage(dirName);
   }

   /**
    * 获得网卡Mac地址
    * 
    * @return
    * @throws SigarException
    */
   public Set<String> getMacs() throws SigarException
   {
      TreeSet<String> treeSet = new TreeSet<String>();
      String[] list = sigar.getNetInterfaceList();
      for (String string : list)
      {
         String mac = sigar.getNetInterfaceConfig(string).getHwaddr();
         if (mac != null)
         {
            treeSet.add(mac);
         }
      }
      return treeSet;
   }
}