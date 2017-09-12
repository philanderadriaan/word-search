
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
    }

    private static void search(Object... input)
    {
        try
        {
            int t = (Integer) input[0];
            if (t < 0 || t > 100)
            {
                System.out.println("T out of range. 1 ≤ T ≤ 100");
            }
            else
            {
                int test_case = 1;
                int i = 1;
                while (i < input.length)
                {
                    int row = (Integer) input[i];
                    i++;
                    int column = (Integer) input[i];
                    i++;

                    char[][] grid = new char[row][];
                    for (int j = 0; j < row; j++)
                    {
                        grid[j] = ((String) input[i]).toCharArray();
                    }
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

}
