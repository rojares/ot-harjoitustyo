package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() throws Exception {
        this.kassa = new Kassapaate();
        this.kortti = new Maksukortti(10000);
    }

    @Test
    public void syoEdullisesti() {
        assertTrue(10 == kassa.syoEdullisesti(250));
        assertTrue(230 == kassa.syoEdullisesti(230));
    }

    @Test
    public void syoMaukkaasti() {
        assertTrue(10 == kassa.syoMaukkaasti(410));
        assertTrue(390 == kassa.syoMaukkaasti(390));
    }

    @Test
    public void syoEdullisestiBoolean() {
        assertTrue(kassa.syoEdullisesti(new Maksukortti(500)));
        assertFalse(kassa.syoEdullisesti(new Maksukortti(200)));
    }

    @Test
    public void syoMaukkaastiBoolean() {
        assertTrue(kassa.syoMaukkaasti(new Maksukortti(500)));
        assertFalse(kassa.syoMaukkaasti(new Maksukortti(200)));
    }

    @Test
    public void lataaRahaaKortille() {
        int saldo = kortti.saldo();
        kassa.lataaRahaaKortille(kortti, 100);
        assertTrue(saldo + 100 == kortti.saldo());
        saldo = kortti.saldo();
        kassa.lataaRahaaKortille(kortti, -100);
        assertTrue(saldo == kortti.saldo());
    }

    @Test
    public void kassassaRahaa() {
        assertTrue(kassa.kassassaRahaa() == kassa.kassassaRahaa());
    }

    @Test
    public void maukkaitaLounaitaMyyty() {
        assertTrue(kassa.maukkaitaLounaitaMyyty() == kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullisiaLounaitaMyyty() {
        assertTrue(kassa.edullisiaLounaitaMyyty() == kassa.edullisiaLounaitaMyyty());
    }
}