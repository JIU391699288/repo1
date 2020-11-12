package com.zl.web;

        import cn.dsna.util.images.ValidateCode;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet("/Demo02")
public class Servletdemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("..success..");
        ValidateCode v = new ValidateCode(100,50,4,10);
        String code = v.getCode();
        System.out.println(code);
        request.getSession().setAttribute("code",code);
        v.write(response.getOutputStream());
    }
}
