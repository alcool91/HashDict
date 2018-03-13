package hashdict;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

//Controls the main menu.

public class MainMenuController implements Initializable {
    
    @FXML
    public void handleNotepadButton(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Textchecker UI.fxml"));
        Stage sg = new Stage();
        Scene sc = new Scene(root);
        
        sg.getIcons().add(new Image("/images/Utoledo.png"));
        sg.setScene(sc);
        sg.show();
    }
    
    @FXML
    public void handleFileButton(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("inputFile UI.fxml"));
        Stage sg = new Stage();
        Scene sc = new Scene(root);
        
        sg.getIcons().add(new Image("/images/Utoledo.png"));
        sg.setScene(sc);
        sg.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}