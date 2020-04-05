package com.baidu.utils;


import com.baidu.entity.Lottery;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/4/4 16:35
 * @Version 1.0
 * @Introduce 读取Excel数据并批量插入数据库
 */
public class ReadExcelUtils {

    /**
     * 获取excel中的数据
     * @param filepath
     * @return
     * @throws Exception
     */
    public static List<Lottery> loadExcel(InputStream filepath) throws Exception{
        Workbook wb = WorkbookFactory.create(filepath);
        Sheet sheet = wb.getSheetAt(0);
        List<Lottery> datas = new ArrayList<>();//将数据添加到数据一行一行的添加到集合中，作为插入数据的入参
        Row row = null;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for(int y=0;y<=7;y++){
                row.getCell(y).setCellType(Cell.CELL_TYPE_STRING);
            }
            if(row == null || StringUtils.isEmpty(row.getCell(0).getStringCellValue())){
                continue;
            }
            Lottery data = new Lottery();

            data.setId(row.getCell(0) == null? "":row.getCell(0).getStringCellValue());
            data.setRedNumberOne(row.getCell(1) == null? "":row.getCell(1).getStringCellValue());
            data.setRedNumberTwo(row.getCell(2) == null? "":row.getCell(2).getStringCellValue());
            data.setRedNumberThree(row.getCell(3) == null? "":row.getCell(3).getStringCellValue());
            data.setRedNumberThour(row.getCell(4) == null? "":row.getCell(4).getStringCellValue());
            data.setRedNumberFive(row.getCell(5) == null? "":row.getCell(5).getStringCellValue());
            data.setRedNumberSix(row.getCell(6) == null? "":row.getCell(6).getStringCellValue());
            data.setBlueOne(row.getCell(7) == null? "":row.getCell(7).getStringCellValue());
            data.setCreateTime(new Date());
            datas.add(data);

        }
       /*for(Lottery lottery:datas){
            System.out.println("id=---------------"+lottery.getId());
        }*/
        return datas;
    }

}
