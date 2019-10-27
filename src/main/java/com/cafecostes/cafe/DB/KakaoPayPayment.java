package com.cafecostes.cafe.DB;


import com.cafecostes.cafe.kakao.AmountVO;
import com.cafecostes.cafe.kakao.CardVO;
import com.cafecostes.cafe.kakao.KakaoPayApprovalVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class KakaoPayPayment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int num;
    // CardVO, AmountVO로 그냥 바로 받아오면 어떻게 되려나?
    //Column(columnDefinition = "TEXT", nullable = false)
    private String aid; // Request 고유 번호
    private String tid; // 결제 고유 번호
    private String cid; // 가맹점 코드
    private String partner_order_id; // 가맹점 주문번호
    private String partner_user_id; // 가맹점 회원 id
    private String payment_method_type; // 결제 수단. CARD, MONEY 중 하나
    private String item_name; // 상품 이름. 최대 100자
    private int quantity; // 상품 수령
    private Date created_at; // 결제 준비 요청 시각
    private Date approved_at; // 결제 승인 시각
    private int money; // 결제 금액 정보

    @Column(columnDefinition = "TEXT", nullable = true)
    private String sid; // subscription id. 정기(배치)결제 CID로 결제요청한 경우 발급
    // private CardVO cardVO; // 결제 상세 정보(결제수단이 카드일 경우만 포함)
    private String item_code; // 상품코드 최대 100자
    private String payload; // Request로 전달한 값

    @Builder
    public KakaoPayPayment(String aid, String tid, String cid, String partner_order_id, String partner_user_id,
                           String payment_method_type, String item_name, int quantity, Date created_at, Date approved_at, AmountVO amountVO){
        this.aid = aid;
        this.tid = tid;
        this.cid = cid;
        this.partner_order_id = partner_order_id;
        this.partner_user_id = partner_user_id;
        this.payment_method_type = payment_method_type;
        this.item_name = item_name;
        this.quantity = quantity;
        this.created_at = created_at;
        this.approved_at = approved_at;
        this.money = amountVO.getTotal();
    }

    @Builder
    public KakaoPayPayment(KakaoPayApprovalVO kakaoPayApprovalVO){
        this.aid = kakaoPayApprovalVO.getAid();
        this.tid = kakaoPayApprovalVO.getTid();
        this.cid = kakaoPayApprovalVO.getCid();
        this.partner_order_id = kakaoPayApprovalVO.getPartner_order_id();
        this.partner_user_id = kakaoPayApprovalVO.getPartner_user_id();
        this.payment_method_type = kakaoPayApprovalVO.getPayment_method_type();
        this.item_name = kakaoPayApprovalVO.getItem_name();
        this.quantity = kakaoPayApprovalVO.getQuantity();
        this.created_at = kakaoPayApprovalVO.getCreated_at();
        this.approved_at = kakaoPayApprovalVO.getApproved_at();
        this.money = kakaoPayApprovalVO.getAmount().getTotal();
    }


}
