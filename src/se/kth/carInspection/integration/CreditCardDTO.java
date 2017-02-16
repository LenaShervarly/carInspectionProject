
package se.kth.carInspection.integration;

import java.util.Date;

public class CreditCardDTO {

    private String cardHolder;
    private String cardName;
    private Date experationDate;
    private int CCV;
    private int pin;

    public CreditCardDTO(String cardHolder, String cardName, Date experationDate, int CCV, int pin) {
        this.cardHolder = cardHolder;
        this.cardName = cardName;
        this.experationDate = experationDate;
        this.CCV = CCV;
        this.pin = pin;

    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardName() {
        return cardName;
    }

    public Date getDate() {
        return experationDate;
    }

    public int getCCV() {
        return CCV;
    }

    public int getPin() {
        return pin;
    }
}
