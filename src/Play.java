/*
 *btran8
 *Project 1 - Play/Main class.
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Play {

    static int Wall_Distance;
    static int Wall_Height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = 0;
        Random Rand = new Random();
        Catapult myCatapult = new Catapult();
        Announcer myAnnouncer = new Announcer();
        while (++round > 0) {
            System.out.println("ROUND " + round);
            Wall_Distance = Rand.nextInt(300) + 50;
            Wall_Height = Rand.nextInt(200) + 50;
            System.out.println("Distance to the wall: " + Wall_Distance + " meters. " + "Height of the wall: " + Wall_Height + " meters");
            System.out.println("The wall will start to move toward you now. Don't get crush!");
            System.out.println("Is this round too hard? Type \"Skip\" to skip or \"Quit\" to forfeit.");
            System.out.print("Else just type in speed and then angle for the shot: ");
            Timer myTimer = new Timer();                                //Creating the timer.
            TimerTask Task = new TimerTask() {
                public void run() {
                    if (Wall_Distance == 1) {
                        myTimer.cancel();                               //The user has been crushed
                        System.out.println("U have been crushed! GAME OVER");
                        System.exit(0);                          //This is game over so i called the System to exit.
                    } else {
                        Wall_Distance -= 1;                             //This is the task implements that the wall gonna move closer at time passes.
                    }
                }
            };
            myTimer.scheduleAtFixedRate(Task, 0, 1000);    //Currently i am setting the wall to get 1 meter closer every second
            String V = sc.next();
            if (V.equals("Skip")) continue;                             //If they type Skip than the current while loop ends and the next one begins.
            if (V.equals("Quit")) System.exit(0);
            myTimer.cancel();                                           //If the code gets to this point, than the user has already made the shot, so the timer should stop
            String Angle = sc.next();
            myCatapult.lineUp(V, Angle);                                //Here is where my catapult set up the stats for the shot
            myCatapult.Shoot(Wall_Distance);                            //The Catapult made the shot, and since the equation involves the distance of the wall, it becomes a parameter.
            myAnnouncer.respond(myCatapult, Wall_Height);               //The Announcer responds to the user the result of the shot.
            System.out.println("CURRENT SCORE: " + myAnnouncer.Score);  //Letting they know the score.
            V = sc.nextLine();                                          //I need to make the Scanner arrive at the next line after every round is done so that it is ready for the new input.
        }
    }
}
