package by.bsu.prj.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    private static final Logger log =  LogManager.getLogger(Controller.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number1 = request.getParameter("num1");
        String number2 = request.getParameter("num2");
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int result = num1 + num2;
        request.setAttribute("res", result);
        request.getRequestDispatcher("pages/main.jsp").forward(request, response);
        log.info("fsdjfjkd");
        log.error("hello world");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

