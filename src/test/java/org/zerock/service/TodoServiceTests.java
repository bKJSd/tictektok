package org.zerock.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.today.domain.TodoVO;
import org.zerock.today.dto.TodoDTO;
import org.zerock.today.service.TodoService;

import java.time.LocalDate;
@Log4j
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister()throws Exception {
       TodoDTO todoDTO = TodoDTO.builder().title("DTO처음사용등록").dueDate(LocalDate.now()).build();
        log.info("===============================================");
log.info(todoDTO);

       todoService.register(todoDTO);
    }

    @Test
    public void testSelectOne()throws Exception{

        Long tno = 1L;
        TodoDTO todoDTO= todoService.get(tno);
        System.out.println(todoDTO);
    }


}
