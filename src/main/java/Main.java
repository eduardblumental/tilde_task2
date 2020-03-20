import java.util.Scanner;

// This algorithm is written in Java 11. To run it you need to install and set up the JDK software.
public class Main {
    public static void main(String[] args) {

        //        Ask the user how many points there are in the sequence
        int numberOfPoints;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many points does you sequence have?");
        numberOfPoints = scanner.nextInt();

        //        Read X and Y coordinates for all the points in the sequence from the user input
        Integer[] sequenceX = new Integer[numberOfPoints];
        Integer[] sequenceY = new Integer[numberOfPoints];

        for (int counter = 0; counter <numberOfPoints; counter++){
            System.out.println("Please, enter the X coordinate of the point " + (counter+1));
            sequenceX[counter] = scanner.nextInt();
            System.out.println("Please, enter the Y coordinate of the point " + (counter+1));
            sequenceY[counter] = scanner.nextInt();
        }

        scanner.close();

        //        Compute a signed area of the shape we got
        Integer sumOfDeterminants = 0;

        for (int counter = 0; counter <(numberOfPoints-1); counter++){
            Integer determinant = sequenceX[counter]*sequenceY[(counter+1)]-sequenceX[(counter+1)]*sequenceY[counter];
            sumOfDeterminants = sumOfDeterminants + determinant;
        }

        Integer lackingDeterminant = sequenceX[(numberOfPoints-1)] * sequenceY[0] - sequenceX[0] * sequenceY[(numberOfPoints-1)];

        Double signedArea = 0.5*(sumOfDeterminants + lackingDeterminant);

        //        If a signed area of a polygon is negative, then it was drawn clockwise
        System.out.println("You have entered the following sequence: ");

        for (int counter = 0; counter <numberOfPoints; counter++){
            System.out.print("(" + sequenceX[counter] + "," + sequenceY[counter] + ") ");
        }

        System.out.println("");

        if (signedArea>0){
            System.out.println("The shape was drawn counterclockwise");
        }   else  {
            System.out.println("The shape was drawn clockwise");
        }
    }
}
