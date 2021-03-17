package com.elsevier.nameParserService;

import com.google.gson.Gson;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "NameParserServlet", value = {"/parseName","/parseNames" })
public class NameParserServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final NameParserService service = new NameParserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String PARSE_NAMES = "parseNames";
        Object result;

        String PARAMETER_NAME = "name";
        String name = request.getParameter(PARAMETER_NAME);
        if (name == null || name.isEmpty()) throw new ServletException("Empty or missing input!");

        if (request.getRequestURI().contains(PARSE_NAMES)) {
            // call to parseNames method
            result = service.parseNames(name);
        } else {
            // call to parseName method
            result = service.parseName(name);
        }

        // create Json output from result object
        String nameJson = this.gson.toJson(result);

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