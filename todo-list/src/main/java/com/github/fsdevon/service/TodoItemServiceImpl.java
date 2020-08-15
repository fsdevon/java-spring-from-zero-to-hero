package com.github.fsdevon.service;

import com.github.fsdevon.model.TodoData;
import com.github.fsdevon.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}
