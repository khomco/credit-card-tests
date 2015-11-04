package org.homconator.service;

import org.homconator.domain.Card;
import org.homconator.domain.Person;
import org.homconator.domain.Wallet;

import java.math.BigDecimal;

/**
 * Created by khomco on 11/2/15.
 */
public interface InterestCalculatorService {
    BigDecimal calculateInterest(Person person);

    BigDecimal calculateInterest(Card card);

    BigDecimal calculateInterest(Wallet wallet);
}
