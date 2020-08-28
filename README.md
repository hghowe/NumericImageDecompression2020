
APCS	August 27, 2020

## Numerical Image Decompression ##

In this project we're looking at a way that a black-and-white pixelated image can be represented as a sequence of numbers. For instance, consider the following 8 x 8 image:


<table>
  <tr>
   <td rowspan="8" >




<img src="images/image1.png" width="80%" alt="drawing">

   </td>
   <td>3 light, 1 dark, 4 light
   </td>
  </tr>
  <tr>
   <td>3 light, 1 dark, 4 light
   </td>
  </tr>
  <tr>
   <td>2 light, 1 dark, 1 light, 1 dark, 3 light
   </td>
  </tr>
  <tr>
   <td>2 light, 1 dark, 1 light, 1 dark, 3 light
   </td>
  </tr>
  <tr>
   <td>1 light, 1 dark, 3 light, 1 dark, 2 light
   </td>
  </tr>
  <tr>
   <td>1 light, 5 dark, 2 light
   </td>
  </tr>
  <tr>
   <td>1 dark, 5 light, 1 dark, 1 light
   </td>
  </tr>
  <tr>
   <td>1 dark, 5 light, 1 dark, 1 light
   </td>
  </tr>
</table>


Since we keep alternating the light and dark values, we might even choose just use the numbers, assuming we always start with light:

```
    3 1 4
    3 1 4
    2 1 1 1 3
    2 1 1 1 3
    1 1 3 1 2
    1 5 2
    0 1 5 1 1
    0 1 5 1 1
```

(Note the zeroes on the last two lines… and consider why they are there. Would it make sense to have zeros in the middle of a line?)

In fact, since we know we always have eight values in each row, we could just use one stream of numbers:

3 1 4 3 1 4 2 1 1 1 3 2 1 1 1 3 1 1 3 1 2 1 5 2 0 1 5 1 1 0 1 5 1 1

… although this would be harder to understand for humans.

Your job in this project is to ask the user for a width and height, then a stream of numbers - and to draw the image that it represents.

For example, here is the output for a sample run:


```
Enter the width and height of the image, separated by spaces: 8 8
You chose a (8 x 8) image.
Enter the numbers you wish to interpret. 3 1 4 3 1 4 2 1 1 1 3 2 1 1 1 3 1 1 3 1 2 1 5 2 0 1 5 1 1 0 1 5 1 1
...M....
...M....
..M.M...
..M.M...
.M...M..
.MMMMM..
M.....M.
M.....M.
Done.
```


… In this case, I am using a period for the "light" cells and an "M" for the dark ones. ("M" just has a lot of dark pixels. Other candidates might be "W," "#" or "@.") You can use whatever you like. And, yes, a space makes better sense for the light cells… when you're done debugging.

Here are some relevant Java tips:


<table>
  <tr>
   <td>Something to notice here is that if the user types in two numbers (e.g., "8 8"), the Scanner's <code>nextInt()</code> method will read the first 8 and "save" the remaining " 8" for later - i.e., another call to <code>nextInt()</code>. So when we enter the long list of numbers, the computer can treat this as if it were reading them one at a time from the user.
   </td>
  </tr>
  <tr>
   <td>When checking whether to numbers (a and b) are the same, we say:
<p>

    <code>if (a == b)</code>
<p>
but when we check whether two Strings (word1 and word2) are the same, we say:
<p>

    <code>if (word1.equals(word2))</code>
<p>
If you use the "==" with strings it will check whether the strings' memory locations match, which is probably not what you want.
   </td>
  </tr>
  <tr>
   <td>If you are in the middle of a while() or for() loop, and you wish to exit immediately, you can use the <code>break</code>; command, which is frequently found in the curly brackets section of an <code>if</code> statement. This will exit the loop, regardless of whether the expression in the <code>while's</code> parentheses is true or not, and move the operation point to immediately after the loop.
<p>
(If you have nested loops, and a break occurs inside the inner one, it will only jump out of the inner loop.)
<p>
This is how you get out of a <code>while(true) </code>loop, which would otherwise run forever.
   </td>
  </tr>
</table>




**Getting the starter code. (This is the same as for Brute Force Graphing, but with a different link.)**



*   Click on this link:  [https://classroom.github.com/a/jBJZoI-D](https://classroom.github.com/a/jBJZoI-D) to take you to a page inviting you to the github classroom assignment. You will likely need to log in with your github account.
*   If this is your first time doing one of these assignments, you should see a list of names - please pick your own.
*   There should be a button prompting you to "accept" this assignment.[^1]


*   After a brief pause, you'll get a message saying you're ready to go, with a url on it. Go ahead and click on this URL.
*   You should see something similar to this. (This is for a different assignment for a different class for a different student, but the overall appearance should be similar.) <br /><img src="images/image2.png" width = 750>
*   Click on the green "Code" button. You'll see the start of a (mighty similar) URL here, too. Click on the clipboard icon next to it to copy this URL into your clipboard.
*   Launch IntelliJ IDEA on your computer, and then…
    *   If you are seeing the IntelliJ greeting screen, click "Get From Version Control."
    *   Otherwise, go to File menu → New → "Project from Version Control…"
*   In the window that appears, paste the URL you just copied into the URL field.  Use the Directory field to modify where you want this project to go on your computer.
*   The project should open up with my starter code.

I would like to draw your attention to the top of the main() method - I've created some variables that I would like to recommend to you, because I think you will find them useful. 

In addition to what we have seen, let us make our program a bit more forgiving: 



1. If a user types in a number that would cause us to go past the end of a row, we'll just draw however many characters as are left in the row and ignore the rest. For example, if we have an image width of 6 and type 2 3 12 for that row, we'll get: \
    `..MMM. `\
    and the remaining 11 dots of the "12" will be discarded.
2. If the user types in a negative number, that will fill in the rest of the row - think of "-1" as equivalent to "imageWidth."
3. If the user types in more numbers that would create extra lines on the image, they are ignored. Only the correct number of rows will be drawn.

A few things to check for yourself, in addition to (a - c), above:



*   The program should work just as well if you end a row with an exact count as with an overflow, like in (a).
*   Starting a row with 0 should work as expected.
*   Ending a row with a light cell or a dark cell should not impact the appearance of the next row.
*   If the user types in too few numbers to make the full shape, it will draw what it can and let the user type in more numbers (without a prompt) and continue from there. If the numbers run out in the middle of that row, you don't have to continue at the indentation where you left off; that row will just be messed up, but the next row should be able to print correctly. (Honestly, this is the normal behavior that I think will happen naturally - I am giving you permission not to stress out about it!)

**Turning this project in**

We will discuss in class what you need to do to turn this in via Github Classroom, but I also am asking you to add something to this document In the table below, share a picture with me: give me width and height on one line, and on the next, the numbers that make the picture.

*(Make these changes in the Google Document.)*

<!-- Footnotes themselves at the bottom. -->
## Notes

[^1]: Sounds like something out of _Mission Impossible,_ doesn't it?
