import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Create a Scanner to read user's input
		Scanner input = new Scanner(System.in);

		// Get user's text file path
		System.out.println("Enter the full path name of the text file you wish to spell check: ");
		String textFilePathString = input.nextLine();

		// Get user's dictionary file path
		System.out.println("Enter the file path for the Dictionary text file you wish to use: ");
		String dictionaryFilePathString = input.nextLine();

		// Close input Scanner
		input.close();

		try
		{
			// Create a scanners for for the files
			Scanner fileReader = new Scanner(new File(textFilePathString));
			Scanner dictionaryReader = new Scanner(new File(dictionaryFilePathString));

			// Create arraylist for the words in both files
			List<String> textFileWords = new ArrayList<String>();
			List<String> dictionaryWordList = new ArrayList<String>();

			// Add each word from the user's text file to the arrayList for that text file
			while (fileReader.hasNext())
			{
				String wordStripped = fileReader.next().replace(".", "");
				textFileWords.add(wordStripped.replaceAll(",", ""));
			}

			// Add each word from the user's dictionary file to the arrayList for that text
			// file
			while (dictionaryReader.hasNext())
			{
				dictionaryWordList.add(dictionaryReader.next().toString());
			}

			// Go through each word in the text file
			for (int i = 0; i < textFileWords.size(); i++)
			{
				// Check each word to see if it is in the dictionary list
				if (dictionaryWordList.contains(textFileWords.get(i).toLowerCase()) == false)
				{
					System.out.println("Unknown word: " + textFileWords.get(i).toString());
				}
			}

			// Close dictionary Scanner
			dictionaryReader.close();

			// Close file Scanner
			fileReader.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
