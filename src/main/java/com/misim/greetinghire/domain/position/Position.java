package com.misim.greetinghire.domain.position;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Position {

    @Id
    @GeneratedValue
    private long id;
    private String company;
    private String name;
    private String experience;
    private String type;
    private Date deadline;
    private String url;

    @Builder
    public Position(String company, String name, String experience, String type, Date deadline, String url) {
        this.company = company;
        this.name = name;
        this.experience = experience;
        this.type = type;
        this.deadline = deadline;
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