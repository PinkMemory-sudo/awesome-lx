//package hk;
//
//import cn.hutool.core.codec.Base64;
//import cn.hutool.core.io.FileUtil;
//import com.sun.jna.Native;
//import com.sun.jna.Pointer;
//import hk.Commom.osSelect;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.swing.*;
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.time.Instant;
//
//@Slf4j
//public class TestMain {
//
//    static HCNetSDK hCNetSDK = null;
//    static PlayCtrl playControl = null;
//
//    static FExceptionCallBack_Imp fExceptionCallBack;
//
//    //是否在预览.
//    static boolean bRealPlay;
//
//    //用户句柄
//    static int lUserID;
//
//    static HCNetSDK.NET_DVR_DEVICEINFO_V30 m_strDeviceInfo;//设备信息
//    static HCNetSDK.NET_DVR_IPPARACFG m_strIpparaCfg;//IP参数
//    static HCNetSDK.NET_DVR_CLIENTINFO m_strClientInfo;//用户参数
//
//    private static final String IP = "192.168.3.235";
//    private static final short PORT = 8000;
//    private static final String USER_NAME = "admin";
//    private static final String PWD = "Lan58825525";
//
//    private static int iSpeed = -1;
//
//    // 预览句柄
//    private static int lPreviewHandle = -1;
//
//    static int lAlarmHandle;//报警布防句柄
//    static int lListenHandle;//报警监听句柄
//
//    public static void main(String[] args) {
//        // 初始化SDK
//        initSDK();
//        // 用户注册
//        register();
//        // 开启预览
//        preview();
//
//        CapturePicture();
//        exit();
////        PTZControlAll(lPreviewHandle, HCNetSDK.PAN_LEFT, 0);
////        try {
////            TimeUnit.MILLISECONDS.sleep(100);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        PTZControlAll(lPreviewHandle, HCNetSDK.PAN_LEFT, 1);
////        // 注销用户
////        // 释放SDK资源
////
////        PTZControlAll(lPreviewHandle, HCNetSDK.ZOOM_OUT, 0);
////        try {
////            TimeUnit.MILLISECONDS.sleep(100);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        PTZControlAll(lPreviewHandle, HCNetSDK.PAN_LEFT, 1);
//
//
//    }
//
//    public static String CapturePicture(){
//        HCNetSDK.NET_DVR_JPEGPARA lpJpegPara = new HCNetSDK.NET_DVR_JPEGPARA();
//        lpJpegPara.wPicSize = (short)2;
//        lpJpegPara.wPicQuality = (short)2;
//        String datePath = System.getProperty("user.dir")+File.separator+"CapturePicture";
//        // 判断文件夹是否创建
//        File file = new File(datePath);
//        if (!file.exists()){
//            file.mkdirs();
//        }
//        // 文件名称
//        String imageName = Instant.now().getEpochSecond() +".jpg";
//        // 全路径
//        String path = datePath+File.separator+imageName;
//        System.out.println(path);
//        if (!hCNetSDK.NET_DVR_CaptureJPEGPicture(lUserID, getChannelNumber(), lpJpegPara, path.getBytes(StandardCharsets.UTF_8)))
//        {
//            System.out.println(hCNetSDK.NET_DVR_GetLastError());
//            return "{失败编码:"+hCNetSDK.NET_DVR_GetLastError()+"}";
//        }else {
//            String encode = Base64.encode(FileUtil.readBytes(path));
//            System.out.println(encode);
//            return encode;
//        }
//    }
//
//    private static void preview() {
//
//        //获取窗口句柄
////        W32API.HWND hwnd = new W32API.HWND(Native.getComponentPointer(panelRealplay));
//
//        //获取通道号
//        int iChannelNum = getChannelNumber();//通道号
//        if (iChannelNum == -1) {
//
////            JOptionPane.showMessageDialog(this, "请选择要预览的通道");
//            return;
//        }
//
//        HCNetSDK.NET_DVR_PREVIEWINFO strClientInfo = new HCNetSDK.NET_DVR_PREVIEWINFO();
//        strClientInfo.read();
////            strClientInfo.hPlayWnd = null;  //窗口句柄，从回调取流不显示一般设置为空
//        strClientInfo.lChannel = iChannelNum;  //通道号
//        strClientInfo.dwStreamType = 0; //0-主码流，1-子码流，2-三码流，3-虚拟码流，以此类推
//        strClientInfo.dwLinkMode = 0; //连接方式：0- TCP方式，1- UDP方式，2- 多播方式，3- RTP方式，4- RTP/RTSP，5- RTP/HTTP，6- HRUDP（可靠传输） ，7- RTSP/HTTPS，8- NPQ
//        strClientInfo.bBlocked = 1;
//
////        strClientInfo.hPlayWnd = hwnd;
//        strClientInfo.write();
//        lPreviewHandle = hCNetSDK.NET_DVR_RealPlay_V40(lUserID, strClientInfo, null, null);
//        if (lPreviewHandle <= -1) {
//            int error;
//            error = hCNetSDK.NET_DVR_GetLastError();
//            log.error("预览失败,错误码：{}", error);
//        }
//    }
//
//    private static int getChannelNumber() {
//        int iChannelNum = -1;
//        //获取选中的通道名,对通道名进行分析:
////        String sChannelName = ((DefaultMutableTreeNode) tp.getLastPathComponent()).toString();
////        if (sChannelName.charAt(0) == 'C')//Camara开头表示模拟通道
////        {
////            //子字符串中获取通道号
////            iChannelNum = Integer.parseInt(sChannelName.substring(6));
////        } else {
////            if (sChannelName.charAt(0) == 'I')//IPCamara开头表示IP通道
////            {
////                //子字符创中获取通道号,IP通道号要加32
////                //iChannelNum = Integer.parseInt(sChannelName.substring(8)) + m_strDeviceInfo.byStartDChan - 1;
////                iChannelNum = Integer.parseInt(sChannelName.split("_")[1]);
////            } else {
////                return -1;
////            }
////        }
//
//        return 1;
//    }
//
//    private static void exit() {
//        //如果在预览,先停止预览, 释放句柄
//        if (lPreviewHandle > -1) {
//            hCNetSDK.NET_DVR_StopRealPlay(lPreviewHandle);
//        }
//
//        //报警撤防
//        if (lAlarmHandle != -1) {
//            hCNetSDK.NET_DVR_CloseAlarmChan_V30(lAlarmHandle);
//        }
//        //停止监听
//        if (lListenHandle != -1) {
//            hCNetSDK.NET_DVR_StopListen_V30(lListenHandle);
//        }
//        //如果已经注册,注销
//        if (lUserID > -1) {
//            hCNetSDK.NET_DVR_Logout_V30(lUserID);
//        }
//        //cleanup SDK
//        hCNetSDK.NET_DVR_Cleanup();
//    }
//
//    private static void register() {
//        //注册之前先注销已注册的用户,预览情况下不可注销
//        if (bRealPlay) {
//            throw new RuntimeException("注册新用户请先停止当前预览!");
//        }
//
//        if (lUserID > -1) {
//            //先注销
//            hCNetSDK.NET_DVR_Logout_V30(lUserID);
//            lUserID = -1;
//        }
//        //注册
//
//        m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
//        lUserID = hCNetSDK.NET_DVR_Login_V30(IP,
//                PORT, USER_NAME, PWD, m_strDeviceInfo);
//
//        long userID = lUserID;
//        if (userID == -1) {
//            int error;
//            error = hCNetSDK.NET_DVR_GetLastError();
//            log.warn("注册失败,错误码：{}", error);
//        } else {
//            log.info("注册成功");
//        }
//    }
//
//    private static void initSDK() {
//        if (hCNetSDK == null && playControl == null) {
//            if (!CreateSDKInstance()) {
//                System.out.println("Load SDK fail");
//                return;
//            }
//            if (!CreatePlayInstance()) {
//                System.out.println("Load PlayCtrl fail");
//                return;
//            }
//            //linux系统建议调用以下接口加载组件库
//            if (osSelect.isLinux()) {
//                HCNetSDK.BYTE_ARRAY ptrByteArray1 = new HCNetSDK.BYTE_ARRAY(256);
//                HCNetSDK.BYTE_ARRAY ptrByteArray2 = new HCNetSDK.BYTE_ARRAY(256);
//                //这里是库的绝对路径，请根据实际情况修改，注意改路径必须有访问权限
//                String strPath1 = System.getProperty("user.dir") + "/lib/libcrypto.so.1.1";
//                String strPath2 = System.getProperty("user.dir") + "/lib/libssl.so.1.1";
//
//                System.arraycopy(strPath1.getBytes(), 0, ptrByteArray1.byValue, 0, strPath1.length());
//                ptrByteArray1.write();
//                hCNetSDK.NET_DVR_SetSDKInitCfg(3, ptrByteArray1.getPointer());
//
//                System.arraycopy(strPath2.getBytes(), 0, ptrByteArray2.byValue, 0, strPath2.length());
//                ptrByteArray2.write();
//                hCNetSDK.NET_DVR_SetSDKInitCfg(4, ptrByteArray2.getPointer());
//
//                String strPathCom = System.getProperty("user.dir") + "/lib/";
//                HCNetSDK.NET_DVR_LOCAL_SDK_PATH struComPath = new HCNetSDK.NET_DVR_LOCAL_SDK_PATH();
//                System.arraycopy(strPathCom.getBytes(), 0, struComPath.sPath, 0, strPathCom.length());
//                struComPath.write();
//                hCNetSDK.NET_DVR_SetSDKInitCfg(2, struComPath.getPointer());
//            }
//
//            boolean initSuc = hCNetSDK.NET_DVR_Init();
//            if (initSuc != true) {
//                JOptionPane.showMessageDialog(null, "初始化失败");
//            }
//            if (fExceptionCallBack == null) {
//                fExceptionCallBack = new FExceptionCallBack_Imp();
//            }
//            Pointer pUser = null;
//            if (!hCNetSDK.NET_DVR_SetExceptionCallBack_V30(0, 0, fExceptionCallBack, pUser)) {
//                return;
//            }
//            System.out.println("设置告警回调成功");
//            hCNetSDK.NET_DVR_SetLogToFile(3, "./sdklog", false);
//        }
//    }
//
//    static class FExceptionCallBack_Imp implements HCNetSDK.FExceptionCallBack {
//        public void invoke(int dwType, int lUserID, int lHandle, Pointer pUser) {
//            System.out.println("异常事件类型:" + dwType);
//            return;
//        }
//    }
//
//    /**
//     * 动态库加载
//     *
//     * @return
//     */
//    private static boolean CreateSDKInstance() {
//        if (hCNetSDK == null) {
//            synchronized (HCNetSDK.class) {
//                String strDllPath = "";
//                try {
//                    if (osSelect.isWindows())
//                        //win系统加载库路径
//                        strDllPath = System.getProperty("user.dir") + "\\lib\\HCNetSDK.dll";
//
//                    else if (osSelect.isLinux())
//                        //Linux系统加载库路径
//                        strDllPath = System.getProperty("user.dir") + "/lib/libhcnetsdk.so";
//                    hCNetSDK = (HCNetSDK) Native.loadLibrary(strDllPath, HCNetSDK.class);
//                } catch (Exception ex) {
//                    System.out.println("loadLibrary: " + strDllPath + " Error: " + ex.getMessage());
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 播放库加载
//     *
//     * @return
//     */
//    private static boolean CreatePlayInstance() {
//        if (playControl == null) {
//            synchronized (PlayCtrl.class) {
//                String strPlayPath = "";
//                try {
//                    if (osSelect.isWindows())
//                        //win系统加载库路径
//                        strPlayPath = System.getProperty("user.dir") + "\\lib\\PlayCtrl.dll";
//                    else if (osSelect.isLinux())
//                        //Linux系统加载库路径
//                        strPlayPath = System.getProperty("user.dir") + "/lib/libPlayCtrl.so";
//                    playControl = (PlayCtrl) Native.loadLibrary(strPlayPath, PlayCtrl.class);
//
//                } catch (Exception ex) {
//                    System.out.println("loadLibrary: " + strPlayPath + " Error: " + ex.getMessage());
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /*************************************************
//     函数名:    PTZControlAll
//     函数描述:	云台控制函数
//     输入参数:
//     lRealHandle: 预览句柄
//     iPTZCommand: PTZ控制命令
//     iStop: 开始或是停止操作
//     输出参数:
//     返回值:
//     *************************************************/
//    private static void PTZControlAll(int lRealHandle, int iPTZCommand, int iStop) {
//        if (lRealHandle >= 0) {
//            boolean ret;
//            //有速度的ptz
//            if (iSpeed >= 1) {
//                ret = hCNetSDK.NET_DVR_PTZControlWithSpeed(lRealHandle, iPTZCommand, iStop, iSpeed);
//                if (!ret) {
//                    log.warn("云台控制失败");
//                }
//            } else//速度为默认时
//            {
//                ret = hCNetSDK.NET_DVR_PTZControl(lRealHandle, iPTZCommand, iStop);
//                if (!ret) {
//                    log.warn("云台控制失败");
//                }
//            }
//        }
//    }
//}
