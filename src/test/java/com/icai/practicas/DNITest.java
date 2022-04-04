package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DNITest {

    @Test
    public void testingDNI() {
        // DNI que no son válidos
        DNI dni = new DNI("00000000T");
        assertEquals(false, dni.validar());
        dni = new DNI("00000001R");
        assertEquals(false, dni.validar());
        dni = new DNI("99999999R");
        assertEquals(false, dni.validar());

        //no cumplen el formato
        dni = new DNI("12345");
        assertEquals(false, dni.validar());
        dni = new DNI("f1234a67Z");
        assertEquals(false, dni.validar());
        dni = new DNI("444444444");
        assertEquals(false, dni.validar());


        // DNI válidos
        dni = new DNI("81356846G");
        assertEquals(true, dni.validar());
        dni = new DNI("81356846G");
        assertEquals(true, dni.validar());
    }
}