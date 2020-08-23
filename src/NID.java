import java.util.Scanner;

public class NID
{

    public static void main(String[] args)
    {
        int imageWidth, imageHeight;
        int n;

        // ++++++
        // Suggested variables....
        int currentRow = 0;
        int currentCol = 0;
        // "final" keyword means "this 'variable' is a constant."
        final String DARK_CHARACTER  = "M";
        final String LIGHT_CHARACTER = ".";
        String currentSymbol = LIGHT_CHARACTER;
        // ++++++

        // Get the size of the image to be drawn.
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Enter the width and height of the image, separated by spaces: ");
        imageWidth = keyboardScanner.nextInt();
        imageHeight = keyboardScanner.nextInt();
        System.out.println("You chose a ("+imageWidth+" x "+imageHeight+") image.");

        System.out.print("Enter the numbers you wish to interpret. ");

        while (true) // loop forever. You'll want to "break" out of this loop at some point.
        {
            n = keyboardScanner.nextInt();
            System.out.println(n); // temporary line so you can see that n is being read. Please delete or comment out when you start writing!

            //--------------------------------
            // TODO: You write this!





            //--------------------------------
        }
        // reinstate this line when you have an exit condition from the while loop:
        //System.out.println("Done.");
    }

}
