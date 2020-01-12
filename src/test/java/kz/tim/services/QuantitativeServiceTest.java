package kz.tim.services;

import kz.tim.enums.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuantitativeServiceTest {
    @Test
    void testDar() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("қағаздар", service.process("қағаз"));
    }

    @Test
    void testDer() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("кiлемдер", service.process("кiлем"));
    }

    @Test
    void testTar() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("жолдастар", service.process("жолдас"));
    }

    @Test
    void testTer() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("мектептер", service.process("мектеп"));
    }

    @Test
    void testLar() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("таулар", service.process("тау"));
    }

    @Test
    void testLer() {
        QuantitativeService service = new QuantitativeService(Quantity.PLURAL);
        assertEquals("үйлер", service.process("үй"));
    }
}
