import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstDynamicResourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //1.通过query String,取到wd这个name对应的value
        String wd = req.getParameter("wd");

     //2.返回COntent_Type 是 text/html:字符集编码是：utf-8
        resp.setContentType("text/html:charest=utf-8");
        PrintWriter writer = resp.getWriter();

        //3.输出的现象应内容
        writer.println("<h1>我是 /s 资源</h1>");
        writer.println("<p>用户要查找的关键字是：" + wd + "</p>");
    }
}
