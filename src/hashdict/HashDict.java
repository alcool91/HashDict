package hashdict;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.Charset;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

//Final project Wirrten by Dustin Fitzpatrick and Allen Williams.
//Initializes the dictionary and opens the GUI.

public class HashDict extends Application {
    
    public static HashTable check = new HashTable(100003);
    
    @Override
    public void start(Stage mainMenu) throws Exception {
        String s;
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        File f = new File("Dictionary.txt");
        Scene sc = new Scene(root);
        Scanner fileIn = new Scanner(f);
        while (fileIn.hasNext()) {
            s = fileIn.next();
            check.insert(s.replace(".", ""));
        }
        
        mainMenu.getIcons().add(new Image("/images/Utoledo.png"));
        mainMenu.setScene(sc);
        mainMenu.show();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        launch(args);
    }
}
