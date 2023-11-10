package org.zerock.today.controller;

import lombok.extern.log4j.Log4j;
import org.zerock.today.dto.TodoDTO;
import org.zerock.today.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", value = "/todo/list")
@Log4j
public class TodoListController extends HttpServlet {
private TodoService todoService =TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

try {


         List<TodoDTO> dtoList = todoService.listAll();

         req.setAttribute("dtoList", dtoList);
         req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
}catch (Exception e) {
    log.error(e.getMessage());
    throw new ServletException("list error");
}




    }


}
