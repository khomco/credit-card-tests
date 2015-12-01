package org.homconator.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WalletImpl implements Wallet {
    
    private List<Card> cards = new ArrayList<>();

    @Override
    public List<Card> getCards() {
        return cards;
    }
    
    @Override
    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public void deleteHighInterestCard() {
        for(Card card: cards){
            if ((card.getInterest().compareTo(BigDecimal.valueOf(10.0)) < 1)){
                cards.remove(card);
            }
        }
    }
    
    

}
