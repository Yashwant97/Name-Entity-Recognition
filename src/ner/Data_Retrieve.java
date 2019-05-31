/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import static ner.NER.NER;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Yashwant
 */
public class Data_Retrieve {
    public static void main(String[] args) throws FileNotFoundException{        
    try{
        //Creates List of files
        
            File folder = new File("Test-2");
            File[] listOfFiles = folder.listFiles();

         //create workbook   
            XSSFWorkbook wb=new XSSFWorkbook();
            XSSFSheet sheet=wb.createSheet();
            
            Cell cell=null;
            Row row=null;
            for (int i = 1; i <listOfFiles.length; i++) {
             
              BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(listOfFiles[i])));  
              String data="";
              data=buffer.readLine();
                //System.out.print(data);
              
            String[] list=NER(data);
            FileOutputStream out=new FileOutputStream(new File("test2 results.xlsx"));
                row=sheet.createRow(i);
                
                cell=row.createCell(0);
                cell.setCellValue(listOfFiles[i].getName());
                cell=row.createCell(1);
                cell.setCellValue(list[0]);
                cell=row.createCell(2);
                cell.setCellValue(list[1]);
                cell=row.createCell(3);
                cell.setCellValue(list[2]);
                System.out.println(i);
                wb.write(out);
            out.close(); 
            }    
            
        }
        catch(Exception e){
            e.getStackTrace();
        }
        
               
    }
}
