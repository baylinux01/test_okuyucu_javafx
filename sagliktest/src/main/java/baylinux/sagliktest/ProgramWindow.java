package baylinux.sagliktest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;





public class ProgramWindow extends Application {
	protected static TableView<ParticipantAnswer> ONTESTTableView,SONTESTTableView,TESTTableView;
	protected static Label lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	protected static TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	protected static ComboBox cb_exams,cb_studentsOfExam,cb_allStudents;
	protected static Button addExamButton,addStudentButton,deleteExamButton,deleteStudentButton,
	updateExamButton,settingsButton,importDataButton,
	clearProgramTablesButton,updateSelectedONTESTButton,
	updateSelectedSONTESTButton,updateSelectedTESTButton,
	deleteSelectedONTESTButton,deleteSelectedSONTESTButton,deleteSelectedTESTButton,
	deleteAllONTESTSButton,deleteAllSONTESTSButton,deleteAllTESTSButton,deleteAllParticipantAnswersButton,
	exportONTESTSButton,exportSONTESTSButton,exportAllONAndSONTESTSButton;
	protected static List<Exam> examList;
	protected static Exam selectedExam;
	protected static ParticipantAnswer selectedONTEST,selectedSONTEST,selectedTEST;
	protected static List<ParticipantAnswer> listOfONTESTS,listOfSONTESTS, listOfTESTS, listOfParticipantAnswers;
	protected static DefaultSettings ds;
	protected static PreferredSettings ps;
	
	
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1300,675);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			Dao dao=new Dao();
			dao.createDatabase(Dao.getPrefSchema());
			dao.clearDefaultDBInformationTable();
			dao.createDefaultDBInformationTable();
			dao.insertIntoDefaultDBInformationTable
			("Sqlite", "", "", Main.prefSch, "", "");
			dao.insertIntoDefaultDBInformationTable
			("MySql", "localhost","3306", Main.prefSch,"root", "");
			dao.insertIntoDefaultDBInformationTable
			("MariaDB", "localhost","3306", Main.prefSch,"root", "");
			dao.insertIntoDefaultDBInformationTable
			("PostgreSql", "localhost","5432", Main.prefSch,"postgres", "");
			
			try
			{
			dao.createDefaultSettingsTable();
			dao.clearDefaultSettingsTable();
			dao.insertIntoDefaultSettingsTable();
			}
			catch(Exception ex)
			{
				
			}
			DefaultSettings ds=dao.getDefaultSettings();
			try
			{
				dao.createPreferredSettingsTable();
			}
			catch(Exception ex)
			{
				
			}
			
			ps=dao.getPreferredSettings();
			
			if(ps.getTesseract_language()==null)
			{
				dao.clearPreferredSettingsTable();
				dao.insertIntoPreferredSettingsTable(ds);
			}
			try 
			{
				ps=dao.getPreferredSettings();
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			try 
			{
				dao.createExamTable();
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			try 
			{
				dao.createParticipantAnswerTable();
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			try 
			{
				examList=dao.getAllExams();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int base_x=5;
			int base_y=5;
			int x_dif=150;
			int y_dif=30;
			
			int standard_element_height=20;
			int standard_element_width=140;
			int standart_table_height=200;
			int standart_table_width=1140;
			
			//ONTEST TABLOSUNUN BAŞLANGICI 
			ONTESTTableView=new TableView<ParticipantAnswer>();
			ONTESTTableView.setPrefHeight(standart_table_height);
			ONTESTTableView.setPrefWidth(standart_table_width);
			ONTESTTableView.setLayoutX(base_x+x_dif);
			ONTESTTableView.setLayoutY(base_y+y_dif*0);
			root.getChildren().add(ONTESTTableView);
			
			TableColumn<ParticipantAnswer,Integer> colONTEST1=
										new TableColumn<ParticipantAnswer,Integer>("Id");
			TableColumn<ParticipantAnswer,String> colONTEST2=
										new TableColumn<ParticipantAnswer,String>("Dosya Adı");
			TableColumn<ParticipantAnswer,String> colONTEST2b=
					new TableColumn<ParticipantAnswer,String>("Test Tipi");
			TableColumn<ParticipantAnswer,String> colONTEST3=
										new TableColumn<ParticipantAnswer,String>("Ad Soyad");
			TableColumn<ParticipantAnswer,String> colONTEST4=
										new TableColumn<ParticipantAnswer,String>("1");
			TableColumn<ParticipantAnswer,String> colONTEST5=
					new TableColumn<ParticipantAnswer,String>("2");
			TableColumn<ParticipantAnswer,String> colONTEST6=
					new TableColumn<ParticipantAnswer,String>("3");
			TableColumn<ParticipantAnswer,String> colONTEST7=
					new TableColumn<ParticipantAnswer,String>("4");
			TableColumn<ParticipantAnswer,String> colONTEST8=
					new TableColumn<ParticipantAnswer,String>("5");
			TableColumn<ParticipantAnswer,String> colONTEST9=
					new TableColumn<ParticipantAnswer,String>("6");
			TableColumn<ParticipantAnswer,String> colONTEST10=
					new TableColumn<ParticipantAnswer,String>("7");
			TableColumn<ParticipantAnswer,String> colONTEST11=
					new TableColumn<ParticipantAnswer,String>("8");
			TableColumn<ParticipantAnswer,String> colONTEST12=
					new TableColumn<ParticipantAnswer,String>("9");
			TableColumn<ParticipantAnswer,String> colONTEST13=
					new TableColumn<ParticipantAnswer,String>("10");
			TableColumn<ParticipantAnswer,String> colONTEST14=
					new TableColumn<ParticipantAnswer,String>("11");
			TableColumn<ParticipantAnswer,String> colONTEST15=
					new TableColumn<ParticipantAnswer,String>("12");
			TableColumn<ParticipantAnswer,String> colONTEST16=
					new TableColumn<ParticipantAnswer,String>("13");
			TableColumn<ParticipantAnswer,String> colONTEST17=
					new TableColumn<ParticipantAnswer,String>("14");
			TableColumn<ParticipantAnswer,String> colONTEST18=
					new TableColumn<ParticipantAnswer,String>("15");
			TableColumn<ParticipantAnswer,String> colONTEST19=
					new TableColumn<ParticipantAnswer,String>("16");
			TableColumn<ParticipantAnswer,String> colONTEST20=
					new TableColumn<ParticipantAnswer,String>("17");
			TableColumn<ParticipantAnswer,String> colONTEST21=
					new TableColumn<ParticipantAnswer,String>("18");
			TableColumn<ParticipantAnswer,String> colONTEST22=
					new TableColumn<ParticipantAnswer,String>("19");
			TableColumn<ParticipantAnswer,String> colONTEST23=
					new TableColumn<ParticipantAnswer,String>("20");
			TableColumn<ParticipantAnswer,String> colONTEST24=
					new TableColumn<ParticipantAnswer,String>("21");
			TableColumn<ParticipantAnswer,String> colONTEST25=
					new TableColumn<ParticipantAnswer,String>("22");
			TableColumn<ParticipantAnswer,String> colONTEST26=
					new TableColumn<ParticipantAnswer,String>("23");
			TableColumn<ParticipantAnswer,String> colONTEST27=
					new TableColumn<ParticipantAnswer,String>("24");
			TableColumn<ParticipantAnswer,String> colONTEST28=
					new TableColumn<ParticipantAnswer,String>("25");
			TableColumn<ParticipantAnswer,String> colONTEST29=
					new TableColumn<ParticipantAnswer,String>("26");
			TableColumn<ParticipantAnswer,String> colONTEST30=
					new TableColumn<ParticipantAnswer,String>("27");
			TableColumn<ParticipantAnswer,String> colONTEST31=
					new TableColumn<ParticipantAnswer,String>("28");
			TableColumn<ParticipantAnswer,String> colONTEST32=
					new TableColumn<ParticipantAnswer,String>("29");
			TableColumn<ParticipantAnswer,String> colONTEST33=
					new TableColumn<ParticipantAnswer,String>("30");
//			TableColumn<ParticipantAnswer,Integer> colONTEST34=
//					new TableColumn<ParticipantAnswer,Integer>("Doğru          ");
//			TableColumn<ParticipantAnswer,Integer> colONTEST35=
//					new TableColumn<ParticipantAnswer,Integer>("Puan");
			
			colONTEST1.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("id"));
			colONTEST2.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("file_name"));
			colONTEST2b.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("test_type"));
			colONTEST3.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("name_surname"));
			colONTEST4.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_1"));
			colONTEST5.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_2"));
			colONTEST6.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_3"));
			colONTEST7.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_4"));
			colONTEST8.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_5"));
			colONTEST9.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_6"));
			colONTEST10.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_7"));
			colONTEST11.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_8"));
			colONTEST12.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_9"));
			colONTEST13.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_10"));
			colONTEST14.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_11"));
			colONTEST15.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_12"));
			colONTEST16.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_13"));
			colONTEST17.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_14"));
			colONTEST18.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_15"));
			colONTEST19.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_16"));
			colONTEST20.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_17"));
			colONTEST21.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_18"));
			colONTEST22.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_19"));
			colONTEST23.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_20"));
			colONTEST24.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_21"));
			colONTEST25.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_22"));
			colONTEST26.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_23"));
			colONTEST27.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_24"));
			colONTEST28.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_25"));
			colONTEST29.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_26"));
			colONTEST30.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_27"));
			colONTEST31.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_28"));
			colONTEST32.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_29"));
			colONTEST33.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_30"));
