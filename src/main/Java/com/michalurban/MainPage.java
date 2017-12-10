package com.michalurban;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainPage", urlPatterns = "/main")
public class MainPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StringBuilder pageContent = new StringBuilder();

        pageContent.append(CommonHtml.getTopHtml("RPG Character Creator"));
        pageContent.append(getMainHtml());
        pageContent.append(CommonHtml.getBottomHtml());

        response.getWriter().write(pageContent.toString());
    }

    private String getMainHtml() {

        return  "<h3>Welcome to RPG Character Creator</h3>" +
                "<h4>On this site you can create a custom D&D character based on your preferences</h4>" +
                "<a href=\"/create\"><button>Creation Page</button></a>";
    }

}
