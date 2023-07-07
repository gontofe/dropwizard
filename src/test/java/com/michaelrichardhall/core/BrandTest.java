package com.michaelrichardhall.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void serializesToJson() throws Exception {
        final Brand brand = new Brand(1L, "Brand 1");

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(MAPPER.getClass().getResource("/fixtures/brand.json"), Brand.class));

        assertEquals(expected, MAPPER.writeValueAsString(brand));
    }

    @Test
    void deserializesFromJson() throws Exception {
        final Brand brand = new Brand(1L, "Brand 1");

        assertEquals(brand, MAPPER.readValue(getClass().getResource("/fixtures/brand.json"), Brand.class));
    }
}