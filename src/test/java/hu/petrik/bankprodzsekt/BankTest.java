package hu.petrik.bankprodzsekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank = new Bank();

    @BeforeEach
    void setUp() {

    }

    @Test
    void ujSzamlaEgyenlegNulla() {
        bank.ujSzamla("Teszt Elek", "1234");
        assertEquals(0, bank.egyenleg("1234"));
    }

    @Test
    void ujSzamlaEgyenlegFeltoltesMegfeleloEgyenleg() {
        bank.ujSzamla("Teszt Elek", "1234");
        bank.egyenlegFeltolt("1234", 1000);
        assertEquals(1000, bank.egyenleg("1234"));
        bank.egyenlegFeltolt("1234", 2000);
        assertEquals(3000, bank.egyenleg("1234"));
    }

    @Test
    void tobbSzamlaFeltoltEgyenlegMegfeleloreKerul() {
        bank.ujSzamla("Teszt Elek", "1234");
        bank.ujSzamla("Gipsz Jakab", "5678");
        bank.egyenlegFeltolt("5678", 1000);
        bank.egyenlegFeltolt("1234", 5000);
        bank.egyenlegFeltolt("5678", 2000);
        assertEquals(5000, bank.egyenleg("1234"));
        assertEquals(3000, bank.egyenleg("5678"));
    }

    @Test
    void ujSzamlaMeglevoSzamlaszammal() {
        bank.ujSzamla("Teszt Elek", "1234");
        assertEquals(0, bank.egyenleg("1234"));
        assertThrows(IllegalArgumentException.class, () -> bank.ujSzamla("Gipsz Jakab", "1234"));
    }

    @Test
    void nemLetezoSzamlaEgyenlegKivetel() {
        assertThrows(HibasSzamlaszamException.class, () -> bank.egyenleg("1234"));
    }

    @Test
    void ujSzamlaUresNevvelKivetel() {
        assertThrows(IllegalArgumentException.class, () -> bank.ujSzamla("", "1234"));
    }

    @Test
    void ujSzamlaUresSzamlaszammalKivetel() {
        assertThrows(IllegalArgumentException.class, () -> bank.ujSzamla("Gipsz Jakab", ""));
    }

    @Test
    void egyenlegFeltoltNemLetezoSzamlaszammalKivetel() {
        assertThrows(IllegalArgumentException.class, () -> bank.egyenlegFeltolt("1234", 100));
    }

    @Test
    void egyenlegFeltoltNullaOsszegKivetel() {
        bank.ujSzamla("Teszt Elek", "1234");
        assertThrows(IllegalArgumentException.class, () -> bank.egyenlegFeltolt("1234", 0));
    }

    @Test
    void egyenlegFeltoltNegativOsszegKivetel() {
        bank.ujSzamla("Teszt Elek", "1234");
        assertThrows(IllegalArgumentException.class, () -> bank.egyenlegFeltolt("1234", -1));

    }



}