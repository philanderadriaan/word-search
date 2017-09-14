
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
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
     * Starts the program.
     *
     * @param args Command line argument.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String[] input_array = readInput(INPUT_FILE_NAME);
        List<Entry<char[][], String>> case_list = getCases(input_array);
        searchAllCases(case_list);
    }

    /**
     * Inputs the file into raw data.
     *
     * @param file_name Name of input file.
     *
     * @return Raw string data.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     * Maps the raw data into data structure for separate cases.
     *
     * @param input Raw input data.
     *
     * @return List of cases containing grid and word to match.
     */
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

    /**
     * Prints the matches for all cases.
     *
     * @param case_list List of all cases.
     */
    private static void searchAllCases(List<Entry<char[][], String>> case_list)
    {

        for (int i = 0; i < case_list.size(); i++)
        {
            System.out.println("Case " + (i + 1) + ": " + searchGrid(case_list.get(i)));
        }

    }

    /**
     * Search the whole grid for matching for the word.
     *
     * @param test_case Test case to be searched.
     *
     * @return Count of all matches for the whole grid.
     */
    private static int searchGrid(Entry<char[][], String> test_case)
    {
        int count = 0;
        char[][] grid = test_case.getKey();
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                count += searchAllDirections(grid, i, j, test_case.getValue());
            }
        }
        return count;
    }

    /**
     * Search word on all 8 directions.
     *
     * @param grid         Word grid.
     * @param row_index    Current row index.
     * @param column_index Current column index.
     * @param word         Word to match.
     *
     * @return Count of matches on all directions.
     */
    private static int searchAllDirections(char[][] grid, int row_index, int column_index, String word)
    {
        int count = 0;
        if (searchOneDirection(grid, row_index, column_index, word, 0, -1, -1))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, -1, 0))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, -1, 1))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, 0, -1))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, 0, 1))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, 1, -1))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, 1, 0))
        {
            count++;
        }
        if (searchOneDirection(grid, row_index, column_index, word, 0, 1, 1))
        {
            count++;
        }
        return count;
    }

    /**
     * Search word on 1 direction.
     *
     * @param grid             Word grid.
     * @param row_index        Current row index.
     * @param column_index     Current column index.
     * @param word             Matching word.
     * @param word_index       Current index on word.
     * @param row_increment    Row to be incremented.
     * @param column_increment Column to be incremented.
     *
     * @return True if word matches.
     */
    public static boolean searchOneDirection(char[][] grid, int row_index, int column_index, String word, int word_index, int row_increment, int column_increment)
    {
        if (row_index < 0 || row_index >= grid.length)
        {
            return false;
        }
        else if (column_index < 0 || column_index >= grid[row_index].length)
        {
            return false;
        }
        else if (word_index < 0 || word_index >= word.length())
        {
            return false;
        }
        else if (word.charAt(word_index) != grid[row_index][column_index])
        {
            return false;
        }
        else if (word_index == word.length() - 1)
        {
            return true;
        }
        else
        {
            return searchOneDirection(grid, row_index + row_increment, column_index + column_increment, word, word_index + 1, row_increment, column_increment);
        }
    }

}
