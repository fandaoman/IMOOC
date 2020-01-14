package com.baidu.export.excel;

import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.utils.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/*
 * @Auther fandaoman
 * @date 2020/1/3 13:42
 * @Ver 1.0
 * */
@RestController
@RequestMapping("/export")
public class ExcleController {
    @Autowired
    private UserService userService;

    @RequestMapping("/excel")
    public String export(HttpServletResponse response, HttpServletRequest request)throws IOException {

        List<User> users = userService.FindAll();

        if(users.size()>0){
            // 创建excel
            HSSFWorkbook wk = new HSSFWorkbook();

            HSSFSheet sheet = wk.createSheet("用户信息");
            sheet.setDefaultColumnWidth(20);
            HSSFCellStyle headStyle = createCellStyle(wk, (short) 12);
            //列标题样式
            HSSFCellStyle colStyle = createCellStyle(wk, (short) 10);

            //设置列宽
            sheet.setColumnWidth(0,5000);

            //表头
            HSSFRow headRow = sheet.createRow(0);

            HSSFCell cell0 = headRow.createCell(0);
            cell0.setCellStyle(headStyle);
            cell0.setCellValue("序号");

            HSSFCell cell1 = headRow.createCell(1);
            cell1.setCellStyle(headStyle);
            cell1.setCellValue("昵称");

            HSSFCell cell2 = headRow.createCell(2);
            cell2.setCellStyle(headStyle);
            cell2.setCellValue("姓名");

            HSSFCell cell3 = headRow.createCell(3);
            cell3.setCellStyle(headStyle);
            cell3.setCellValue("邮箱");

            HSSFCell cell4 = headRow.createCell(4);
            cell4.setCellStyle(headStyle);
            cell4.setCellValue("注册时间");

            //表数据导入
            for(int i=0;i<users.size();i++){
                HSSFRow datarow = sheet.createRow(sheet.getLastRowNum() + 1);

                HSSFCell cell = datarow.createCell(0);
                cell.setCellStyle(colStyle);
                cell.setCellValue(i+1);

                HSSFCell cell00 = datarow.createCell(1);
                cell00.setCellStyle(colStyle);
                cell00.setCellValue(users.get(i).getUsername());

                HSSFCell cell01 = datarow.createCell(2);
                cell01.setCellStyle(colStyle);
                cell01.setCellValue(users.get(i).getRealname());

                HSSFCell cell02 = datarow.createCell(3);
                cell02.setCellStyle(colStyle);
                cell02.setCellValue(users.get(i).getEmail());

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

                HSSFCell cell03 = datarow.createCell(4);
                cell03.setCellStyle(colStyle);
                cell03.setCellValue(sdf.format(users.get(i).getCreateTime()));
            }

            //下载导出
            //设置头信息
            response.setContentType("application/vnd.ms-excel");
            String filename="用户基本信息.xlsx";
            //获取浏览器信息头
            String agent = request.getHeader("user-agent");
            filename = FileUtils.encodeDownloadFilename(filename, agent);
            response.setHeader("Content-Disposition","attachment;filename"+filename);
            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            wk.write(outputStream);
            //关闭流
            wk.close();
        }else{

        }



        return null;
    }


    /**
     * @param workbook
     * @param fontsize
     * @return 单元格样式
     */
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        // 创建字体
        HSSFFont font = workbook.createFont();
        if (fontsize == 12) {
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        }
        if (fontsize == 15) {
            font.setColor(HSSFColor.RED.index);// HSSFColor.VIOLET.index //字体颜色
        }
        font.setFontHeightInPoints(fontsize);
        style.setWrapText(true);// 设置自动换行
        // 加载字体
        style.setFont(font);
        return style;
    }
}
