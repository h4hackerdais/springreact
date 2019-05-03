package com.spring.react.springreact.services;

import com.spring.react.springreact.domain.Project;
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

    public Project saveOrUpdateProject(Project project){
//        login add here
        return projectRepository.save(project);
    }
}