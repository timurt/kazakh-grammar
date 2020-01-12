package kz.tim.services;

import kz.tim.enums.Form;
import kz.tim.enums.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PossessiveServiceTest {
    @Test
    void test() {
        PossessiveService service = new PossessiveService(Form.FIRST, Quantity.PLURAL);
        assertEquals("қағазымыз", service.process("қағаз"));
    }
}
