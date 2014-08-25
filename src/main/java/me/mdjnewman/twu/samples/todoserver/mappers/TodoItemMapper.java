package me.mdjnewman.twu.samples.todoserver.mappers;

import me.mdjnewman.twu.samples.todoserver.model.TodoItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TodoItemMapper {

    @Select(
            "SELECT description, dueDate " +
                    "FROM todo_items"
    )
    @Results(value = {
            @Result(property = "description", column = "description"),
            @Result(property = "dueDate", column = "dueDate")
    })
    List<TodoItem> findAll();


    @Insert(
            "INSERT INTO todo_items (description, dueDate) " +
                    "VALUES (#{description}, #{dueDate})"
    )
    void insert(TodoItem item);

}
