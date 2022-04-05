package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TelefonoTest {
    @Test
    public void testingTelefono() {
        //TELEFONO VALIDO
        Telefono tel = new Telefono("662613163");
        assertEquals(true, tel.validar());

        //NO VALIDOS
        tel = new Telefono("6126111");
        assertEquals(false, tel.validar());
        tel = new Telefono("67261316366");
        assertEquals(false, tel.validar());
        tel = new Telefono("66G61g163");
        assertEquals(false, tel.validar());
    }
}