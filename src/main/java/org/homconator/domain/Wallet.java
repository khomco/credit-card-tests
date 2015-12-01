package org.homconator.domain;

import java.util.List;

public interface Wallet {
    
    List<Card> getCards();
    void addCard(Card card);
    void deleteHighInterestCard();
}
