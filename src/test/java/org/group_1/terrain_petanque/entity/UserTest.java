package org.group_1.terrain_petanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        try {
            new User(null, "Surname", "mail@mail.com", "password", "username");
            throw new RuntimeException("It cannot be possible to have a name with null");
        } catch (NullPointerException exception) {
            // The constrain is a success
        }

        try {
            new User("Name", null, "mail@mail.com", "password", "username");
            throw new RuntimeException("It cannot be possible to have a surname with null");
        } catch (NullPointerException exception) {
            // The constrain is a success
        }

        try {
            new User("Name", "Surname", null, "password", "username");
            throw new RuntimeException("It cannot be possible to have a mail with null");
        } catch (NullPointerException exception) {
            // The constrain is a success
        }

        try {
            new User("Name", "Surname", "mail@mail.com", null, "username");
            throw new RuntimeException("It cannot be possible to have a password with null");
        } catch (NullPointerException exception) {
            // The constrain is a success
        }

        try {
            new User("Name", "Surname", "mail@mail.com", "password", null);
            throw new RuntimeException("It cannot be possible to have a username with null");
        } catch (NullPointerException exception) {
            // The constrain is a success
        }
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
        try {
            user.setName(null);
            throw new RuntimeException("It cannot be possible to have a name with null");
        } catch (NullPointerException exception) {}

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
        try {
            user.setSurname(null);
            throw new RuntimeException("It cannot be possible to have a surname with null");
        } catch (NullPointerException exception) {}

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
        try {
            user.setMail(null);
            throw new RuntimeException("It cannot be possible to have a mail with null");
        } catch (NullPointerException exception) {}

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
        try {
            user.setPassword(null);
            throw new RuntimeException("It cannot be possible to have a password with null");
        } catch (NullPointerException exception) {}

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
        try {
            user.setUsername(null);
            throw new RuntimeException("It cannot be possible to have a username with null");
        } catch (NullPointerException exception) {}

        user.setUsername("newusername");

        // Assertion
        assertEquals(user.getUsername(), "newusername");
    }

}
