package hashdict;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

//Controls the text box GUI where users can enter in any text.

public class EnterTextBoxController implements Initializable {

    @FXML private TextArea incorrectlist;
    @FXML private Button exitbtn;
    @FXML private TextArea inputtxt;

    
    @FXML
    public void handleCheckButton(ActionEvent e){
        String[] S;
        String noPunct;
        noPunct=inputtxt.getText().replace("\n"," ");
        noPunct=noPunct.replace(",","").replace(".","");
        noPunct=noPunct.replace("?","").replace(";", "");
        noPunct=noPunct.replace(":", "");
        S = noPunct.split(" ");
        incorrectlist.clear();
        for(String i : S) {
            if(!HashDict.check.contains(i)) {
                incorrectlist.appendText(i + " ");
            }
        }
    }
    
    @FXML
    public void handleClearButton(ActionEvent e){
        inputtxt.clear();
    }
    
    @FXML
    public void handleExitButton(ActionEvent e) {
        Stage stage = (Stage) exitbtn.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}
