package org.aispace;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    // ---------- 1. Email ----------
    @Test
    void email_acceptsValidShapes() {
        assertTrue(Validators.isValidEmail("t.okafor@staff.semicolon.africa"));
        assertTrue(Validators.isValidEmail("p.nwankwo@native.semicolon.africa"));
    }

    @Test
    void email_rejectsDeviations() {
        assertFalse(Validators.isValidEmail(null));
        assertFalse(Validators.isValidEmail(""));
        assertFalse(Validators.isValidEmail("T.okafor@staff.semicolon.africa"));      // uppercase initial
        assertFalse(Validators.isValidEmail("tokafor@staff.semicolon.africa"));       // missing dot
        assertFalse(Validators.isValidEmail("tt.okafor@staff.semicolon.africa"));     // two-letter initial
        assertFalse(Validators.isValidEmail("t.o@staff.semicolon.africa"));           // surname too short
        assertFalse(Validators.isValidEmail("t.okafor@intern.semicolon.africa"));     // wrong group
        assertFalse(Validators.isValidEmail("t.okafor@staff.semicolon.com"));         // wrong TLD
        assertFalse(Validators.isValidEmail("t.okafor@staffxsemicolon.africa"));      // unescaped-dot trap
        assertFalse(Validators.isValidEmail(" t.okafor@staff.semicolon.africa"));     // leading space
        assertFalse(Validators.isValidEmail("t.okafor@staff.semicolon.africa.evil")); // trailing junk
        assertFalse(Validators.isValidEmail("hi t.okafor@staff.semicolon.africa"));   // matches() vs find()
    }

    // ---------- 6. Passwords that are suitable ----------
    @Test
    void password_acceptsValid() {
        assertTrue(Validators.isValidPassword("Str0ng#Pass"));
        assertTrue(Validators.isValidPassword("a#1bcdef"));            // exactly 8
        assertTrue(Validators.isValidPassword("abcdefghijkl#_+1"));    // exactly 16
    }

    @Test
    void password_rejectsDeviations() {
        assertFalse(Validators.isValidPassword(null));
        assertFalse(Validators.isValidPassword("a#1bcde"));            // 7 chars
        assertFalse(Validators.isValidPassword("abcdefghijkl#_+12"));  // 17 chars
        assertFalse(Validators.isValidPassword("Str0ng #Pass"));       // space
        assertFalse(Validators.isValidPassword("Strong#Pass"));        // no digit
        assertFalse(Validators.isValidPassword("Str0ngPass9"));        // no special
        assertFalse(Validators.isValidPassword("Str0ng!Pass"));        // ! not allowed here
    }
}