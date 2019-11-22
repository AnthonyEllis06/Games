package Checkers;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CheckerTransferable implements Transferable {
    static DataFlavor checker_flavor;
    static{
        try {
            checker_flavor = new DataFlavor(Class.forName("Checkers.Checker"),"Checker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private Checker checker;
    public CheckerTransferable(Checker checker){
        this.checker=checker;
    }
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if(flavor.equals(checker_flavor)){
            return checker;
        }
        else{
            throw new UnsupportedFlavorException(flavor);
        }
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] flavors = {checker_flavor};
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(checker_flavor);
    }


}
