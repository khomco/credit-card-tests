package org.homconator.domain;

import java.util.ArrayList;

/**
 * Created by khomco on 11/2/15.
 *
 * This class could be renamed.  It is simply intended to represent
 * the having of a collection of {@link Wallet Wallets} with the context
 * of it belonging to a Person more than likely.
 */
public interface Person {

    /**
     * Get all {@link Wallet Wallets}
     *
     * @return collection of wallets
     */
    ArrayList<Wallet> getWallets();
}
