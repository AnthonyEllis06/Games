package Checkers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
//----------------------------------------------------------------------------
// File name: CheckerTransferable.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: CheckerTransferable <br>
 * Class Purpose: Determines if a checker is transferable  <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Anthony Ellis
 */
public class CheckerTransferable implements Transferable {

    static DataFlavor checker_flavor; //creates a new checker flavor to be checked
   // creates new data flavor called Checker and catches an exception if the correct class isn't found
    static{
        try {
            checker_flavor = new DataFlavor(Class.forName("Checkers.Checker"),"Checker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Checker checker; //creates a new checker
    /**
     * Method Name: CheckerTransferable <br>
     * Method Purpose: sets the checker to be transferable <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param checker checker tile
     *
     */
    public CheckerTransferable(Checker checker){
        this.checker=checker;
    }

    /**
     * Method Name: getTransferData <br>
     * Method Purpose: gets the checker flavor and returns it if its equal to flavor<br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param flavor flavor of the checker
     */
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
       //if checker flavor equals flavor then return the checker otherwise throw exception up the chain
        if(flavor.equals(checker_flavor)){
            return checker;
        }
        else{
            throw new UnsupportedFlavorException(flavor);
        }
    }

    /**
     * Method Name: getTransferDataFlavors <br>
     * Method Purpose: an array of all the checker flavors<br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @return DataFlavor[] returns an array of flavors
     */
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] flavors = {checker_flavor};
        return flavors;
    }
    /**
     * Method Name: isDataFlavorSupported <br>
     * Method Purpose: sends the checker's flavor
     * <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param flavor
     * @return  checker flavor
     */
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(checker_flavor);
    }


}
