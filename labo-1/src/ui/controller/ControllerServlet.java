package ui.controller;

import domain.db.DbException;
import domain.db.PersonDbInMemory;
import domain.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {

    private PersonDbInMemory db = new PersonDbInMemory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = handelRequest(request, response);
        request.getRequestDispatcher(location).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = handelRequest(request, response);
        request.getRequestDispatcher(location).forward(request, response);
    }

    private String handelRequest(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if(action == null) {
            return "index.jsp";
        }

        if(action.equals("overview")) {
            request.setAttribute("db", db);
            return "personoverview.jsp";
        }

        if(action.equals("signUp")) {
            return "signUp.jsp";
        }

        if(action.equals("submit")) {
            Person p = new Person();

            ArrayList<String> errors = new ArrayList<>();

            String userid = request.getParameter("userid");
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                p.setUserid(userid);
                request.setAttribute("userid", userid);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }

            try {
                p.setFirstName(firstname);
                request.setAttribute("firstName", firstname);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }

            try {
                p.setLastName(lastname);
                request.setAttribute("lastName", lastname);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }

            try {
                p.setEmail(email);
                request.setAttribute("email", email);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }

            try {
                p.setPassword(password);
                request.setAttribute("password", password);
            } catch (IllegalArgumentException e){
                errors.add(e.getMessage());
            }

            try {
                db.add(p);
            } catch (DbException e) {
                errors.add(e.getMessage());
            }

            if(errors.size() == 0) {
                request.setAttribute("db", db);
                return "personoverview.jsp";
            }

            else {
                request.setAttribute("errors", errors);
                return "signUp.jsp";
            }
        }

        return "index.jsp";
    }
}
