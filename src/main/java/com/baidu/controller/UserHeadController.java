package com.baidu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.common.Result;
import com.baidu.entity.User;
import com.baidu.entity.UserHead;
import com.baidu.service.UserHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/*
 * @Auther fandaoman
 * @date 2019/11/15 17:15
 * @Ver 1.0
 * */
@Controller
@RequestMapping("/userhead")
public class UserHeadController {
    @Autowired
    private UserHeadService userHeadService;

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    @ResponseBody
    public Result  add(HttpServletResponse response,HttpServletRequest request,
                      MultipartFile fileName, String jsondata)throws Exception{
        Result result = new Result();
        if(fileName.isEmpty()){
            return result.failure(false,"头像不能为空");
        }else{
            String s1=jsondata.replace("[","");
            String data=s1.replace("]","");
            JSONObject jsonObject = JSONObject.parseObject(data);
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            UserHead userHead = new UserHead();
            //根据相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/back/images/photos");
            //获取文件名
            String realname = fileName.getOriginalFilename();
            //从session取到当前登录用户的id
            HttpSession session = request.getSession();
            User user1 =  (User) session.getAttribute("user");
            userHead.setUserId(user1.getId());
            //将得到的真实名称赋值给数据库中的路径信息
            userHead.setPath("images/photos/"+realname);
            //记录此图片的id
            userHead.setHead_sculpture_id(realname+sdf.format(new Date()));
            //调用业务层方法保存图片
            userHeadService.add(userHead);
            //上传文件
            fileName.transferTo(new File(realPath,fileName.getOriginalFilename()));
            //查询此人头像
            UserHead userhead = userHeadService.findOne(user1.getId());
            //将此人正在使用的头像存储到session中
            session.setAttribute("userHead",userhead);
            return result.success(true);
        }
    }

    //头像的上传
    public Result inPoto(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        UserHead userHead = new UserHead();
        //从session取到当前登录用户的id
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userHead.setUserId(user.getId());

        //图片的上传
        /*
        * 1:上传图片需要制定服务器上保存的地址，photos文件夹保存照片
        * 2：存储照片的路径方便回显数据
        * */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //存储路径
        String savePath=request.getServletContext().getRealPath("/photos");

        //通过表单file空间的名字直接获取Part对象
        Part part = request.getPart("uploadFile");
        //获取请求头，请求头格式为 form-data;name="file";filename="snmp4j--api.zip"
        String header = part.getHeader("content-disposition");
        ///获取文件名
        String fileName = getFileName(header);
        //把文件写到指定路径
        part.write(savePath+File.separator+fileName);
        //把这个照片的路径保存到数据库
        userHead.setPath(fileName);

        userHeadService.add(userHead);
        return null;
    }

    /**
     * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";
     * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
     * filename="E:\snmp4j--api.zip"
     *
     * @param header
     *            请求头
     * @return 文件名
     */
    public String getFileName(String header){
        String[] tempArr1 = header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");

        return fileName;

    }



}
