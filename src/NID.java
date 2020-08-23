import java.util.Scanner;

public class NID
{

    public static void main(String[] args)
    {
        int imageWidth, imageHeight;
        int n;
        int currentRow = 0;

        // ++++++
        // Suggested variables....
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

        while (currentRow<imageHeight)
        {
            n = keyboardScanner.nextInt();
            System.out.println(n); // temporary line so you can see that n is being read. Please delete or comment out when you start writing!

            //--------------------------------
            // TODO: You write this!





            //--------------------------------
        }

    }

}
