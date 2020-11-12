package com.zl.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/aaa")
public class HELS extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaa");
        String filename = req.getParameter("filename");//拿到 草莓.jpg
////        System.out.println(filename);
        String path = getServletContext().getRealPath("/WEB-INF/classes/com/zl/dowmload/"+filename);
//        System.out.println(path);//拿到草莓的真是路径
                FileInputStream is =new FileInputStream(path);//服务器读取图片
//        InputStream is = getServletContext().getResourceAsStream(filename);
//        String header = resp.getHeader("User-Agent");
//        filename = DownLoadUtils.getFileName(header, filename);
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        resp.setHeader("Content-Type", getServletContext().getMimeType(filename));

        ServletOutputStream os = resp.getOutputStream();//服务器响应写给浏览器

        int ch;
        byte[] b = new byte[1024];
        while ((ch=is.read(b))!=-1){
            os.write(b, 0, ch);
        }
        os.close();
        is.close();
//        IOUtils.copy(is, os);
//        IOUtils.closeQuietly(os);
//        IOUtils.closeQuietly(is);


    }
}
