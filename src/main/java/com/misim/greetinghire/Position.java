package com.misim.greetinghire;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
class Position {

    private @Id @GeneratedValue long id;
    private String company;
    private String name;
    private String experience;
    private String type;
    private Date deadline;
    private String url;

    Position() {}

    Position(String company, String name, String experience, String type, Date deadline, String url) {
        this.company = company;
        this.name = name;
        this.experience = experience;
        this.type = type;
        this.deadline = deadline;
        this.url = url;
    }

    public  Long getId() {
        return this.id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                ", type='" + type + '\'' +
                ", deadline=" + deadline +
                ", url='" + url + '\'' +
                '}';
    }
}
