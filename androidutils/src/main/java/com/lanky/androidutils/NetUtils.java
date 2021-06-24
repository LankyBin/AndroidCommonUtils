package com.lanky.androidutils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName NetUtils
 * @Description TODO
 * @Author LankyBin
 * @Date 2021/6/24 14:09
 * @Version 1.0
 */
public class NetUtils {
    private static final String TAG = "lanky.net";

    public static class IfConfigInfo{
        private static final String defaultIP = "0.0.0.0";
        private static final String command = "ifconfig";
        public static String getWlan0Mask() {
            String Mask = defaultIP;
            try {
                Process process = Runtime.getRuntime().exec(new String[]{command});
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                do {
                    String line = bufferedReader.readLine();
                    if (line == null) {
//                        Log.d(TAG, "test: line is null");
                        break;
                    }
                    if (line.startsWith("wlan0     ")) {
                        Mask = defaultIP;
                    }
                    Mask = getLineMask(line).equals("") ?Mask:getLineMask(line);
                    if (line.startsWith("p2p0      ")) {
                        break;
                    }


                } while (true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Mask;
        }
        public static String getEth0Mask() {
            String Mask = defaultIP;
            try {
                Process process = Runtime.getRuntime().exec(new String[]{command});
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                do {
                    String line = bufferedReader.readLine();
                    if (line == null) {
//                        Log.d(TAG, "test: line is null");
                        break;
                    }
                    if (line.startsWith("eth0      ")) {
                        Mask = defaultIP;
                    }
                    Mask = getLineMask(line).equals("") ?Mask:getLineMask(line);
                    if (line.startsWith("lo        ")) {
                        break;
                    }
                } while (true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Mask;
        }

        private static String getLineMask(String line){
            String IP = "";
            if (line.trim().matches("inet addr:(\\d{1,3}\\.){3}\\d{1,3}( ){2}" +
                    "(Bcast:(\\d{1,3}\\.){3}\\d{1,3}( ){2}){0,1}" +
                    "Mask:(\\d{1,3}\\.){3}\\d{1,3}")) {
                String[] props = line.trim().split("( ){2}");
                for (String prop : props) {
                    if (prop.length() == 0) {
                        continue;
                    }

                    String[] kv = prop.split(":");
                    if (kv[0].startsWith("inet addr")) {
//                        Log.d(TAG, "----ipAddr: " + kv[1]);
                    } else if (kv[0].startsWith("Bcast")) {
//                        Log.d(TAG, "----Bcast: " + kv[1]);
                    } else if (kv[0].startsWith("Mask")) {
//                        Log.d(TAG, "----mask: " + kv[1]);
                        IP = kv[1];
                    }
                }
            }
            return IP;
        }
    }
}
