package com.grading.gradingStudentSystem;

import javax.persistence.*;

@Entity

public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    private String firstName;

    private String lastName;

    private long metric1;

    private long metric2;

    private long metric3;

    private long metric4;

    private long metric5;


    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, long metric1, long metric2, long metric3, long metric4, long metric5) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.metric1 = metric1;
        this.metric2 = metric2;
        this.metric3 = metric3;
        this.metric4 = metric4;
        this.metric5 = metric5;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", metric1=" + metric1 +
                ", metric2=" + metric2 +
                ", metric3=" + metric3 +
                ", metric4=" + metric4 +
                ", metric5=" + metric5 +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMetric1() {
        return metric1;
    }

    public void setMetric1(long metric1) {
        this.metric1 = metric1;
    }

    public long getMetric2() {
        return metric2;
    }

    public void setMetric2(long metric2) {
        this.metric2 = metric2;
    }

    public long getMetric3() {
        return metric3;
    }

    public void setMetric3(long metric3) {
        this.metric3 = metric3;
    }

    public long getMetric4() {
        return metric4;
    }

    public void setMetric4(long metric4) {
        this.metric4 = metric4;
    }

    public long getMetric5() {
        return metric5;
    }

    public void setMetric5(long metric5) {
        this.metric5 = metric5;
    }
}
