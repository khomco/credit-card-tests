package org.homconator.service;

import org.homconator.domain.Card;
import org.homconator.domain.Person;
import org.homconator.domain.Wallet;

import java.math.BigDecimal;

/**
 * Created by khomco on 11/2/15.
 *
 */
public interface InterestCalculatorService {
    /**
     * Calculate interest for all {@link Wallet Wallets}
     * for a {@link Person}
     *
     * @param person
     * @return interest for the given person
     */
    BigDecimal calculateInterest(Person person);

    /**
     * Calculate interest for a {@link Card}
     *
     * @param card
     * @return interest for the given card
     */
    BigDecimal calculateInterest(Card card);

    /**
     * Calculate interest for all {@link Card Cards}
     * for a {@link Wallet}
     *
     * @param wallet
     * @return interest for the given wallet
     */
    BigDecimal calculateInterest(Wallet wallet);
}
