package org.homconator.domain;

import java.math.BigDecimal;

public class VisaCard implements Card{
    
    private BigDecimal balance = BigDecimal.ZERO;
    private BigDecimal interest = BigDecimal.valueOf(13.5);
    
    @Override
    public BigDecimal getBalance(){
        return balance;
    }

    @Override
    public BigDecimal getInterest(){
        return interest;
    }

}
