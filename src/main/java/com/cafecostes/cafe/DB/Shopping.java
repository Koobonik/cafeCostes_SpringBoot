package com.cafecostes.cafe.DB;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Shopping {
    @Id
    @GeneratedValue
    private int id;

//    @OneToOne(cascade={CascadeType.ALL})
//    @JoinColumn(foreignKey = @ForeignKey(name = "users_userNum"))
//    private Users users;
    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String userName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String list;
    private String num;
    private String sum_cost;

    @Column(columnDefinition = "TEXT")
    private String userRequestion;

    @Builder
    public Shopping(String userName, String list, String num, String sum_cost){
        this.userName = userName;
        this.list = list;
        this.num = num;
        this.sum_cost = sum_cost;
    }

    @Builder
    public Shopping(String userName, String list, String num, String sum_cost, String userRequestion){
        this.userName = userName;
        this.list = list;
        this.num = num;
        this.sum_cost = sum_cost;
        this.userRequestion = userRequestion;

    }
}
