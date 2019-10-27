package com.cafecostes.cafe.DB;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
public class WithDrawReason {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int num;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reason;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String gender;

    @Column(columnDefinition = "TEXT", nullable = false)
    private int age;



    @Builder
    public WithDrawReason(String reason, String gender, int age){
        this.reason = reason;
        this.gender = gender;
        this.age = age;
    }
}
