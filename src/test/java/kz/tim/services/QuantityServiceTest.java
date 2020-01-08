package kz.tim.services;

import kz.tim.enums.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuantityServiceTest {
    @Test
    void testDar() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("қағаздар", service.process("қағаз"));
    }

    @Test
    void testDer() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("кiлемдер", service.process("кiлем"));
    }

    @Test
    void testTar() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("жолдастар", service.process("жолдас"));
    }

    @Test
    void testTer() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("мектептер", service.process("мектеп"));
    }

    @Test
    void testLar() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("таулар", service.process("тау"));
    }

    @Test
    void testLer() {
        QuantityService service = new QuantityService(Quantity.PLURAL);
        assertEquals("үйлер", service.process("үй"));
    }
}
