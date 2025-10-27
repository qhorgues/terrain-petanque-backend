package org.group_1.terrain_petanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This class tests the User entity.
 */
public class UserTest {

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        assertThrows(NullPointerException.class, () -> {
            new User(null, "Surname", "mail@mail.com", "password", "username");
        });

        assertThrows(NullPointerException.class, () -> {
            new User("Name", null, "mail@mail.com", "password", "username");
        });

        assertThrows(NullPointerException.class, () -> {
            new User("Name", "Surname", null, "password", "username");
        });

        assertThrows(NullPointerException.class, () -> {
            new User("Name", "Surname", "mail@mail.com", null, "username");
        });

        assertThrows(NullPointerException.class, () -> {
            new User("Name", "Surname", "mail@mail.com", "password", null);
        });
    }



    /**
     * This method tests the getter of the id.
     */
    @Test
    public void getIdTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
        
        // Assertion
        assertEquals(user.getId(), null);
    }



    /**
     * This method tests the getter of the name.
     */
    @Test
    public void getNameTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
        
        // Assertion
        assertEquals(user.getName(), "Name");
    }



    /**
     * This method tests the setter of the name.
     */
    @Test
    public void setNameTest() {
        // Init
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");

        // Test
        assertThrows(NullPointerException.class, () -> {
            user.setName(null);
        });

        user.setName("NewName");

        // Assertion
        assertEquals(user.getName(), "NewName");
    }



    /**
     * This method tests the getter of the surname.
     */
    @Test
    public void getSurnameTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
        
        // Assertion
        assertEquals(user.getSurname(), "Surname");
    }



    /**
     * This method tests the setter of the surname.
     */
    @Test
    public void setSurnameTest() {
        // Init
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");

        // Test
        assertThrows(NullPointerException.class, () -> {
            user.setSurname(null);
        });

        user.setSurname("NewSurname");

        // Assertion
        assertEquals(user.getSurname(), "NewSurname");
    }



    /**
     * This method tests the getter of the mail.
     */
    @Test
    public void getMailTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
        
        // Assertion
        assertEquals(user.getMail(), "mail@mail.com");
    }



    /**
     * This method tests the setter of the mail.
     */
    @Test
    public void setMailTest() {
        // Init
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");

        // Test
        assertThrows(NullPointerException.class, () -> {
            user.setMail(null);
        });

        user.setMail("new@mail.com");

        // Assertion
        assertEquals(user.getMail(), "new@mail.com");
    }



    /**
     * This method tests the getter of the password.
     */
    @Test
    public void getPasswordTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
        
        // Assertion
        assertEquals(user.getPassword(), "password");
    }



    /**
     * This method tests the setter of the password.
     */
    @Test
    public void setPasswordTest() {
        // Init
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");

        // Test
        assertThrows(NullPointerException.class, () -> {
            user.setPassword(null);
        });

        user.setPassword("newpassword");

        // Assertion
        assertEquals(user.getPassword(), "newpassword");
    }



    /**
     * This method tests the getter of the username.
     */
    @Test
    public void getUsernameTest() {
        // Init & test
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");
       
        // Assertion
        assertEquals(user.getUsername(), "username");
    }



    /**
     * This method tests the setter of the username.
     */
    @Test
    public void setUsernameTest() {
        // Init
        User user = new User("Name", "Surname", "mail@mail.com", "password", "username");

        // Test
        assertThrows(NullPointerException.class, () -> {
            user.setUsername(null);
        });

        user.setUsername("newusername");

        // Assertion
        assertEquals(user.getUsername(), "newusername");
    }

}
