package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q726_NumberOfAtomsTest {
    Q726_NumberOfAtoms test = new Q726_NumberOfAtoms();

    @Test
    void countOfAtoms() {
        assertEquals("H2O", test.countOfAtoms("H2O"));
        assertEquals("H4O2", test.countOfAtoms("(H2O)2"));
        assertEquals("H2MgO2", test.countOfAtoms("Mg(OH)2"));
        assertEquals("K4N2O14S4", test.countOfAtoms("K4(ON(SO3)2)2"));
    }
}