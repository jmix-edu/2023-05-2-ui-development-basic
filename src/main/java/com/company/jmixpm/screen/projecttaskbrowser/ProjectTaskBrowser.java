package com.company.jmixpm.screen.projecttaskbrowser;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@UiController("ProjectTaskBrowser")
@UiDescriptor("project-task-browser.xml")
public class ProjectTaskBrowser extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public ProjectTaskBrowser withProject(@Nullable Project project) {
        if (project == null) {
            tasksDl.removeParameter("projectId");
        } else {
            tasksDl.setParameter("projectId", project.getId());
        }
        tasksDl.load();

        return this;
    }
}