//			colONTEST34.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("number_of_correct_answers"));
//			colONTEST35.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("total_point"));
			
			colONTEST1.setMinWidth(40);
			colONTEST1.setMaxWidth(40);
			colONTEST2.setMinWidth(280);
			colONTEST2.setMaxWidth(280);
			colONTEST2b.setMaxWidth(80);
			colONTEST3.setMinWidth(140);
			colONTEST3.setMaxWidth(140);
			colONTEST4.setMaxWidth(20);
			colONTEST5.setMaxWidth(20);
			colONTEST6.setMaxWidth(20);
			colONTEST7.setMaxWidth(20);
			colONTEST8.setMaxWidth(20);
			colONTEST9.setMaxWidth(20);
			colONTEST10.setMaxWidth(20);
			colONTEST11.setMaxWidth(20);
			colONTEST12.setMaxWidth(20);
			colONTEST13.setMaxWidth(20);
			colONTEST14.setMaxWidth(20);
			colONTEST15.setMaxWidth(20);
			colONTEST16.setMaxWidth(20);
			colONTEST17.setMaxWidth(20);
			colONTEST18.setMaxWidth(20);
			colONTEST19.setMaxWidth(20);
			colONTEST20.setMaxWidth(20);
			colONTEST21.setMaxWidth(20);
			colONTEST22.setMaxWidth(20);
			colONTEST23.setMaxWidth(20);
			colONTEST24.setMaxWidth(20);
			colONTEST25.setMaxWidth(20);
			colONTEST26.setMaxWidth(20);
			colONTEST27.setMaxWidth(20);
			colONTEST28.setMaxWidth(20);
			colONTEST29.setMaxWidth(20);
			colONTEST30.setMaxWidth(20);
			colONTEST31.setMaxWidth(20);
			colONTEST32.setMaxWidth(20);
			colONTEST33.setMaxWidth(20);
//			colONTEST34.setMinWidth(80);
//			colONTEST34.setMaxWidth(80);
//			colONTEST35.setMinWidth(60);
//			colONTEST35.setMaxWidth(60);
			
			colONTEST1.setStyle("-fx-alignment: center");
			colONTEST2.setStyle("-fx-alignment: left;-fx-font-size: 10;");
			colONTEST2b.setStyle("-fx-alignment: center");
			colONTEST3.setStyle("-fx-alignment: left;-fx-font-size: 10;");
			colONTEST4.setStyle("-fx-alignment: center");
			colONTEST5.setStyle("-fx-alignment: center");
			colONTEST6.setStyle("-fx-alignment: center");
			colONTEST7.setStyle("-fx-alignment: center");
			colONTEST8.setStyle("-fx-alignment: center");
			colONTEST9.setStyle("-fx-alignment: center");
			colONTEST10.setStyle("-fx-alignment: center");
			colONTEST11.setStyle("-fx-alignment: center");
			colONTEST12.setStyle("-fx-alignment: center");
			colONTEST13.setStyle("-fx-alignment: center");
			colONTEST14.setStyle("-fx-alignment: center");
			colONTEST15.setStyle("-fx-alignment: center");
			colONTEST16.setStyle("-fx-alignment: center");
			colONTEST17.setStyle("-fx-alignment: center");
			colONTEST18.setStyle("-fx-alignment: center");
			colONTEST19.setStyle("-fx-alignment: center");
			colONTEST20.setStyle("-fx-alignment: center");
			colONTEST21.setStyle("-fx-alignment: center");
			colONTEST22.setStyle("-fx-alignment: center");
			colONTEST23.setStyle("-fx-alignment: center");
			colONTEST24.setStyle("-fx-alignment: center");
			colONTEST25.setStyle("-fx-alignment: center");
			colONTEST26.setStyle("-fx-alignment: center");
			colONTEST27.setStyle("-fx-alignment: center");
			colONTEST28.setStyle("-fx-alignment: center");
			colONTEST29.setStyle("-fx-alignment: center");
			colONTEST30.setStyle("-fx-alignment: center");
			colONTEST31.setStyle("-fx-alignment: center");
			colONTEST32.setStyle("-fx-alignment: center");
			colONTEST33.setStyle("-fx-alignment: center");
//			colONTEST34.setStyle("-fx-alignment: left;-fx-font-size: 10;");
//			colONTEST35.setStyle("-fx-alignment: left");
			
			
			
			ONTESTTableView.getColumns().add(colONTEST1);
			ONTESTTableView.getColumns().add(colONTEST2);
			ONTESTTableView.getColumns().add(colONTEST2b);
			ONTESTTableView.getColumns().add(colONTEST3);
			ONTESTTableView.getColumns().add(colONTEST4);
			ONTESTTableView.getColumns().add(colONTEST5);
			ONTESTTableView.getColumns().add(colONTEST6);
			ONTESTTableView.getColumns().add(colONTEST7);
			ONTESTTableView.getColumns().add(colONTEST8);
			ONTESTTableView.getColumns().add(colONTEST9);
			ONTESTTableView.getColumns().add(colONTEST10);
			ONTESTTableView.getColumns().add(colONTEST11);
			ONTESTTableView.getColumns().add(colONTEST12);
			ONTESTTableView.getColumns().add(colONTEST13);
			ONTESTTableView.getColumns().add(colONTEST14);
			ONTESTTableView.getColumns().add(colONTEST15);
			ONTESTTableView.getColumns().add(colONTEST16);
			ONTESTTableView.getColumns().add(colONTEST17);
			ONTESTTableView.getColumns().add(colONTEST18);
			ONTESTTableView.getColumns().add(colONTEST19);
			ONTESTTableView.getColumns().add(colONTEST20);
			ONTESTTableView.getColumns().add(colONTEST21);
			ONTESTTableView.getColumns().add(colONTEST22);
			ONTESTTableView.getColumns().add(colONTEST23);
			ONTESTTableView.getColumns().add(colONTEST24);
			ONTESTTableView.getColumns().add(colONTEST25);
			ONTESTTableView.getColumns().add(colONTEST26);
			ONTESTTableView.getColumns().add(colONTEST27);
			ONTESTTableView.getColumns().add(colONTEST28);
			ONTESTTableView.getColumns().add(colONTEST29);
			ONTESTTableView.getColumns().add(colONTEST30);
			ONTESTTableView.getColumns().add(colONTEST31);
			ONTESTTableView.getColumns().add(colONTEST32);
			ONTESTTableView.getColumns().add(colONTEST33);
