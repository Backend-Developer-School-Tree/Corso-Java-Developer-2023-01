package tinderlike;

import java.util.*;

/**
 * Scrivere un programma per gestire gli interessi in comune tra le persone.
 * In particolare, deve essere possibile gestire una quantità potenzialmente infinita di utenti,
 * ognuno con i propri interessi (a ciascun utente può essere associato uno o più interessi).
 */
public class TinderLike {
    Map<User, Set<Interest>> interestsByUser = new HashMap<>();
    Map<String, User> userById = new HashMap<>();

    /**
     * Inserisce un utente e un insieme di interessi a lui associati
     *
     * @param user utente da inserire
     * @param interests interessi da associare all'utente inserito
     */
    public void insertUserWithInterests(User user, Set<Interest> interests) {
        userById.put(user.getId(), user);
        // add interests if user already exists
        if (interestsByUser.containsKey(user))
            interestsByUser.get(user).addAll(interests);
        else
            interestsByUser.put(user, new HashSet<>(interests));
    }

    /**
     * Cancella un utente e gli interessi a lui associati
     *
     * @param user utente da cancellare
     */
    public void removeUser(User user) {
        interestsByUser.remove(user);
        userById.remove(user.getId());
    }

    /**
     * Rimuove l'associazione tra gli interessi specificati e l'utente
     *
     * @param user utente a cui rimuovere gli interessi associati
     * @param interests interessi da rimuovere dall'utente
     */
    public void removeInterestsForUser(User user, Set<Interest> interests) {
        if(interestsByUser.containsKey(user))
            interestsByUser.get(user).removeAll(interests);
    }

    /**
     * Trova l'utente con più interessi in comune rispetto all'utente specificato
     *
     * @param user utente per cui cercare l'utente con più interessi in comune
     * @return utente con più interessi in comune rispetto all'utente specificato
     */
    public User getMostSimilarUser(User user) {
        if(user == null || !interestsByUser.containsKey(user))
            return null;

        Set<Interest> userInterests = this.interestsByUser.get(user);
        User mostSimilarUser = null;
        int interestsInCommonCount = 0;

        for(User user2 : this.interestsByUser.keySet()) {
            // skip user
            if(user2.equals(user))
                continue;
            Set<Interest> interestsInCommon = new HashSet<>(this.interestsByUser.get(user2));
            interestsInCommon.retainAll(userInterests);
           if(mostSimilarUser == null || interestsInCommon.size() > interestsInCommonCount) {
               mostSimilarUser = user2;
               interestsInCommonCount = interestsInCommon.size();
           }
        }
        return mostSimilarUser;
    }

    /**
     * Trova gli utenti più simili tra loro, ovvero con più interessi in comune
     *
     * @return un array di due elementi, contenente la coppia di utenti con più interessi in comune
     */
    public User[] getMostSimilarUsers() {
        User mostSimilarUser1 = null;
        User mostSimilarUser2 = null;
        int interestsInCommonCount = 0;

        for(User user : interestsByUser.keySet()){

            User mostSimilarUser = getMostSimilarUser(user);
            Set<Interest> interestsInCommon = new HashSet<>(interestsByUser.get(user));
            interestsInCommon.retainAll(interestsByUser.get(mostSimilarUser));

            if(interestsInCommon.size() > interestsInCommonCount) {
                mostSimilarUser1 = user;
                mostSimilarUser2 = mostSimilarUser;
                interestsInCommonCount = interestsInCommon.size();
            }
        }

        return new User[]{mostSimilarUser1, mostSimilarUser2};
    }

    public static void main(String[] args) {
        TinderLike tinderLike = new TinderLike();
        Interest i1 = new Interest("1", "football");
        Interest i2 = new Interest("2", "tennis");
        Interest i3 = new Interest("3", "cricket");
        Interest i4 = new Interest("4", "jumping");
        Interest i5 = new Interest("5", "gym");
        Interest i6 = new Interest("6", "jogging");
        Interest i7 = new Interest("7", "cards");
        User u1 = new User("1", "mario");
        User u2 = new User("2", "giovanni");
        User u3 = new User("3", "andrea");
        User u4 = new User("4", "jonathan");
        Set<Interest> s1 = new HashSet<>();
        s1.add(i1);
        s1.add(i2);
        s1.add(i3);
        tinderLike.insertUserWithInterests(u1, s1);
        Set<Interest> s2 = new HashSet<>();
        s2.add(i1);
        s2.add(i5);
        Set<Interest> s3 = new HashSet<>();
        s3.add(i2);
        s3.add(i3);
        Set<Interest> s4 = new HashSet<>();
        s4.add(i1);
        s4.add(i2);
        s4.add(i3);
        s4.add(i7);
        tinderLike.insertUserWithInterests(u2, s2);
        tinderLike.insertUserWithInterests(u3, s3);
        User u = tinderLike.getMostSimilarUser(u1);
        System.out.println(u.getName().equals("andrea"));
        tinderLike.insertUserWithInterests(u4, s4);
        User[] mostSimilarUsers = tinderLike.getMostSimilarUsers();
        System.out.println(mostSimilarUsers[0].getName().equals("mario"));
        System.out.println(mostSimilarUsers[1].getName().equals("jonathan"));

    }
}
