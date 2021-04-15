package app;

import iterators.ProfileIterator;
import profiles.Profile;
import social_networks.SocialNetwork;

public class MessageSendingApp {

    public SocialNetwork socialNetwork;
    public ProfileIterator iterator;

    public MessageSendingApp(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public void sendMessageToFriends (String name, String profileEmail, String message){

        System.out.println("\n Iterating over the " + name + " friends...\n");

        iterator = socialNetwork.createFriendsIterator(profileEmail);

        while (iterator.hasNext()){
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessageToCoworkers (String name,String profileEmail, String message){

        System.out.println("\n Iterating over the " + name + " friends coworkers...\n");

        iterator = socialNetwork.createCoworkersIterator(profileEmail);

        while (iterator.hasNext()){
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    private void sendMessage(String email, String message) {

        System.out.println("Sent message to: '" + email + "' Text: '" + message + "'");
    }
}
