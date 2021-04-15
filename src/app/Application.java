package app;

import profiles.Profile;
import social_networks.Facebook;
import social_networks.LinkedIn;
import social_networks.SocialNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please specify social network to target message tool (default: Facebook)");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");

        String choice = scanner.nextLine();

        SocialNetwork socialNetwork;

        if (choice.equals("2")){
            socialNetwork = new LinkedIn(getProfiles());
        } else {
            socialNetwork = new Facebook(getProfiles());
        }

        MessageSendingApp messenger = new MessageSendingApp(socialNetwork);

        messenger.sendMessageToFriends("Anna Smith","anna.smith@bing.com", "Hey! Can you do me a favor and like this post [link]?");
        messenger.sendMessageToCoworkers("Anna Smith","anna.smith@bing.com", "Hello! I purpose you would be interested in [link].");
    }



    private static List<Profile> getProfiles() {

        List<Profile> data = new ArrayList<>();

        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));

        return data;
    }

}
