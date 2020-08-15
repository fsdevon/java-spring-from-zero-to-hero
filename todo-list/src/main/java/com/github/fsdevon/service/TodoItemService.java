package com.github.fsdevon.service;

import com.github.fsdevon.model.TodoData;
import com.github.fsdevon.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
