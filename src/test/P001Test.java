package tests;

import org.junit.jupiter.api.Test;
import problems.P001;

import static org.junit.jupiter.api.Assertions.*;

public class P001Test {
    @Test
    void solve() {
        assertEquals(new P001().solve(), "233168");
    }

}