import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class cubePuzzle {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "adventOfCodeDay2PuzzleInput.txt";
        String input; //current line in file
        int comparsion[] = new int[3]; //values elf wants
        comparsion[0] = 12;//red cubes
        comparsion[1] = 13;//green cubes
        comparsion[2] = 14;//blue cubes

        int inputLine[] = new int[3]; //values of the game
        inputLine[0] = 0;//red cubes
        inputLine[1] = 0;//green cubes
        inputLine[2] = 0;//blue cubes

        int gameCounter = 0;

        FileReader fr = new FileReader(filename);
        Scanner scanInput = new Scanner(fr);


        int game[] = new int[100];
        int count = 0;

        while (scanInput.hasNext()) { //as long as there are games
            final String red = " red";
            final String green = " green";
            final String blue = " blue";
            int currentGame = 0;
            boolean first = true;//first number is always the game

            input = scanInput.nextLine();
            StringBuilder current = new StringBuilder();
            current.append(input);

            char[] inputCharArray = input.toCharArray();

            for (int i = 0; i < inputCharArray.length; i++) {
                StringBuilder sC = new StringBuilder();
                sC.append(inputCharArray[i]);
                String currentC = sC.toString();

                //itterate over String, can skip "Game "
                if (first && Character.isDigit(inputCharArray[i])) { // if its the first didgit in the line
                    int digit = Integer.parseInt(currentC);
                    currentGame = digit;
                    first = false;
                }

                if (Character.isDigit(inputCharArray[i]) && !first) {
                    //find out what color is associated
                    if (Character.isDigit(inputCharArray[i + 1])) {
                        if (i + 6 <= inputCharArray.length) {
                            String sub = current.substring(i + 2, i + 6); //red?
                            if (sub.equals(red)) {
                                sC.append(inputCharArray[i + 1]);
                                currentC = sC.toString();
                                int redPos = Integer.parseInt(currentC);
                                if (inputLine[0] < redPos) {
                                    inputLine[0] = redPos;
                                }
                            }
                        }
                    } else if (i + 5 <= inputCharArray.length) {
                        String sub = current.substring(i + 1, i + 5); //red?
                        if (sub.equals(red)) {
                            int redPos = Integer.parseInt(currentC);
                            if (inputLine[0] < redPos) {
                                inputLine[0] = redPos;
                            }
                        }
                    }
                    if (Character.isDigit(inputCharArray[i + 1])) {
                        if (i + 8 <= inputCharArray.length) {
                            String sub = current.substring(i + 2, i + 8);
                            if (sub.equals(green)) {
                                sC.append(inputCharArray[i + 1]);
                                currentC = sC.toString();
                                int greenPos = Integer.parseInt(currentC);
                                if (inputLine[1] < greenPos) {
                                    inputLine[1] = greenPos;
                                }
                            }
                        }
                    } else if (i + 7 <= inputCharArray.length) {
                        String sub2 = current.substring(i + 1, i + 7);
                        if (sub2.equals(green)) {
                            int greenPos = Integer.parseInt(currentC);
                            if (inputLine[1] < greenPos) {
                                inputLine[1] = greenPos;
                            }
                        }
                    }
                    if(Character.isDigit(inputCharArray[i+1])) {
                        if (i + 7 <= inputCharArray.length) {
                            String sub = current.substring(i + 2, i + 7);
                            if (sub.equals(blue)) {
                                sC.append(inputCharArray[i + 1]);
                                currentC = sC.toString();
                                int bluePos = Integer.parseInt(currentC);
                                if (inputLine[2] < bluePos) {
                                    inputLine[2] = bluePos;
                                }
                            }
                        }
                    } else if (i + 6 <= inputCharArray.length) {
                        String sub3 = current.substring(i + 1, i + 6);
                        if (sub3.equals(blue)) {
                            int bluePos = Integer.parseInt(currentC);
                            if (inputLine[2] < bluePos) {
                                inputLine[2] = bluePos;
                            }
                        }
                    }
                }
            }

            //compare against comparsion values
            boolean isGamePossible = false;
            if ((inputLine[0] <= comparsion[0]) && (inputLine[1] <= comparsion[1]) && (inputLine[2] <= comparsion[2])) {
                isGamePossible = true;
                game[count] = 1;
            }

            if (isGamePossible == true) {
                gameCounter += count+1;
            }
            //resetting values for next line read
            count++;
            inputLine[0] = 0;//red cubes
            inputLine[1] = 0;//green cubes
            inputLine[2] = 0;//blue cubes
        }
        System.out.println(count);
        for (int i = 0; i < 100; i++) {
            System.out.println(game[i]);
        }
        System.out.print("The final number of games added up is: ");
        System.out.println(gameCounter);
    }
}
