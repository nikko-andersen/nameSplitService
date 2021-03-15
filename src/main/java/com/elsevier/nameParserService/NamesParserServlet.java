package com.elsevier.nameParserService;

import com.elsevier.nameParserService.model.Group;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NamesParserServlet", value = "/parseNames")
public class NamesParserServlet extends HttpServlet {
    private Gson gson = new Gson();
    private final String PARAMETER_NAME = "names";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String names = request.getParameter(PARAMETER_NAME);
        if (names == null || names.isEmpty()) throw new ServletException("Empty or missing input!");

        // run the parser on the name
        Group group = new Group(names);

        // create Json output from Person object
        String nameJson = this.gson.toJson(group);

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
