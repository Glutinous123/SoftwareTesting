package com.WebdriverTest;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class csvreader {
	boolean isSucess=false;
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
    public static void main(String args[]){
	   	 List<String> dataList=csvreader.importCsv(new File("D:\\SoftwareTesting\\inputgit.csv"));
	   	String data;
	   	for(int i=1;i<dataList.size()-1;i++){
	   		data = dataList.get(i);
	   		int urlLocation = data.lastIndexOf(",");
            if(data.charAt(14) == ','){
            	System.out.println(data.substring(urlLocation+1,data.length()));
            }
            else{
            	System.out.println(data.substring(urlLocation+1,data.length()));
            }
	   	}
   }
}