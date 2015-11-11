package org.homconator.domain;

import java.math.BigDecimal;

/**
 * Created by khomco on 11/2/15.
 */
public interface Card {
    /**
     * Get balance on card
     *
     * @return current balance
     */
    BigDecimal getBalance();

    /**
     * Get interest rate for card
     *
     * @return current interest rate
     */
    BigDecimal getInterest();
}
