package com.synisys.service;

import com.synisys.dao.Dao;
import com.synisys.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by rima.khrkhryan on 4/12/2018.
 */
@WebServlet("/addUser")
/**
 * add new employee in tmp table whit "add" flag
 */
public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setAddress(request.getParameter("address"));
        employee.setJobTitle(request.getParameter("jobTitle"));
        employee.setId((int)(Math.random()*100));
        employee.setFlag("add");
        Dao dao = new Dao();
        try {
            dao.save(employee,"tmp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/portfolio.jsp");
    }
}
