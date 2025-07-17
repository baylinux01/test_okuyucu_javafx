package baylinux.sagliktest;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class UpdatingExamWindow extends Application {
	protected static Exam examToBeUpdated;
	protected static PreferredSettings ps;
	protected static Label lb0, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,
	lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,
	lb21,lb22,lb23,lb24,lb25,lb26,lb27,lb28,lb29,lb30,
	lb31,lb32,lb33,lb34,lb35,lb36,lb37,lb38,lb39,lb40,
	lb41,lb42,lb43,lb44,lb45,lb46,lb47,lb48,lb49,lb50,
	lb51,lb52,lb53,lb54,lb55,lb56,lb57,lb58,lb59,lb60,lb61,lb62;
	protected static TextField tf1,tf2;
	protected static ComboBox<String> cb_on1,cb_on2,cb_on3,cb_on4,cb_on5,
	cb_on6,cb_on7,cb_on8,cb_on9,cb_on10,cb_on11,cb_on12,cb_on13,cb_on14,cb_on15,
	cb_on16,cb_on17,cb_on18,cb_on19,cb_on20,cb_on21,cb_on22,cb_on23,cb_on24,cb_on25,
	cb_on26,cb_on27,cb_on28,cb_on29,cb_on30,
	cb_son1,cb_son2,cb_son3,cb_son4,cb_son5,cb_son6,cb_son7,cb_son8,cb_son9,cb_son10,
	cb_son11,cb_son12,cb_son13,cb_son14,cb_son15,cb_son16,cb_son17,cb_son18,cb_son19,cb_son20,
	cb_son21,cb_son22,cb_son23,cb_son24,cb_son25,cb_son26,cb_son27,cb_son28,cb_son29,cb_son30;
	protected static Button updateExamButton,goBackButton;
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1100,640);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Pane pane=new Pane();
			pane.setPrefHeight(600);
			pane.setPrefWidth(600);
			pane.setLayoutX(10);
			pane.setLayoutY(10);
			root.getChildren().add(pane);
			
			Dao dao=new Dao();
			ps=dao.getPreferredSettings();
			
			int base_x=0;
			int base_y=0;
			int x_dif=130;
			int y_dif=25;
			
			int standard_element_height=20;
			int standard_element_width=120;
			int lbdif=5;
			
			
			
			lb0=new Label("Sınav Adını Girin");
			lb0.setPrefHeight(standard_element_height);
			lb0.setPrefWidth(standard_element_width);
			lb0.setLayoutX(base_x+x_dif*0);
			lb0.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb0);
			
			tf1=new TextField();
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getName()!=null)
				tf1.setText(examToBeUpdated.getName());
			}
			tf1.setPrefHeight(standard_element_height);
			tf1.setPrefWidth(standard_element_width);
			tf1.setLayoutX(base_x+x_dif*0);
			tf1.setLayoutY(base_y+y_dif);
			pane.getChildren().add(tf1);
			
			lb1=new Label("On Test Cevap-1");
			lb1.setPrefHeight(standard_element_height);
			lb1.setPrefWidth(standard_element_width);
			lb1.setLayoutX(base_x+x_dif*1);
			lb1.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb1);
			
			cb_on1=new ComboBox<String>();
			cb_on1.setPrefHeight(standard_element_height);
			cb_on1.setPrefWidth(standard_element_width);
			cb_on1.setLayoutX(base_x+x_dif);
			cb_on1.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_on1);
			cb_on1.getItems().clear();
			cb_on1.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn1()!=null)
				cb_on1.getSelectionModel().select(examToBeUpdated.getOn1());
			}
			
			lb2=new Label("On Test Cevap-2");
			lb2.setPrefHeight(standard_element_height);
			lb2.setPrefWidth(standard_element_width);
			lb2.setLayoutX(base_x+x_dif);
			lb2.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb2);
			
			cb_on2=new ComboBox<String>();
			cb_on2.setPrefHeight(standard_element_height);
			cb_on2.setPrefWidth(standard_element_width);
			cb_on2.setLayoutX(base_x+x_dif);
			cb_on2.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_on2);
			cb_on2.getItems().clear();
			cb_on2.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn2()!=null)
				cb_on2.getSelectionModel().select(examToBeUpdated.getOn2());
			}
			
			
			lb3=new Label("On Test Cevap-3");
			lb3.setPrefHeight(standard_element_height);
			lb3.setPrefWidth(standard_element_width);
			lb3.setLayoutX(base_x+x_dif);
			lb3.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb3);
			
			cb_on3=new ComboBox<String>();
			cb_on3.setPrefHeight(standard_element_height);
			cb_on3.setPrefWidth(standard_element_width);
			cb_on3.setLayoutX(base_x+x_dif);
			cb_on3.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_on3);
			cb_on3.getItems().clear();
			cb_on3.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn3()!=null)
				cb_on3.getSelectionModel().select(examToBeUpdated.getOn3());
			}
			
			
			lb4=new Label("On Test Cevap-4");
			lb4.setPrefHeight(standard_element_height);
			lb4.setPrefWidth(standard_element_width);
			lb4.setLayoutX(base_x+x_dif);
			lb4.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb4);
			
			cb_on4=new ComboBox<String>();
			cb_on4.setPrefHeight(standard_element_height);
			cb_on4.setPrefWidth(standard_element_width);
			cb_on4.setLayoutX(base_x+x_dif);
			cb_on4.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_on4);
			cb_on4.getItems().clear();
			cb_on4.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn4()!=null)
				cb_on4.getSelectionModel().select(examToBeUpdated.getOn4());
			}
			
			
			lb5=new Label("On Test Cevap-5");
			lb5.setPrefHeight(standard_element_height);
			lb5.setPrefWidth(standard_element_width);
			lb5.setLayoutX(base_x+x_dif);
			lb5.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb5);
			
			cb_on5=new ComboBox<String>();
			cb_on5.setPrefHeight(standard_element_height);
			cb_on5.setPrefWidth(standard_element_width);
			cb_on5.setLayoutX(base_x+x_dif);
			cb_on5.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_on5);
			cb_on5.getItems().clear();
			cb_on5.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn5()!=null)
				cb_on5.getSelectionModel().select(examToBeUpdated.getOn5());
			}
			
			lb6=new Label("On Test Cevap-6");
			lb6.setPrefHeight(standard_element_height);
			lb6.setPrefWidth(standard_element_width);
			lb6.setLayoutX(base_x+x_dif);
			lb6.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb6);
			
			cb_on6=new ComboBox<String>();
			cb_on6.setPrefHeight(standard_element_height);
			cb_on6.setPrefWidth(standard_element_width);
			cb_on6.setLayoutX(base_x+x_dif);
			cb_on6.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_on6);
			cb_on6.getItems().clear();
			cb_on6.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn6()!=null)
				cb_on6.getSelectionModel().select(examToBeUpdated.getOn6());
			}
			
			lb7=new Label("On Test Cevap-7");
			lb7.setPrefHeight(standard_element_height);
			lb7.setPrefWidth(standard_element_width);
			lb7.setLayoutX(base_x+x_dif);
			lb7.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb7);
			
			cb_on7=new ComboBox<String>();
			cb_on7.setPrefHeight(standard_element_height);
			cb_on7.setPrefWidth(standard_element_width);
			cb_on7.setLayoutX(base_x+x_dif);
			cb_on7.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_on7);
			cb_on7.getItems().clear();
			cb_on7.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn7()!=null)
				cb_on7.getSelectionModel().select(examToBeUpdated.getOn7());
			}
			
			lb8=new Label("On Test Cevap-8");
			lb8.setPrefHeight(standard_element_height);
			lb8.setPrefWidth(standard_element_width);
			lb8.setLayoutX(base_x+x_dif);
			lb8.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb8);
			
			cb_on8=new ComboBox<String>();
			cb_on8.setPrefHeight(standard_element_height);
			cb_on8.setPrefWidth(standard_element_width);
			cb_on8.setLayoutX(base_x+x_dif);
			cb_on8.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_on8);
			cb_on8.getItems().clear();
			cb_on8.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn8()!=null)
				cb_on8.getSelectionModel().select(examToBeUpdated.getOn8());
			}
			
			lb9=new Label("On Test Cevap-9");
			lb9.setPrefHeight(standard_element_height);
			lb9.setPrefWidth(standard_element_width);
			lb9.setLayoutX(base_x+x_dif);
			lb9.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb9);
			
			cb_on9=new ComboBox<String>();
			cb_on9.setPrefHeight(standard_element_height);
			cb_on9.setPrefWidth(standard_element_width);
			cb_on9.setLayoutX(base_x+x_dif);
			cb_on9.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_on9);
			cb_on9.getItems().clear();
			cb_on9.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn9()!=null)
				cb_on9.getSelectionModel().select(examToBeUpdated.getOn9());
			}
			
			lb10=new Label("On Test Cevap-10");
			lb10.setPrefHeight(standard_element_height);
			lb10.setPrefWidth(standard_element_width);
			lb10.setLayoutX(base_x+x_dif);
			lb10.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb10);
			
			cb_on10=new ComboBox<String>();
			cb_on10.setPrefHeight(standard_element_height);
			cb_on10.setPrefWidth(standard_element_width);
			cb_on10.setLayoutX(base_x+x_dif);
			cb_on10.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_on10);
			cb_on10.getItems().clear();
			cb_on10.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn10()!=null)
				cb_on10.getSelectionModel().select(examToBeUpdated.getOn10());
			}
			
			lb11=new Label("On Test Cevap-11");
			lb11.setPrefHeight(standard_element_height);
			lb11.setPrefWidth(standard_element_width);
			lb11.setLayoutX(base_x+x_dif);
			lb11.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb11);
			
			cb_on11=new ComboBox<String>();
			cb_on11.setPrefHeight(standard_element_height);
			cb_on11.setPrefWidth(standard_element_width);
			cb_on11.setLayoutX(base_x+x_dif);
			cb_on11.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_on11);
			cb_on11.getItems().clear();
			cb_on11.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn11()!=null)
				cb_on11.getSelectionModel().select(examToBeUpdated.getOn11());
			}
			
			lb12=new Label("On Test Cevap-12");
			lb12.setPrefHeight(standard_element_height);
			lb12.setPrefWidth(standard_element_width);
			lb12.setLayoutX(base_x+x_dif);
			lb12.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb12);
			
			cb_on12=new ComboBox<String>();
			cb_on12.setPrefHeight(standard_element_height);
			cb_on12.setPrefWidth(standard_element_width);
			cb_on12.setLayoutX(base_x+x_dif);
			cb_on12.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_on12);
			cb_on12.getItems().clear();
			cb_on12.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn12()!=null)
				cb_on12.getSelectionModel().select(examToBeUpdated.getOn12());
			}
			
			lb13=new Label("On Test Cevap-13");
			lb13.setPrefHeight(standard_element_height);
			lb13.setPrefWidth(standard_element_width);
			lb13.setLayoutX(base_x+x_dif*2);
			lb13.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb13);
			
			cb_on13=new ComboBox<String>();
			cb_on13.setPrefHeight(standard_element_height);
			cb_on13.setPrefWidth(standard_element_width);
			cb_on13.setLayoutX(base_x+x_dif*2);
			cb_on13.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_on13);
			cb_on13.getItems().clear();
			cb_on13.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn13()!=null)
				cb_on13.getSelectionModel().select(examToBeUpdated.getOn13());
			}
			
			lb14=new Label("On Test Cevap-14");
			lb14.setPrefHeight(standard_element_height);
			lb14.setPrefWidth(standard_element_width);
			lb14.setLayoutX(base_x+x_dif*2);
			lb14.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb14);
			
			cb_on14=new ComboBox<String>();
			cb_on14.setPrefHeight(standard_element_height);
			cb_on14.setPrefWidth(standard_element_width);
			cb_on14.setLayoutX(base_x+x_dif*2);
			cb_on14.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_on14);
			cb_on14.getItems().clear();
			cb_on14.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn14()!=null)
				cb_on14.getSelectionModel().select(examToBeUpdated.getOn14());
			}
			
			lb15=new Label("On Test Cevap-15");
			lb15.setPrefHeight(standard_element_height);
			lb15.setPrefWidth(standard_element_width);
			lb15.setLayoutX(base_x+x_dif*2);
			lb15.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb15);
			
			cb_on15=new ComboBox<String>();
			cb_on15.setPrefHeight(standard_element_height);
			cb_on15.setPrefWidth(standard_element_width);
			cb_on15.setLayoutX(base_x+x_dif*2);
			cb_on15.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_on15);
			cb_on15.getItems().clear();
			cb_on15.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn15()!=null)
				cb_on15.getSelectionModel().select(examToBeUpdated.getOn15());
			}
			
			lb16=new Label("On Test Cevap-16");
			lb16.setPrefHeight(standard_element_height);
			lb16.setPrefWidth(standard_element_width);
			lb16.setLayoutX(base_x+x_dif*2);
			lb16.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb16);
			
			cb_on16=new ComboBox<String>();
			cb_on16.setPrefHeight(standard_element_height);
			cb_on16.setPrefWidth(standard_element_width);
			cb_on16.setLayoutX(base_x+x_dif*2);
			cb_on16.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_on16);
			cb_on16.getItems().clear();
			cb_on16.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn16()!=null)
				cb_on16.getSelectionModel().select(examToBeUpdated.getOn16());
			}
			
			lb17=new Label("On Test Cevap-17");
			lb17.setPrefHeight(standard_element_height);
			lb17.setPrefWidth(standard_element_width);
			lb17.setLayoutX(base_x+x_dif*2);
			lb17.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb17);
			
			cb_on17=new ComboBox<String>();
			cb_on17.setPrefHeight(standard_element_height);
			cb_on17.setPrefWidth(standard_element_width);
			cb_on17.setLayoutX(base_x+x_dif*2);
			cb_on17.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_on17);
			cb_on17.getItems().clear();
			cb_on17.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn17()!=null)
				cb_on17.getSelectionModel().select(examToBeUpdated.getOn17());
			}
			
			lb18=new Label("On Test Cevap-18");
			lb18.setPrefHeight(standard_element_height);
			lb18.setPrefWidth(standard_element_width);
			lb18.setLayoutX(base_x+x_dif*2);
			lb18.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb18);
			
			cb_on18=new ComboBox<String>();
			cb_on18.setPrefHeight(standard_element_height);
			cb_on18.setPrefWidth(standard_element_width);
			cb_on18.setLayoutX(base_x+x_dif*2);
			cb_on18.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_on18);
			cb_on18.getItems().clear();
			cb_on18.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn18()!=null)
				cb_on18.getSelectionModel().select(examToBeUpdated.getOn18());
			}
			
			lb19=new Label("On Test Cevap-19");
			lb19.setPrefHeight(standard_element_height);
			lb19.setPrefWidth(standard_element_width);
			lb19.setLayoutX(base_x+x_dif*2);
			lb19.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb19);
			
			cb_on19=new ComboBox<String>();
			cb_on19.setPrefHeight(standard_element_height);
			cb_on19.setPrefWidth(standard_element_width);
			cb_on19.setLayoutX(base_x+x_dif*2);
			cb_on19.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_on19);
			cb_on19.getItems().clear();
			cb_on19.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn19()!=null)
				cb_on19.getSelectionModel().select(examToBeUpdated.getOn19());
			}
			
			lb20=new Label("On Test Cevap-20");
			lb20.setPrefHeight(standard_element_height);
			lb20.setPrefWidth(standard_element_width);
			lb20.setLayoutX(base_x+x_dif*2);
			lb20.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb20);
			
			cb_on20=new ComboBox<String>();
			cb_on20.setPrefHeight(standard_element_height);
			cb_on20.setPrefWidth(standard_element_width);
			cb_on20.setLayoutX(base_x+x_dif*2);
			cb_on20.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_on20);
			cb_on20.getItems().clear();
			cb_on20.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn20()!=null)
				cb_on20.getSelectionModel().select(examToBeUpdated.getOn20());
			}
			
			lb21=new Label("On Test Cevap-21");
			lb21.setPrefHeight(standard_element_height);
			lb21.setPrefWidth(standard_element_width);
			lb21.setLayoutX(base_x+x_dif*2);
			lb21.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb21);
			
			cb_on21=new ComboBox<String>();
			cb_on21.setPrefHeight(standard_element_height);
			cb_on21.setPrefWidth(standard_element_width);
			cb_on21.setLayoutX(base_x+x_dif*2);
			cb_on21.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_on21);
			cb_on21.getItems().clear();
			cb_on21.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn21()!=null)
				cb_on21.getSelectionModel().select(examToBeUpdated.getOn21());
			}
			
			lb22=new Label("On Test Cevap-22");
			lb22.setPrefHeight(standard_element_height);
			lb22.setPrefWidth(standard_element_width);
			lb22.setLayoutX(base_x+x_dif*2);
			lb22.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb22);
			
			cb_on22=new ComboBox<String>();
			cb_on22.setPrefHeight(standard_element_height);
			cb_on22.setPrefWidth(standard_element_width);
			cb_on22.setLayoutX(base_x+x_dif*2);
			cb_on22.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_on22);
			cb_on22.getItems().clear();
			cb_on22.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn22()!=null)
				cb_on22.getSelectionModel().select(examToBeUpdated.getOn22());
			}
			
			lb23=new Label("On Test Cevap-23");
			lb23.setPrefHeight(standard_element_height);
			lb23.setPrefWidth(standard_element_width);
			lb23.setLayoutX(base_x+x_dif*2);
			lb23.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb23);
			
			cb_on23=new ComboBox<String>();
			cb_on23.setPrefHeight(standard_element_height);
			cb_on23.setPrefWidth(standard_element_width);
			cb_on23.setLayoutX(base_x+x_dif*2);
			cb_on23.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_on23);
			cb_on23.getItems().clear();
			cb_on23.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn23()!=null)
				cb_on23.getSelectionModel().select(examToBeUpdated.getOn23());
			}
			
			lb24=new Label("On Test Cevap-24");
			lb24.setPrefHeight(standard_element_height);
			lb24.setPrefWidth(standard_element_width);
			lb24.setLayoutX(base_x+x_dif*2);
			lb24.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb24);
			
			cb_on24=new ComboBox<String>();
			cb_on24.setPrefHeight(standard_element_height);
			cb_on24.setPrefWidth(standard_element_width);
			cb_on24.setLayoutX(base_x+x_dif*2);
			cb_on24.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_on24);
			cb_on24.getItems().clear();
			cb_on24.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn24()!=null)
				cb_on24.getSelectionModel().select(examToBeUpdated.getOn24());
			}
			
			lb25=new Label("On Test Cevap-25");
			lb25.setPrefHeight(standard_element_height);
			lb25.setPrefWidth(standard_element_width);
			lb25.setLayoutX(base_x+x_dif*3);
			lb25.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb25);
			
			cb_on25=new ComboBox<String>();
			cb_on25.setPrefHeight(standard_element_height);
			cb_on25.setPrefWidth(standard_element_width);
			cb_on25.setLayoutX(base_x+x_dif*3);
			cb_on25.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_on25);
			cb_on25.getItems().clear();
			cb_on25.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn25()!=null)
				cb_on25.getSelectionModel().select(examToBeUpdated.getOn25());
			}
			
			lb26=new Label("On Test Cevap-26");
			lb26.setPrefHeight(standard_element_height);
			lb26.setPrefWidth(standard_element_width);
			lb26.setLayoutX(base_x+x_dif*3);
			lb26.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb26);
			
			cb_on26=new ComboBox<String>();
			cb_on26.setPrefHeight(standard_element_height);
			cb_on26.setPrefWidth(standard_element_width);
			cb_on26.setLayoutX(base_x+x_dif*3);
			cb_on26.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_on26);
			cb_on26.getItems().clear();
			cb_on26.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn26()!=null)
				cb_on26.getSelectionModel().select(examToBeUpdated.getOn26());
			}
			
			lb27=new Label("On Test Cevap-27");
			lb27.setPrefHeight(standard_element_height);
			lb27.setPrefWidth(standard_element_width);
			lb27.setLayoutX(base_x+x_dif*3);
			lb27.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb27);
			
			cb_on27=new ComboBox<String>();
			cb_on27.setPrefHeight(standard_element_height);
			cb_on27.setPrefWidth(standard_element_width);
			cb_on27.setLayoutX(base_x+x_dif*3);
			cb_on27.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_on27);
			cb_on27.getItems().clear();
			cb_on27.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn27()!=null)
				cb_on27.getSelectionModel().select(examToBeUpdated.getOn27());
			}
			
			lb28=new Label("On Test Cevap-28");
			lb28.setPrefHeight(standard_element_height);
			lb28.setPrefWidth(standard_element_width);
			lb28.setLayoutX(base_x+x_dif*3);
			lb28.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb28);
			
			cb_on28=new ComboBox<String>();
			cb_on28.setPrefHeight(standard_element_height);
			cb_on28.setPrefWidth(standard_element_width);
			cb_on28.setLayoutX(base_x+x_dif*3);
			cb_on28.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_on28);
			cb_on28.getItems().clear();
			cb_on28.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn28()!=null)
				cb_on28.getSelectionModel().select(examToBeUpdated.getOn28());
			}
			
			lb29=new Label("On Test Cevap-29");
			lb29.setPrefHeight(standard_element_height);
			lb29.setPrefWidth(standard_element_width);
			lb29.setLayoutX(base_x+x_dif*3);
			lb29.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb29);
			
			cb_on29=new ComboBox<String>();
			cb_on29.setPrefHeight(standard_element_height);
			cb_on29.setPrefWidth(standard_element_width);
			cb_on29.setLayoutX(base_x+x_dif*3);
			cb_on29.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_on29);
			cb_on29.getItems().clear();
			cb_on29.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn29()!=null)
				cb_on29.getSelectionModel().select(examToBeUpdated.getOn29());
			}
			
			lb30=new Label("On Test Cevap-30");
			lb30.setPrefHeight(standard_element_height);
			lb30.setPrefWidth(standard_element_width);
			lb30.setLayoutX(base_x+x_dif*3);
			lb30.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb30);
			
			cb_on30=new ComboBox<String>();
			cb_on30.setPrefHeight(standard_element_height);
			cb_on30.setPrefWidth(standard_element_width);
			cb_on30.setLayoutX(base_x+x_dif*3);
			cb_on30.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_on30);
			cb_on30.getItems().clear();
			cb_on30.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getOn30()!=null)
				cb_on30.getSelectionModel().select(examToBeUpdated.getOn30());
			}
			
			lb31=new Label("Son Test Cevap-1");
			lb31.setPrefHeight(standard_element_height);
			lb31.setPrefWidth(standard_element_width);
			lb31.setLayoutX(base_x+x_dif*4);
			lb31.setLayoutY(base_y+lbdif);
			pane.getChildren().add(lb31);
			
			cb_son1=new ComboBox<String>();
			cb_son1.setPrefHeight(standard_element_height);
			cb_son1.setPrefWidth(standard_element_width);
			cb_son1.setLayoutX(base_x+x_dif*4);
			cb_son1.setLayoutY(base_y+y_dif);
			pane.getChildren().add(cb_son1);
			cb_son1.getItems().clear();
			cb_son1.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon1()!=null)
				cb_son1.getSelectionModel().select(examToBeUpdated.getSon1());
			}
			
			lb32=new Label("Son Test Cevap-2");
			lb32.setPrefHeight(standard_element_height);
			lb32.setPrefWidth(standard_element_width);
			lb32.setLayoutX(base_x+x_dif*4);
			lb32.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb32);
			
			cb_son2=new ComboBox<String>();
			cb_son2.setPrefHeight(standard_element_height);
			cb_son2.setPrefWidth(standard_element_width);
			cb_son2.setLayoutX(base_x+x_dif*4);
			cb_son2.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_son2);
			cb_son2.getItems().clear();
			cb_son2.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon2()!=null)
				cb_son2.getSelectionModel().select(examToBeUpdated.getSon2());
			}
			
			lb33=new Label("Son Test Cevap-3");
			lb33.setPrefHeight(standard_element_height);
			lb33.setPrefWidth(standard_element_width);
			lb33.setLayoutX(base_x+x_dif*4);
			lb33.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb33);
			
			cb_son3=new ComboBox<String>();
			cb_son3.setPrefHeight(standard_element_height);
			cb_son3.setPrefWidth(standard_element_width);
			cb_son3.setLayoutX(base_x+x_dif*4);
			cb_son3.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_son3);
			cb_son3.getItems().clear();
			cb_son3.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon3()!=null)
				cb_son3.getSelectionModel().select(examToBeUpdated.getSon3());
			}
			
			lb34=new Label("Son Test Cevap-4");
			lb34.setPrefHeight(standard_element_height);
			lb34.setPrefWidth(standard_element_width);
			lb34.setLayoutX(base_x+x_dif*4);
			lb34.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb34);
			
			cb_son4=new ComboBox<String>();
			cb_son4.setPrefHeight(standard_element_height);
			cb_son4.setPrefWidth(standard_element_width);
			cb_son4.setLayoutX(base_x+x_dif*4);
			cb_son4.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_son4);
			cb_son4.getItems().clear();
			cb_son4.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon4()!=null)
				cb_son4.getSelectionModel().select(examToBeUpdated.getSon4());
			}
			
			lb35=new Label("Son Test Cevap-5");
			lb35.setPrefHeight(standard_element_height);
			lb35.setPrefWidth(standard_element_width);
			lb35.setLayoutX(base_x+x_dif*4);
			lb35.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb35);
			
			cb_son5=new ComboBox<String>();
			cb_son5.setPrefHeight(standard_element_height);
			cb_son5.setPrefWidth(standard_element_width);
			cb_son5.setLayoutX(base_x+x_dif*4);
			cb_son5.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_son5);
			cb_son5.getItems().clear();
			cb_son5.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon5()!=null)
				cb_son5.getSelectionModel().select(examToBeUpdated.getSon5());
			}
			
			lb36=new Label("Son Test Cevap-6");
			lb36.setPrefHeight(standard_element_height);
			lb36.setPrefWidth(standard_element_width);
			lb36.setLayoutX(base_x+x_dif*4);
			lb36.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb36);
			
			cb_son6=new ComboBox<String>();
			cb_son6.setPrefHeight(standard_element_height);
			cb_son6.setPrefWidth(standard_element_width);
			cb_son6.setLayoutX(base_x+x_dif*4);
			cb_son6.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_son6);
			cb_son6.getItems().clear();
			cb_son6.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon6()!=null)
				cb_son6.getSelectionModel().select(examToBeUpdated.getSon6());
			}
			
			lb37=new Label("Son Test Cevap-7");
			lb37.setPrefHeight(standard_element_height);
			lb37.setPrefWidth(standard_element_width);
			lb37.setLayoutX(base_x+x_dif*4);
			lb37.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb37);
			
			cb_son7=new ComboBox<String>();
			cb_son7.setPrefHeight(standard_element_height);
			cb_son7.setPrefWidth(standard_element_width);
			cb_son7.setLayoutX(base_x+x_dif*4);
			cb_son7.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_son7);
			cb_son7.getItems().clear();
			cb_son7.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon7()!=null)
				cb_son7.getSelectionModel().select(examToBeUpdated.getSon7());
			}
			
			lb38=new Label("Son Test Cevap-8");
			lb38.setPrefHeight(standard_element_height);
			lb38.setPrefWidth(standard_element_width);
			lb38.setLayoutX(base_x+x_dif*4);
			lb38.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb38);
			
			cb_son8=new ComboBox<String>();
			cb_son8.setPrefHeight(standard_element_height);
			cb_son8.setPrefWidth(standard_element_width);
			cb_son8.setLayoutX(base_x+x_dif*4);
			cb_son8.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_son8);
			cb_son8.getItems().clear();
			cb_son8.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon8()!=null)
				cb_son8.getSelectionModel().select(examToBeUpdated.getSon8());
			}
			
			lb39=new Label("Son Test Cevap-9");
			lb39.setPrefHeight(standard_element_height);
			lb39.setPrefWidth(standard_element_width);
			lb39.setLayoutX(base_x+x_dif*4);
			lb39.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb39);
			
			cb_son9=new ComboBox<String>();
			cb_son9.setPrefHeight(standard_element_height);
			cb_son9.setPrefWidth(standard_element_width);
			cb_son9.setLayoutX(base_x+x_dif*4);
			cb_son9.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_son9);
			cb_son9.getItems().clear();
			cb_son9.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon9()!=null)
				cb_son9.getSelectionModel().select(examToBeUpdated.getSon9());
			}
			
			lb40=new Label("Son Test Cevap-10");
			lb40.setPrefHeight(standard_element_height);
			lb40.setPrefWidth(standard_element_width);
			lb40.setLayoutX(base_x+x_dif*4);
			lb40.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb40);
			
			cb_son10=new ComboBox<String>();
			cb_son10.setPrefHeight(standard_element_height);
			cb_son10.setPrefWidth(standard_element_width);
			cb_son10.setLayoutX(base_x+x_dif*4);
			cb_son10.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_son10);
			cb_son10.getItems().clear();
			cb_son10.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon10()!=null)
				cb_son10.getSelectionModel().select(examToBeUpdated.getSon10());
			}
			
			lb41=new Label("Son Test Cevap-11");
			lb41.setPrefHeight(standard_element_height);
			lb41.setPrefWidth(standard_element_width);
			lb41.setLayoutX(base_x+x_dif*4);
			lb41.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb41);
			
			cb_son11=new ComboBox<String>();
			cb_son11.setPrefHeight(standard_element_height);
			cb_son11.setPrefWidth(standard_element_width);
			cb_son11.setLayoutX(base_x+x_dif*4);
			cb_son11.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_son11);
			cb_son11.getItems().clear();
			cb_son11.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon11()!=null)
				cb_son11.getSelectionModel().select(examToBeUpdated.getSon11());
			}
			
			lb42=new Label("Son Test Cevap-12");
			lb42.setPrefHeight(standard_element_height);
			lb42.setPrefWidth(standard_element_width);
			lb42.setLayoutX(base_x+x_dif*4);
			lb42.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb42);
			
			cb_son12=new ComboBox<String>();
			cb_son12.setPrefHeight(standard_element_height);
			cb_son12.setPrefWidth(standard_element_width);
			cb_son12.setLayoutX(base_x+x_dif*4);
			cb_son12.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_son12);
			cb_son12.getItems().clear();
			cb_son12.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon12()!=null)
				cb_son12.getSelectionModel().select(examToBeUpdated.getSon12());
			}
			
			lb43=new Label("Son Test Cevap-13");
			lb43.setPrefHeight(standard_element_height);
			lb43.setPrefWidth(standard_element_width);
			lb43.setLayoutX(base_x+x_dif*5);
			lb43.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb43);
			
			cb_son13=new ComboBox<String>();
			cb_son13.setPrefHeight(standard_element_height);
			cb_son13.setPrefWidth(standard_element_width);
			cb_son13.setLayoutX(base_x+x_dif*5);
			cb_son13.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_son13);
			cb_son13.getItems().clear();
			cb_son13.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon13()!=null)
				cb_son13.getSelectionModel().select(examToBeUpdated.getSon13());
			}
			
			lb44=new Label("Son Test Cevap-14");
			lb44.setPrefHeight(standard_element_height);
			lb44.setPrefWidth(standard_element_width);
			lb44.setLayoutX(base_x+x_dif*5);
			lb44.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb44);
			
			cb_son14=new ComboBox<String>();
			cb_son14.setPrefHeight(standard_element_height);
			cb_son14.setPrefWidth(standard_element_width);
			cb_son14.setLayoutX(base_x+x_dif*5);
			cb_son14.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_son14);
			cb_son14.getItems().clear();
			cb_son14.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon14()!=null)
				cb_son14.getSelectionModel().select(examToBeUpdated.getSon14());
			}
			
			lb45=new Label("Son Test Cevap-15");
			lb45.setPrefHeight(standard_element_height);
			lb45.setPrefWidth(standard_element_width);
			lb45.setLayoutX(base_x+x_dif*5);
			lb45.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb45);
			
			cb_son15=new ComboBox<String>();
			cb_son15.setPrefHeight(standard_element_height);
			cb_son15.setPrefWidth(standard_element_width);
			cb_son15.setLayoutX(base_x+x_dif*5);
			cb_son15.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_son15);
			cb_son15.getItems().clear();
			cb_son15.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon15()!=null)
				cb_son15.getSelectionModel().select(examToBeUpdated.getSon15());
			}
			
			lb46=new Label("Son Test Cevap-16");
			lb46.setPrefHeight(standard_element_height);
			lb46.setPrefWidth(standard_element_width);
			lb46.setLayoutX(base_x+x_dif*5);
			lb46.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb46);
			
			cb_son16=new ComboBox<String>();
			cb_son16.setPrefHeight(standard_element_height);
			cb_son16.setPrefWidth(standard_element_width);
			cb_son16.setLayoutX(base_x+x_dif*5);
			cb_son16.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_son16);
			cb_son16.getItems().clear();
			cb_son16.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon16()!=null)
				cb_son16.getSelectionModel().select(examToBeUpdated.getSon16());
			}
			
			lb47=new Label("Son Test Cevap-17");
			lb47.setPrefHeight(standard_element_height);
			lb47.setPrefWidth(standard_element_width);
			lb47.setLayoutX(base_x+x_dif*5);
			lb47.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb47);
			
			cb_son17=new ComboBox<String>();
			cb_son17.setPrefHeight(standard_element_height);
			cb_son17.setPrefWidth(standard_element_width);
			cb_son17.setLayoutX(base_x+x_dif*5);
			cb_son17.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_son17);
			cb_son17.getItems().clear();
			cb_son17.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon17()!=null)
				cb_son17.getSelectionModel().select(examToBeUpdated.getSon17());
			}
			
			lb48=new Label("Son Test Cevap-18");
			lb48.setPrefHeight(standard_element_height);
			lb48.setPrefWidth(standard_element_width);
			lb48.setLayoutX(base_x+x_dif*5);
			lb48.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb48);
			
			cb_son18=new ComboBox<String>();
			cb_son18.setPrefHeight(standard_element_height);
			cb_son18.setPrefWidth(standard_element_width);
			cb_son18.setLayoutX(base_x+x_dif*5);
			cb_son18.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_son18);
			cb_son18.getItems().clear();
			cb_son18.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon18()!=null)
				cb_son18.getSelectionModel().select(examToBeUpdated.getSon18());
			}
			
			lb49=new Label("Son Test Cevap-19");
			lb49.setPrefHeight(standard_element_height);
			lb49.setPrefWidth(standard_element_width);
			lb49.setLayoutX(base_x+x_dif*5);
			lb49.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb49);
			
			cb_son19=new ComboBox<String>();
			cb_son19.setPrefHeight(standard_element_height);
			cb_son19.setPrefWidth(standard_element_width);
			cb_son19.setLayoutX(base_x+x_dif*5);
			cb_son19.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_son19);
			cb_son19.getItems().clear();
			cb_son19.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon19()!=null)
				cb_son19.getSelectionModel().select(examToBeUpdated.getSon19());
			}
			
			lb50=new Label("Son Test Cevap-20");
			lb50.setPrefHeight(standard_element_height);
			lb50.setPrefWidth(standard_element_width);
			lb50.setLayoutX(base_x+x_dif*5);
			lb50.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb50);
			
			cb_son20=new ComboBox<String>();
			cb_son20.setPrefHeight(standard_element_height);
			cb_son20.setPrefWidth(standard_element_width);
			cb_son20.setLayoutX(base_x+x_dif*5);
			cb_son20.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_son20);
			cb_son20.getItems().clear();
			cb_son20.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon20()!=null)
				cb_son20.getSelectionModel().select(examToBeUpdated.getSon20());
			}
			
			lb51=new Label("Son Test Cevap-21");
			lb51.setPrefHeight(standard_element_height);
			lb51.setPrefWidth(standard_element_width);
			lb51.setLayoutX(base_x+x_dif*5);
			lb51.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb51);
			
			cb_son21=new ComboBox<String>();
			cb_son21.setPrefHeight(standard_element_height);
			cb_son21.setPrefWidth(standard_element_width);
			cb_son21.setLayoutX(base_x+x_dif*5);
			cb_son21.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_son21);
			cb_son21.getItems().clear();
			cb_son21.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon21()!=null)
				cb_son21.getSelectionModel().select(examToBeUpdated.getSon21());
			}
			
			lb52=new Label("Son Test Cevap-22");
			lb52.setPrefHeight(standard_element_height);
			lb52.setPrefWidth(standard_element_width);
			lb52.setLayoutX(base_x+x_dif*5);
			lb52.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb52);
			
			cb_son22=new ComboBox<String>();
			cb_son22.setPrefHeight(standard_element_height);
			cb_son22.setPrefWidth(standard_element_width);
			cb_son22.setLayoutX(base_x+x_dif*5);
			cb_son22.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_son22);
			cb_son22.getItems().clear();
			cb_son22.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon22()!=null)
				cb_son22.getSelectionModel().select(examToBeUpdated.getSon22());
			}
			
			lb53=new Label("Son Test Cevap-23");
			lb53.setPrefHeight(standard_element_height);
			lb53.setPrefWidth(standard_element_width);
			lb53.setLayoutX(base_x+x_dif*5);
			lb53.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb53);
			
			cb_son23=new ComboBox<String>();
			cb_son23.setPrefHeight(standard_element_height);
			cb_son23.setPrefWidth(standard_element_width);
			cb_son23.setLayoutX(base_x+x_dif*5);
			cb_son23.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_son23);
			cb_son23.getItems().clear();
			cb_son23.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon23()!=null)
				cb_son23.getSelectionModel().select(examToBeUpdated.getSon23());
			}
			
			lb54=new Label("Son Test Cevap-24");
			lb54.setPrefHeight(standard_element_height);
			lb54.setPrefWidth(standard_element_width);
			lb54.setLayoutX(base_x+x_dif*5);
			lb54.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb54);
			
			cb_son24=new ComboBox<String>();
			cb_son24.setPrefHeight(standard_element_height);
			cb_son24.setPrefWidth(standard_element_width);
			cb_son24.setLayoutX(base_x+x_dif*5);
			cb_son24.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_son24);
			cb_son24.getItems().clear();
			cb_son24.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon24()!=null)
				cb_son24.getSelectionModel().select(examToBeUpdated.getSon24());
			}
			
			lb55=new Label("Son Test Cevap-25");
			lb55.setPrefHeight(standard_element_height);
			lb55.setPrefWidth(standard_element_width);
			lb55.setLayoutX(base_x+x_dif*6);
			lb55.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb55);
			
			cb_son25=new ComboBox<String>();
			cb_son25.setPrefHeight(standard_element_height);
			cb_son25.setPrefWidth(standard_element_width);
			cb_son25.setLayoutX(base_x+x_dif*6);
			cb_son25.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_son25);
			cb_son25.getItems().clear();
			cb_son25.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon25()!=null)
				cb_son25.getSelectionModel().select(examToBeUpdated.getSon25());
			}
			
			lb56=new Label("Son Test Cevap-26");
			lb56.setPrefHeight(standard_element_height);
			lb56.setPrefWidth(standard_element_width);
			lb56.setLayoutX(base_x+x_dif*6);
			lb56.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb56);
			
			cb_son26=new ComboBox<String>();
			cb_son26.setPrefHeight(standard_element_height);
			cb_son26.setPrefWidth(standard_element_width);
			cb_son26.setLayoutX(base_x+x_dif*6);
			cb_son26.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_son26);
			cb_son26.getItems().clear();
			cb_son26.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon26()!=null)
				cb_son26.getSelectionModel().select(examToBeUpdated.getSon26());
			}
			
			lb57=new Label("Son Test Cevap-27");
			lb57.setPrefHeight(standard_element_height);
			lb57.setPrefWidth(standard_element_width);
			lb57.setLayoutX(base_x+x_dif*6);
			lb57.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb57);
			
			cb_son27=new ComboBox<String>();
			cb_son27.setPrefHeight(standard_element_height);
			cb_son27.setPrefWidth(standard_element_width);
			cb_son27.setLayoutX(base_x+x_dif*6);
			cb_son27.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_son27);
			cb_son27.getItems().clear();
			cb_son27.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon27()!=null)
				cb_son27.getSelectionModel().select(examToBeUpdated.getSon27());
			}
			
			lb58=new Label("Son Test Cevap-28");
			lb58.setPrefHeight(standard_element_height);
			lb58.setPrefWidth(standard_element_width);
			lb58.setLayoutX(base_x+x_dif*6);
			lb58.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb58);
			
			cb_son28=new ComboBox<String>();
			cb_son28.setPrefHeight(standard_element_height);
			cb_son28.setPrefWidth(standard_element_width);
			cb_son28.setLayoutX(base_x+x_dif*6);
			cb_son28.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_son28);
			cb_son28.getItems().clear();
			cb_son28.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon28()!=null)
				cb_son28.getSelectionModel().select(examToBeUpdated.getSon28());
			}
			
			lb59=new Label("Son Test Cevap-29");
			lb59.setPrefHeight(standard_element_height);
			lb59.setPrefWidth(standard_element_width);
			lb59.setLayoutX(base_x+x_dif*6);
			lb59.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb59);
			
			cb_son29=new ComboBox<String>();
			cb_son29.setPrefHeight(standard_element_height);
			cb_son29.setPrefWidth(standard_element_width);
			cb_son29.setLayoutX(base_x+x_dif*6);
			cb_son29.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_son29);
			cb_son29.getItems().clear();
			cb_son29.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon29()!=null)
				cb_son29.getSelectionModel().select(examToBeUpdated.getSon29());
			}
			
			lb60=new Label("Son Test Cevap-30");
			lb60.setPrefHeight(standard_element_height);
			lb60.setPrefWidth(standard_element_width);
			lb60.setLayoutX(base_x+x_dif*6);
			lb60.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb60);
			
			cb_son30=new ComboBox<String>();
			cb_son30.setPrefHeight(standard_element_height);
			cb_son30.setPrefWidth(standard_element_width);
			cb_son30.setLayoutX(base_x+x_dif*6);
			cb_son30.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_son30);
			cb_son30.getItems().clear();
			cb_son30.getItems().addAll("A","B","C","D","E");
			if(examToBeUpdated!=null)
			{	if(examToBeUpdated.getSon30()!=null)
				cb_son30.getSelectionModel().select(examToBeUpdated.getSon30());
			}
			
			EventHandler<ActionEvent> updatingExamEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					Dao dao=new Dao();
					int result=-1;
					
					try 
					{
						Exam exam=new Exam();
						exam.setId(examToBeUpdated.getId());
						
						if(tf1.getText()!=null&&tf1.getText().length()>1)
						exam.setName(tf1.getText());
						
						if(cb_on1.getValue()!=null)
							exam.setOn1(cb_on1.getValue());
						else
							exam.setOn1("");
						if(cb_on2.getValue()!=null)
							exam.setOn2(cb_on2.getValue());
						else
							exam.setOn2("");
						if(cb_on3.getValue()!=null)
							exam.setOn3(cb_on3.getValue());
						else
							exam.setOn3("");
						if(cb_on4.getValue()!=null)
							exam.setOn4(cb_on4.getValue());
						else
							exam.setOn4("");
						if(cb_on5.getValue()!=null)
							exam.setOn5(cb_on5.getValue());
						else
							exam.setOn5("");
						if(cb_on6.getValue()!=null)
							exam.setOn6(cb_on6.getValue());
						else
							exam.setOn6("");
						if(cb_on7.getValue()!=null)
							exam.setOn7(cb_on7.getValue());
						else
							exam.setOn7("");
						if(cb_on8.getValue()!=null)
							exam.setOn8(cb_on8.getValue());
						else
							exam.setOn8("");
						if(cb_on9.getValue()!=null)
							exam.setOn9(cb_on9.getValue());
						else
							exam.setOn9("");
						if(cb_on10.getValue()!=null)
							exam.setOn10(cb_on10.getValue());
						else
							exam.setOn10("");
						if(cb_on11.getValue()!=null)
							exam.setOn11(cb_on11.getValue());
						else
							exam.setOn11("");
						if(cb_on12.getValue()!=null)
							exam.setOn12(cb_on12.getValue());
						else
							exam.setOn12("");
						if(cb_on13.getValue()!=null)
							exam.setOn13(cb_on13.getValue());
						else
							exam.setOn13("");
						if(cb_on14.getValue()!=null)
							exam.setOn14(cb_on14.getValue());
						else
							exam.setOn14("");
						if(cb_on15.getValue()!=null)
							exam.setOn15(cb_on15.getValue());
						else
							exam.setOn15("");
						if(cb_on16.getValue()!=null)
							exam.setOn16(cb_on16.getValue());
						else
							exam.setOn16("");
						if(cb_on17.getValue()!=null)
							exam.setOn17(cb_on17.getValue());
						else
							exam.setOn17("");
						if(cb_on18.getValue()!=null)
							exam.setOn18(cb_on18.getValue());
						else
							exam.setOn18("");
						if(cb_on19.getValue()!=null)
							exam.setOn19(cb_on19.getValue());
						else
							exam.setOn19("");
						if(cb_on20.getValue()!=null)
							exam.setOn20(cb_on20.getValue());
						else
							exam.setOn20("");
						if(cb_on21.getValue()!=null)
							exam.setOn21(cb_on21.getValue());
						else
							exam.setOn21("");
						if(cb_on22.getValue()!=null)
							exam.setOn22(cb_on22.getValue());
						else
							exam.setOn22("");
						if(cb_on23.getValue()!=null)
							exam.setOn23(cb_on23.getValue());
						else
							exam.setOn23("");
						if(cb_on24.getValue()!=null)
							exam.setOn24(cb_on24.getValue());
						else
							exam.setOn24("");
						if(cb_on25.getValue()!=null)
							exam.setOn25(cb_on25.getValue());
						else
							exam.setOn25("");
						if(cb_on26.getValue()!=null)
							exam.setOn26(cb_on26.getValue());
						else
							exam.setOn26("");
						if(cb_on27.getValue()!=null)
							exam.setOn27(cb_on27.getValue());
						else
							exam.setOn27("");
						if(cb_on28.getValue()!=null)
							exam.setOn28(cb_on28.getValue());
						else
							exam.setOn28("");
						if(cb_on29.getValue()!=null)
							exam.setOn29(cb_on29.getValue());
						else
							exam.setOn29("");
						if(cb_on30.getValue()!=null)
							exam.setOn30(cb_on30.getValue());
						else
							exam.setOn30("");
						
							if(cb_son1.getValue()!=null)
								exam.setSon1(cb_son1.getValue());
							else
								exam.setSon1("");
							if(cb_son2.getValue()!=null)
								exam.setSon2(cb_son2.getValue());
							else
								exam.setSon2("");
							if(cb_son3.getValue()!=null)
								exam.setSon3(cb_son3.getValue());
							else
								exam.setSon3("");
							if(cb_son4.getValue()!=null)
								exam.setSon4(cb_son4.getValue());
							else
								exam.setSon4("");
							if(cb_son5.getValue()!=null)
								exam.setSon5(cb_son5.getValue());
							else
								exam.setSon5("");
							if(cb_son6.getValue()!=null)
								exam.setSon6(cb_son6.getValue());
							else
								exam.setSon6("");
							if(cb_son7.getValue()!=null)
								exam.setSon7(cb_son7.getValue());
							else
								exam.setSon7("");
							if(cb_son8.getValue()!=null)
								exam.setSon8(cb_son8.getValue());
							else
								exam.setSon8("");
							if(cb_son9.getValue()!=null)
								exam.setSon9(cb_son9.getValue());
							else
								exam.setSon9("");
							if(cb_son10.getValue()!=null)
								exam.setSon10(cb_son10.getValue());
							else
								exam.setSon10("");
							if(cb_son11.getValue()!=null)
								exam.setSon11(cb_son11.getValue());
							else
								exam.setSon11("");
							if(cb_son12.getValue()!=null)
								exam.setSon12(cb_son12.getValue());
							else
								exam.setSon12("");
							if(cb_son13.getValue()!=null)
								exam.setSon13(cb_son13.getValue());
							else
								exam.setSon13("");
							if(cb_son14.getValue()!=null)
								exam.setSon14(cb_son14.getValue());
							else
								exam.setSon14("");
							if(cb_son15.getValue()!=null)
								exam.setSon15(cb_son15.getValue());
							else
								exam.setSon15("");
							if(cb_son16.getValue()!=null)
								exam.setSon16(cb_son16.getValue());
							else
								exam.setSon16("");
							if(cb_son17.getValue()!=null)
								exam.setSon17(cb_son17.getValue());
							else
								exam.setSon17("");
							if(cb_son18.getValue()!=null)
								exam.setSon18(cb_son18.getValue());
							else
								exam.setSon18("");
							if(cb_son19.getValue()!=null)
								exam.setSon19(cb_son19.getValue());
							else
								exam.setSon19("");
							if(cb_son20.getValue()!=null)
								exam.setSon20(cb_son20.getValue());
							else
								exam.setSon20("");
							if(cb_son21.getValue()!=null)
								exam.setSon21(cb_son21.getValue());
							else
								exam.setSon21("");
							if(cb_son22.getValue()!=null)
								exam.setSon22(cb_son22.getValue());
							else
								exam.setSon22("");
							if(cb_son23.getValue()!=null)
								exam.setSon23(cb_son23.getValue());
							else
								exam.setSon23("");
							if(cb_son24.getValue()!=null)
								exam.setSon24(cb_son24.getValue());
							else
								exam.setSon24("");
							if(cb_son25.getValue()!=null)
								exam.setSon25(cb_son25.getValue());
							else
								exam.setSon25("");
							if(cb_son26.getValue()!=null)
								exam.setSon26(cb_son26.getValue());
							else
								exam.setSon26("");
							if(cb_son27.getValue()!=null)
								exam.setSon27(cb_son27.getValue());
							else
								exam.setSon27("");
							if(cb_son28.getValue()!=null)
								exam.setSon28(cb_son28.getValue());
							else
								exam.setSon28("");
							if(cb_son29.getValue()!=null)
								exam.setSon29(cb_son29.getValue());
							else
								exam.setSon29("");
							if(cb_son30.getValue()!=null)
								exam.setSon30(cb_son30.getValue());
							else
								exam.setSon30("");
							
						try 
						{
							result=dao.updateExam(exam);
							List<ParticipantAnswer> paList=dao.getParticipantAnswersByExam(exam);
							paList.stream().forEach(pa->{
								try 
								{
									try 
									{
										pa=ExamEvaluator.updateParticipantAnswerInformation(ps, pa, exam);
									} 
									catch (Exception e) 
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									
									dao.updateParticipantAnswer(pa);
								} 
								catch (SQLException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							});
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						}
						if(result<=0)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setTitle("işlem başarısız");
							alert.setHeaderText("Güncelleme işlemi başarısız");
							alert.setContentText("Girdiğiniz sınav adının benzersiz olduğundan ve en az 2 harf uzunluğunda olduğundan emin olun");
							alert.showAndWait().orElse(null);
						}
						else
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("işlem başarılı");
							alert.setHeaderText("işlem başarıyla tamamlandı");
							alert.setContentText("Sınav başarıyla güncellendi");
							alert.showAndWait().orElse(null);
						}
					} 
					catch (Exception e) 
					{
						Alert alert=new Alert(AlertType.ERROR);
						alert.setTitle("işlem başarısız");
						alert.setHeaderText("Güncelleme işlemi başarısız");
						alert.setContentText("Girdiğiniz sınav adının benzersiz olduğundan ve en az 2 harf uzunluğunda olduğundan emin olun");
						alert.showAndWait().orElse(null);
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			updateExamButton=new Button("Sınavı Güncelle");
			updateExamButton.setPrefHeight(30);
			updateExamButton.setPrefWidth(140);
			updateExamButton.setLayoutX(base_x+x_dif*7);
			updateExamButton.setLayoutY(base_y+y_dif*20);
			pane.getChildren().add(updateExamButton);
			updateExamButton.setOnAction(updatingExamEventHandler);
			
			EventHandler<ActionEvent> goBackToProgramWindowEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					Group root=new Group();
					Scene scene=new Scene(root);
					Stage stage=new Stage();
					stage.setScene(scene);
					stage.getIcons().add(
							new Image(AddingExamWindow.class
							.getResourceAsStream(Main.logo)));
					stage.setTitle("Ana Sayfa");
					ProgramWindow window=new ProgramWindow();
					
					try {
						window.selectedExam=null;
						window.start(stage);
						primaryStage.hide();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			goBackButton=new Button("Ana Sayfa");
			goBackButton.setPrefHeight(30);
			goBackButton.setPrefWidth(140);
			goBackButton.setLayoutX(base_x+x_dif*7);
			goBackButton.setLayoutY(base_y+y_dif*22);
			pane.getChildren().add(goBackButton);
			goBackButton.setOnAction(goBackToProgramWindowEventHandler);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
