package com.cafecostes.cafe.DB;


import com.cafecostes.cafe.domain.OrderList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Custom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JsonBackReference
    private OrderList orderList;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String customName;
    private int customCount;

//    @OneToMany
//    @JoinColumn(name="custom", referencedColumnName="id")
    //private List<Schedule> scheduleList;
}
