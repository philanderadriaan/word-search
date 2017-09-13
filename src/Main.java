
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

/**
 * <p>
 * There is a well-known puzzle called Word Search that involves looking for
 * words in a grid of letters. The words are given in a list and can appear in
 * the grid horizontally, vertically, or diagonally in any direction. In this
 * task, you should implement a solver for word search. You will be given grids
 * and a word to search for, and you have to find how many times that word comes
 * out in the grid. Words that are spelled the same backwards and forwards, also
 * known as palindromes, will not be given, so you don’t need to worry about
 * words that match in the exact same spot in two different directions.
 * <p>
 * Input:
 * <p>
 * The first line is the number of test cases T. Each test case will have two
 * numbers N and M, each on their own line given in that order. Following that
 * is N lines of M lowercase letters each representing the grid of letters.
 * Lastly, a word W is given that you must look for.
 * <p>
 * Output:
 * <p>
 * For each test case, output one line of the form “Case C: X” (without the
 * quotes), where C is the case number (starting from 1), and X is how many
 * times the word W appeared in the grid.
 *
 * @author Phil Adriaan
 */
public class Main
{

    private static final String INPUT_FILE_NAME = "input.in";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String[] input = readInput(INPUT_FILE_NAME);
        List<Entry<char[][], String>> cases = getCases(input);
        search(cases);

        //map test cases
        //for each test case
        // search 1st char
        // search all 8 directions
    }

    private static String[] readInput(String file_name) throws FileNotFoundException, IOException
    {
        BufferedReader buffered_reader = new BufferedReader(new FileReader(new File(file_name)));
        List<String> input_list = new ArrayList();
        String line = buffered_reader.readLine();
        while (line != null)
        {
            input_list.add(line);
            line = buffered_reader.readLine();
        }
        return input_list.toArray(new String[input_list.size()]);
    }

    private static List<Entry<char[][], String>> getCases(String[] input)
    {
        List<Entry<char[][], String>> case_list = new ArrayList();
        int t = Integer.parseInt(input[0]);
        if (t < 0 || t > 100)
        {
            System.out.println("T out of range. 1 ≤ T ≤ 100");
        }
        else
        {
            int i = 1;
            while (i < input.length)
            {
                int row = Integer.parseInt(input[i]);
                i++;
                int column = Integer.parseInt(input[i]);
                i++;
                char[][] grid = new char[row][column];
                for (int j = 0; j < row; j++)
                {
                    grid[j] = input[i].toCharArray();
                    i++;
                }

                String word = input[i];
                i++;
                case_list.add(new SimpleEntry(grid, word));
            }
        }

        return case_list;
    }

    private static void search(List<Entry<char[][], String>> cases)
    {
        int case_number = 1;

        for (Entry<char[][], String> i : cases)
        {
            System.out.println("Case: " + case_number);
            for (char[] j : i.getKey())
            {
                System.out.println(Arrays.toString(j));
            }
            System.out.println("Word: " + i.getValue());
            System.out.println();

        }

    }

}
