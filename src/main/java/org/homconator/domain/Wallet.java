package org.homconator.domain;

import java.util.ArrayList;

/**
 * Created by khomco on 11/2/15.
 */
public interface Wallet {
    /**
     * Get all {@link Card Cards} within the current wallet
     *
     * @return collection of cards in wallet
     */
    ArrayList<Card> getCards();
}
