package com.company.jmixpm.screen.project;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.screen.projecttaskbrowser.ProjectTaskBrowser;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
public class ProjectBrowse extends StandardLookup<Project> {
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private GroupTable<Project> projectsTable;
//    private Project project;

    @Subscribe("projectsTable.projectTasksAction")
    public void onProjectsTableProjectTasksAction(Action.ActionPerformedEvent event) {
        Project singleSelected = projectsTable.getSingleSelected();
        if (singleSelected == null) {
            return;
        }

        screenBuilders.screen(this)
                .withScreenClass(ProjectTaskBrowser.class)
                .build()
                .withProject(singleSelected)
                .show();
    }

    /*@Subscribe("projectsTable")
    public void onProjectsTableSelection(Table.SelectionEvent<Project> event) {
        Set<Project> selectedProjects = event.getSelected();
        if (selectedProjects.isEmpty()) {
            return;
        }

        project = selectedProjects.iterator().next();
    }*/
}