package hu.petrik.bankprodzsekt;

public class HibasSzamlaszamException extends RuntimeException{
    public HibasSzamlaszamException(String szamlaszam) {
        super("Hibás számlaszám: " + szamlaszam);
    }
}
