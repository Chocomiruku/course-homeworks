package com.chocomiruku.homework3;

import static com.chocomiruku.homework3.Util.convertLongToTimeString;
import static com.chocomiruku.homework3.Util.formatPrice;

import com.chocomiruku.homework3.task1.Book;
import com.chocomiruku.homework3.task1.Magazine;
import com.chocomiruku.homework3.task1.Publication;
import com.chocomiruku.homework3.task2.Action;
import com.chocomiruku.homework3.task2.AuthCallback;
import com.chocomiruku.homework3.task2.Operation;
import com.chocomiruku.homework3.task2.Type;
import com.chocomiruku.homework3.task2.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public void buy(Publication purchase) {
        if (purchase == null) throw new NullPointerException();
        System.out.println("\nThe purchase is complete. The purchase amount was " + formatPrice(purchase.getPrice()));
    }

    private static final AuthCallback anonymousAuthCallback = new AuthCallback() {
        @Override
        public void authSuccess() {
            System.out.println("Authorization was successful.");
        }

        @Override
        public void authFailed() {
            System.out.println("Authorization has failed.");
        }
    };

    public void updateCache() {
        System.out.println("Cache was updated.");
    }

    public void auth(User user, Runnable r) {
        try {
            user.checkAge();
            anonymousAuthCallback.authSuccess();
            r.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            anonymousAuthCallback.authFailed();
        }
    }

    public void doAction(Action action) {
        if (action instanceof Action.Registration) {
            System.out.println("\nRegistration has started.");
        } else if (action instanceof Action.Login) {
            System.out.println("Auth has started.");
            User user = ((Action.Login) action).getUser();
            if (user == null) {
                throw new NullPointerException("User should be specified.");
            } else auth(user, this::updateCache);
        } else if (action instanceof Action.Logout) {
            System.out.println("Logout has started.");
        }
    }

    public void runFirstTask() {
        // Exercise 1: Publication's info
        Book bookFirst = new Book(25.50, 1000);
        Book bookSecond = new Book(50.70, 7500);
        Magazine magazine = new Magazine(11.50, 2000);

        System.out.println(bookFirst.toString());
        System.out.println(bookSecond.toString());
        System.out.println(magazine.toString());

        // Exercise 2: Equality
        System.out.println("\nReferential equality: " + (bookFirst == bookSecond));
        System.out.println("Structural equality: " + (bookFirst.equals(bookSecond)));

        // Exercise 3: Null safety (which doesn't exist ¯\_(ツ)_/¯)
        Book nullTestBookFirst = null;
        Book nullTestBookSecond = new Book(17.20, 500);

        try {
            buy(nullTestBookSecond);
            buy(nullTestBookFirst);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught.");
        }

        // Exercise 4: Lambda
        Operation sum = (x, y) -> x + y;
        System.out.println("\n27 + 17 = " + sum.calculate(27, 17));
    }

    public void runSecondTask() {
        // Exercise 2-3:  Data class with lazy property
        User user = new User(1, "Angelina", 20, Type.DEMO);

        try {
            System.out.println(convertLongToTimeString(user.getStartTime()));
            Thread.sleep(1000);
            System.out.println(convertLongToTimeString(user.getStartTime()));
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught.");
        }

        // Exercise 4: Scope function apply (
        List<User> users = new ArrayList<>();
        users.add(new User(2, "Ivan", 25, Type.FULL));
        users.add(new User(3, "Maria", 30, Type.DEMO));

        // Exercise 5: Filtering collections
        List<User> usersWithFullAccess = users.stream()
                .filter(u -> u.getType() == Type.FULL)
                .collect(Collectors.toList());

        // Exercise 6: Collection transformation operations
        List<String> userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("\nFirst element: " + userNames.get(0) + ", last element: " + userNames.get(userNames.size() - 1));

        //Alternative solution:
        LinkedList<String> userNamesAlternative = users.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("First element: " + userNamesAlternative.getFirst() + ", last element: " + userNamesAlternative.getLast());

        // Exercises 7-12: Extension function,
        // anonymous object, inline, sealed class
        // (not supported)
        doAction(new Action.Registration());
        try {
            doAction(new Action.Login(user));
            doAction(new Action.Logout());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runFirstTask();
        main.runSecondTask();
    }
}