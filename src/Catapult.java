/*
 *btran8
 *Project 1 - Catapult class
 *Lab section: 9:40 - 10:55 TR
 *TA: Rahaf AlQarni
 *I did not collaborate with anyone on this assignment
 */
import java.lang.Math;

public class Catapult {                                                         //Catapult is my object for calculating the shot.
    int V;
    int Angle;
    double G = 9.8;
    double Projectile_Height = 0.0;

    public void lineUp(String V, String Angle) {                                //Setter for the shot.
        this.V = Integer.parseInt(V);
        this.Angle = Integer.parseInt(Angle);
    }

    public void Shoot(int Dis) {
        double Angle_1 = Math.toRadians(Angle);
        Projectile_Height = Dis * Math.tan(Angle_1);
        double tmp = G * Dis * Dis;
        double tmp2 = 2 * (V * Math.cos(Angle_1)) * (V * Math.cos(Angle_1));    //calculate the distance of the projectile at the position of the wall.
        tmp /= tmp2;
        Projectile_Height -= tmp;
    }
}
