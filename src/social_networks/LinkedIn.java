package social_networks;

import iterators.LinkedInIterator;
import iterators.ProfileIterator;
import profiles.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedIn implements SocialNetwork{

    private List<Profile> contacts;

    public LinkedIn (List<Profile> cache){

        this.contacts = Objects.requireNonNullElseGet(cache, ArrayList::new);
    }

    public Profile requestContactInfoFromLinkedInAPI(String profileEmail) {

        // Here would be a POST request to one of the LinkedIn API endpoints.

        simulateNetworkLatency();
        System.out.println("LinkedIn: loading profile '" + profileEmail + "' over the network...");

        return findContact(profileEmail);
    }

    public List<String> requestRelatedContactsFromLinkedInAPI(String profileEmail, String contactType){

        // Here would be a POST request to one of the LinkedIn API endpoints.

        simulateNetworkLatency();
        System.out.println("LinkedIn: loading '" + contactType + "' list of '" + profileEmail + "' over the network...");

        Profile profile = findContact (profileEmail);

        if (profile != null){
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findContact (String profileEmail){

        for (Profile profile: contacts){
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

        return new LinkedInIterator(this, "friends", profileEmail);

    }
    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {

        return new LinkedInIterator(this, "coworkers", profileEmail);
    }


}