//			ONTESTTableView.getColumns().add(colONTEST34);
//			ONTESTTableView.getColumns().add(colONTEST35);
			
			
			ONTESTTableView.setEditable(true); 
			colONTEST3.setEditable(true);
			
			
			colONTEST3.setCellFactory(TextFieldTableCell.forTableColumn());
			
			
			ONTESTTableView.setRowFactory(tv -> 
			{
			    TableRow<ParticipantAnswer> row = new TableRow<>();
			    row.setOnMouseClicked(e -> 
			    {
			        if (e.getClickCount() == 2 && !row.isEmpty()) {
			            int index = row.getIndex();
			            ONTESTTableView.edit(index, colONTEST3);   
			        }
			    });
			    
			    return row;
			});
			
			
			
			
			EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>> 
			changeNameSurnameOnONTESTTableEventHandler
						=new EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>>()
			{
				@Override
				public void handle(CellEditEvent<ParticipantAnswer, String> event) 
				{
					String newValue=event.getNewValue();
					ParticipantAnswer pa=event.getRowValue();
					pa.setName_surname(newValue);
					try 
					{
						dao.updateParticipantAnswer(pa);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						listOfONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					ONTESTTableView.getItems().clear();
					ONTESTTableView.getItems().addAll(listOfONTESTS);
				}
			};
			colONTEST3.setOnEditCommit(changeNameSurnameOnONTESTTableEventHandler);
			
			
			
			//ONTEST TABLOSUNUN BİTİŞİ
			
			
			
			//SONTEST TABLOSUNUN BAŞLANGICI 
			SONTESTTableView=new TableView<ParticipantAnswer>();
			SONTESTTableView.setPrefHeight(standart_table_height);
			SONTESTTableView.setPrefWidth(standart_table_width);
			SONTESTTableView.setLayoutX(base_x+x_dif);
			SONTESTTableView.setLayoutY(base_y+standart_table_height+y_dif*1);
			root.getChildren().add(SONTESTTableView);
			
			TableColumn<ParticipantAnswer,Integer> colSONTEST1=
										new TableColumn<ParticipantAnswer,Integer>("Id");
			TableColumn<ParticipantAnswer,String> colSONTEST2=
										new TableColumn<ParticipantAnswer,String>("Dosya Adı");
			TableColumn<ParticipantAnswer,String> colSONTEST2b=
					new TableColumn<ParticipantAnswer,String>("Test Tipi");
			TableColumn<ParticipantAnswer,String> colSONTEST3=
										new TableColumn<ParticipantAnswer,String>("Ad Soyad");
			TableColumn<ParticipantAnswer,String> colSONTEST4=
										new TableColumn<ParticipantAnswer,String>("1");
			TableColumn<ParticipantAnswer,String> colSONTEST5=
					new TableColumn<ParticipantAnswer,String>("2");
			TableColumn<ParticipantAnswer,String> colSONTEST6=
					new TableColumn<ParticipantAnswer,String>("3");
			TableColumn<ParticipantAnswer,String> colSONTEST7=
					new TableColumn<ParticipantAnswer,String>("4");
			TableColumn<ParticipantAnswer,String> colSONTEST8=
					new TableColumn<ParticipantAnswer,String>("5");
			TableColumn<ParticipantAnswer,String> colSONTEST9=
					new TableColumn<ParticipantAnswer,String>("6");
			TableColumn<ParticipantAnswer,String> colSONTEST10=
					new TableColumn<ParticipantAnswer,String>("7");
			TableColumn<ParticipantAnswer,String> colSONTEST11=
					new TableColumn<ParticipantAnswer,String>("8");
			TableColumn<ParticipantAnswer,String> colSONTEST12=
					new TableColumn<ParticipantAnswer,String>("9");
			TableColumn<ParticipantAnswer,String> colSONTEST13=
					new TableColumn<ParticipantAnswer,String>("10");
			TableColumn<ParticipantAnswer,String> colSONTEST14=
					new TableColumn<ParticipantAnswer,String>("11");
			TableColumn<ParticipantAnswer,String> colSONTEST15=
					new TableColumn<ParticipantAnswer,String>("12");
			TableColumn<ParticipantAnswer,String> colSONTEST16=
					new TableColumn<ParticipantAnswer,String>("13");
			TableColumn<ParticipantAnswer,String> colSONTEST17=
					new TableColumn<ParticipantAnswer,String>("14");
			TableColumn<ParticipantAnswer,String> colSONTEST18=
					new TableColumn<ParticipantAnswer,String>("15");
			TableColumn<ParticipantAnswer,String> colSONTEST19=
					new TableColumn<ParticipantAnswer,String>("16");
			TableColumn<ParticipantAnswer,String> colSONTEST20=
					new TableColumn<ParticipantAnswer,String>("17");
			TableColumn<ParticipantAnswer,String> colSONTEST21=
					new TableColumn<ParticipantAnswer,String>("18");
			TableColumn<ParticipantAnswer,String> colSONTEST22=
					new TableColumn<ParticipantAnswer,String>("19");
			TableColumn<ParticipantAnswer,String> colSONTEST23=
					new TableColumn<ParticipantAnswer,String>("20");
			TableColumn<ParticipantAnswer,String> colSONTEST24=
					new TableColumn<ParticipantAnswer,String>("21");
			TableColumn<ParticipantAnswer,String> colSONTEST25=
					new TableColumn<ParticipantAnswer,String>("22");
			TableColumn<ParticipantAnswer,String> colSONTEST26=
					new TableColumn<ParticipantAnswer,String>("23");
			TableColumn<ParticipantAnswer,String> colSONTEST27=
					new TableColumn<ParticipantAnswer,String>("24");
			TableColumn<ParticipantAnswer,String> colSONTEST28=
					new TableColumn<ParticipantAnswer,String>("25");
			TableColumn<ParticipantAnswer,String> colSONTEST29=
					new TableColumn<ParticipantAnswer,String>("26");
			TableColumn<ParticipantAnswer,String> colSONTEST30=
					new TableColumn<ParticipantAnswer,String>("27");
			TableColumn<ParticipantAnswer,String> colSONTEST31=
					new TableColumn<ParticipantAnswer,String>("28");
			TableColumn<ParticipantAnswer,String> colSONTEST32=
					new TableColumn<ParticipantAnswer,String>("29");
			TableColumn<ParticipantAnswer,String> colSONTEST33=
					new TableColumn<ParticipantAnswer,String>("30");
//			TableColumn<ParticipantAnswer,Integer> colSONTEST34=
//					new TableColumn<ParticipantAnswer,Integer>("Doğru          ");
//			TableColumn<ParticipantAnswer,Integer> colSONTEST35=
//					new TableColumn<ParticipantAnswer,Integer>("Puan");
			
			colSONTEST1.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("id"));
			colSONTEST2.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("file_name"));
			colSONTEST2b.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("test_type"));
			colSONTEST3.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("name_surname"));
			colSONTEST4.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_1"));
			colSONTEST5.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_2"));
			colSONTEST6.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_3"));
			colSONTEST7.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_4"));
			colSONTEST8.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_5"));
			colSONTEST9.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_6"));
			colSONTEST10.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_7"));
			colSONTEST11.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_8"));
			colSONTEST12.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_9"));
			colSONTEST13.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_10"));
			colSONTEST14.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_11"));
			colSONTEST15.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_12"));
			colSONTEST16.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_13"));
			colSONTEST17.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_14"));
			colSONTEST18.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_15"));
			colSONTEST19.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_16"));
			colSONTEST20.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_17"));
			colSONTEST21.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_18"));
			colSONTEST22.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_19"));
			colSONTEST23.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_20"));
			colSONTEST24.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_21"));
			colSONTEST25.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_22"));
			colSONTEST26.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_23"));
			colSONTEST27.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_24"));
			colSONTEST28.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_25"));
			colSONTEST29.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_26"));
			colSONTEST30.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_27"));
			colSONTEST31.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_28"));
			colSONTEST32.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_29"));
			colSONTEST33.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_30"));
//			colSONTEST34.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("number_of_correct_answers"));
//			colSONTEST35.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("total_point"));
			
			colSONTEST1.setMinWidth(40);
			colSONTEST1.setMaxWidth(40);
			colSONTEST2.setMinWidth(280);
			colSONTEST2.setMaxWidth(280);
			colSONTEST2b.setMaxWidth(80);
			colSONTEST3.setMinWidth(140);
			colSONTEST3.setMaxWidth(140);
			colSONTEST4.setMaxWidth(20);
			colSONTEST5.setMaxWidth(20);
			colSONTEST6.setMaxWidth(20);
			colSONTEST7.setMaxWidth(20);
			colSONTEST8.setMaxWidth(20);
			colSONTEST9.setMaxWidth(20);
			colSONTEST10.setMaxWidth(20);
			colSONTEST11.setMaxWidth(20);
			colSONTEST12.setMaxWidth(20);
			colSONTEST13.setMaxWidth(20);
			colSONTEST14.setMaxWidth(20);
			colSONTEST15.setMaxWidth(20);
			colSONTEST16.setMaxWidth(20);
			colSONTEST17.setMaxWidth(20);
			colSONTEST18.setMaxWidth(20);
			colSONTEST19.setMaxWidth(20);
			colSONTEST20.setMaxWidth(20);
			colSONTEST21.setMaxWidth(20);
			colSONTEST22.setMaxWidth(20);
			colSONTEST23.setMaxWidth(20);
			colSONTEST24.setMaxWidth(20);
			colSONTEST25.setMaxWidth(20);
			colSONTEST26.setMaxWidth(20);
			colSONTEST27.setMaxWidth(20);
			colSONTEST28.setMaxWidth(20);
			colSONTEST29.setMaxWidth(20);
			colSONTEST30.setMaxWidth(20);
			colSONTEST31.setMaxWidth(20);
			colSONTEST32.setMaxWidth(20);
			colSONTEST33.setMaxWidth(20);
//			colSONTEST34.setMinWidth(80);
//			colSONTEST34.setMaxWidth(80);
//			colSONTEST35.setMinWidth(60);
//			colSONTEST35.setMaxWidth(60);
			
			colSONTEST1.setStyle("-fx-alignment: center");
			colSONTEST2.setStyle("-fx-alignment: left; -fx-font-size: 10;");
			colSONTEST2b.setStyle("-fx-alignment: center");
			colSONTEST3.setStyle("-fx-alignment: center;-fx-font-size: 10;");
			colSONTEST4.setStyle("-fx-alignment: center");
			colSONTEST5.setStyle("-fx-alignment: center");
			colSONTEST6.setStyle("-fx-alignment: center");
			colSONTEST7.setStyle("-fx-alignment: center");
			colSONTEST8.setStyle("-fx-alignment: center");
			colSONTEST9.setStyle("-fx-alignment: center");
			colSONTEST10.setStyle("-fx-alignment: center");
			colSONTEST11.setStyle("-fx-alignment: center");
			colSONTEST12.setStyle("-fx-alignment: center");
			colSONTEST13.setStyle("-fx-alignment: center");
			colSONTEST14.setStyle("-fx-alignment: center");
			colSONTEST15.setStyle("-fx-alignment: center");
			colSONTEST16.setStyle("-fx-alignment: center");
			colSONTEST17.setStyle("-fx-alignment: center");
			colSONTEST18.setStyle("-fx-alignment: center");
			colSONTEST19.setStyle("-fx-alignment: center");
			colSONTEST20.setStyle("-fx-alignment: center");
			colSONTEST21.setStyle("-fx-alignment: center");
			colSONTEST22.setStyle("-fx-alignment: center");
			colSONTEST23.setStyle("-fx-alignment: center");
			colSONTEST24.setStyle("-fx-alignment: center");
			colSONTEST25.setStyle("-fx-alignment: center");
			colSONTEST26.setStyle("-fx-alignment: center");
			colSONTEST27.setStyle("-fx-alignment: center");
			colSONTEST28.setStyle("-fx-alignment: center");
			colSONTEST29.setStyle("-fx-alignment: center");
			colSONTEST30.setStyle("-fx-alignment: center");
			colSONTEST31.setStyle("-fx-alignment: center");
			colSONTEST32.setStyle("-fx-alignment: center");
			colSONTEST33.setStyle("-fx-alignment: center");
