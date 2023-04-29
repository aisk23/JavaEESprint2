package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Users;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/pageOfLogin")
public class CheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users user = DBConnection.getUser(email);
        if (user != null){
            String userPassword = user.getPassword();
            if (userPassword.equals(password)){
                DBConnection.setLogin(true);
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else {
                DBConnection.setCorrect(false);
                response.sendRedirect("/home");
            }
        } else {
            DBConnection.setCorrect(false);
            response.sendRedirect("/home");
        }


    }
}