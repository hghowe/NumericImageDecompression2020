import java.util.Scanner;

public class NID
{

    public static void main(String[] args)
    {
        int imageWidth, imageHeight;
        int currentRow = 0;
        int currentCol = 0;
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Enter the width and height of the image, separated by spaces: ");
        imageWidth = keyboardScanner.nextInt();
        imageHeight = keyboardScanner.nextInt();

        System.out.println("You chose a ("+imageWidth+" x "+imageHeight+") image.");

        // ++++
        // Clear the carriage return from the input, so it doesn't interfere with the next line request.
        keyboardScanner.nextLine();
        // ++++
        while (currentRow<imageHeight)
        {
            System.out.print("Enter the numbers you wish to interpret. ");
            String line = keyboardScanner.nextLine();

            Scanner lineReader = new Scanner(line);

            while(lineReader.hasNextInt())
            {
                System.out.println(lineReader.nextInt());
            }



        }

    }

}
