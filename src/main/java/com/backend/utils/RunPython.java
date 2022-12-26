package com.backend.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunPython {
    //运行python文件
    public static void run() {
        Process proc;
        try {
            //TODO python.exe路径+要运行的py文件路径+参数
            proc = Runtime.getRuntime().exec("D:\\anaconda3\\python.exe C:/Users/ljh/Desktop/ARIMA-master/test.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);//每一行即为python的控制台输出
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
