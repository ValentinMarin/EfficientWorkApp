/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efficientwork;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author marin
 */
public class FXML_EfficientWorkController implements Initializable {
    
    @FXML
    private ImageView btn_settings, btn_charts;
    
    @FXML
    private AnchorPane panel_right_settings, panel_right_charts;
    
    private final HashMap<String, AnchorPane> UIcomponents = new HashMap<>();
    
    @FXML
    private void btn_settings_clicked(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY)
        showComponent("Settings");
    }
    @FXML
    private void btn_settings_dragged(MouseEvent event) {
    }
    
    @FXML
    private void btn_settings_released(MouseEvent event) {
    }
    
    @FXML
    private void btn_charts_clicked(MouseEvent event) {
        showComponent("Charts");
    }
    @FXML
    private void btn_charts_dragged(MouseEvent event) {
    }
    
    @FXML
    private void btn_charts_released(MouseEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initUIcomponentTable();
        addContextMenu();
    }   
    
    private void initUIcomponentTable() {
       UIcomponents.put("Settings", panel_right_settings);
       UIcomponents.put("Charts", panel_right_charts);
    }
    
    private void showComponent(String id) {
        Collection<AnchorPane> list = UIcomponents.values();
        list.forEach((pane) -> {
            pane.setVisible(false);
        });
        

        UIcomponents.get(id).setVisible(true);

    }
    
    private void hideComponent() {
        Collection<AnchorPane> list = UIcomponents.values();
        list.forEach((pane) -> {
            pane.setVisible(false);
        });
    }
    
    final ContextMenu contextMenu = new ContextMenu();
    final MenuItem cMenuAbout = new MenuItem("About");
    final MenuItem cMenuHideInfo = new MenuItem("Hide info");
    SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
    final MenuItem cMenuExit = new MenuItem("Exit");
    
    private void addContextMenu() {
        cMenuAbout.setOnAction((ActionEvent e) -> {
            
        });
        
        cMenuHideInfo.setOnAction((ActionEvent e) -> {
            hideComponent();
        });
        
        cMenuExit.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        
        contextMenu.getItems().addAll(cMenuAbout, cMenuHideInfo, separatorMenuItem, cMenuExit);

        btn_settings.setOnContextMenuRequested(e -> 
            contextMenu.show(btn_settings, e.getScreenX(), e.getScreenY()));
    }
    
}
