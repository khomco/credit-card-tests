package org.homconator.domain;

import java.math.BigDecimal;

/**
 * Created by khomco on 11/2/15.
 */
public interface Card {
    BigDecimal getBalance();
    BigDecimal getInterest();
}
