package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Text IP;

    public static Text IPaddress;


    public void ChangeContent()
    {
        //TODO
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IPaddress=IP;
        IPaddress.setText("ip地址");
    }
}
