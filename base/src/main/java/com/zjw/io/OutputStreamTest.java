package com.zjw.io;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * 输入输出是相对内存而言。
 * 输出：从内存往硬盘写东西。对内存来说是输出，对硬盘来说是写入（write）
 * 输入：从硬盘往内存写东西。对内存来说是输入，对硬盘来说是写入（read）
 *
 * @author Administrator
 */
public class OutputStreamTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输出文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        //判断父路径是否存在
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();//不存在就创建
        }
        //2、应该使用OutputStream和其子类进行对象的实例化，此时目录存在，文件还不存在
        //文件不存在会自动创建
        OutputStream output = Files.newOutputStream(file.toPath());//覆盖原来内容
//		OutputStream output = new FileOutputStream(file,true);//对原来内容追加

        //3、要进行文件内容的输出
        String str = "好好学习天天向上！";
        byte[] data = str.getBytes();
        output.write(data);//全部字节输出
//		output.write(data,0,3);//部分输出

        //4、资源使用完要关闭
        output.close();
    }
}
