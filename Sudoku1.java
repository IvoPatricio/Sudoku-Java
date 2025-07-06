import java.util.Scanner;
import java.util.HashMap;

public class Sudoku1 {
    public static int ft_checkInput(Scanner scanner)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        String numCombination = scanner.nextLine();

        if (numCombination.length() != 9)
            return 1;

        for (int i = 0; i < numCombination.length(); i++)
        {
            int num = numCombination.charAt((i)) - 48;
            /*CPP: map[i]++ init with 0. Java hashmaps starts with null values
            getordefault retrives and if null adds 0 to the map; */
            if (num < 1 || num > 9)
                return 1;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.getOrDefault(9, 0) == 0 || map.getOrDefault(1, 0) == 0)
            return 2;
    
        for (int i = 1; i <= 9; i++)
        {
            int count = map.getOrDefault(i, 0);
            if (count != 1)
                return 3;
        }

        return 0;
    }
    
    public static int ft_checkOption(Scanner scanner)
    {
        int numValidator = 0;

        try
        {
            numValidator = scanner.nextInt();
            scanner.nextLine();
            if (numValidator != 1 && numValidator != 2)
                System.err.println("ERROR, Number must be 1 or 2!\n");
            return numValidator;
        }
        catch(Exception e)
        {
            System.err.println("ERROR, Invalid Input!");
            scanner.nextLine();
            return 3;
        }
    }

    public static void ft_PrintReturnInfo(int returnValue)
    {
        if (returnValue != 0)
        {
            switch (returnValue) 
            {
                case 1:
                    System.err.println("1. ERROR, bad combination! (Must be positive "
                    + "and have 9 digits)");
                    break;
                case 2:
                    System.err.println("2. ERROR, bad combination! (Largest digit "
                        + "must be 9 and smallest digit must be 1)");
                    break;
                case 3:
                    System.err.println("3. ERROR, bad combination!(Both the "
                        + "sum of digits must be 45 and product of digits must be 362880)");
                    break;
            }
            System.err.println("Please try again!");
        }
        else
            System.out.println("Valid combination!");
    }

    public static int ft_sudokuMenu(Scanner scanner)
    {
        System.out.println("\n|===============================|");
        System.out.println("|     SUDOKU NUMBER VALIDATOR   |");
        System.out.println("|-------------------------------|");
        System.out.println("| 1. Test a number combination  |");
        System.out.println("| 2. Quit validator             |");
        System.out.println("|===============================|");
    
        return ft_checkOption(scanner);
    }

    public static boolean ft_executeUserChoice(Scanner scanner)
    {
        int checkOption = ft_sudokuMenu(scanner);
    
        if (checkOption == 2)
            return false;
        else if (checkOption == 1)
        {
            System.out.printf("| Type the sudoku numbers: ");
            ft_PrintReturnInfo(ft_checkInput(scanner));
        }
        else
            System.err.println("You must choose between 1 or 2!");

        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning == true)
        {
            isRunning = ft_executeUserChoice(scanner);
        }
        scanner.close();
    }
}
