package org.homconator.domain;

import org.junit.Test;

public class WalletTest {

    @Test
    public void test() {
        Wallet wallet = new WalletImpl();
        wallet.addCard(new VisaCard());
        wallet.deleteHighInterestCard();
    }

}
