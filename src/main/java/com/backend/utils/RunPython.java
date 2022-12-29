package com.backend.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RunPython {
    //运行python文件
    public static int runSale(String envPath, String filePath, String args) {
        envPath = "D:\\anaconda3\\python.exe";//运行环境
        filePath = "E:/coding/JAVA/demo/machine_learning/sales/arima.py";//py文件地址
        //args为传递的参数，按照 日期（精确到日） 数量 表示
        Process proc;
        Random random = new Random();
        int res = random.nextInt(100) + 10;
        try {
            //TODO python.exe路径+要运行的py文件路径+参数
            proc = Runtime.getRuntime().exec(envPath + " " + filePath + " " + args);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            String lastLine = "0.0";
            String line = null;
            
            while ((line = in.readLine()) != null) {
                //System.out.println(line);//每一行即为python的控制台输出
                lastLine = line;
                //System.out.println(line);
                //System.out.println(lastLine);
            }
            res = (int) Double.parseDouble(lastLine);
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static void runSpeech() {
        Process proc;
        try {
            //TODO python.exe路径+要运行的py文件路径+参数
            proc = Runtime.getRuntime().exec("D:\\miniconda\\envs\\BUAA-python-Online-question-bank-platform\\python.exe C:\\Users\\83782\\Desktop\\android\\project\\ASRT\\predict_speech_file.py");// 执行py文件
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
