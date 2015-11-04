package org.homconator.service.impl;

import com.ctlts.it.qa.junit.rules.AssertCollector;
import org.homconator.domain.Card;
import org.homconator.domain.Person;
import org.homconator.domain.Wallet;
import org.homconator.service.InterestCalculatorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by khomco on 11/2/15.
 */
public class InterestCalculatorServiceImpl_UT {

    private InterestCalculatorService interestCalculatorService;
    private Card visa;
    private Card mastercard;
    private Card discover;

    @Rule
    public AssertCollector assertCollector = new AssertCollector();

    @Before
    public void setup() {
        interestCalculatorService = new SimpleInterestCalculatorServiceImpl();

        visa = mock(Card.class);
        when(visa.getInterest()).thenReturn(new BigDecimal(0.1));
        when(visa.getBalance()).thenReturn(new BigDecimal(100.00));

        mastercard = mock(Card.class);
        when(mastercard.getInterest()).thenReturn(new BigDecimal(0.05));
        when(mastercard.getBalance()).thenReturn(new BigDecimal(100.00));

        discover = mock(Card.class);
        when(discover.getInterest()).thenReturn(new BigDecimal(0.01));
        when(discover.getBalance()).thenReturn(new BigDecimal(100.00));
    }

    @Test
    public void verifyPersonWithOneWalletEachCard() {
        Person person1 = mock(Person.class);
        Wallet wallet1 = mock(Wallet.class);

        configureCards(wallet1, visa, mastercard, discover);
        configureWallets(person1, wallet1);

        BigDecimal interestForperson1 = interestCalculatorService.calculateInterest(person1);
        assertCollector.assertEquals(16D, interestForperson1.doubleValue());

        BigDecimal visaInterest = interestCalculatorService.calculateInterest(visa);
        assertCollector.assertEquals(10D, visaInterest.doubleValue());

        BigDecimal mastercardInterest = interestCalculatorService.calculateInterest(mastercard);
        assertCollector.assertEquals(5D, mastercardInterest.doubleValue());

        BigDecimal discoverInterest = interestCalculatorService.calculateInterest(discover);
        assertCollector.assertEquals(1D, discoverInterest.doubleValue());
    }

    @Test
    public void verifyPersonWith2WalletsAndEachWithDifferentCards() {
        Person person1 = mock(Person.class);
        Wallet wallet1 = mock(Wallet.class);
        Wallet wallet2 = mock(Wallet.class);

        configureCards(wallet1, visa, discover);
        configureCards(wallet2, mastercard);
        configureWallets(person1, wallet1, wallet2);

        BigDecimal interestForPerson = interestCalculatorService.calculateInterest(person1);
        assertCollector.assertEquals(16D, interestForPerson.doubleValue());

        BigDecimal walletOneInterest = interestCalculatorService.calculateInterest(wallet1);
        assertCollector.assertEquals(11D, walletOneInterest.doubleValue());

        BigDecimal walletTwoInterest = interestCalculatorService.calculateInterest(wallet2);
        assertCollector.assertEquals(5D, walletTwoInterest.doubleValue());
    }

    @Test
    public void verify2PeopleWith1WalletEachHavingSameCards() {
        Person person1 = mock(Person.class);
        Wallet wallet1 = mock(Wallet.class);

        Person person2 = mock(Person.class);
        Wallet wallet2 = mock(Wallet.class);

        configureCards(wallet1, visa, mastercard);
        configureCards(wallet2, visa, mastercard);
        configureWallets(person1, wallet1);
        configureWallets(person2, wallet2);

        BigDecimal interestForPersonOne = interestCalculatorService.calculateInterest(person1);
        assertCollector.assertEquals(15D, interestForPersonOne.doubleValue());

        BigDecimal interestForPersonTwo = interestCalculatorService.calculateInterest(person2);
        assertCollector.assertEquals(15D, interestForPersonTwo.doubleValue());

        BigDecimal walletOneInterest = interestCalculatorService.calculateInterest(wallet1);
        assertCollector.assertEquals(15D, walletOneInterest.doubleValue());

        BigDecimal walletTwoInterest = interestCalculatorService.calculateInterest(wallet2);
        assertCollector.assertEquals(15D, walletTwoInterest.doubleValue());
    }

    private void configureWallets(Person person, Wallet... wallets) {
        ArrayList walletList = new ArrayList(Arrays.asList(wallets));
        when(person.getWallets()).thenReturn((ArrayList<Wallet>) walletList);
    }

    private void configureCards(Wallet wallet, Card... cards) {
        ArrayList cardList = new ArrayList(Arrays.asList(cards));
        when(wallet.getCards()).thenReturn((ArrayList<Card>) cardList);
    }
}
