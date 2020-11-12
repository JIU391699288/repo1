package com.zl.web;

import com.zl.web.download.DownLoadUtils;
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

@WebServlet("/meinv")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("laile");
        String filename = req.getParameter("Filename");
        System.out.println(filename);//拿到图片名称
        //通过全局管理者直接拿到图片全局路径输入流然后读取到图片
        InputStream is = getServletContext().getResourceAsStream("/WEB-INF/classes/com/zl/web/download/"+filename);
//        String path = getServletContext().getRealPath("/WEB-INF/classes/com/zl/web/download/"+filename);
//        System.out.println(path);//拿到真实路径
//        FileInputStream is = new FileInputStream(path); //服务器读取文件
        String header = req.getHeader("User-Agent"); //响应给浏览器前指定响应字符集,先通过浏览器请求头拿到浏览器类型
        filename = DownLoadUtils.getFileName(header, filename);
//        System.out.println(filename);
        resp.setHeader("Content-Disposition", "attachment;Filename="+filename); //设置响应头附件形式下载
        resp.setHeader("Content-Type", getServletContext().getMimeType(filename)); //指定类型为mime

        ServletOutputStream os = resp.getOutputStream();//服务器响应给浏览器
//        int ch;
//        byte[] b = new byte[1024];
//        while ((ch=is.read(b))!=-1){
//            os.write(b, 0, ch);
//        }
//        os.close();
//        is.close();
        IOUtils.copy(is, os); //优化IO流输入输出代码
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(is);
    }
}
