/*
 *btran8
 *Project 1 - Annoucer Class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */
import java.util.Random;

public class Announcer {                                    //Announcer is my object for outputing the result of the shot to the user.
    int Score = 0;                                                                      //Annoucer is also responsible for the score.
    String s[] = {"Passin' with grace", "Perfect Curve", "Beautiful!"};                 //This is my array that i gonna choose random from it a quote for a close-clear case.
    Random Rand = new Random();

    public void respond(Catapult cp, int Height) {
        double Projectile_Height = cp.Projectile_Height;                                //Through out this class i take the projectile height at the wall distance to compare it to the height of the wall.
        int Wall_height = Height;
        Score--;                                                                        //Each launch costs 1 point
        if (Projectile_Height <= 0) {                                                   //This means the projectile didn;t even get to the wall => Far miss
            System.out.println("Not even close... At least touch the wall would you? :(");
            Score -= 3;
            return;
        } else if (Projectile_Height <= Wall_height) {                                  //It hits the wall => Near miss
            if (Projectile_Height == Wall_height)                                       //I just create the case where the shot perfectly touch the top of the wall.
                System.out.println("Touched the top! Too bad");
            else
                System.out.println("U broke the wall! That would cost you 1 point to build it again.");
            System.out.print("Your shot was " + (Wall_height - Projectile_Height) + " meters from the top of the wall   ");
            Score -= 1;
            return;
        } else if (Projectile_Height <= Wall_height + 30) {                             //This is a close-clear ( with my documentation )
            int Id = Rand.nextInt(3);                                           //Generate a number ID and then take the string from the array that bears that ID to be the respond.
            System.out.println(s[Id]);
            Score += 5;
        } else {
            System.out.println("Plenty of room");                                       //The rest are far clears.
            Score += 2;
        }
        System.out.print("Your shot was " + (Projectile_Height - Wall_height) + " meters above the wall     ");
    }
}
