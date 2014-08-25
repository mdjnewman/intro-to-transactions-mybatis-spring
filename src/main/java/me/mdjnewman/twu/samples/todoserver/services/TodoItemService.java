package me.mdjnewman.twu.samples.todoserver.services;

import me.mdjnewman.twu.samples.todoserver.mappers.TodoItemMapper;
import me.mdjnewman.twu.samples.todoserver.model.TodoItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TodoItemService {

    @Resource
    private TodoItemMapper todoItemMapper;

    public List<TodoItem> findAll() {
        return todoItemMapper.findAll();
    }

    public void insert(TodoItem todoItem) {
        todoItemMapper.insert(todoItem);
    }
}
