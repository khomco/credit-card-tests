package org.homconator.service.impl;

import org.homconator.domain.Card;
import org.homconator.domain.Person;
import org.homconator.domain.Wallet;
import org.homconator.service.InterestCalculatorService;

import java.math.BigDecimal;

/**
 * Created by khomco on 11/2/15.
 */
public class SimpleInterestCalculatorServiceImpl implements InterestCalculatorService {

    public SimpleInterestCalculatorServiceImpl() {}

    public BigDecimal calculateInterest(Person person) {
        BigDecimal totalInterest = BigDecimal.ZERO;

        for (Wallet wallet : person.getWallets()) {
            totalInterest = totalInterest.add(calculateInterest(wallet));
        }

        return totalInterest;
    }

    public BigDecimal calculateInterest(Card card) {
        return card.getBalance().multiply(card.getInterest());
    }

    public BigDecimal calculateInterest(Wallet wallet) {
        BigDecimal totalInterest = BigDecimal.ZERO;

        for (Card card : wallet.getCards()) {
            totalInterest = totalInterest.add(calculateInterest(card));
        }

        return totalInterest;
    }
}
