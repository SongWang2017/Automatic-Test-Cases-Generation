package com.zen.test;

import com.zen.test.human.Human;

/**
 * @author zen
 * @since 20161214.
 */
public class TicketMachine {

    public final static float DISCOUNT = 0.9f;

    public final static float ORIGIN_PRICE = 100f;

    private int ticketNum;

    public TicketMachine(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Ticket sellTicket(Human human) {
        if (ticketNum == 0)
            throw new UnsupportedOperationException("sold out");
        if (human.getAge() < 18)
            throw new UnsupportedOperationException("must older than 18");
        Ticket t = new Ticket(queryTicketPrice(human));
        ticketNum--;
        return t;
    }

    public float queryTicketPrice(Human human) {
        float price = ORIGIN_PRICE;
        int age = human.getAge();
        switch (human.getSex()) {
            case FEMALE:
                if (age < 30 && age >= 18) {
                    price *= DISCOUNT;
                }
                break;
            case MALE:
                if (age > 35) {
                    price *= DISCOUNT;
                }
                break;
            default:
                break;
        }
        return price;
    }

    public int getTicketNum() {
        return ticketNum;
    }
}
