package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertTrue(10 == kortti.saldo());
    }

    @Test
    public void lataaminenKasvattaa() {
        kortti.lataaRahaa(5);
        assertTrue(15 == kortti.saldo());
    }

    @Test
    public void ottaminenToimii() {
        kortti.otaRahaa(5);
        assertTrue(5 == kortti.saldo());
    }

    @Test
    public void vaheneeOikeinJosTarpeeksi() {
        kortti.otaRahaa(5);
        assertTrue(5 == kortti.saldo());
    }

    @Test
    public void eiMuutuJosEiTarpeeksi() {
        kortti.otaRahaa(15);
        assertTrue(10 == kortti.saldo());
    }

    @Test
    public void trueJosRiittaaMuutenFalse() {
        Maksukortti korttiA = new Maksukortti(10);
        assertTrue(true == korttiA.otaRahaa(10));
        Maksukortti korttiB = new Maksukortti(10);
        assertTrue(false == korttiB.otaRahaa(11));
    }

}
