package org.example.util;

import org.junit.Test;

import static org.example.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_password() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_password_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefg"));
    }

    @Test
    public void medium_password() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_password() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd1234$%&"));
    }
}