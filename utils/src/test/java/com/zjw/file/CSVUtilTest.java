package com.zjw.file;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;

/**
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
        String fileName = "Product.csv";
        int startLine = 1;
        int endLine = 10000;
        boolean existFlag = false;
        while (!existFlag){
            List<String> stringList = CSVUtil.readCSV(fileName, "UTF-8", startLine, endLine);
            if (stringList.size() !=0){
                for (String str : stringList) {
                    if (str.contains("179352SH")){
                        System.out.println(str);
                        existFlag = true;
                        break;
                    }
                }
                startLine = endLine + 1 ;
                endLine += 10000;
            } else {
                break;
            }
        }
        System.out.println(existFlag);
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
