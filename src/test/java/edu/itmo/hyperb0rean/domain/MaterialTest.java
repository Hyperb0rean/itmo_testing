package edu.itmo.hyperb0rean.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
    @Test
    void testMaterialToString() {
        assertEquals("камень", Material.ROCK.toString());
        assertEquals("сталь", Material.STEEL.toString());
        assertEquals("чистое золото", Material.GOLD.toString());
    }
}