//			colSONTEST34.setStyle("-fx-alignment: left;-fx-font-size: 10;");
//			colSONTEST35.setStyle("-fx-alignment: left");
			
			SONTESTTableView.getColumns().add(colSONTEST1);
			SONTESTTableView.getColumns().add(colSONTEST2);
			SONTESTTableView.getColumns().add(colSONTEST2b);
			SONTESTTableView.getColumns().add(colSONTEST3);
			SONTESTTableView.getColumns().add(colSONTEST4);
			SONTESTTableView.getColumns().add(colSONTEST5);
			SONTESTTableView.getColumns().add(colSONTEST6);
			SONTESTTableView.getColumns().add(colSONTEST7);
			SONTESTTableView.getColumns().add(colSONTEST8);
			SONTESTTableView.getColumns().add(colSONTEST9);
			SONTESTTableView.getColumns().add(colSONTEST10);
			SONTESTTableView.getColumns().add(colSONTEST11);
			SONTESTTableView.getColumns().add(colSONTEST12);
			SONTESTTableView.getColumns().add(colSONTEST13);
			SONTESTTableView.getColumns().add(colSONTEST14);
			SONTESTTableView.getColumns().add(colSONTEST15);
			SONTESTTableView.getColumns().add(colSONTEST16);
			SONTESTTableView.getColumns().add(colSONTEST17);
			SONTESTTableView.getColumns().add(colSONTEST18);
			SONTESTTableView.getColumns().add(colSONTEST19);
			SONTESTTableView.getColumns().add(colSONTEST20);
			SONTESTTableView.getColumns().add(colSONTEST21);
			SONTESTTableView.getColumns().add(colSONTEST22);
			SONTESTTableView.getColumns().add(colSONTEST23);
			SONTESTTableView.getColumns().add(colSONTEST24);
			SONTESTTableView.getColumns().add(colSONTEST25);
			SONTESTTableView.getColumns().add(colSONTEST26);
			SONTESTTableView.getColumns().add(colSONTEST27);
			SONTESTTableView.getColumns().add(colSONTEST28);
			SONTESTTableView.getColumns().add(colSONTEST29);
			SONTESTTableView.getColumns().add(colSONTEST30);
			SONTESTTableView.getColumns().add(colSONTEST31);
			SONTESTTableView.getColumns().add(colSONTEST32);
			SONTESTTableView.getColumns().add(colSONTEST33);
//			SONTESTTableView.getColumns().add(colSONTEST34);
//			SONTESTTableView.getColumns().add(colSONTEST35);
			
			SONTESTTableView.setEditable(true); 
			colSONTEST3.setEditable(true);
			
			colSONTEST3.setCellFactory(TextFieldTableCell.forTableColumn());
			
			SONTESTTableView.setRowFactory(tv -> 
			{
			    TableRow<ParticipantAnswer> row = new TableRow<>();
			    row.setOnMouseClicked(e -> 
			    {
			        if (e.getClickCount() == 2 && !row.isEmpty()) {
			            int index = row.getIndex();
			            SONTESTTableView.edit(index, colSONTEST3);   
			        }
			    });
			    return row;
			});
			
			
			EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>> 
			changeNameSurnameOnSONTESTTableEventHandler
						=new EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>>()
			{
				@Override
				public void handle(CellEditEvent<ParticipantAnswer, String> event) 
				{
					String newValue=event.getNewValue();
					ParticipantAnswer pa=event.getRowValue();
					pa.setName_surname(newValue);
					try 
					{
						dao.updateParticipantAnswer(pa);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						listOfSONTESTS=dao.getSONTESTParticipantAnswersByExam(selectedExam);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					SONTESTTableView.getItems().clear();
					SONTESTTableView.getItems().addAll(listOfSONTESTS);
				}
			};
			colSONTEST3.setOnEditCommit(changeNameSurnameOnSONTESTTableEventHandler);
			//SONTEST TABLOSUNUN BİTİŞİ
			
			
			
			//TEST TABLOSUNUN BAŞLANGICI 
			TESTTableView=new TableView<ParticipantAnswer>();
			TESTTableView.setPrefHeight(standart_table_height);
			TESTTableView.setPrefWidth(standart_table_width);
			TESTTableView.setLayoutX(base_x+x_dif);
			TESTTableView.setLayoutY(base_y+standart_table_height*2+y_dif*2);
			root.getChildren().add(TESTTableView);
			
			TableColumn<ParticipantAnswer,Integer> colTEST1=
										new TableColumn<ParticipantAnswer,Integer>("Id");
			TableColumn<ParticipantAnswer,String> colTEST2=
										new TableColumn<ParticipantAnswer,String>("Dosya Adı");
			TableColumn<ParticipantAnswer,String> colTEST2b=
					new TableColumn<ParticipantAnswer,String>("Test Tipi");
			TableColumn<ParticipantAnswer,String> colTEST3=
										new TableColumn<ParticipantAnswer,String>("Ad Soyad");
			TableColumn<ParticipantAnswer,String> colTEST4=
										new TableColumn<ParticipantAnswer,String>("1");
			TableColumn<ParticipantAnswer,String> colTEST5=
					new TableColumn<ParticipantAnswer,String>("2");
			TableColumn<ParticipantAnswer,String> colTEST6=
					new TableColumn<ParticipantAnswer,String>("3");
			TableColumn<ParticipantAnswer,String> colTEST7=
					new TableColumn<ParticipantAnswer,String>("4");
			TableColumn<ParticipantAnswer,String> colTEST8=
					new TableColumn<ParticipantAnswer,String>("5");
			TableColumn<ParticipantAnswer,String> colTEST9=
					new TableColumn<ParticipantAnswer,String>("6");
			TableColumn<ParticipantAnswer,String> colTEST10=
					new TableColumn<ParticipantAnswer,String>("7");
			TableColumn<ParticipantAnswer,String> colTEST11=
					new TableColumn<ParticipantAnswer,String>("8");
			TableColumn<ParticipantAnswer,String> colTEST12=
					new TableColumn<ParticipantAnswer,String>("9");
			TableColumn<ParticipantAnswer,String> colTEST13=
					new TableColumn<ParticipantAnswer,String>("10");
			TableColumn<ParticipantAnswer,String> colTEST14=
					new TableColumn<ParticipantAnswer,String>("11");
			TableColumn<ParticipantAnswer,String> colTEST15=
					new TableColumn<ParticipantAnswer,String>("12");
			TableColumn<ParticipantAnswer,String> colTEST16=
					new TableColumn<ParticipantAnswer,String>("13");
			TableColumn<ParticipantAnswer,String> colTEST17=
					new TableColumn<ParticipantAnswer,String>("14");
			TableColumn<ParticipantAnswer,String> colTEST18=
					new TableColumn<ParticipantAnswer,String>("15");
			TableColumn<ParticipantAnswer,String> colTEST19=
					new TableColumn<ParticipantAnswer,String>("16");
			TableColumn<ParticipantAnswer,String> colTEST20=
					new TableColumn<ParticipantAnswer,String>("17");
			TableColumn<ParticipantAnswer,String> colTEST21=
					new TableColumn<ParticipantAnswer,String>("18");
			TableColumn<ParticipantAnswer,String> colTEST22=
					new TableColumn<ParticipantAnswer,String>("19");
			TableColumn<ParticipantAnswer,String> colTEST23=
					new TableColumn<ParticipantAnswer,String>("20");
			TableColumn<ParticipantAnswer,String> colTEST24=
					new TableColumn<ParticipantAnswer,String>("21");
			TableColumn<ParticipantAnswer,String> colTEST25=
					new TableColumn<ParticipantAnswer,String>("22");
			TableColumn<ParticipantAnswer,String> colTEST26=
					new TableColumn<ParticipantAnswer,String>("23");
			TableColumn<ParticipantAnswer,String> colTEST27=
					new TableColumn<ParticipantAnswer,String>("24");
			TableColumn<ParticipantAnswer,String> colTEST28=
					new TableColumn<ParticipantAnswer,String>("25");
			TableColumn<ParticipantAnswer,String> colTEST29=
					new TableColumn<ParticipantAnswer,String>("26");
			TableColumn<ParticipantAnswer,String> colTEST30=
					new TableColumn<ParticipantAnswer,String>("27");
			TableColumn<ParticipantAnswer,String> colTEST31=
					new TableColumn<ParticipantAnswer,String>("28");
			TableColumn<ParticipantAnswer,String> colTEST32=
					new TableColumn<ParticipantAnswer,String>("29");
			TableColumn<ParticipantAnswer,String> colTEST33=
					new TableColumn<ParticipantAnswer,String>("30");
//			TableColumn<ParticipantAnswer,Integer> colTEST34=
//					new TableColumn<ParticipantAnswer,Integer>("Doğru          ");
//			TableColumn<ParticipantAnswer,Integer> colTEST35=
//					new TableColumn<ParticipantAnswer,Integer>("Puan");
			
			colTEST1.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("id"));
			colTEST2.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("file_name"));
			colTEST2b.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("test_type"));
			colTEST3.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("name_surname"));
			colTEST4.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_1"));
			colTEST5.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_2"));
			colTEST6.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_3"));
			colTEST7.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_4"));
			colTEST8.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_5"));
			colTEST9.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_6"));
			colTEST10.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_7"));
			colTEST11.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_8"));
			colTEST12.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_9"));
			colTEST13.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_10"));
			colTEST14.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_11"));
			colTEST15.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_12"));
			colTEST16.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_13"));
			colTEST17.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_14"));
			colTEST18.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_15"));
			colTEST19.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_16"));
			colTEST20.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_17"));
			colTEST21.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_18"));
			colTEST22.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_19"));
			colTEST23.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_20"));
			colTEST24.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_21"));
			colTEST25.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_22"));
			colTEST26.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_23"));
			colTEST27.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_24"));
			colTEST28.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_25"));
			colTEST29.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_26"));
			colTEST30.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_27"));
			colTEST31.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_28"));
			colTEST32.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_29"));
			colTEST33.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,String>("answer_correctness_30"));
