package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 50)
    private String location;
    private Job job;


//    public Employer(String location) {
//        this.location = location;
//    }

    public Employer(){}

//    // one employer to many jobs
    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
//    @Override
//    public String toString() {
//        return location;
//    }

// ** Do we need to do the hash for this? I do not believe so since it is already in the AbstractEntity Class ** Double check
}