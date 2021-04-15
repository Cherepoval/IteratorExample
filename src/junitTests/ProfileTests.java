package junitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import profiles.Profile;

import java.util.List;

public class ProfileTests {

    Profile profile;

    @BeforeEach
    void setUp() throws Exception {

       profile = new Profile("bymerang@hotmail.com", "Lara Croft", "friends:artemon@hotmail.com", "coworkers:pokemon@gmail.com" );
    }

    @Test
    @DisplayName("Show the email of profile")

    public void getTestProfileEmail(){
        String email = profile.getEmail();
        System.out.println(email);
    }

    @Test
    @DisplayName("Show the name of profile")

    public void getTestProfileName(){
        String name = profile.getName();
        System.out.println(name);
    }

    @Test
    @DisplayName("Show the profile's contacts")

    public void getTestProfileContacts(){
        List<String> friendsContacts = profile.getContacts("friends");
        List<String> coworkersContacts = profile.getContacts("coworkers");

        System.out.println("friends: " + friendsContacts);
        System.out.println("coworkers: " + coworkersContacts);
    }
}
