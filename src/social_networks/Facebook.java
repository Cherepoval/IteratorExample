package social_networks;

import iterators.FacebookIterator;
import iterators.ProfileIterator;
import profiles.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facebook implements SocialNetwork{

    private List<Profile> profiles;

    public Facebook (List<Profile> cache){

        this.profiles = Objects.requireNonNullElseGet(cache, ArrayList::new);
    }

    public Profile requestProfileFromFacebook (String profileEmail){

        // Here would be a POST request to one of the Facebook API endpoints.

        simulateNetworkLatency();
        System.out.println("Facebook: loading profile '" + profileEmail + "' over the network...");

        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType){

        // Here would be a POST request to one of the Facebook API endpoints.

        simulateNetworkLatency();
        System.out.println("Facebook: loading '" + contactType + "' list of '" + profileEmail + "' over the network...");

        Profile profile = findProfile(profileEmail);

        if (profile != null){
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findProfile (String profileEmail){

        for (Profile profile: profiles){

            if (profile.getEmail().equals(profileEmail)){

                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {

        return new FacebookIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
