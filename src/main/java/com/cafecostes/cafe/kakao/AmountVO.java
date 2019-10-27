package com.cafecostes.cafe.kakao;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AmountVO {

    private Integer total, tax_free, vat, point, discount;
}