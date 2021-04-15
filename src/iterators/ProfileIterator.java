package iterators;

import profiles.Profile;

public interface ProfileIterator {

    boolean hasNext();
    Profile getNext();
    void reset();
}
