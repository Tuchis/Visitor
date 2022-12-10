package org.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks;

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        for (Task<T> task: tasks) {
            task.freeze();
        }
    }

    @Override
    void stamp(Visitor<T> visitor) {

    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task: tasks) {
            Visitor visitor;

            task.apply(arg);
        }
    }
}
