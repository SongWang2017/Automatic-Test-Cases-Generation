package com.zen.test;

import com.zen.test.human.Human;
import com.zen.test.human.Sex;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.zen.test.TicketMachine.DISCOUNT;

/**
 * zen.oreo.test.TicketMachine Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 14, 2016</pre>
 */
public class TicketMachineTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sellTicket(Human zen.oreo.test.human)
     */
    @Test
    public void testSellTicket_to_male() throws Exception {
        Ticket t = buyTicketFromMachine(10, 18, Sex.MALE);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE, t.getPrice(), 0.0);
    }

    @Test
    public void testSellTicket_to_female() throws Exception {
        Ticket t = buyTicketFromMachine(10, 19, Sex.FEMALE);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE * DISCOUNT, t.getPrice(), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSellTicket_to_non_adult() throws Exception {
        Ticket t = buyTicketFromMachine(10, 17, Sex.FEMALE);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSellTicket_to_no_ticket() throws Exception {
        Ticket t = buyTicketFromMachine(0, 19, Sex.FEMALE);

    }

    @Test
    public void testSellTicket_to_male_with_discount() throws Exception {
        TicketMachine tm = new TicketMachine(2);
        Human man = new Person(45, Sex.MALE);

        Ticket t = tm.sellTicket(man);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE * DISCOUNT, t.getPrice(), 0.0);
        Assert.assertEquals(1, tm.getTicketNum());
    }

//    @Test
//    public void testSellTicket_to_adult_woman() throws Exception {
//        Ticket t = buyTicketFromMachine(10, 18, Sex.FEMALE);
//
//        Assert.assertEquals(TicketMachine.ORIGIN_PRICE * DISCOUNT, t.getPrice(), 0.0);
//    }

    private Ticket buyTicketFromMachine(int ticketNum,
                                        int age,
                                        Sex sex) {
        TicketMachine tm = new TicketMachine(ticketNum);
        Human woman = new Person(age, sex);
        return tm.sellTicket(woman);
    }
}
