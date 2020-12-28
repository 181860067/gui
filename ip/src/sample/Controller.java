package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;

public class Controller {

    @FXML
    private TextField IpAddress;

    @FXML
    private TextField PortNum;

    @FXML
    private Button Confirm;

    @FXML
    private Label Message;


    @FXML
    void CompleteInput(ActionEvent event) {
        Effect effect=new DropShadow();
        Effect effect1=new Lighting();
        Confirm.setEffect(effect);
        Confirm.setEffect(effect);
        String IP=IpAddress.getText();
        String Port=PortNum.getText();
        if (IP.isEmpty())
        {
            Message.setText("请输入IP地址。");
            System.out.println("ip");
            IpAddress.clear();
            PortNum.clear();
        }
        else if (Port.isEmpty())
        {
            Message.setText("请输入端口号。");
            System.out.println("port");
            IpAddress.clear();
            PortNum.clear();
        }
        else
        {
            Message.setText("输入成功。");
            System.out.println("输入成功");
        }
    }

}
