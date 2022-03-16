package hu.petrik.bankprodzsekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void ujSzamlaEgyenlegNulla() {
        Bank bank = new Bank();
        bank.ujSzamla("Teszt Elek", "1234");
        long egyenleg = bank.egyenleg("1234");
        assertEquals(0, egyenleg);
    }

    @Test
    void ujSzamlaEgyenlegFeltoltesMegfeleloEgyenleg() {
        Bank bank = new Bank();
        bank.ujSzamla("Teszt Elek", "1234");
        bank.egyenlegFeltolt("1234", 1000);
        long egyenleg = bank.egyenleg("1234");
        assertEquals(1000, egyenleg);
    }
}