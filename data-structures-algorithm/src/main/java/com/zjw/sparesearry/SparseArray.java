package com.zjw.sparesearry;

import java.io.*;
import java.util.Arrays;

/**
 * 稀疏数组:
 *      当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 * @author zjw
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.创建一个二维数组
        int[][] arr = new int[11][11];
        arr[1][2] = 1 ;
        arr[2][3] = 2 ;
        System.out.println("原始二维数组：");
        printArray(arr);

        //2.转为稀疏数组
        System.out.println("转换为的稀疏数组为：");
        int[][] sparseArr = castToSparseArray(arr);
        printArray(sparseArr);

        //3.将稀疏数组转为二维数组
        int[][] normalArr = castToNormalArray(sparseArr);
        System.out.println("转换后的二维数组为：");
        printArray(normalArr);

    }

    /**
     * 将普通数组转为稀疏数组
     * @param arr 普通数组
     * @return 稀疏数组
     */
    public static int[][] castToSparseArray(int[][] arr){
        // 原数组的总行数
        int row = arr.length;
        //原数组的总列数
        int column = arr[0].length;
        //记录普通数组中数据的个数
        int sum = 0;
        for (int[] rows : arr){
            for (int data : rows){
                if (data!=0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //为稀疏数组第一行赋值
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;
        //在稀疏数组中标记原数组数组的位置及对应的值
        int sparseRow = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0){
                    sparseArr[sparseRow][0]=i;
                    sparseArr[sparseRow][1]=j;
                    sparseArr[sparseRow][2]=arr[i][j];
                    sparseRow++;
                }
            }
        }
        return sparseArr;
    }

    /**
     * 稀疏数组转为普通数组
     * @param sparseArray 稀疏数组
     * @return 普通数组
     */
    public static int[][] castToNormalArray(int[][] sparseArray){
        int[][] arr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1 ; i<sparseArray.length ; i++){
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return arr;
    }

    public static void saveArray(int[][] arr,File file) throws IOException {
        String path = SparseArray.class.getResource("").getPath().substring(1);
        File saveFile = new File(path+"/"+file.getName());
        if (!saveFile.exists()){
            if(!saveFile.createNewFile()){
                throw new RuntimeException("创建文件："+saveFile+"失败；");
            }
        }
        //写数据
        FileWriter fw = new FileWriter(saveFile);
        for (int[] ints : arr) {
            String line = Arrays.toString(ints);
            line = line.replace(" ","");
            line = line.substring(1, line.length() - 1);
            fw.write(line + "\r\n");
        }
        fw.close();
    }


    public static int[][] readArray(File file) throws IOException {
        String path = SparseArray.class.getResource("").getPath().substring(1);
        File readFile = new File(path+"/"+file.getName());
        if (!readFile.exists()){
           throw new RuntimeException("读取文件："+readFile+"失败，文件不存在");
        }
        //读取数据
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        //读取头信息
        String line = br.readLine();
        String[] strings = line.split(",");
        int lens = Integer.parseInt(strings[2]);
        int[][] retArray = new int[lens+1][3];
        retArray[0][0] = Integer.parseInt(strings[0]);
        retArray[0][1] = Integer.parseInt(strings[1]);
        retArray[0][2] = Integer.parseInt(strings[2]);
        //读取头以外的信息
        for(int count=1;count<=lens;count++){
            line = br.readLine();
            strings = line.split(",");
            retArray[count][0] = Integer.parseInt(strings[0]);
            retArray[count][1] = Integer.parseInt(strings[1]);
            retArray[count][2] = Integer.parseInt(strings[2]);
        }
        br.close();
        return retArray;
    }

    /**
     * 打印二维数组
     * @param array 二维数组
     */
    public static void printArray(int[][] array){
        for (int[] rows : array){
            for (int data : rows){
                System.out.printf("%2d ",data);
            }
            System.out.println();
        }
    }
}
