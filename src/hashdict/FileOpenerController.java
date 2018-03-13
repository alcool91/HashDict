package hashdict;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//Controls the file input GUI where users can choose a file.

public class FileOpenerController implements Initializable{
    
    @FXML private TextArea misspelledwordstxt;
    @FXML private TextArea inputfiletext;
    @FXML private Button exitbtn;
    
    @FXML
    public void handleOpenFileButton(ActionEvent e) throws FileNotFoundException{
        String[] S;
        String noPunct;
        Stage sg = new Stage();
        File f;
        FileChooser fc = new FileChooser();
        Scanner read;
        
        misspelledwordstxt.clear();
        inputfiletext.clear();
        fc.setTitle("Please select a text file");
        f = fc.showOpenDialog(sg);
        read = new Scanner(f);
        
        
        while(read.hasNext()){
            inputfiletext.appendText(read.next() +" ");
        }
        noPunct = inputfiletext.getText().replace("\n", " ");
        noPunct = noPunct.replace(",", "").replace(".", "");
        noPunct = noPunct.replace("?", "").replace(";","");
        noPunct = noPunct.replace(":", "");
        S=noPunct.split(" ");
        for(String i : S) {
            if(!HashDict.check.contains(i)) {
                misspelledwordstxt.appendText(i + " ");
            }
        }
    }
    
    @FXML
    public void handleExitButton(ActionEvent e) {
        Stage sg = (Stage) exitbtn.getScene().getWindow();
        sg.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}
