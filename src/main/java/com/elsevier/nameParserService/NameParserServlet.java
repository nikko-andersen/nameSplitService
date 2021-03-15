package com.elsevier.nameParserService;

import com.elsevier.nameParserService.model.Person;
import com.google.gson.Gson;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "NameParserServlet", value = "/parseName")
public class NameParserServlet extends HttpServlet {
    private Gson gson = new Gson();
    private final String PARAMETER_NAME = "name";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter(PARAMETER_NAME);
        if (name == null || name.isEmpty()) throw new ServletException("Empty or missing input!");

        // run the parser on the name
        Person person = new Person(name);

        // create Json output from Person object
        String nameJson = this.gson.toJson(person);

        // write Json result to the response
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(nameJson);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}