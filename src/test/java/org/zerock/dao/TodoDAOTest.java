package org.zerock.dao;

import com.sun.jna.platform.linux.LibC;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.zerock.today.dao.TodoDAO;
import org.zerock.today.domain.TodoVO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TodoDAOTest {

    TodoDAO todoDAO = new TodoDAO();
    @Test
    public void testTime() throws Exception{

        System.out.println(todoDAO.getTime() +"찍히고있니???" );

    }


    @Test
public void insert () throws Exception{

        TodoVO todoVO = TodoVO.builder()
                .title("타이틀이다").dueDate(LocalDate.of(2023,11,10))
                .build();

todoDAO.insert(todoVO);
    }

@Test
    public void testlist()throws Exception{

        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(i -> System.out.println(i));
}
@Test
public void testSelectOne()throws Exception{

    Long tno = 1L;
        TodoVO vo = todoDAO.selectOne(tno);
    System.out.println(vo);
}

@Test
public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(1L)
                .title("수정 타이틀")
                .dueDate(LocalDate.of(2023,11,10))
                .finished(true)
                .build();
        todoDAO.updateOne(vo);
}





}
