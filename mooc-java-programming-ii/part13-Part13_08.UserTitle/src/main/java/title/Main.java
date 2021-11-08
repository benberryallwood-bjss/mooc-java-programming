package title;


import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a title:");
        System.out.print("> ");

        String userTitle = userInput.nextLine();

        Application.launch(UserTitle.class,
                "--title=" + userTitle);
    }

}