//			colTEST34.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("number_of_correct_answers"));
//			colTEST35.setCellValueFactory(new PropertyValueFactory<ParticipantAnswer,Integer>("total_point"));
			
			colTEST1.setMinWidth(40);
			colTEST1.setMaxWidth(40);
			colTEST2.setMinWidth(280);
			colTEST2.setMaxWidth(280);
			colTEST2b.setMaxWidth(80);
			colTEST3.setMinWidth(140);
			colTEST3.setMaxWidth(140);
			colTEST4.setMaxWidth(20);
			colTEST5.setMaxWidth(20);
			colTEST6.setMaxWidth(20);
			colTEST7.setMaxWidth(20);
			colTEST8.setMaxWidth(20);
			colTEST9.setMaxWidth(20);
			colTEST10.setMaxWidth(20);
			colTEST11.setMaxWidth(20);
			colTEST12.setMaxWidth(20);
			colTEST13.setMaxWidth(20);
			colTEST14.setMaxWidth(20);
			colTEST15.setMaxWidth(20);
			colTEST16.setMaxWidth(20);
			colTEST17.setMaxWidth(20);
			colTEST18.setMaxWidth(20);
			colTEST19.setMaxWidth(20);
			colTEST20.setMaxWidth(20);
			colTEST21.setMaxWidth(20);
			colTEST22.setMaxWidth(20);
			colTEST23.setMaxWidth(20);
			colTEST24.setMaxWidth(20);
			colTEST25.setMaxWidth(20);
			colTEST26.setMaxWidth(20);
			colTEST27.setMaxWidth(20);
			colTEST28.setMaxWidth(20);
			colTEST29.setMaxWidth(20);
			colTEST30.setMaxWidth(20);
			colTEST31.setMaxWidth(20);
			colTEST32.setMaxWidth(20);
			colTEST33.setMaxWidth(20);
//			colTEST34.setMinWidth(80);
//			colTEST34.setMaxWidth(80);
//			colTEST35.setMinWidth(60);
//			colTEST35.setMaxWidth(60);
			
			colTEST1.setStyle("-fx-alignment: center");
			colTEST2.setStyle("-fx-alignment: left;-fx-font-size: 10;");
			colTEST2b.setStyle("-fx-alignment: center");
			colTEST3.setStyle("-fx-alignment: left;-fx-font-size: 10;");
			colTEST4.setStyle("-fx-alignment: center");
			colTEST5.setStyle("-fx-alignment: center");
			colTEST6.setStyle("-fx-alignment: center");
			colTEST7.setStyle("-fx-alignment: center");
			colTEST8.setStyle("-fx-alignment: center");
			colTEST9.setStyle("-fx-alignment: center");
			colTEST10.setStyle("-fx-alignment: center");
			colTEST11.setStyle("-fx-alignment: center");
			colTEST12.setStyle("-fx-alignment: center");
			colTEST13.setStyle("-fx-alignment: center");
			colTEST14.setStyle("-fx-alignment: center");
			colTEST15.setStyle("-fx-alignment: center");
			colTEST16.setStyle("-fx-alignment: center");
			colTEST17.setStyle("-fx-alignment: center");
			colTEST18.setStyle("-fx-alignment: center");
			colTEST19.setStyle("-fx-alignment: center");
			colTEST20.setStyle("-fx-alignment: center");
			colTEST21.setStyle("-fx-alignment: center");
			colTEST22.setStyle("-fx-alignment: center");
			colTEST23.setStyle("-fx-alignment: center");
			colTEST24.setStyle("-fx-alignment: center");
			colTEST25.setStyle("-fx-alignment: center");
			colTEST26.setStyle("-fx-alignment: center");
			colTEST27.setStyle("-fx-alignment: center");
			colTEST28.setStyle("-fx-alignment: center");
			colTEST29.setStyle("-fx-alignment: center");
			colTEST30.setStyle("-fx-alignment: center");
			colTEST31.setStyle("-fx-alignment: center");
			colTEST32.setStyle("-fx-alignment: center");
			colTEST33.setStyle("-fx-alignment: center");
//			colTEST34.setStyle("-fx-alignment: left;-fx-font-size: 10;");
//			colTEST35.setStyle("-fx-alignment: left");
			
			TESTTableView.getColumns().add(colTEST1);
			TESTTableView.getColumns().add(colTEST2);
			TESTTableView.getColumns().add(colTEST2b);
			TESTTableView.getColumns().add(colTEST3);
			TESTTableView.getColumns().add(colTEST4);
			TESTTableView.getColumns().add(colTEST5);
			TESTTableView.getColumns().add(colTEST6);
			TESTTableView.getColumns().add(colTEST7);
			TESTTableView.getColumns().add(colTEST8);
			TESTTableView.getColumns().add(colTEST9);
			TESTTableView.getColumns().add(colTEST10);
			TESTTableView.getColumns().add(colTEST11);
			TESTTableView.getColumns().add(colTEST12);
			TESTTableView.getColumns().add(colTEST13);
			TESTTableView.getColumns().add(colTEST14);
			TESTTableView.getColumns().add(colTEST15);
			TESTTableView.getColumns().add(colTEST16);
			TESTTableView.getColumns().add(colTEST17);
			TESTTableView.getColumns().add(colTEST18);
			TESTTableView.getColumns().add(colTEST19);
			TESTTableView.getColumns().add(colTEST20);
			TESTTableView.getColumns().add(colTEST21);
			TESTTableView.getColumns().add(colTEST22);
			TESTTableView.getColumns().add(colTEST23);
			TESTTableView.getColumns().add(colTEST24);
			TESTTableView.getColumns().add(colTEST25);
			TESTTableView.getColumns().add(colTEST26);
			TESTTableView.getColumns().add(colTEST27);
			TESTTableView.getColumns().add(colTEST28);
			TESTTableView.getColumns().add(colTEST29);
			TESTTableView.getColumns().add(colTEST30);
			TESTTableView.getColumns().add(colTEST31);
			TESTTableView.getColumns().add(colTEST32);
			TESTTableView.getColumns().add(colTEST33);
