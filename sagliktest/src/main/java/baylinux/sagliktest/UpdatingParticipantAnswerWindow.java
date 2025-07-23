package baylinux.sagliktest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import java.io.ByteArrayInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class UpdatingParticipantAnswerWindow extends Application {
	private static PreferredSettings ps;
	private static Dao dao;
	protected static ParticipantAnswer paToBeUpdated;
	protected static Label lb0a,lb0b, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,
	lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,
	lb21,lb22,lb23,lb24,lb25,lb26,lb27,lb28,lb29,lb30,
	lb31,lb32,lb33,lb34,lb35,lb36,lb37,lb38,lb39,lb40,
	lb41,lb42,lb43,lb44,lb45,lb46,lb47,lb48,lb49,lb50,
	lb51,lb52,lb53,lb54,lb55,lb56,lb57,lb58,lb59,lb60,lb61,lb62;
	protected static TextField tf1a,tf1b,tf2;
	protected static ComboBox<String> cb_kc1,cb_kc2,cb_kc3,cb_kc4,cb_kc5,
	cb_kc6,cb_kc7,cb_kc8,cb_kc9,cb_kc10,cb_kc11,cb_kc12,cb_kc13,cb_kc14,cb_kc15,
	cb_kc16,cb_kc17,cb_kc18,cb_kc19,cb_kc20,cb_kc21,cb_kc22,cb_kc23,cb_kc24,cb_kc25,
	cb_kc26,cb_kc27,cb_kc28,cb_kc29,cb_kc30, cb_test_type,
	cb_son1,cb_son2,cb_son3,cb_son4,cb_son5,cb_son6,cb_son7,cb_son8,cb_son9,cb_son10,
	cb_son11,cb_son12,cb_son13,cb_son14,cb_son15,cb_son16,cb_son17,cb_son18,cb_son19,cb_son20,
	cb_son21,cb_son22,cb_son23,cb_son24,cb_son25,cb_son26,cb_son27,cb_son28,cb_son29,cb_son30;
	protected static Button updateExamButton,goBackButton;
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1300,630);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			EventHandler closeRequestEventHandler=new EventHandler()
			{

				@Override
				public void handle(Event event) {
					Group rootProgramWindow=new Group();
					Scene sceneProgramWindow=new Scene(rootProgramWindow,1300,700);
					Stage stageProgramWindow=new Stage();
					stageProgramWindow.setScene(sceneProgramWindow);
					stageProgramWindow.getIcons().add(
							new Image(ProgramWindow.class
							.getResourceAsStream("hotelLogo.png")));
					
					//stageOpenAidatPayerAddingWindow.show();
					
					ProgramWindow programWindow=new ProgramWindow();
					try {
						//programWindow.language=language;
						programWindow.start(stageProgramWindow);

						
						primaryStage.hide();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
				}
				
			};
			primaryStage.setOnCloseRequest(closeRequestEventHandler);
			
			dao=new Dao();
			ps=dao.getPreferredSettings();
			Pane pane=new Pane();
			pane.setPrefHeight(600);
			pane.setPrefWidth(600);
			pane.setLayoutX(10);
			pane.setLayoutY(10);
			root.getChildren().add(pane);
			
			int base_x=240;
			int base_y=0;
			int x_dif=200;
			int y_dif=25;
			
			int standard_element_height=20;
			int standard_element_width=180;
			int lbdif=5;
			
			byte[] imgBytes = paToBeUpdated.getTest_image();
			Image fxImage=null;
			if (imgBytes != null && imgBytes.length > 0)
			{
				fxImage = new Image(new ByteArrayInputStream(imgBytes));
			}
			    
			ImageView imageView = new ImageView(fxImage);
			imageView.setLayoutX(0);
			imageView.setLayoutY(base_y+y_dif*0);
			imageView.setFitHeight(610);
			imageView.setFitWidth(430);
			pane.getChildren().add(imageView);
			
			lb0a=new Label("Dosya Adı:");
			lb0a.setPrefHeight(standard_element_height);
			lb0a.setPrefWidth(standard_element_width);
			lb0a.setLayoutX(base_x+x_dif*1);
			lb0a.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb0a);
			
			tf1a=new TextField();
			tf1a.setStyle("-fx-font-size: 10");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getFile_name()!=null)
				tf1a.setText(paToBeUpdated.getFile_name());
			}
			tf1a.setPrefHeight(standard_element_height);
			tf1a.setPrefWidth(standard_element_width);
			tf1a.setLayoutX(base_x+x_dif*1);
			tf1a.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(tf1a);
			
			lb0b=new Label("İsim Soyisim:");
			lb0b.setPrefHeight(standard_element_height);
			lb0b.setPrefWidth(standard_element_width);
			lb0b.setLayoutX(base_x+x_dif*1);
			lb0b.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb0b);
			
			tf1b=new TextField();
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getName_surname()!=null)
				tf1b.setText(paToBeUpdated.getName_surname());
			}
			tf1b.setPrefHeight(standard_element_height);
			tf1b.setPrefWidth(standard_element_width);
			tf1b.setLayoutX(base_x+x_dif*1);
			tf1b.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(tf1b);
			
			lb31=new Label("Test Tipi");
			lb31.setPrefHeight(standard_element_height);
			lb31.setPrefWidth(standard_element_width);
			lb31.setLayoutX(base_x+x_dif*1);
			lb31.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb31);
			
			cb_test_type=new ComboBox<String>();
			cb_test_type.setPrefHeight(standard_element_height);
			cb_test_type.setPrefWidth(standard_element_width);
			cb_test_type.setLayoutX(base_x+x_dif*2);
			cb_test_type.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_test_type);
			cb_test_type.getItems().clear();
			cb_test_type.getItems().addAll("ON TEST","SON TEST","TEST");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getTest_type()!=null)
				cb_test_type.getSelectionModel().select(paToBeUpdated.getTest_type());
			}
			
			lb1=new Label("Katılımcı Cevap-1");
			lb1.setPrefHeight(standard_element_height);
			lb1.setPrefWidth(standard_element_width);
			lb1.setLayoutX(base_x+x_dif*2);
			lb1.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb1);
			
			cb_kc1=new ComboBox<String>();
			cb_kc1.setPrefHeight(standard_element_height);
			cb_kc1.setPrefWidth(standard_element_width);
			cb_kc1.setLayoutX(base_x+x_dif*2);
			cb_kc1.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_kc1);
			cb_kc1.getItems().clear();
			cb_kc1.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_1()!=null)
				cb_kc1.getSelectionModel().select(paToBeUpdated.getParticipant_answer_1());
			}
			
			lb2=new Label("Katılımcı Cevap-2");
			lb2.setPrefHeight(standard_element_height);
			lb2.setPrefWidth(standard_element_width);
			lb2.setLayoutX(base_x+x_dif*2);
			lb2.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb2);
			
			cb_kc2=new ComboBox<String>();
			cb_kc2.setPrefHeight(standard_element_height);
			cb_kc2.setPrefWidth(standard_element_width);
			cb_kc2.setLayoutX(base_x+x_dif*2);
			cb_kc2.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_kc2);
			cb_kc2.getItems().clear();
			cb_kc2.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_2()!=null)
				cb_kc2.getSelectionModel().select(paToBeUpdated.getParticipant_answer_2());
			}
			
			
			lb3=new Label("Katılımcı Cevap-3");
			lb3.setPrefHeight(standard_element_height);
			lb3.setPrefWidth(standard_element_width);
			lb3.setLayoutX(base_x+x_dif*2);
			lb3.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb3);
			
			cb_kc3=new ComboBox<String>();
			cb_kc3.setPrefHeight(standard_element_height);
			cb_kc3.setPrefWidth(standard_element_width);
			cb_kc3.setLayoutX(base_x+x_dif*2);
			cb_kc3.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_kc3);
			cb_kc3.getItems().clear();
			cb_kc3.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_3()!=null)
				cb_kc3.getSelectionModel().select(paToBeUpdated.getParticipant_answer_3());
			}
			
			
			lb4=new Label("Katılımcı Cevap-4");
			lb4.setPrefHeight(standard_element_height);
			lb4.setPrefWidth(standard_element_width);
			lb4.setLayoutX(base_x+x_dif*2);
			lb4.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb4);
			
			cb_kc4=new ComboBox<String>();
			cb_kc4.setPrefHeight(standard_element_height);
			cb_kc4.setPrefWidth(standard_element_width);
			cb_kc4.setLayoutX(base_x+x_dif*2);
			cb_kc4.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_kc4);
			cb_kc4.getItems().clear();
			cb_kc4.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_4()!=null)
				cb_kc4.getSelectionModel().select(paToBeUpdated.getParticipant_answer_4());
			}
			
			
			lb5=new Label("Katılımcı Cevap-5");
			lb5.setPrefHeight(standard_element_height);
			lb5.setPrefWidth(standard_element_width);
			lb5.setLayoutX(base_x+x_dif*2);
			lb5.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb5);
			
			cb_kc5=new ComboBox<String>();
			cb_kc5.setPrefHeight(standard_element_height);
			cb_kc5.setPrefWidth(standard_element_width);
			cb_kc5.setLayoutX(base_x+x_dif*2);
			cb_kc5.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_kc5);
			cb_kc5.getItems().clear();
			cb_kc5.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_5()!=null)
				cb_kc5.getSelectionModel().select(paToBeUpdated.getParticipant_answer_5());
			}
			
			lb6=new Label("Katılımcı Cevap-6");
			lb6.setPrefHeight(standard_element_height);
			lb6.setPrefWidth(standard_element_width);
			lb6.setLayoutX(base_x+x_dif*2);
			lb6.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb6);
			
			cb_kc6=new ComboBox<String>();
			cb_kc6.setPrefHeight(standard_element_height);
			cb_kc6.setPrefWidth(standard_element_width);
			cb_kc6.setLayoutX(base_x+x_dif*2);
			cb_kc6.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_kc6);
			cb_kc6.getItems().clear();
			cb_kc6.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_6()!=null)
				cb_kc6.getSelectionModel().select(paToBeUpdated.getParticipant_answer_6());
			}
			
			lb7=new Label("Katılımcı Cevap-7");
			lb7.setPrefHeight(standard_element_height);
			lb7.setPrefWidth(standard_element_width);
			lb7.setLayoutX(base_x+x_dif*2);
			lb7.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb7);
			
			cb_kc7=new ComboBox<String>();
			cb_kc7.setPrefHeight(standard_element_height);
			cb_kc7.setPrefWidth(standard_element_width);
			cb_kc7.setLayoutX(base_x+x_dif*2);
			cb_kc7.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_kc7);
			cb_kc7.getItems().clear();
			cb_kc7.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_7()!=null)
				cb_kc7.getSelectionModel().select(paToBeUpdated.getParticipant_answer_7());
			}
			
			lb8=new Label("Katılımcı Cevap-8");
			lb8.setPrefHeight(standard_element_height);
			lb8.setPrefWidth(standard_element_width);
			lb8.setLayoutX(base_x+x_dif*2);
			lb8.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb8);
			
			cb_kc8=new ComboBox<String>();
			cb_kc8.setPrefHeight(standard_element_height);
			cb_kc8.setPrefWidth(standard_element_width);
			cb_kc8.setLayoutX(base_x+x_dif*2);
			cb_kc8.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_kc8);
			cb_kc8.getItems().clear();
			cb_kc8.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_8()!=null)
				cb_kc8.getSelectionModel().select(paToBeUpdated.getParticipant_answer_8());
			}
			
			lb9=new Label("Katılımcı Cevap-9");
			lb9.setPrefHeight(standard_element_height);
			lb9.setPrefWidth(standard_element_width);
			lb9.setLayoutX(base_x+x_dif*2);
			lb9.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb9);
			
			cb_kc9=new ComboBox<String>();
			cb_kc9.setPrefHeight(standard_element_height);
			cb_kc9.setPrefWidth(standard_element_width);
			cb_kc9.setLayoutX(base_x+x_dif*2);
			cb_kc9.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_kc9);
			cb_kc9.getItems().clear();
			cb_kc9.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_9()!=null)
				cb_kc9.getSelectionModel().select(paToBeUpdated.getParticipant_answer_9());
			}
			
			lb10=new Label("Katılımcı Cevap-10");
			lb10.setPrefHeight(standard_element_height);
			lb10.setPrefWidth(standard_element_width);
			lb10.setLayoutX(base_x+x_dif*2);
			lb10.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb10);
			
			cb_kc10=new ComboBox<String>();
			cb_kc10.setPrefHeight(standard_element_height);
			cb_kc10.setPrefWidth(standard_element_width);
			cb_kc10.setLayoutX(base_x+x_dif*2);
			cb_kc10.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_kc10);
			cb_kc10.getItems().clear();
			cb_kc10.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_10()!=null)
				cb_kc10.getSelectionModel().select(paToBeUpdated.getParticipant_answer_10());
			}
			
			lb11=new Label("Katılımcı Cevap-11");
			lb11.setPrefHeight(standard_element_height);
			lb11.setPrefWidth(standard_element_width);
			lb11.setLayoutX(base_x+x_dif*2);
			lb11.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb11);
			
			cb_kc11=new ComboBox<String>();
			cb_kc11.setPrefHeight(standard_element_height);
			cb_kc11.setPrefWidth(standard_element_width);
			cb_kc11.setLayoutX(base_x+x_dif*2);
			cb_kc11.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_kc11);
			cb_kc11.getItems().clear();
			cb_kc11.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_11()!=null)
				cb_kc11.getSelectionModel().select(paToBeUpdated.getParticipant_answer_11());
			}
			
			lb12=new Label("Katılımcı Cevap-12");
			lb12.setPrefHeight(standard_element_height);
			lb12.setPrefWidth(standard_element_width);
			lb12.setLayoutX(base_x+x_dif*2);
			lb12.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb12);
			
			cb_kc12=new ComboBox<String>();
			cb_kc12.setPrefHeight(standard_element_height);
			cb_kc12.setPrefWidth(standard_element_width);
			cb_kc12.setLayoutX(base_x+x_dif*2);
			cb_kc12.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_kc12);
			cb_kc12.getItems().clear();
			cb_kc12.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_12()!=null)
				cb_kc12.getSelectionModel().select(paToBeUpdated.getParticipant_answer_12());
			}                                                       
			
			lb13=new Label("Katılımcı Cevap-13");
			lb13.setPrefHeight(standard_element_height);
			lb13.setPrefWidth(standard_element_width);
			lb13.setLayoutX(base_x+x_dif*3);
			lb13.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb13);
			
			cb_kc13=new ComboBox<String>();
			cb_kc13.setPrefHeight(standard_element_height);
			cb_kc13.setPrefWidth(standard_element_width);
			cb_kc13.setLayoutX(base_x+x_dif*3);
			cb_kc13.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_kc13);
			cb_kc13.getItems().clear();
			cb_kc13.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getAnswer_correctness_13()!=null)
				cb_kc13.getSelectionModel().select(paToBeUpdated.getParticipant_answer_13());
			}                                      
			
			lb14=new Label("Katılımcı Cevap-14");
			lb14.setPrefHeight(standard_element_height);
			lb14.setPrefWidth(standard_element_width);
			lb14.setLayoutX(base_x+x_dif*3);
			lb14.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb14);
			
			cb_kc14=new ComboBox<String>();
			cb_kc14.setPrefHeight(standard_element_height);
			cb_kc14.setPrefWidth(standard_element_width);
			cb_kc14.setLayoutX(base_x+x_dif*3);
			cb_kc14.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_kc14);
			cb_kc14.getItems().clear();
			cb_kc14.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_14()!=null)
				cb_kc14.getSelectionModel().select(paToBeUpdated.getParticipant_answer_14());
			}
			
			lb15=new Label("Katılımcı Cevap-15");
			lb15.setPrefHeight(standard_element_height);
			lb15.setPrefWidth(standard_element_width);
			lb15.setLayoutX(base_x+x_dif*3);
			lb15.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb15);
			
			cb_kc15=new ComboBox<String>();
			cb_kc15.setPrefHeight(standard_element_height);
			cb_kc15.setPrefWidth(standard_element_width);
			cb_kc15.setLayoutX(base_x+x_dif*3);
			cb_kc15.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_kc15);
			cb_kc15.getItems().clear();
			cb_kc15.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_15()!=null)
				cb_kc15.getSelectionModel().select(paToBeUpdated.getParticipant_answer_15());
			}
			
			lb16=new Label("Katılımcı Cevap-16");
			lb16.setPrefHeight(standard_element_height);
			lb16.setPrefWidth(standard_element_width);
			lb16.setLayoutX(base_x+x_dif*3);
			lb16.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb16);
			
			cb_kc16=new ComboBox<String>();
			cb_kc16.setPrefHeight(standard_element_height);
			cb_kc16.setPrefWidth(standard_element_width);
			cb_kc16.setLayoutX(base_x+x_dif*3);
			cb_kc16.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_kc16);
			cb_kc16.getItems().clear();
			cb_kc16.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_16()!=null)
				cb_kc16.getSelectionModel().select(paToBeUpdated.getParticipant_answer_16());
			}
			
			lb17=new Label("Katılımcı Cevap-17");
			lb17.setPrefHeight(standard_element_height);
			lb17.setPrefWidth(standard_element_width);
			lb17.setLayoutX(base_x+x_dif*3);
			lb17.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb17);
			
			cb_kc17=new ComboBox<String>();
			cb_kc17.setPrefHeight(standard_element_height);
			cb_kc17.setPrefWidth(standard_element_width);
			cb_kc17.setLayoutX(base_x+x_dif*3);
			cb_kc17.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_kc17);
			cb_kc17.getItems().clear();
			cb_kc17.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_17()!=null)
				cb_kc17.getSelectionModel().select(paToBeUpdated.getParticipant_answer_17());
			}
			
			lb18=new Label("Katılımcı Cevap-18");
			lb18.setPrefHeight(standard_element_height);
			lb18.setPrefWidth(standard_element_width);
			lb18.setLayoutX(base_x+x_dif*3);
			lb18.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb18);
			
			cb_kc18=new ComboBox<String>();
			cb_kc18.setPrefHeight(standard_element_height);
			cb_kc18.setPrefWidth(standard_element_width);
			cb_kc18.setLayoutX(base_x+x_dif*3);
			cb_kc18.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_kc18);
			cb_kc18.getItems().clear();
			cb_kc18.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_18()!=null)
				cb_kc18.getSelectionModel().select(paToBeUpdated.getParticipant_answer_18());
			}
			
			lb19=new Label("Katılımcı Cevap-19");
			lb19.setPrefHeight(standard_element_height);
			lb19.setPrefWidth(standard_element_width);
			lb19.setLayoutX(base_x+x_dif*3);
			lb19.setLayoutY(base_y+y_dif*12+lbdif);
			pane.getChildren().add(lb19);
			
			cb_kc19=new ComboBox<String>();
			cb_kc19.setPrefHeight(standard_element_height);
			cb_kc19.setPrefWidth(standard_element_width);
			cb_kc19.setLayoutX(base_x+x_dif*3);
			cb_kc19.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_kc19);
			cb_kc19.getItems().clear();
			cb_kc19.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_19()!=null)
				cb_kc19.getSelectionModel().select(paToBeUpdated.getParticipant_answer_19());
			}
			
			lb20=new Label("Katılımcı Cevap-20");
			lb20.setPrefHeight(standard_element_height);
			lb20.setPrefWidth(standard_element_width);
			lb20.setLayoutX(base_x+x_dif*3);
			lb20.setLayoutY(base_y+y_dif*14+lbdif);
			pane.getChildren().add(lb20);
			
			cb_kc20=new ComboBox<String>();
			cb_kc20.setPrefHeight(standard_element_height);
			cb_kc20.setPrefWidth(standard_element_width);
			cb_kc20.setLayoutX(base_x+x_dif*3);
			cb_kc20.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(cb_kc20);
			cb_kc20.getItems().clear();
			cb_kc20.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_20()!=null)
				cb_kc20.getSelectionModel().select(paToBeUpdated.getParticipant_answer_20());
			}
			
			lb21=new Label("Katılımcı Cevap-21");
			lb21.setPrefHeight(standard_element_height);
			lb21.setPrefWidth(standard_element_width);
			lb21.setLayoutX(base_x+x_dif*3);
			lb21.setLayoutY(base_y+y_dif*16+lbdif);
			pane.getChildren().add(lb21);
			
			cb_kc21=new ComboBox<String>();
			cb_kc21.setPrefHeight(standard_element_height);
			cb_kc21.setPrefWidth(standard_element_width);
			cb_kc21.setLayoutX(base_x+x_dif*3);
			cb_kc21.setLayoutY(base_y+y_dif*17);
			pane.getChildren().add(cb_kc21);
			cb_kc21.getItems().clear();
			cb_kc21.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_21()!=null)
				cb_kc21.getSelectionModel().select(paToBeUpdated.getParticipant_answer_21());
			}
			
			lb22=new Label("Katılımcı Cevap-22");
			lb22.setPrefHeight(standard_element_height);
			lb22.setPrefWidth(standard_element_width);
			lb22.setLayoutX(base_x+x_dif*3);
			lb22.setLayoutY(base_y+y_dif*18+lbdif);
			pane.getChildren().add(lb22);
			
			cb_kc22=new ComboBox<String>();
			cb_kc22.setPrefHeight(standard_element_height);
			cb_kc22.setPrefWidth(standard_element_width);
			cb_kc22.setLayoutX(base_x+x_dif*3);
			cb_kc22.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_kc22);
			cb_kc22.getItems().clear();
			cb_kc22.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_22()!=null)
				cb_kc22.getSelectionModel().select(paToBeUpdated.getParticipant_answer_22());
			}
			
			lb23=new Label("Katılımcı Cevap-23");
			lb23.setPrefHeight(standard_element_height);
			lb23.setPrefWidth(standard_element_width);
			lb23.setLayoutX(base_x+x_dif*3);
			lb23.setLayoutY(base_y+y_dif*20+lbdif);
			pane.getChildren().add(lb23);
			
			cb_kc23=new ComboBox<String>();
			cb_kc23.setPrefHeight(standard_element_height);
			cb_kc23.setPrefWidth(standard_element_width);
			cb_kc23.setLayoutX(base_x+x_dif*3);
			cb_kc23.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(cb_kc23);
			cb_kc23.getItems().clear();
			cb_kc23.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_23()!=null)
				cb_kc23.getSelectionModel().select(paToBeUpdated.getParticipant_answer_23());
			}
			
			lb24=new Label("Katılımcı Cevap-24");
			lb24.setPrefHeight(standard_element_height);
			lb24.setPrefWidth(standard_element_width);
			lb24.setLayoutX(base_x+x_dif*3);
			lb24.setLayoutY(base_y+y_dif*22+lbdif);
			pane.getChildren().add(lb24);
			
			cb_kc24=new ComboBox<String>();
			cb_kc24.setPrefHeight(standard_element_height);
			cb_kc24.setPrefWidth(standard_element_width);
			cb_kc24.setLayoutX(base_x+x_dif*3);
			cb_kc24.setLayoutY(base_y+y_dif*23);
			pane.getChildren().add(cb_kc24);
			cb_kc24.getItems().clear();
			cb_kc24.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_24()!=null)
				cb_kc24.getSelectionModel().select(paToBeUpdated.getParticipant_answer_24());
			}
			
			lb25=new Label("Katılımcı Cevap-25");
			lb25.setPrefHeight(standard_element_height);
			lb25.setPrefWidth(standard_element_width);
			lb25.setLayoutX(base_x+x_dif*4);
			lb25.setLayoutY(base_y+y_dif*0+lbdif);
			pane.getChildren().add(lb25);
			
			cb_kc25=new ComboBox<String>();
			cb_kc25.setPrefHeight(standard_element_height);
			cb_kc25.setPrefWidth(standard_element_width);
			cb_kc25.setLayoutX(base_x+x_dif*4);
			cb_kc25.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_kc25);
			cb_kc25.getItems().clear();
			cb_kc25.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_25()!=null)
				cb_kc25.getSelectionModel().select(paToBeUpdated.getParticipant_answer_25());
			}
			
			lb26=new Label("Katılımcı Cevap-26");
			lb26.setPrefHeight(standard_element_height);
			lb26.setPrefWidth(standard_element_width);
			lb26.setLayoutX(base_x+x_dif*4);
			lb26.setLayoutY(base_y+y_dif*2+lbdif);
			pane.getChildren().add(lb26);
			
			cb_kc26=new ComboBox<String>();
			cb_kc26.setPrefHeight(standard_element_height);
			cb_kc26.setPrefWidth(standard_element_width);
			cb_kc26.setLayoutX(base_x+x_dif*4);
			cb_kc26.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(cb_kc26);
			cb_kc26.getItems().clear();
			cb_kc26.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_26()!=null)
				cb_kc26.getSelectionModel().select(paToBeUpdated.getParticipant_answer_26());
			}
			
			lb27=new Label("Katılımcı Cevap-27");
			lb27.setPrefHeight(standard_element_height);
			lb27.setPrefWidth(standard_element_width);
			lb27.setLayoutX(base_x+x_dif*4);
			lb27.setLayoutY(base_y+y_dif*4+lbdif);
			pane.getChildren().add(lb27);
			
			cb_kc27=new ComboBox<String>();
			cb_kc27.setPrefHeight(standard_element_height);
			cb_kc27.setPrefWidth(standard_element_width);
			cb_kc27.setLayoutX(base_x+x_dif*4);
			cb_kc27.setLayoutY(base_y+y_dif*5);
			pane.getChildren().add(cb_kc27);
			cb_kc27.getItems().clear();
			cb_kc27.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_27()!=null)
				cb_kc27.getSelectionModel().select(paToBeUpdated.getParticipant_answer_27());
			}
			
			lb28=new Label("Katılımcı Cevap-28");
			lb28.setPrefHeight(standard_element_height);
			lb28.setPrefWidth(standard_element_width);
			lb28.setLayoutX(base_x+x_dif*4);
			lb28.setLayoutY(base_y+y_dif*6+lbdif);
			pane.getChildren().add(lb28);
			
			cb_kc28=new ComboBox<String>();
			cb_kc28.setPrefHeight(standard_element_height);
			cb_kc28.setPrefWidth(standard_element_width);
			cb_kc28.setLayoutX(base_x+x_dif*4);
			cb_kc28.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_kc28);
			cb_kc28.getItems().clear();
			cb_kc28.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_28()!=null)
				cb_kc28.getSelectionModel().select(paToBeUpdated.getParticipant_answer_28());
			}
			
			lb29=new Label("Katılımcı Cevap-29");
			lb29.setPrefHeight(standard_element_height);
			lb29.setPrefWidth(standard_element_width);
			lb29.setLayoutX(base_x+x_dif*4);
			lb29.setLayoutY(base_y+y_dif*8+lbdif);
			pane.getChildren().add(lb29);
			
			cb_kc29=new ComboBox<String>();
			cb_kc29.setPrefHeight(standard_element_height);
			cb_kc29.setPrefWidth(standard_element_width);
			cb_kc29.setLayoutX(base_x+x_dif*4);
			cb_kc29.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(cb_kc29);
			cb_kc29.getItems().clear();
			cb_kc29.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_29()!=null)
				cb_kc29.getSelectionModel().select(paToBeUpdated.getParticipant_answer_29());
			}
			
			lb30=new Label("Katılımcı Cevap-30");
			lb30.setPrefHeight(standard_element_height);
			lb30.setPrefWidth(standard_element_width);
			lb30.setLayoutX(base_x+x_dif*4);
			lb30.setLayoutY(base_y+y_dif*10+lbdif);
			pane.getChildren().add(lb30);
			
			cb_kc30=new ComboBox<String>();
			cb_kc30.setPrefHeight(standard_element_height);
			cb_kc30.setPrefWidth(standard_element_width);
			cb_kc30.setLayoutX(base_x+x_dif*4);
			cb_kc30.setLayoutY(base_y+y_dif*11);
			pane.getChildren().add(cb_kc30);
			cb_kc30.getItems().clear();
			cb_kc30.getItems().addAll("A","B","C","D","E","");
			if(paToBeUpdated!=null)
			{	if(paToBeUpdated.getParticipant_answer_30()!=null)
				cb_kc30.getSelectionModel().select(paToBeUpdated.getParticipant_answer_30());
			}
			
			
			
			
			
			EventHandler<ActionEvent> updatingParticipantAnswerEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					Exam exam=null;
					try
					{
						exam=dao.getExamById(paToBeUpdated.getExam_id());
					}
					catch(Exception ex)
					{
						
					}
					int result=-1;
					
					try 
					{
						ParticipantAnswer pa=new ParticipantAnswer();
						pa.setId(paToBeUpdated.getId());
						pa.setTest_image(paToBeUpdated.getTest_image());
						
						if(tf1b.getText()!=null&&tf1b.getText().length()>1)
						pa.setName_surname(tf1b.getText());
						
						if(cb_test_type.getValue()!=null)
							pa.setTest_type(cb_test_type.getValue());
						else
							pa.setTest_type("Test");
						
						
						
						
						if(cb_kc1.getValue()!=null)
							pa.setParticipant_answer_1(cb_kc1.getValue());
						else
							pa.setParticipant_answer_1("");
						
						
						
						
						
						if(cb_kc2.getValue()!=null)
							pa.setParticipant_answer_2(cb_kc2.getValue());
						else
							pa.setParticipant_answer_2("");
						
						
						
						
						
						if(cb_kc3.getValue()!=null)
							pa.setParticipant_answer_3(cb_kc3.getValue());
						else
							pa.setParticipant_answer_3("");
						
						
						
						
						
						if(cb_kc4.getValue()!=null)
							pa.setParticipant_answer_4(cb_kc4.getValue());
						else
							pa.setParticipant_answer_4("");
						
						
						
						
						
						if(cb_kc5.getValue()!=null)
							pa.setParticipant_answer_5(cb_kc5.getValue());
						else
							pa.setParticipant_answer_5("");
						
						
						
						
						
						if(cb_kc6.getValue()!=null)
							pa.setParticipant_answer_6(cb_kc6.getValue());
						else
							pa.setParticipant_answer_6("");
						
						
						
						
						
						if(cb_kc7.getValue()!=null)
							pa.setParticipant_answer_7(cb_kc7.getValue());
						else
							pa.setParticipant_answer_7("");
						
						
						
						
						
						if(cb_kc8.getValue()!=null)
							pa.setParticipant_answer_8(cb_kc8.getValue());
						else
							pa.setParticipant_answer_8("");
						
						
						
						
						
						if(cb_kc9.getValue()!=null)
							pa.setParticipant_answer_9(cb_kc9.getValue());
						else
							pa.setParticipant_answer_9("");
						
						
						
						
						
						if(cb_kc10.getValue()!=null)
							pa.setParticipant_answer_10(cb_kc10.getValue());
						else
							pa.setParticipant_answer_10("");
						
						
						
						
						
						if(cb_kc11.getValue()!=null)
							pa.setParticipant_answer_11(cb_kc11.getValue());
						else
							pa.setParticipant_answer_11("");
						
						
						
						
						
						
						if(cb_kc12.getValue()!=null)
							pa.setParticipant_answer_12(cb_kc12.getValue());
						else
							pa.setParticipant_answer_12("");
						
						
						
						
						
						if(cb_kc13.getValue()!=null)
							pa.setParticipant_answer_13(cb_kc13.getValue());
						else
							pa.setParticipant_answer_13("");
						
						
						
						
						if(cb_kc14.getValue()!=null)
							pa.setParticipant_answer_14(cb_kc14.getValue());
						else
							pa.setParticipant_answer_14("");
						
						
						
						
						if(cb_kc15.getValue()!=null)
							pa.setParticipant_answer_15(cb_kc15.getValue());
						else
							pa.setParticipant_answer_15("");
						
						
						
						
						
						if(cb_kc16.getValue()!=null)
							pa.setParticipant_answer_16(cb_kc16.getValue());
						else
							pa.setParticipant_answer_16("");
						
						
						
						
						if(cb_kc17.getValue()!=null)
							pa.setParticipant_answer_17(cb_kc17.getValue());
						else
							pa.setParticipant_answer_17("");
						
						
						
						
						if(cb_kc18.getValue()!=null)
							pa.setParticipant_answer_18(cb_kc18.getValue());
						else
							pa.setParticipant_answer_18("");
						
						
						
						
						if(cb_kc19.getValue()!=null)
							pa.setParticipant_answer_19(cb_kc19.getValue());
						else
							pa.setParticipant_answer_19("");
						
						
						
						if(cb_kc20.getValue()!=null)
							pa.setParticipant_answer_20(cb_kc20.getValue());
						else
							pa.setParticipant_answer_20("");
						
						
						if(cb_kc21.getValue()!=null)
							pa.setParticipant_answer_21(cb_kc21.getValue());
						else
							pa.setParticipant_answer_21("");
						
						
						
						
						if(cb_kc22.getValue()!=null)
							pa.setParticipant_answer_22(cb_kc22.getValue());
						else
							pa.setParticipant_answer_22("");
						
						
						
						if(cb_kc23.getValue()!=null)
							pa.setParticipant_answer_23(cb_kc23.getValue());
						else
							pa.setParticipant_answer_23("");
						
						
						if(cb_kc24.getValue()!=null)
							pa.setParticipant_answer_24(cb_kc24.getValue());
						else
							pa.setParticipant_answer_24("");
						
						
						
						if(cb_kc25.getValue()!=null)
							pa.setParticipant_answer_25(cb_kc25.getValue());
						else
							pa.setParticipant_answer_25("");
						
						
						
						if(cb_kc26.getValue()!=null)
							pa.setParticipant_answer_26(cb_kc26.getValue());
						else
							pa.setParticipant_answer_26("");
						
						
						
						if(cb_kc27.getValue()!=null)
							pa.setParticipant_answer_27(cb_kc27.getValue());
						else
							pa.setParticipant_answer_27("");
						
						
						
						if(cb_kc28.getValue()!=null)
							pa.setParticipant_answer_28(cb_kc28.getValue());
						else
							pa.setParticipant_answer_28("");
						
						
						
						if(cb_kc29.getValue()!=null)
							pa.setParticipant_answer_29(cb_kc29.getValue());
						else
							pa.setParticipant_answer_29("");
						
						
						
						if(cb_kc30.getValue()!=null)
							pa.setParticipant_answer_30(cb_kc30.getValue());
						else
							pa.setParticipant_answer_30("");
						
						
						try 
						{
							pa=ExamEvaluator.updateParticipantAnswerInformation(ps, pa, exam);
							result=dao.updateParticipantAnswer(pa);
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
			
			updateExamButton=new Button("Cevapları Güncelle");
			updateExamButton.setPrefHeight(standard_element_height);
			updateExamButton.setPrefWidth(standard_element_width);
			updateExamButton.setLayoutX(base_x+x_dif*4);
			updateExamButton.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(updateExamButton);
			updateExamButton.setOnAction(updatingParticipantAnswerEventHandler);
			
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
			goBackButton.setPrefHeight(standard_element_height);
			goBackButton.setPrefWidth(standard_element_width);
			goBackButton.setLayoutX(base_x+x_dif*4);
			goBackButton.setLayoutY(base_y+y_dif*23);
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
