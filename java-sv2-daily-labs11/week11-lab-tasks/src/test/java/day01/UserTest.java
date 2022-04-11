package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testNormalUser() {
        User normalUser = new NormalUser("normal@domain.com", "PassWord");

        assertEquals("normal@domain.com", normalUser.getUserEmail());
        assertEquals("PassWord", normalUser.getPassword());
    }

    @Test
    void testAdminUser() {
        User adminUser = new AdminUser("admin@domain.com", "PassWord");

        assertEquals("admin@domain.com", adminUser.getUserEmail());
        assertEquals("********", adminUser.getPassword());
    }

}