//			TESTTableView.getColumns().add(colTEST34);
//			TESTTableView.getColumns().add(colTEST35);
			
			TESTTableView.setEditable(true); 
			colTEST3.setEditable(true);
			
			colTEST3.setCellFactory(TextFieldTableCell.forTableColumn());
			
			TESTTableView.setRowFactory(tv -> 
			{
			    TableRow<ParticipantAnswer> row = new TableRow<>();
			    row.setOnMouseClicked(e -> 
			    {
			        if (e.getClickCount() == 2 && !row.isEmpty()) {
			            int index = row.getIndex();
			            TESTTableView.edit(index, colTEST3);  
			        }
			    });
			    return row;
			});
			
			
			EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>> 
			changeNameSurnameOnTESTTableEventHandler
						=new EventHandler<TableColumn.CellEditEvent<ParticipantAnswer, String>>()
			{
				@Override
				public void handle(CellEditEvent<ParticipantAnswer, String> event) 
				{
					String newValue=event.getNewValue();
					ParticipantAnswer pa=event.getRowValue();
					pa.setName_surname(newValue);
					try 
					{
						dao.updateParticipantAnswer(pa);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						listOfTESTS=dao.getTESTParticipantAnswersByExam(selectedExam);
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					TESTTableView.getItems().clear();
					TESTTableView.getItems().addAll(listOfTESTS);
				}
			};
			colTEST3.setOnEditCommit(changeNameSurnameOnTESTTableEventHandler);
			//TEST TABLOSUNUN BİTİŞİ
			
			
			
			
			Pane pane=new Pane();
			pane.setPrefHeight(600);
			pane.setPrefWidth(600);
			root.getChildren().add(pane);
			
			lb1=new Label("Görüntülenecek Sınav");
			//lb1.setStyle("-fx-font-size:10");
			lb1.setPrefHeight(standard_element_height);
			lb1.setPrefWidth(standard_element_width);
			lb1.setLayoutX(base_x);
			lb1.setLayoutY(base_y+7);
			pane.getChildren().add(lb1);
			
			
			
			EventHandler<ActionEvent> changeSelectedExamEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					selectedExam=(Exam) cb_exams.getSelectionModel().getSelectedItem();
					try 
					{
						listOfONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
						ONTESTTableView.getItems().clear();
						ONTESTTableView.getItems().addAll(listOfONTESTS);
						
						listOfSONTESTS=dao.getSONTESTParticipantAnswersByExam(selectedExam);
						SONTESTTableView.getItems().clear();
						SONTESTTableView.getItems().addAll(listOfSONTESTS);
						
						listOfTESTS=dao.getTESTParticipantAnswersByExam(selectedExam);
						TESTTableView.getItems().clear();
						TESTTableView.getItems().addAll(listOfTESTS);
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						listOfSONTESTS=dao.getSONTESTParticipantAnswersByExam(selectedExam);
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						listOfTESTS=dao.getTESTParticipantAnswersByExam(selectedExam);
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			cb_exams=new ComboBox<Exam>();
			cb_exams.setPrefHeight(standard_element_height);
			cb_exams.setPrefWidth(standard_element_width);
			cb_exams.setLayoutX(base_x);
			cb_exams.setLayoutY(base_y+y_dif);
			cb_exams.getItems().clear();
			if(examList!=null)
			{
				cb_exams.getItems().addAll(examList);
			}
			pane.getChildren().add(cb_exams);
			cb_exams.setOnAction(changeSelectedExamEventHandler);
			
			EventHandler<ActionEvent> openAddingExamWindowEventHandler=new EventHandler<ActionEvent>()
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
					stage.setTitle("Sınav Ekleme Sayfası");
					AddingExamWindow window=new AddingExamWindow();
					
					try {
						window.start(stage);
						primaryStage.hide();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			addExamButton=new Button("Sınav Oluştur");
			//addExamButton.setStyle("-fx-font-size: 10");
			addExamButton.setPrefHeight(standard_element_height);
			addExamButton.setPrefWidth(standard_element_width);
			addExamButton.setLayoutX(base_x);
			addExamButton.setLayoutY(base_y + y_dif*2);
			pane.getChildren().add(addExamButton);
			addExamButton.setOnAction(openAddingExamWindowEventHandler);
			
			EventHandler<ActionEvent> deleteExamEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					//selectedExam=(Exam) cb_exams.getSelectionModel().getSelectedItem();
					int result=-1;
					
					try {
						if(selectedExam!=null)
						{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Dikkat");
							alert.setHeaderText("Uyarı");
							alert.setContentText("Bunu yaparsanız seçili sınav silinecektir");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
							result=dao.deleteExamById(selectedExam.getId());
							cb_exams.getSelectionModel().select(null);
							}
							else
							{
								
							}
						}
						if(result<=0)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setTitle("işlem başarısız");
							alert.setHeaderText("hata oluştu");
							alert.setContentText("Sınav silinemedi. Bir sınav seçili olduğundan emin olun");
							alert.showAndWait().orElse(null);
						}
						else
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("işlem başarılı");
							alert.setHeaderText("işlem başarıyla tamamlandı");
							alert.setContentText("Sınav başarıyla silindi");
							alert.showAndWait().orElse(null);
							
							try 
							{
								examList=dao.getAllExams();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
							cb_exams.getItems().clear();
							if(examList!=null)
							{
								cb_exams.getItems().addAll(examList);
							}
							ONTESTTableView.getItems().clear();
							SONTESTTableView.getItems().clear();
							TESTTableView.getItems().clear();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			deleteExamButton=new Button("Seçili Sınavı Sil");
			deleteExamButton.setPrefHeight(standard_element_height);
			deleteExamButton.setPrefWidth(standard_element_width);
			deleteExamButton.setLayoutX(base_x);
			deleteExamButton.setLayoutY(base_y + y_dif*3);
			pane.getChildren().add(deleteExamButton);
			deleteExamButton.setOnAction(deleteExamEventHandler);
			
			EventHandler<ActionEvent> openUpdatingExamWindowEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(selectedExam!=null)
					{
						Group root=new Group();
						Scene scene=new Scene(root);
						Stage stage=new Stage();
						stage.setScene(scene);
						stage.getIcons().add(
								new Image(UpdatingExamWindow.class
								.getResourceAsStream(Main.logo)));
						stage.setTitle("Sınav Güncelleme Sayfası");
						UpdatingExamWindow window=new UpdatingExamWindow();
						
						try {
							window.examToBeUpdated=(Exam)cb_exams.getValue();
							window.start(stage);
							primaryStage.hide();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir sınav seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
					
				}
				
			};
			
			updateExamButton=new Button("Seçili sınavı Güncelle");
			updateExamButton.setStyle("-fx-font-size: 12");
			updateExamButton.setPrefHeight(standard_element_height);
			updateExamButton.setPrefWidth(standard_element_width);
			updateExamButton.setLayoutX(base_x);
			updateExamButton.setLayoutY(base_y + y_dif*4);
			pane.getChildren().add(updateExamButton);
			updateExamButton.setOnAction(openUpdatingExamWindowEventHandler);
			
			EventHandler<ActionEvent> importDataEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(selectedExam!=null)
					{
						DirectoryChooser dc=new DirectoryChooser();
						dc.setTitle("Test kağıtlarının fotoğraflarının bulunduğu klasörü seçin");
						String userHome=System.getProperty("user.home");
						File initialDirectory1=new File(userHome,"Desktop");
						File selectedDirectory=null;
						if (initialDirectory1 != null && initialDirectory1.isDirectory())
						{
							dc.setInitialDirectory(initialDirectory1);
							
						}
						else
						{
							File initialDirectory2=new File(userHome,"OneDrive/Desktop");
							dc.setInitialDirectory(initialDirectory2);
						}
						selectedDirectory=dc.showDialog(primaryStage);
						if (selectedDirectory != null && selectedDirectory.isDirectory()) 
						{
							
						    File[] files = selectedDirectory.listFiles();
						    for(File file : files)
						    {
						    	ParticipantAnswer pa=null;
						    	try 
						    	{
									pa=ExamEvaluator
											.createParticipantAnswerWithInformation
													(ps, file.getAbsolutePath(), selectedExam);
									
								} 
						    	catch (Exception e) 
						    	{
									
									e.printStackTrace();
								} 
						    	
						    	try 
						    	{
									dao.insertIntoParticipantAnswerTable(pa);
								} 
						    	catch (SQLException e) 
						    	{
									
									e.printStackTrace();
								}
						    }
						    
						    try 
							{
								listOfONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
							} 
							catch (SQLException e) 
							{
								
								e.printStackTrace();
							}
							try 
							{
								listOfSONTESTS=dao.getSONTESTParticipantAnswersByExam(selectedExam);
							} catch (SQLException e) 
							{
								
								e.printStackTrace();
							}
							try 
							{
								listOfTESTS=dao.getTESTParticipantAnswersByExam(selectedExam);
							} 
							catch (SQLException e) 
							{
								
								e.printStackTrace();
							}
							SONTESTTableView.getItems().clear();
							SONTESTTableView.getItems().addAll(listOfSONTESTS);
							ONTESTTableView.getItems().clear();
							ONTESTTableView.getItems().addAll(listOfONTESTS);
							TESTTableView.getItems().clear();
							TESTTableView.getItems().addAll(listOfTESTS);
						  
						  }
						
						}
						else
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("Dikkat");
							alert.setHeaderText("Uyarı");
							alert.setContentText("Bunu yapmak için önce bir sınav seçmeniz gerekir");
							alert.showAndWait().orElse(null);
						}
					
					
				}
				
			};
			
			importDataButton=new Button("Okunacak klasör seç");
			importDataButton.setStyle("-fx-font-size: 12");
			importDataButton.setPrefHeight(standard_element_height);
			importDataButton.setPrefWidth(standard_element_width);
			importDataButton.setLayoutX(base_x);
			importDataButton.setLayoutY(base_y + y_dif*5);
			pane.getChildren().add(importDataButton);
			importDataButton.setOnAction(importDataEventHandler);
			
			
			
			EventHandler<ActionEvent> updateSelectedONTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(ONTESTTableView.getSelectionModel().getSelectedItem()!=null)
					{
						Group root=new Group();
						Scene scene=new Scene(root);
						Stage stage=new Stage();
						stage.setScene(scene);
						stage.getIcons().add(
								new Image(UpdatingParticipantAnswerWindow.class
								.getResourceAsStream(Main.logo)));
						stage.setTitle("Cevap Güncelleme Sayfası");
						UpdatingParticipantAnswerWindow window=new UpdatingParticipantAnswerWindow();
						
						try 
						{
							window.paToBeUpdated=ONTESTTableView.getSelectionModel().getSelectedItem();
							window.start(stage);
							primaryStage.hide();
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir ön test cevabı seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
					
					
				}
				
			};
			
			updateSelectedONTESTButton=new Button("Seçili Ön Testi Güncelle");
			updateSelectedONTESTButton.setStyle("-fx-font-size: 11");
			updateSelectedONTESTButton.setPrefHeight(standard_element_height);
			updateSelectedONTESTButton.setPrefWidth(standard_element_width);
			updateSelectedONTESTButton.setLayoutX(base_x);
			updateSelectedONTESTButton.setLayoutY(base_y +y_dif*6);
			pane.getChildren().add(updateSelectedONTESTButton);
			updateSelectedONTESTButton.setOnAction(updateSelectedONTESTEventHandler);
			

			EventHandler<ActionEvent> updateSelectedSONTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					if(SONTESTTableView.getSelectionModel().getSelectedItem()!=null)
					{
						Group root=new Group();
						Scene scene=new Scene(root);
						Stage stage=new Stage();
						stage.setScene(scene);
						stage.getIcons().add(
								new Image(UpdatingParticipantAnswerWindow.class
								.getResourceAsStream(Main.logo)));
						stage.setTitle("Cevap Güncelleme Sayfası");
						UpdatingParticipantAnswerWindow window=new UpdatingParticipantAnswerWindow();
						
						try 
						{
							window.paToBeUpdated=SONTESTTableView.getSelectionModel().getSelectedItem();
							window.start(stage);
							primaryStage.hide();
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir son test cevabı seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
					
					
				}
				
			};
			
			updateSelectedSONTESTButton=new Button("Seçili Son Testi Güncelle");
			updateSelectedSONTESTButton.setStyle("-fx-font-size: 11");
			updateSelectedSONTESTButton.setPrefHeight(standard_element_height);
			updateSelectedSONTESTButton.setPrefWidth(standard_element_width);
			updateSelectedSONTESTButton.setLayoutX(base_x);
			updateSelectedSONTESTButton.setLayoutY(base_y +y_dif*7);
			pane.getChildren().add(updateSelectedSONTESTButton);
			updateSelectedSONTESTButton.setOnAction(updateSelectedSONTESTEventHandler);
			
			EventHandler<ActionEvent> updateSelectedTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					if(TESTTableView.getSelectionModel().getSelectedItem()!=null)
					{
						Group root=new Group();
						Scene scene=new Scene(root);
						Stage stage=new Stage();
						stage.setScene(scene);
						stage.getIcons().add(
								new Image(UpdatingParticipantAnswerWindow.class
								.getResourceAsStream(Main.logo)));
						stage.setTitle("Cevap Güncelleme Sayfası");
						UpdatingParticipantAnswerWindow window=new UpdatingParticipantAnswerWindow();
						
						try 
						{
							window.paToBeUpdated=TESTTableView.getSelectionModel().getSelectedItem();
							window.start(stage);
							primaryStage.hide();
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir test cevabı seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
					
					
					
				}
				
			};
			
			updateSelectedTESTButton=new Button("Seçili Testi Güncelle");
			updateSelectedTESTButton.setPrefHeight(standard_element_height);
			updateSelectedTESTButton.setPrefWidth(standard_element_width);
			updateSelectedTESTButton.setLayoutX(base_x);
			updateSelectedTESTButton.setLayoutY(base_y +y_dif*8);
			pane.getChildren().add(updateSelectedTESTButton);
			updateSelectedTESTButton.setOnAction(updateSelectedTESTEventHandler);
			
			
			EventHandler<ActionEvent> deleteSelectedONTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					ParticipantAnswer pon=ONTESTTableView.getSelectionModel().getSelectedItem();
					if(pon!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız seçili ön test silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
						  try 
						  {
							dao.deleteParticipantAnswerById(pon.getId());
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  try 
						  {
							listOfONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  ONTESTTableView.getItems().clear();
						  ONTESTTableView.getItems().addAll(listOfONTESTS);
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteSelectedONTESTButton=new Button("Seçili Ön Testi Sil");
			deleteSelectedONTESTButton.setPrefHeight(standard_element_height);
			deleteSelectedONTESTButton.setPrefWidth(standard_element_width);
			deleteSelectedONTESTButton.setLayoutX(base_x);
			deleteSelectedONTESTButton.setLayoutY(base_y +y_dif*9);
			pane.getChildren().add(deleteSelectedONTESTButton);
			deleteSelectedONTESTButton.setOnAction(deleteSelectedONTESTEventHandler);
			
			EventHandler<ActionEvent> deleteAllONTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(listOfONTESTS!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız tüm ön testler silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							
							while(0<listOfONTESTS.size())
							{
								try 
								{
									dao.deleteParticipantAnswerById(listOfONTESTS.get(0).getId());
									listOfONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
							}
						  
						  
						  ONTESTTableView.getItems().clear();
						  if(listOfONTESTS!=null)
						  {
						  ONTESTTableView.getItems().addAll(listOfONTESTS);
						  }
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteAllONTESTSButton=new Button("Tüm Ön Testleri Sil");
			deleteAllONTESTSButton.setPrefHeight(standard_element_height);
			deleteAllONTESTSButton.setPrefWidth(standard_element_width);
			deleteAllONTESTSButton.setLayoutX(base_x);
			deleteAllONTESTSButton.setLayoutY(base_y +y_dif*10);
			pane.getChildren().add(deleteAllONTESTSButton);
			deleteAllONTESTSButton.setOnAction(deleteAllONTESTSEventHandler);

			EventHandler<ActionEvent> deleteSelectedSONTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					ParticipantAnswer pson=SONTESTTableView.getSelectionModel().getSelectedItem();
					if(pson!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız seçili son test silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
						  try 
						  {
							dao.deleteParticipantAnswerById(pson.getId());
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  try 
						  {
							listOfSONTESTS=dao.getSONTESTParticipantAnswersByExam(selectedExam);
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  SONTESTTableView.getItems().clear();
						  SONTESTTableView.getItems().addAll(listOfSONTESTS);
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteSelectedSONTESTButton=new Button("Seçili Son Testi Sil");
			deleteSelectedSONTESTButton.setPrefHeight(standard_element_height);
			deleteSelectedSONTESTButton.setPrefWidth(standard_element_width);
			deleteSelectedSONTESTButton.setLayoutX(base_x);
			deleteSelectedSONTESTButton.setLayoutY(base_y +y_dif*11);
			pane.getChildren().add(deleteSelectedSONTESTButton);
			deleteSelectedSONTESTButton.setOnAction(deleteSelectedSONTESTEventHandler);
			
			EventHandler<ActionEvent> deleteAllSONTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(listOfSONTESTS!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız tüm son testler silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							
							while(0<listOfSONTESTS.size())
							{
								try 
								{
									dao.deleteParticipantAnswerById(listOfSONTESTS.get(0).getId());
									listOfSONTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
							}
						  
						  
						  SONTESTTableView.getItems().clear();
						  if(listOfSONTESTS!=null)
						  {
						  SONTESTTableView.getItems().addAll(listOfSONTESTS);
						  }
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteAllSONTESTSButton=new Button("Tüm Son Testleri Sil");
			deleteAllSONTESTSButton.setPrefHeight(standard_element_height);
			deleteAllSONTESTSButton.setPrefWidth(standard_element_width);
			deleteAllSONTESTSButton.setLayoutX(base_x);
			deleteAllSONTESTSButton.setLayoutY(base_y +y_dif*12);
			pane.getChildren().add(deleteAllSONTESTSButton);
			deleteAllSONTESTSButton.setOnAction(deleteAllSONTESTSEventHandler);
			
			EventHandler<ActionEvent> deleteSelectedTESTEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					ParticipantAnswer pt=TESTTableView.getSelectionModel().getSelectedItem();
					if(pt!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız seçili test silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
						  try 
						  {
							dao.deleteParticipantAnswerById(pt.getId());
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  try 
						  {
							listOfTESTS=dao.getTESTParticipantAnswersByExam(selectedExam);
						  } 
						  catch (SQLException e) 
						  {
							
							e.printStackTrace();
						  }
						  TESTTableView.getItems().clear();
						  TESTTableView.getItems().addAll(listOfTESTS);
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteSelectedTESTButton=new Button("Seçili Sınıfsız Testi Sil");
			deleteSelectedTESTButton.setStyle("-fx-font-size: 11");
			deleteSelectedTESTButton.setPrefHeight(standard_element_height);
			deleteSelectedTESTButton.setPrefWidth(standard_element_width);
			deleteSelectedTESTButton.setLayoutX(base_x);
			deleteSelectedTESTButton.setLayoutY(base_y +y_dif*13);
			pane.getChildren().add(deleteSelectedTESTButton);
			deleteSelectedTESTButton.setOnAction(deleteSelectedTESTEventHandler);
			
			EventHandler<ActionEvent> deleteAllTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					
					if(listOfTESTS!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız tüm sınıflandırılmalış testler silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							
							while(0<listOfTESTS.size())
							{
								try 
								{
									dao.deleteParticipantAnswerById(listOfTESTS.get(0).getId());
									listOfTESTS=dao.getONTESTParticipantAnswersByExam(selectedExam);
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
							}
						  
						  
						  TESTTableView.getItems().clear();
						  if(listOfTESTS!=null)
						  {
						  TESTTableView.getItems().addAll(listOfTESTS);
						  }
						}
						else
						{
							
						}
					}
					
					
				}
				
			};
			
			deleteAllTESTSButton=new Button("Tüm Sınıfsız Testleri Sil");
			deleteAllTESTSButton.setStyle("-fx-font-size: 11");
			deleteAllTESTSButton.setPrefHeight(standard_element_height);
			deleteAllTESTSButton.setPrefWidth(standard_element_width);
			deleteAllTESTSButton.setLayoutX(base_x);
			deleteAllTESTSButton.setLayoutY(base_y +y_dif*14);
			pane.getChildren().add(deleteAllTESTSButton);
			deleteAllTESTSButton.setOnAction(deleteAllTESTSEventHandler);
			
			
			EventHandler<ActionEvent> deleteAllParticipantAnswersEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Dikkat");
					alert.setHeaderText("Uyarı");
					alert.setContentText("Bunu yaparsanız veritanabındaki tüm testler silinecektir");
					ButtonType bt=alert.showAndWait().orElse(null);
					if(bt.equals(ButtonType.OK))
					{
						try 
						{
							dao.dropParticipantAnswerTable();
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
						try 
						{
							dao.createParticipantAnswerTable();
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
						listOfONTESTS.clear();
						listOfSONTESTS.clear();
						listOfTESTS.clear();
						ONTESTTableView.getItems().clear();
						SONTESTTableView.getItems().clear();
						TESTTableView.getItems().clear();
					}
					else
					{
						
					}
					
					
					
					
					
				}
				
			};
			
			deleteAllParticipantAnswersButton=new Button("Tüm Testleri Sil");
			deleteAllParticipantAnswersButton.setPrefHeight(standard_element_height);
			deleteAllParticipantAnswersButton.setPrefWidth(standard_element_width);
			deleteAllParticipantAnswersButton.setLayoutX(base_x);
			deleteAllParticipantAnswersButton.setLayoutY(base_y +y_dif*15);
			pane.getChildren().add(deleteAllParticipantAnswersButton);
			deleteAllParticipantAnswersButton.setOnAction(deleteAllParticipantAnswersEventHandler);
			
			EventHandler<ActionEvent> clearProgramTablesEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Dikkat");
					alert.setHeaderText("Dikkat");
					alert.setContentText("Bunu yaparsanız veri tabanındaki veriler tamamen silinecektir");
					ButtonType bt=alert.showAndWait().orElse(null);
					if(bt.equals(ButtonType.OK))
					{
						try 
						{
							dao.clearProgramTables();
							cb_exams.getItems().clear();
							SONTESTTableView.getItems().clear();
							ONTESTTableView.getItems().clear();
							TESTTableView.getItems().clear();
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
					}
					
					
				}
				
			};
			
			clearProgramTablesButton=new Button("Veri Tabanını Sil");
			clearProgramTablesButton.setPrefHeight(standard_element_height);
			clearProgramTablesButton.setPrefWidth(standard_element_width);
			clearProgramTablesButton.setLayoutX(base_x);
			clearProgramTablesButton.setLayoutY(base_y +y_dif*16);
			pane.getChildren().add(clearProgramTablesButton);
			clearProgramTablesButton.setOnAction(clearProgramTablesEventHandler);
			
			EventHandler<ActionEvent> exportONTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					if(selectedExam!=null)
					{
						FileChooser fileChooser = new FileChooser();
						 
			            fileChooser.setTitle("Kaydedilecek Dosyayı Seçiniz");
			            File initialDirectory1=new File(System.getProperty("user.home") + "/Desktop");
			            File initialDirectory2=new File(System.getProperty("user.home") + "/OneDrive/Desktop");
			            if(initialDirectory1!=null&&initialDirectory1.exists()&&initialDirectory1.isDirectory())
			            {
			            	fileChooser.setInitialDirectory(initialDirectory1);
			            }
			            else
			            {
			            	fileChooser.setInitialDirectory(initialDirectory2);
			            }
			            
			            fileChooser.setInitialFileName("yeni_dosya_on_test.xlsx");

			            fileChooser.getExtensionFilters().add(
			                new FileChooser.ExtensionFilter("Dosya Formatları", "*.xlsx")
			            );

			            File selectedFile = fileChooser.showSaveDialog(primaryStage);
			            String os = System.getProperty("os.name").toLowerCase();
			            String pathToSave="";
			            pathToSave=System.getProperty("user.home")
			            								+"/Desktop/"
			            									+fileChooser.getInitialFileName();
			            if(selectedFile!=null)
			            {
			            	pathToSave=selectedFile.getAbsolutePath();
			            	try 
				            {
			            		if(listOfONTESTS.size()>0)
				            	{
									OutputWriter.writeToXlsx(pathToSave, listOfONTESTS, "ON TEST");
				            	}
				            	else
				            	{
				            		Alert alert=new Alert(AlertType.INFORMATION);
									alert.setTitle("Dikkat");
									alert.setHeaderText("Uyarı");
									alert.setContentText("Çıktı alınacak ön test mevcut değil");
									alert.showAndWait().orElse(null);
				            	}
							} 
				            catch (IOException e) 
				            {
								e.printStackTrace();
							}
			            }
			            else
			            {
			            	
			            }
			            
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir sınav seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
					
					
				}
				
			};
			
			exportONTESTSButton=new Button("Ön Testleri Çıktı Al");
			exportONTESTSButton.setPrefHeight(standard_element_height);
			exportONTESTSButton.setPrefWidth(standard_element_width);
			exportONTESTSButton.setLayoutX(base_x);
			exportONTESTSButton.setLayoutY(base_y +y_dif*17);
			pane.getChildren().add(exportONTESTSButton);
			exportONTESTSButton.setOnAction(exportONTESTSEventHandler);
			
			EventHandler<ActionEvent> exportSONTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					if(selectedExam!=null)
					{
						FileChooser fileChooser = new FileChooser();
						 
			            fileChooser.setTitle("Kaydedilecek Dosyayı Seçiniz");
			            File initialDirectory1=new File(System.getProperty("user.home") + "/Desktop");
			            File initialDirectory2=new File(System.getProperty("user.home") + "/OneDrive/Desktop");
			            if(initialDirectory1!=null&&initialDirectory1.exists()&&initialDirectory1.isDirectory())
			            {
			            	fileChooser.setInitialDirectory(initialDirectory1);
			            }
			            else
			            {
			            	fileChooser.setInitialDirectory(initialDirectory2);
			            }
				            fileChooser.setInitialFileName("yeni_dosya_son_test.xlsx");

				            fileChooser.getExtensionFilters().add(
				                new FileChooser.ExtensionFilter("Dosya Formatları", "*.xlsx")
				            );

				            File selectedFile = fileChooser.showSaveDialog(primaryStage);
				            String os = System.getProperty("os.name").toLowerCase();
				            String pathToSave="";
				            pathToSave=System.getProperty("user.home")
				            								+"/Desktop/"
				            									+fileChooser.getInitialFileName();
				            if(selectedFile!=null)
				            {
				            	pathToSave=selectedFile.getAbsolutePath();
				            	try 
					            {	if(listOfSONTESTS.size()>0)
					            	{
										OutputWriter.writeToXlsx(pathToSave, listOfSONTESTS,"SON TEST");
					            	}
					            	else
					            	{
					            		Alert alert=new Alert(AlertType.INFORMATION);
										alert.setTitle("Dikkat");
										alert.setHeaderText("Uyarı");
										alert.setContentText("Çıktı alınacak son test mevcut değil");
										alert.showAndWait().orElse(null);
					            	}
								} 
					            catch (IOException e) 
					            {
									e.printStackTrace();
								}
				            }
				            else
				            {
				            	
				            }
				            
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir sınav seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
			            
					
					
				}
				
			};
			
			exportSONTESTSButton=new Button("Son Testleri Çıktı Al");
			exportSONTESTSButton.setPrefHeight(standard_element_height);
			exportSONTESTSButton.setPrefWidth(standard_element_width);
			exportSONTESTSButton.setLayoutX(base_x);
			exportSONTESTSButton.setLayoutY(base_y +y_dif*18);
			pane.getChildren().add(exportSONTESTSButton);
			exportSONTESTSButton.setOnAction(exportSONTESTSEventHandler);
			
			
			EventHandler<ActionEvent> exportAllONAndSONTESTSEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					if(selectedExam!=null)
					{
						FileChooser fileChooser = new FileChooser();
						 
			            fileChooser.setTitle("Kaydedilecek Dosyayı Seçiniz");
			            File initialDirectory1=new File(System.getProperty("user.home") + "/Desktop");
			            File initialDirectory2=new File(System.getProperty("user.home") + "/OneDrive/Desktop");
			            if(initialDirectory1!=null&&initialDirectory1.exists()&&initialDirectory1.isDirectory())
			            {
			            	fileChooser.setInitialDirectory(initialDirectory1);
			            }
			            else
			            {
			            	fileChooser.setInitialDirectory(initialDirectory2);
			            }
				            fileChooser.setInitialFileName("yeni_dosya_tum_testler.xlsx");

				            fileChooser.getExtensionFilters().add(
				                new FileChooser.ExtensionFilter("Dosya Formatları", "*.xlsx")
				            );

				            File selectedFile = fileChooser.showSaveDialog(primaryStage);
				            String os = System.getProperty("os.name").toLowerCase();
				            String pathToSave="";
				            pathToSave=System.getProperty("user.home")
				            								+"/Desktop/"
				            									+fileChooser.getInitialFileName();
				            if(selectedFile!=null)
				            {
				            	pathToSave=selectedFile.getAbsolutePath();
				            	try 
					            {
									try 
									{
										if(listOfSONTESTS.size()>0&&listOfONTESTS.size()>0)
						            	{
											OutputWriter.writeToSameXlsxAllONAndSONTESTES(pathToSave, 
													listOfONTESTS, listOfSONTESTS);
											
						            	}
										else if(listOfONTESTS.size()>0)
										{
											OutputWriter.writeToXlsx(pathToSave, listOfONTESTS,"ON TEST");
										}
										else if(listOfSONTESTS.size()>0)
										{
											OutputWriter.writeToXlsx(pathToSave, listOfSONTESTS,"SON TEST");
										}
						            	else
						            	{
						            		Alert alert=new Alert(AlertType.INFORMATION);
											alert.setTitle("Dikkat");
											alert.setHeaderText("Uyarı");
											alert.setContentText("Çıktı alınacak ön ve son test mevcut değil");
											alert.showAndWait().orElse(null);
						            	}
										
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
								} 
					            catch (Exception e) 
					            {
									e.printStackTrace();
								}
				            }
				            else
				            {
				            	
				            }
				            
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yapmak için önce bir sınav seçmeniz gerekir");
						alert.showAndWait().orElse(null);
					}
					
			            
					
					
				}
				
			};
			
			exportAllONAndSONTESTSButton=new Button("Tüm Testleri Çıktı Al");
			exportAllONAndSONTESTSButton.setPrefHeight(standard_element_height);
			exportAllONAndSONTESTSButton.setPrefWidth(standard_element_width);
			exportAllONAndSONTESTSButton.setLayoutX(base_x);
			exportAllONAndSONTESTSButton.setLayoutY(base_y +y_dif*19);
			pane.getChildren().add(exportAllONAndSONTESTSButton);
			exportAllONAndSONTESTSButton.setOnAction(exportAllONAndSONTESTSEventHandler);
			
			EventHandler<ActionEvent> openSettingsEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					Group root=new Group();
					Scene scene=new Scene(root);
					Stage stage=new Stage();
					stage.setScene(scene);
					stage.getIcons().add(
							new Image(SettingsWindow.class
							.getResourceAsStream(Main.logo)));
					stage.setTitle("Ayarlar Sayfası");
					SettingsWindow window=new SettingsWindow();
					
					try {
						window.start(stage);
						primaryStage.hide();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			settingsButton=new Button("Ayarlar");
			settingsButton.setPrefHeight(standard_element_height);
			settingsButton.setPrefWidth(standard_element_width);
			settingsButton.setLayoutX(base_x);
			settingsButton.setLayoutY(base_y + y_dif*20);
			pane.getChildren().add(settingsButton);
			settingsButton.setOnAction(openSettingsEventHandler);
			
			
			
			
			
	   	        
		
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
