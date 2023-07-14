package com.zjw.file;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试CSV文件处理工具类
 * @author zjw
 * @date 2023/03/21 16:27
 */
public class CSVUtilTest {

    /**
     * 测试从大CSV文件中查找内容
     */
    @SneakyThrows
    @Test
    public void testReadCSV(){
        String fileName = "D:\\系统文件夹\\桌面\\Bond_Product_20230322.csv";

        String newFilename = "D:\\系统文件夹\\桌面\\Bond_Product_20230324_zjw.csv";
        Map<String,Integer> bondMap = new HashMap();
        int count = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFilename)); // 创建一个 BufferedWriter 以写入新文件

        String[] bondName = {"360026SH","175762SH","511360SH","511260SH","511523SH","511880SH","178377SH","151498SH","032100362IB","171293SH","109022SH","101822SH","109937SH","101424SH","101421SH","109476SH","166913SH","167313SH","177716SH","178027SH","177467SH","178611SH","114495SH","177917SH","185054SH","177379SH","155799SH","102101807IB","101900476IB","150572SH","178773SH","102001331IB","114292SZ","114504SH"};
        int startLine = 1;
        int endLine = 10000;

        String headLine = CSVUtil.readCSV(fileName, 1).get(0);
        writer.write(headLine); // 写入当前行数据
        writer.newLine(); // 换行

        for (String s : bondName) {
            bondMap.put(s,0);
        }
        boolean existFlag = false;
        while (!existFlag){
            List<String> stringList = CSVUtil.readCSV(fileName, "UTF-8", startLine, endLine);
            if (stringList.size() !=0){
                for (String str : stringList) {
                    for (String name : bondName) {
                        if (str.contains(name)){
                            writer.write(str); // 写入当前行数据
                            writer.newLine(); // 换行
                            bondMap.put(name,bondMap.get(name)+1);
                            count++;
                        }
                    }
                }
                startLine = endLine + 1 ;
                endLine += 10000;
            } else {
                break;
            }
        }
        writer.close();
        System.out.println(count);
        for (String s : bondMap.keySet()) {
            if (bondMap.get(s)==0){
                System.out.println(s+ "--" +bondMap.get(s));
            }
        }
    }

    /**
     * 测试将大文件拆分为小文件
     */
    @SneakyThrows
    @Test
    public void testSplitCSV(){
        String fileName = "Product.csv";
        CSVUtil.splitCSV(fileName,10000);
    }
}
