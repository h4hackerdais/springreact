package com.spring.react.springreact.services;

import com.spring.react.springreact.domain.Project;
import com.spring.react.springreact.exceptions.ProjectIdException;
import com.spring.react.springreact.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// we create this class we can add all logic of controller add here
// we dont need this service we can use direct all login in controller but
// that is not good practice we should use service for logic
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    INSERT DATA THIS METHOD
    public Project saveOrUpdateProject(Project project){
//        login add here
        try {
//         // set indentifier to update case save
            project.setProjectIdentifier(project.getProjectIdentifier().toLowerCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID"+project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }


    // search by project identifier with
    public Project findProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid);

        if (project == null){
            throw new ProjectIdException("Project "+projectid + " does not exist");
        }

        return project;

    }

    // get all list
    public Iterable<Project> findAllProject(){
        return projectRepository.findAll();
    }

    // remove by identifier project

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null){
            throw new ProjectIdException("Conn't Project with id "+ projectId + " This project does not exits ");
        }
    projectRepository.delete(project);
    }



}




