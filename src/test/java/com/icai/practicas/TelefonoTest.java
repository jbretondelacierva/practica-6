package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TelefonoTest {
    @Test
    public void testingTelefono() {
        //Validable
        Telefono tel = new Telefono("662613163");
        assertEquals(true, tel.validar());

        //False
        tel = new Telefono("6626131");
        assertEquals(false, tel.validar());
        //Un teléfono con 10 dígitos dice que debería ser true, cuando debería ser false
        tel = new Telefono("66261316366");
        assertEquals(false, tel.validar());
        tel = new Telefono("66261g163");
        assertEquals(false, tel.validar());
    }
}