package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DNITest {

    @Test
    public void testingDNI() {
        //FORMATO ERRONEO
        dni = new DNI("123456");
        assertEquals(false, dni.validar());
        dni = new DNI("f123467Z");
        assertEquals(false, dni.validar());
        dni = new DNI("555555555");
        assertEquals(false, dni.validar());

        // DNI NO VALIDO
        DNI dni = new DNI("00000001T");
        assertEquals(false, dni.validar());
        dni = new DNI("00000011R");
        assertEquals(false, dni.validar());
        dni = new DNI("99999999R");
        assertEquals(false, dni.validar());

        // DNI VALIDOS
        dni = new DNI("21700364W");
        assertEquals(true, dni.validar());
        dni = new DNI("37153196P");
        assertEquals(true, dni.validar());
    }
}