import java.util.Scanner;
import java.util.HashMap;


public class Sudoku {
    Scanner _scanner = new Scanner(System.in);
    int[] _userInput= new int[2];

    public void ft_parseUserInput()
    {
        String strUserInput = "";

        try
        {
            strUserInput = _scanner.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Error\n");
            _scanner.nextLine();
            return ;
        }

        if (strUserInput.length() != 3 || !Character.isDigit(strUserInput.charAt(0)) ||
            strUserInput.charAt(1) != ' ' || !Character.isDigit(strUserInput.charAt(2)))
        {
            System.out.println("Error\n");
            return ;
        }
    }

    public void ft_menu()
    {
        System.err.println("Escolha opcao: \r\n" + //
                        "1. 0 - Sair \r\n" + //
                        "2. 1 - Aplicar permutacao de dois numeros \r\n" + //
                        "3. 2 - Aplicar permutacao de duas linhas de uma mesma faixa horizontal \r\n" + //
                        "4. 3 - Aplicar permutacao de duas colunas de uma mesma faixa vertical \r\n" + //
                        "5. 4 - Aplicar permutacao de duas faixas horizontais\r\n" + //
                        "6. 5 - Aplicar permutacao de duas faixas verticais \r\n" + //
                        "7. 6 - Aplicar reflexao horizontal \r\n" + //
                        "8. 7 - Aplicar reflexao vertical\r\n" + //
                        "9. 8 - Indicar quadricula");
    }
    
    public static void main(String[] args)
    {
        Sudoku sudokuGame = new Sudoku();
        boolean isrunning = true;
        while (isrunning)
        {
            ;
        }
        sudokuGame._scanner.close();
    }
}
