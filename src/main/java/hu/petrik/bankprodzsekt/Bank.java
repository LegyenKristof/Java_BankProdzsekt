package hu.petrik.bankprodzsekt;

import java.util.HashMap;

public class Bank {

    private HashMap<String, Szamla> szamlak;

    public Bank() {
        this.szamlak = new HashMap<>();
    }

    public void egyenlegFeltolt(String szamlaszam, long osszeg)
    {
        Szamla szamla = szamlak.get(szamlaszam);
        szamla.setEgyenleg(szamla.getEgyenleg() + osszeg);
    }

    public void ujSzamla(String nev, String szamlaszam)
    {
        Szamla szamla = new Szamla(nev, szamlaszam);
        szamlak.put(szamlaszam, szamla);
    }

    public boolean utal(String honnan, String hova, long osszeg)
    {
        throw new UnsupportedOperationException();
    }

    public long egyenleg(String szamlaszam)
    {
        Szamla szamla = szamlak.get(szamlaszam);
        return szamla.getEgyenleg();
    }

    private class Szamla {
        private String nev;
        private String szamlaszam;
        private long egyenleg;

        public Szamla(String nev, String szamlaszam) {
            this.nev = nev;
            this.szamlaszam = szamlaszam;
            this.egyenleg = 0;
        }

        public String getNev() {
            return nev;
        }

        public void setNev(String nev) {
            this.nev = nev;
        }

        public String getSzamlaszam() {
            return szamlaszam;
        }

        public void setSzamlaszam(String szamlaszam) {
            this.szamlaszam = szamlaszam;
        }

        public long getEgyenleg() {
            return egyenleg;
        }

        public void setEgyenleg(long egyenleg) {
            this.egyenleg = egyenleg;
        }
    }
}
