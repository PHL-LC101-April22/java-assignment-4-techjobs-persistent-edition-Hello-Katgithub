package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 500)
    private String description;


    @ManyToMany(mappedBy="skills")
    private List<Job> jobs = new ArrayList<>();

    //Entity needs an empty constructor remember that
    public Skill() {}

//    public Skill(String description, List<Job> job) {
//        this.description = description;
////        this.jobs = jobs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
