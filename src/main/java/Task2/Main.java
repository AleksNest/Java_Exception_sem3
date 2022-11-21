package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongOfDataInputException {
        Scanner in = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            InputOfData input = new InputOfData();
            WriteToFile writeToFile = new WriteToFile();
            writeToFile.writeToFile(input.input());
            System.out.println("do you want to enter new data?: y/n");
            if (!in.nextLine().equals("y")) {
                flag = false;
            }
        }
    }
}
