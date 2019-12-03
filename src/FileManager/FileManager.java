package FileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//----------------------------------------------------------------------------
// File name: FileManager.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Amber Stanifer, stanifera@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 12/1/19
// Date of Last Modification: 12/1/19
// ---------------------------------------------------------------------------
/** Class Name: FileManager <br>
 * Class Purpose: This class is demonstrating file handling since it wasn't used within our project <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Amber Stanifer
 */
public class FileManager
{

    /**
     * Method Name: FileHandlingExample <br>
     * Method Purpose: Dummy class demonstrating an example of file handling by using a file reader <br>
     *
     * <hr>
     * Date created: 12/1/19 <br>
     * Date last modified: 12/1/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    public void FileHandlingExample() throws Exception
    {

        int lines; //lines in the file


        FileReader reader = null;
        //check File existence
        try
        {
            reader = new FileReader("text"); //if found insert file text
        }
        catch (FileNotFoundException notFound)
        {
            System.out.println("File not found"); //if not found print the following exception
        }

        //reads from the FileReader until the end
        while ((lines=reader.read())!=-1)
            System.out.print((char)lines);


        reader.close(); //closes file
    }
}
