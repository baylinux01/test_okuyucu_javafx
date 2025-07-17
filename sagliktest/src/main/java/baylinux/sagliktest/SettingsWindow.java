package baylinux.sagliktest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class SettingsWindow extends Application {
	
	protected static Label lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb10b,lb10c,lb10d,lb10e,
	lb11,lb12,lb13,lb14,
	lb15,lb16,lb17,lb18,
	lb19,lb20,lb21,lb21b,lb21c,lb22,
	lb23,lb24,lb25,lb26,lb27;
	protected static TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	protected static ComboBox<Integer> cb_tesseract_page_seg_mode,
	cb_tesseract_ocr_engine_mode,cb_x_start,cb_y_start,
	cb_min_area_threshold_for_noise,
	cb_width_percentage_to_be_cut,cb_height_percentage_to_be_cut,
	cb_white_ratio_limit_value,cb_row_number,cb_column_number,
	cb_erosion_degree,cb_dilation_degree,
	cb_horizontal_kernel_length_division_factor,cb_vertical_kernel_length_division_factor,
	cb_horizontal_erosion_iteration_number,cb_vertical_erosion_iteration_number,
	cb_horizontal_dilation_iteration_number,cb_vertical_dilation_iteration_number,
	cb_max_y_dif_for_intersection_points,cb_cell_mat_width_crop_degree_factor,
	cb_margin_x,cb_margin_y,
	cb_resized_width_for_title,cb_resized_height_for_title,
	cb_resized_width_for_table,cb_resized_height_for_table;
	protected static ComboBox<String> cb_dont_read_first_row,cb_dont_read_first_column;
	
	protected static Button defaultsButton,saveButton,goToProgramWindowButton;
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1260,680);
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
			
			Dao dao=new Dao();
			DefaultSettings ds=dao.getDefaultSettings();
			PreferredSettings ps=dao.getPreferredSettings();
			
			Pane pane=new Pane();
			pane.setPrefHeight(600);
			pane.setPrefWidth(600);
			root.getChildren().add(pane);
			
			int base_x=5;
			int base_y=5;
			int x_dif=310;
			int y_dif=25;
			
			int standart_element_height=30;
			int standart_element_width=300;
			
			lb1=new Label("Tesseract Veri Yolu:");
			lb1.setPrefHeight(standart_element_height);
			lb1.setPrefWidth(standart_element_width);
			lb1.setLayoutX(base_x);
			lb1.setLayoutY(base_y);
			pane.getChildren().add(lb1);
			
			tf1=new TextField(ps.getTesseract_data_path());
			tf1.setPrefHeight(standart_element_height);
			tf1.setPrefWidth(standart_element_width);
			tf1.setLayoutX(base_x);
			tf1.setLayoutY(base_y+y_dif);
			pane.getChildren().add(tf1);
			
			lb2=new Label("Tesseract Dili:");
			lb2.setPrefHeight(standart_element_height);
			lb2.setPrefWidth(standart_element_width);
			lb2.setLayoutX(base_x);
			lb2.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(lb2);
			
			tf2=new TextField(ps.getTesseract_language());
			tf2.setPrefHeight(standart_element_height);
			tf2.setPrefWidth(standart_element_width);
			tf2.setLayoutX(base_x);
			tf2.setLayoutY(base_y+y_dif*4);
			pane.getChildren().add(tf2);
			
			lb3=new Label("Tesseract Page Seg Mode:");
			lb3.setPrefHeight(standart_element_height);
			lb3.setPrefWidth(standart_element_width);
			lb3.setLayoutX(base_x);
			lb3.setLayoutY(base_y+y_dif*6);
			pane.getChildren().add(lb3);
			
			cb_tesseract_page_seg_mode=new ComboBox<Integer>();
			cb_tesseract_page_seg_mode.setPrefHeight(standart_element_height);
			cb_tesseract_page_seg_mode.setPrefWidth(standart_element_width);
			cb_tesseract_page_seg_mode.setLayoutX(base_x);
			cb_tesseract_page_seg_mode.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_tesseract_page_seg_mode);
			cb_tesseract_page_seg_mode.getItems().clear();
			cb_tesseract_page_seg_mode.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
			cb_tesseract_page_seg_mode.getSelectionModel()
									.select(Integer.valueOf(ps.getTesseract_page_seg_mode()));
			
			lb4=new Label("Tesseract OCR Engine Mode:");
			lb4.setPrefHeight(standart_element_height);
			lb4.setPrefWidth(standart_element_width);
			lb4.setLayoutX(base_x);
			lb4.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(lb4);
			
			cb_tesseract_ocr_engine_mode=new ComboBox<Integer>();
			cb_tesseract_ocr_engine_mode.setPrefHeight(standart_element_height);
			cb_tesseract_ocr_engine_mode.setPrefWidth(standart_element_width);
			cb_tesseract_ocr_engine_mode.setLayoutX(base_x);
			cb_tesseract_ocr_engine_mode.setLayoutY(base_y+y_dif*10);
			pane.getChildren().add(cb_tesseract_ocr_engine_mode);
			cb_tesseract_ocr_engine_mode.getItems().clear();
			cb_tesseract_ocr_engine_mode.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
			cb_tesseract_ocr_engine_mode.getSelectionModel()
										.select(Integer.valueOf(ps.getTesseract_ocr_engine_mode()));
			
			lb5=new Label("Temizlenecek gürültü için minimum alan eşiği:");
			lb5.setPrefHeight(standart_element_height);
			lb5.setPrefWidth(standart_element_width);
			lb5.setLayoutX(base_x);
			lb5.setLayoutY(base_y+y_dif*12);
			pane.getChildren().add(lb5);
			
			cb_min_area_threshold_for_noise=new ComboBox<Integer>();
			cb_min_area_threshold_for_noise.setPrefHeight(standart_element_height);
			cb_min_area_threshold_for_noise.setPrefWidth(standart_element_width);
			cb_min_area_threshold_for_noise.setLayoutX(base_x);
			cb_min_area_threshold_for_noise.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_min_area_threshold_for_noise);
			cb_min_area_threshold_for_noise.getItems().clear();
			cb_min_area_threshold_for_noise.getItems()
								.addAll(0,10,15,20,25,50,55,60,65,70,71,72,73,74,75,76,77,78,79,80,85,90,95,100,125,150,175,200);
			cb_min_area_threshold_for_noise.getSelectionModel()
											.select(Integer.valueOf(ps.getMin_area_threshold_for_noise()));
			
			lb6=new Label("Başlık kısmı kesimi için başlangıç x koordinatı:");
			lb6.setPrefHeight(standart_element_height);
			lb6.setPrefWidth(standart_element_width);
			lb6.setLayoutX(base_x);
			lb6.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(lb6);
			
			cb_x_start=new ComboBox<Integer>();
			cb_x_start.setPrefHeight(standart_element_height);
			cb_x_start.setPrefWidth(standart_element_width);
			cb_x_start.setLayoutX(base_x);
			cb_x_start.setLayoutY(base_y+y_dif*16);
			pane.getChildren().add(cb_x_start);
			cb_x_start.getItems().clear();
			cb_x_start.getItems().addAll(0,100,200,300,400,500,600,700,800,900);
			cb_x_start.getSelectionModel()
										.select(Integer.valueOf(ps.getX_start()));
			
			lb7=new Label("Başlık kısmı kesimi için başlangıç y koordinatı:");
			lb7.setPrefHeight(standart_element_height);
			lb7.setPrefWidth(standart_element_width);
			lb7.setLayoutX(base_x);
			lb7.setLayoutY(base_y+y_dif*18);
			pane.getChildren().add(lb7);
			
			cb_y_start=new ComboBox<Integer>();
			cb_y_start.setPrefHeight(standart_element_height);
			cb_y_start.setPrefWidth(standart_element_width);
			cb_y_start.setLayoutX(base_x);
			cb_y_start.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_y_start);
			cb_y_start.getItems().clear();
			cb_y_start.getItems().addAll(0,100,200,300,400,500,600,700,800,900);
			cb_y_start.getSelectionModel()
										.select(Integer.valueOf(ps.getY_start()));
			
			
			
			lb8=new Label("Başlık kısmı kesimi için yüzde genişlik:");
			lb8.setPrefHeight(standart_element_height);
			lb8.setPrefWidth(standart_element_width);
			lb8.setLayoutX(base_x);
			lb8.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(lb8);
			
			cb_width_percentage_to_be_cut=new ComboBox<Integer>();
			cb_width_percentage_to_be_cut.setPrefHeight(standart_element_height);
			cb_width_percentage_to_be_cut.setPrefWidth(standart_element_width);
			cb_width_percentage_to_be_cut.setLayoutX(base_x);
			cb_width_percentage_to_be_cut.setLayoutY(base_y+y_dif*22);
			pane.getChildren().add(cb_width_percentage_to_be_cut);
			cb_width_percentage_to_be_cut.getItems().clear();
			cb_width_percentage_to_be_cut.getItems().addAll(0,10,20,30,40,50,60,70,80,90,100);
			cb_width_percentage_to_be_cut.getSelectionModel()
										.select(Integer.valueOf(ps.getWidth_percentage_to_be_cut()));
			
			lb9=new Label("Başlık kısmı kesimi için yüzde yükseklik:");
			lb9.setPrefHeight(standart_element_height);
			lb9.setPrefWidth(standart_element_width);
			lb9.setLayoutX(base_x);
			lb9.setLayoutY(base_y+y_dif*24);
			pane.getChildren().add(lb9);
			
			cb_height_percentage_to_be_cut=new ComboBox<Integer>();
			cb_height_percentage_to_be_cut.setPrefHeight(standart_element_height);
			cb_height_percentage_to_be_cut.setPrefWidth(standart_element_width);
			cb_height_percentage_to_be_cut.setLayoutX(base_x);
			cb_height_percentage_to_be_cut.setLayoutY(base_y+y_dif*25);
			pane.getChildren().add(cb_height_percentage_to_be_cut);
			cb_height_percentage_to_be_cut.getItems().clear();
			cb_height_percentage_to_be_cut.getItems().addAll(0,10,20,30,40,50,60,70,80,90,100);
			cb_height_percentage_to_be_cut.getSelectionModel()
										.select(Integer.valueOf(ps.getHeight_percentage_to_be_cut()));
			
			lb10=new Label("Hücrenin dolu kabul edilmesi için eşik:");
			lb10.setPrefHeight(standart_element_height);
			lb10.setPrefWidth(standart_element_width);
			lb10.setLayoutX(base_x+x_dif*1);
			lb10.setLayoutY(base_y+y_dif*0);
			pane.getChildren().add(lb10);
			
			cb_white_ratio_limit_value=new ComboBox<Integer>();
			cb_white_ratio_limit_value.setPrefHeight(standart_element_height);
			cb_white_ratio_limit_value.setPrefWidth(standart_element_width);
			cb_white_ratio_limit_value.setLayoutX(base_x+x_dif*1);
			cb_white_ratio_limit_value.setLayoutY(base_y+y_dif*1);
			pane.getChildren().add(cb_white_ratio_limit_value);
			cb_white_ratio_limit_value.getItems().clear();
			cb_white_ratio_limit_value.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,20,25,30);
			cb_white_ratio_limit_value.getSelectionModel()
										.select(Integer.valueOf(ps.getWhite_ratio_limit_value()));
			
			lb10b=new Label("Başlık resmi için yeni genişlik");
			lb10b.setPrefHeight(standart_element_height);
			lb10b.setPrefWidth(standart_element_width);
			lb10b.setLayoutX(base_x+x_dif*1);
			lb10b.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(lb10b);
			
			cb_resized_width_for_title=new ComboBox<Integer>();
			cb_resized_width_for_title.setPrefHeight(standart_element_height);
			cb_resized_width_for_title.setPrefWidth(standart_element_width);
			cb_resized_width_for_title.setLayoutX(base_x+x_dif*1);
			cb_resized_width_for_title.setLayoutY(base_y+y_dif*4);
			pane.getChildren().add(cb_resized_width_for_title);
			cb_resized_width_for_title.getItems().clear();
			for(int a=1000;a<10001;a=a+100)
			{
			cb_resized_width_for_title.getItems().add(a);
			}
			cb_resized_width_for_title.getItems()
				.addAll(180,312,396,720,268,820,1024,1080,1280,1440,1584,1920,2160,2560,3120,3840,4160);
			cb_resized_width_for_title.getSelectionModel()
										.select(Integer.valueOf(ps.getResized_width_for_title()));
			
			lb10c=new Label("Başlık resmi için yeni yükseklik");
			lb10c.setPrefHeight(standart_element_height);
			lb10c.setPrefWidth(standart_element_width);
			lb10c.setLayoutX(base_x+x_dif*1);
			lb10c.setLayoutY(base_y+y_dif*6);
			pane.getChildren().add(lb10c);
			
			cb_resized_height_for_title=new ComboBox<Integer>();
			cb_resized_height_for_title.setPrefHeight(standart_element_height);
			cb_resized_height_for_title.setPrefWidth(standart_element_width);
			cb_resized_height_for_title.setLayoutX(base_x+x_dif*1);
			cb_resized_height_for_title.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_resized_height_for_title);
			cb_resized_height_for_title.getItems().clear();
			for(int a=1000;a<10001;a=a+100)
			{
			cb_resized_height_for_title.getItems().add(a);
			}
			cb_resized_height_for_title.getItems()
			.addAll(180,312,396,720,268,820,1024,1080,1280,1440,1584,1920,2160,2560,3120,3840,4160);
			cb_resized_height_for_title.getSelectionModel()
										.select(Integer.valueOf(ps.getResized_height_for_title()));
			
			
			lb10d=new Label("Tablo resmi için yeni genişlik");
			lb10d.setPrefHeight(standart_element_height);
			lb10d.setPrefWidth(standart_element_width);
			lb10d.setLayoutX(base_x+x_dif*1);
			lb10d.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(lb10d);
			
			cb_resized_width_for_table=new ComboBox<Integer>();
			cb_resized_width_for_table.setPrefHeight(standart_element_height);
			cb_resized_width_for_table.setPrefWidth(standart_element_width);
			cb_resized_width_for_table.setLayoutX(base_x+x_dif*1);
			cb_resized_width_for_table.setLayoutY(base_y+y_dif*10);
			pane.getChildren().add(cb_resized_width_for_table);
			cb_resized_width_for_table.getItems().clear();
			for(int a=1000;a<10001;a=a+100)
			{
			cb_resized_width_for_table.getItems().add(a);
			}
			cb_resized_width_for_table.getItems()
			.addAll(180,312,396,720,268,820,1024,1080,1280,1440,1584,1920,2160,2560,3120,3840,4160);
			cb_resized_width_for_table.getSelectionModel()
										.select(Integer.valueOf(ps.getResized_width_for_table()));
			
			lb10e=new Label("Tablo resmi için yeni yükseklik");
			lb10e.setPrefHeight(standart_element_height);
			lb10e.setPrefWidth(standart_element_width);
			lb10e.setLayoutX(base_x+x_dif*1);
			lb10e.setLayoutY(base_y+y_dif*12);
			pane.getChildren().add(lb10e);
			
			cb_resized_height_for_table=new ComboBox<Integer>();
			cb_resized_height_for_table.setPrefHeight(standart_element_height);
			cb_resized_height_for_table.setPrefWidth(standart_element_width);
			cb_resized_height_for_table.setLayoutX(base_x+x_dif*1);
			cb_resized_height_for_table.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_resized_height_for_table);
			cb_resized_height_for_table.getItems().clear();
			for(int a=1000;a<10001;a=a+100)
			{
			cb_resized_height_for_table.getItems().add(a);
			}
			cb_resized_height_for_table.getItems()
			.addAll(180,312,396,720,268,820,1024,1080,1280,1440,1584,1920,2160,2560,3120,3840,4160);
			cb_resized_height_for_table.getSelectionModel()
										.select(Integer.valueOf(ps.getResized_height_for_table()));
			
			lb11=new Label("Tablonun toplam satır sayısı:");
			lb11.setPrefHeight(standart_element_height);
			lb11.setPrefWidth(standart_element_width);
			lb11.setLayoutX(base_x+x_dif);
			lb11.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(lb11);
			
			cb_row_number=new ComboBox<Integer>();
			cb_row_number.setPrefHeight(standart_element_height);
			cb_row_number.setPrefWidth(standart_element_width);
			cb_row_number.setLayoutX(base_x+x_dif);
			cb_row_number.setLayoutY(base_y+y_dif*16);
			pane.getChildren().add(cb_row_number);
			cb_row_number.getItems().clear();
			cb_row_number.getItems().addAll(0,5,10,15,20,25,30);
			cb_row_number.getSelectionModel()
										.select(Integer.valueOf(ps.getRow_number()));
			
			lb12=new Label("Tablonun toplam sütun sayısı:");
			lb12.setPrefHeight(standart_element_height);
			lb12.setPrefWidth(standart_element_width);
			lb12.setLayoutX(base_x+x_dif);
			lb12.setLayoutY(base_y+y_dif*18);
			pane.getChildren().add(lb12);
			
			cb_column_number=new ComboBox<Integer>();
			cb_column_number.setPrefHeight(standart_element_height);
			cb_column_number.setPrefWidth(standart_element_width);
			cb_column_number.setLayoutX(base_x+x_dif);
			cb_column_number.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_column_number);
			cb_column_number.getItems().clear();
			cb_column_number.getItems().addAll(0,5,10,15,20,25,30);
			cb_column_number.getSelectionModel()
										.select(Integer.valueOf(ps.getColumn_number()));
			
			lb13=new Label("Tablonun ilk satırını okuma:");
			lb13.setPrefHeight(standart_element_height);
			lb13.setPrefWidth(standart_element_width);
			lb13.setLayoutX(base_x+x_dif);
			lb13.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(lb13);
			
			cb_dont_read_first_row=new ComboBox<String>();
			cb_dont_read_first_row.setPrefHeight(standart_element_height);
			cb_dont_read_first_row.setPrefWidth(standart_element_width);
			cb_dont_read_first_row.setLayoutX(base_x+x_dif);
			cb_dont_read_first_row.setLayoutY(base_y+y_dif*22);
			pane.getChildren().add(cb_dont_read_first_row);
			cb_dont_read_first_row.getItems().clear();
			cb_dont_read_first_row.getItems().addAll("Evet","Hayır");
			if(Integer.valueOf(ps.getDont_read_first_row())==1)
			{
				cb_dont_read_first_row.getSelectionModel()
				.select("Evet");
			}
			else
			{
				cb_dont_read_first_row.getSelectionModel()
				.select("Hayır");
			}
			
			lb14=new Label("Tablonun ilk sütununu okuma:");
			lb14.setPrefHeight(standart_element_height);
			lb14.setPrefWidth(standart_element_width);
			lb14.setLayoutX(base_x+x_dif);
			lb14.setLayoutY(base_y+y_dif*24);
			pane.getChildren().add(lb14);
			
			cb_dont_read_first_column=new ComboBox<String>();
			cb_dont_read_first_column.setPrefHeight(standart_element_height);
			cb_dont_read_first_column.setPrefWidth(standart_element_width);
			cb_dont_read_first_column.setLayoutX(base_x+x_dif);
			cb_dont_read_first_column.setLayoutY(base_y+y_dif*25);
			pane.getChildren().add(cb_dont_read_first_column);
			cb_dont_read_first_column.getItems().clear();
			cb_dont_read_first_column.getItems().addAll("Evet","Hayır");
			if(Integer.valueOf(ps.getDont_read_first_column())==1)
			{
				cb_dont_read_first_column.getSelectionModel()
				.select("Evet");
			}
			else
			{
				cb_dont_read_first_column.getSelectionModel()
				.select("Hayır");
			}
			
			lb15=new Label("Erezyon Derecesi");
			lb15.setPrefHeight(standart_element_height);
			lb15.setPrefWidth(standart_element_width);
			lb15.setLayoutX(base_x+x_dif*2);
			lb15.setLayoutY(base_y+y_dif*0);
			pane.getChildren().add(lb15);
			
			cb_erosion_degree=new ComboBox<Integer>();
			cb_erosion_degree.setPrefHeight(standart_element_height);
			cb_erosion_degree.setPrefWidth(standart_element_width);
			cb_erosion_degree.setLayoutX(base_x+x_dif*2);
			cb_erosion_degree.setLayoutY(base_y+y_dif);
			pane.getChildren().add(cb_erosion_degree);
			cb_erosion_degree.getItems().clear();
			cb_erosion_degree.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
			cb_erosion_degree.getSelectionModel()
				.select(Integer.valueOf(ps.getErosion_degree()));
			
			lb16=new Label("Dilasyon Derecesi");
			lb16.setPrefHeight(standart_element_height);
			lb16.setPrefWidth(standart_element_width);
			lb16.setLayoutX(base_x+x_dif*2);
			lb16.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(lb16);
			
			cb_dilation_degree=new ComboBox<Integer>();
			cb_dilation_degree.setPrefHeight(standart_element_height);
			cb_dilation_degree.setPrefWidth(standart_element_width);
			cb_dilation_degree.setLayoutX(base_x+x_dif*2);
			cb_dilation_degree.setLayoutY(base_y+y_dif*4);
			pane.getChildren().add(cb_dilation_degree);
			cb_dilation_degree.getItems().clear();
			cb_dilation_degree.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
			cb_dilation_degree.getSelectionModel()
				.select(Integer.valueOf(ps.getDilation_degree()));
			
			lb17=new Label("Yatay kernel bölme faktörü");
			lb17.setPrefHeight(standart_element_height);
			lb17.setPrefWidth(standart_element_width);
			lb17.setLayoutX(base_x+x_dif*2);
			lb17.setLayoutY(base_y+y_dif*6);
			pane.getChildren().add(lb17);
			
			cb_horizontal_kernel_length_division_factor=new ComboBox<Integer>();
			cb_horizontal_kernel_length_division_factor.setPrefHeight(standart_element_height);
			cb_horizontal_kernel_length_division_factor.setPrefWidth(standart_element_width);
			cb_horizontal_kernel_length_division_factor.setLayoutX(base_x+x_dif*2);
			cb_horizontal_kernel_length_division_factor.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_horizontal_kernel_length_division_factor);
			cb_horizontal_kernel_length_division_factor.getItems().clear();
			cb_horizontal_kernel_length_division_factor.getItems()
										.addAll(5,10,15,20,25,30,31,32,33,34,35,36,37,38,39,40,45,50);
			cb_horizontal_kernel_length_division_factor.getSelectionModel()
				.select(Integer.valueOf(ps.getHorizontal_kernel_length_division_factor()));
			
			lb18=new Label("Dikey kernel bölme faktörü");
			lb18.setPrefHeight(standart_element_height);
			lb18.setPrefWidth(standart_element_width);
			lb18.setLayoutX(base_x+x_dif*2);
			lb18.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(lb18);
			
			cb_vertical_kernel_length_division_factor=new ComboBox<Integer>();
			cb_vertical_kernel_length_division_factor.setPrefHeight(standart_element_height);
			cb_vertical_kernel_length_division_factor.setPrefWidth(standart_element_width);
			cb_vertical_kernel_length_division_factor.setLayoutX(base_x+x_dif*2);
			cb_vertical_kernel_length_division_factor.setLayoutY(base_y+y_dif*10);
			pane.getChildren().add(cb_vertical_kernel_length_division_factor);
			cb_vertical_kernel_length_division_factor.getItems().clear();
			cb_horizontal_kernel_length_division_factor.getItems()
										.addAll(5,10,15,20,25,30,31,32,33,34,35,36,37,38,39,40,45,50);
			cb_vertical_kernel_length_division_factor.getSelectionModel()
				.select(Integer.valueOf(ps.getVertical_kernel_length_division_factor()));
			
			lb19=new Label("Yatay erozyon iterasyon sayısı");
			lb19.setPrefHeight(standart_element_height);
			lb19.setPrefWidth(standart_element_width);
			lb19.setLayoutX(base_x+x_dif*2);
			lb19.setLayoutY(base_y+y_dif*12);
			pane.getChildren().add(lb19);
			
			cb_horizontal_erosion_iteration_number=new ComboBox<Integer>();
			cb_horizontal_erosion_iteration_number.setPrefHeight(standart_element_height);
			cb_horizontal_erosion_iteration_number.setPrefWidth(standart_element_width);
			cb_horizontal_erosion_iteration_number.setLayoutX(base_x+x_dif*2);
			cb_horizontal_erosion_iteration_number.setLayoutY(base_y+y_dif*13);
			pane.getChildren().add(cb_horizontal_erosion_iteration_number);
			cb_horizontal_erosion_iteration_number.getItems().clear();
			cb_horizontal_erosion_iteration_number.getItems()
										.addAll(1,2,3,4,5,6,7,8,9,10);
			cb_horizontal_erosion_iteration_number.getSelectionModel()
				.select(Integer.valueOf(ps.getHorizontal_erosion_iteration_number()));
			
			lb20=new Label("Dikey erozyon iterasyon sayısı");
			lb20.setPrefHeight(standart_element_height);
			lb20.setPrefWidth(standart_element_width);
			lb20.setLayoutX(base_x+x_dif*2);
			lb20.setLayoutY(base_y+y_dif*15);
			pane.getChildren().add(lb20);
			
			cb_vertical_erosion_iteration_number=new ComboBox<Integer>();
			cb_vertical_erosion_iteration_number.setPrefHeight(standart_element_height);
			cb_vertical_erosion_iteration_number.setPrefWidth(standart_element_width);
			cb_vertical_erosion_iteration_number.setLayoutX(base_x+x_dif*2);
			cb_vertical_erosion_iteration_number.setLayoutY(base_y+y_dif*16);
			pane.getChildren().add(cb_vertical_erosion_iteration_number);
			cb_vertical_erosion_iteration_number.getItems().clear();
			cb_vertical_erosion_iteration_number.getItems()
										.addAll(1,2,3,4,5,6,7,8,9,10);
			cb_vertical_erosion_iteration_number.getSelectionModel()
				.select(Integer.valueOf(ps.getVertical_erosion_iteration_number()));
			
			lb21=new Label("Yatay dilasyon iterasyon sayısı");
			lb21.setPrefHeight(standart_element_height);
			lb21.setPrefWidth(standart_element_width);
			lb21.setLayoutX(base_x+x_dif*2);
			lb21.setLayoutY(base_y+y_dif*18);
			pane.getChildren().add(lb21);
			
			lb21b=new Label("Hücreler için Margin X");
			lb21b.setPrefHeight(standart_element_height);
			lb21b.setPrefWidth(standart_element_width);
			lb21b.setLayoutX(base_x+x_dif*2);
			lb21b.setLayoutY(base_y+y_dif*21);
			pane.getChildren().add(lb21b);
			
			cb_margin_x=new ComboBox<Integer>();
			cb_margin_x.setPrefHeight(standart_element_height);
			cb_margin_x.setPrefWidth(standart_element_width);
			cb_margin_x.setLayoutX(base_x+x_dif*2);
			cb_margin_x.setLayoutY(base_y+y_dif*22);
			pane.getChildren().add(cb_margin_x);
			cb_margin_x.getItems().clear();
			cb_margin_x.getItems()
										.addAll(5,10,15,20,25,30,35,40);
			cb_margin_x.getSelectionModel()
				.select(Integer.valueOf(ps.getMargin_x()));
			
			lb21c=new Label("Hücreler için Margin Y");
			lb21c.setPrefHeight(standart_element_height);
			lb21c.setPrefWidth(standart_element_width);
			lb21c.setLayoutX(base_x+x_dif*2);
			lb21c.setLayoutY(base_y+y_dif*24);
			pane.getChildren().add(lb21c);
			
			cb_margin_y=new ComboBox<Integer>();
			cb_margin_y.setPrefHeight(standart_element_height);
			cb_margin_y.setPrefWidth(standart_element_width);
			cb_margin_y.setLayoutX(base_x+x_dif*2);
			cb_margin_y.setLayoutY(base_y+y_dif*25);
			pane.getChildren().add(cb_margin_y);
			cb_margin_y.getItems().clear();
			cb_margin_y.getItems()
										.addAll(5,10,15,20,25,30,35,40);
			cb_margin_y.getSelectionModel()
				.select(Integer.valueOf(ps.getMargin_y()));
			
			cb_horizontal_dilation_iteration_number=new ComboBox<Integer>();
			cb_horizontal_dilation_iteration_number.setPrefHeight(standart_element_height);
			cb_horizontal_dilation_iteration_number.setPrefWidth(standart_element_width);
			cb_horizontal_dilation_iteration_number.setLayoutX(base_x+x_dif*2);
			cb_horizontal_dilation_iteration_number.setLayoutY(base_y+y_dif*19);
			pane.getChildren().add(cb_horizontal_dilation_iteration_number);
			cb_horizontal_dilation_iteration_number.getItems().clear();
			cb_horizontal_dilation_iteration_number.getItems()
										.addAll(1,2,3,4,5,6,7,8,9,10);
			cb_horizontal_dilation_iteration_number.getSelectionModel()
				.select(Integer.valueOf(ps.getHorizontal_dilation_iteration_number()));
			
			lb22=new Label("Dikey dilasyon iterasyon sayısı");
			lb22.setPrefHeight(standart_element_height);
			lb22.setPrefWidth(standart_element_width);
			lb22.setLayoutX(base_x+x_dif*3);
			lb22.setLayoutY(base_y);
			pane.getChildren().add(lb22);
			
			cb_vertical_dilation_iteration_number=new ComboBox<Integer>();
			cb_vertical_dilation_iteration_number.setPrefHeight(standart_element_height);
			cb_vertical_dilation_iteration_number.setPrefWidth(standart_element_width);
			cb_vertical_dilation_iteration_number.setLayoutX(base_x+x_dif*3);
			cb_vertical_dilation_iteration_number.setLayoutY(base_y+y_dif);
			pane.getChildren().add(cb_vertical_dilation_iteration_number);
			cb_vertical_dilation_iteration_number.getItems().clear();
			cb_vertical_dilation_iteration_number.getItems()
										.addAll(1,2,3,4,5,6,7,8,9,10);
			cb_vertical_dilation_iteration_number.getSelectionModel()
				.select(Integer.valueOf(ps.getVertical_dilation_iteration_number()));
			
			lb23=new Label("Kesişim noktaları için maksimum dikey fark:");
			lb23.setPrefHeight(standart_element_height);
			lb23.setPrefWidth(standart_element_width);
			lb23.setLayoutX(base_x+x_dif*3);
			lb23.setLayoutY(base_y+y_dif*3);
			pane.getChildren().add(lb23);
			
			cb_max_y_dif_for_intersection_points=new ComboBox<Integer>();
			cb_max_y_dif_for_intersection_points.setPrefHeight(standart_element_height);
			cb_max_y_dif_for_intersection_points.setPrefWidth(standart_element_width);
			cb_max_y_dif_for_intersection_points.setLayoutX(base_x+x_dif*3);
			cb_max_y_dif_for_intersection_points.setLayoutY(base_y+y_dif*4);
			pane.getChildren().add(cb_max_y_dif_for_intersection_points);
			cb_max_y_dif_for_intersection_points.getItems().clear();
			cb_max_y_dif_for_intersection_points.getItems()
										.addAll(5,10,15,20,25,30,35,40);
			cb_max_y_dif_for_intersection_points.getSelectionModel()
				.select(Integer.valueOf(ps.getMax_y_dif_for_intersection_points()));
			
			
			lb24=new Label("Hücre Kırpma Faktörü");
			lb24.setPrefHeight(standart_element_height);
			lb24.setPrefWidth(standart_element_width);
			lb24.setLayoutX(base_x+x_dif*3);
			lb24.setLayoutY(base_y+y_dif*6);
			pane.getChildren().add(lb24);
			
			cb_cell_mat_width_crop_degree_factor=new ComboBox<Integer>();
			cb_cell_mat_width_crop_degree_factor.setPrefHeight(standart_element_height);
			cb_cell_mat_width_crop_degree_factor.setPrefWidth(standart_element_width);
			cb_cell_mat_width_crop_degree_factor.setLayoutX(base_x+x_dif*3);
			cb_cell_mat_width_crop_degree_factor.setLayoutY(base_y+y_dif*7);
			pane.getChildren().add(cb_cell_mat_width_crop_degree_factor);
			cb_cell_mat_width_crop_degree_factor.getItems().clear();
			cb_cell_mat_width_crop_degree_factor.getItems()
										.addAll(5,10,15,20,25,30,35,40);
			cb_cell_mat_width_crop_degree_factor.getSelectionModel()
				.select(Integer.valueOf(ps.getCell_mat_width_crop_degree_factor()));
			
			
			
			lb27=new Label("İsim ve Soyisim ile aynı satırda olabilecek kelimeler");
			lb27.setPrefHeight(standart_element_height);
			lb27.setPrefWidth(standart_element_width);
			lb27.setLayoutX(base_x+x_dif*3);
			lb27.setLayoutY(base_y+y_dif*9);
			pane.getChildren().add(lb27);
			
			
			tf3=new TextField(String.valueOf(ps.getNearWords()));
			tf3.setPrefHeight(standart_element_height);
			tf3.setPrefWidth(standart_element_width);
			tf3.setLayoutX(base_x+x_dif*3);
			tf3.setLayoutY(base_y+y_dif*10);
			pane.getChildren().add(tf3);
			
			EventHandler<ActionEvent> changeFieldsToDefaultsEventHandler=new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event) 
				{
					tf1.setText(String.valueOf(ds.getTesseract_data_path()));
					tf2.setText(String.valueOf(ds.getTesseract_language()));
					cb_tesseract_page_seg_mode.getSelectionModel()
										.select(Integer.valueOf(ds.getTesseract_page_seg_mode()));
					cb_tesseract_ocr_engine_mode.getSelectionModel()
										.select(Integer.valueOf(ds.getTesseract_ocr_engine_mode()));
					cb_x_start.getSelectionModel()
										.select(Integer.valueOf(ds.getX_start()));
					cb_y_start.getSelectionModel()
										.select(Integer.valueOf(ds.getY_start()));
					cb_min_area_threshold_for_noise.getSelectionModel()
										.select(Integer.valueOf(ds.getMin_area_threshold_for_noise()));
					cb_width_percentage_to_be_cut.getSelectionModel()
										.select(Integer.valueOf(ds.getWidth_percentage_to_be_cut()));
					cb_height_percentage_to_be_cut.getSelectionModel()
										.select(Integer.valueOf(ds.getHeight_percentage_to_be_cut()));
					cb_white_ratio_limit_value.getSelectionModel()
										.select(Integer.valueOf(ds.getWhite_ratio_limit_value()));
					cb_row_number.getSelectionModel()
										.select(Integer.valueOf(ds.getRow_number()));
					cb_column_number.getSelectionModel()
										.select(Integer.valueOf(ds.getColumn_number()));
					cb_erosion_degree.getSelectionModel()
										.select(Integer.valueOf(ds.getErosion_degree()));
					cb_dilation_degree.getSelectionModel()
										.select(Integer.valueOf(ds.getDilation_degree()));
					cb_horizontal_kernel_length_division_factor.getSelectionModel()
										.select(Integer.valueOf(ds.getHorizontal_kernel_length_division_factor()));
					cb_vertical_kernel_length_division_factor.getSelectionModel()
										.select(Integer.valueOf(ds.getVertical_kernel_length_division_factor()));
					cb_horizontal_erosion_iteration_number.getSelectionModel()
										.select(Integer.valueOf(ds.getHorizontal_erosion_iteration_number()));
					cb_vertical_erosion_iteration_number.getSelectionModel()
										.select(Integer.valueOf(ds.getVertical_erosion_iteration_number()));
					cb_horizontal_dilation_iteration_number.getSelectionModel()
										.select(Integer.valueOf(ds.getHorizontal_dilation_iteration_number()));
					cb_vertical_dilation_iteration_number.getSelectionModel()
										.select(Integer.valueOf(ds.getVertical_dilation_iteration_number()));
					cb_max_y_dif_for_intersection_points.getSelectionModel()
										.select(Integer.valueOf(ds.getMax_y_dif_for_intersection_points()));
					cb_cell_mat_width_crop_degree_factor.getSelectionModel()
										.select(Integer.valueOf(ds.getCell_mat_width_crop_degree_factor()));
					cb_margin_x.getSelectionModel()
										.select(Integer.valueOf(ds.getMargin_x()));
					cb_margin_y.getSelectionModel()
										.select(Integer.valueOf(ds.getMargin_y()));
					cb_resized_width_for_title.getSelectionModel()
										.select(Integer.valueOf(ds.getResized_width_for_title()));
					cb_resized_height_for_title.getSelectionModel()
										.select(Integer.valueOf(ds.getResized_height_for_title()));
					cb_resized_width_for_table.getSelectionModel()
										.select(Integer.valueOf(ds.getResized_width_for_table()));
					cb_resized_height_for_table.getSelectionModel()
										.select(Integer.valueOf(ds.getResized_height_for_table()));
					tf3.setText(String.valueOf(ds.getNearWords()));
					if(ds.getDont_read_first_row()==1)
					{
						cb_dont_read_first_row.getSelectionModel().select("Evet");
					}
					else
					{
						cb_dont_read_first_row.getSelectionModel().select("Hayır");
					}
					if(ds.getDont_read_first_column()==1)
					{
						cb_dont_read_first_column.getSelectionModel().select("Evet");
					}
					else
					{
						cb_dont_read_first_column.getSelectionModel().select("Hayır");
					}
				}
				
			};
			
			defaultsButton=new Button("Varsayılan Ayarlar");
			defaultsButton.setPrefHeight(standart_element_height);
			defaultsButton.setPrefWidth(standart_element_width);
			defaultsButton.setLayoutX(base_x+x_dif*3);
			defaultsButton.setLayoutY(base_y+y_dif*18);
			pane.getChildren().add(defaultsButton);
			defaultsButton.setOnAction(changeFieldsToDefaultsEventHandler);
			
			EventHandler<ActionEvent> savePreferredSettingsEventHandler=new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent event) 
				{
					try
					{
						
						ps.setTesseract_data_path(tf1.getText());
						ps.setTesseract_language(tf2.getText());
						ps.setTesseract_page_seg_mode(cb_tesseract_page_seg_mode.getValue());
						ps.setTesseract_ocr_engine_mode(cb_tesseract_ocr_engine_mode.getValue());
						ps.setX_start(cb_x_start.getValue());
						ps.setY_start(cb_y_start.getValue());
						ps.setMin_area_threshold_for_noise(cb_min_area_threshold_for_noise.getValue());
						ps.setWidth_percentage_to_be_cut(cb_width_percentage_to_be_cut.getValue());
						ps.setHeight_percentage_to_be_cut(cb_height_percentage_to_be_cut.getValue());
						ps.setWhite_ratio_limit_value(cb_white_ratio_limit_value.getValue());
						ps.setRow_number(cb_row_number.getValue());
						ps.setColumn_number(cb_column_number.getValue());
						ps.setErosion_degree(cb_erosion_degree.getValue());
						ps.setDilation_degree(cb_dilation_degree.getValue());
						ps.setHorizontal_kernel_length_division_factor(cb_horizontal_kernel_length_division_factor.getValue());
						ps.setVertical_kernel_length_division_factor(cb_vertical_kernel_length_division_factor.getValue());
						ps.setHorizontal_erosion_iteration_number(cb_horizontal_erosion_iteration_number.getValue());
						ps.setVertical_erosion_iteration_number(cb_vertical_erosion_iteration_number.getValue());
						ps.setHorizontal_dilation_iteration_number(cb_horizontal_dilation_iteration_number.getValue());
						ps.setVertical_dilation_iteration_number(cb_vertical_dilation_iteration_number.getValue());
						ps.setMax_y_dif_for_intersection_points(cb_max_y_dif_for_intersection_points.getValue());
						ps.setCell_mat_width_crop_degree_factor(cb_cell_mat_width_crop_degree_factor.getValue());
						ps.setMargin_x(cb_margin_x.getValue());
						ps.setMargin_y(cb_margin_y.getValue());
						ps.setNearWords(tf3.getText());
						ps.setResized_width_for_title(cb_resized_width_for_title.getValue());
						ps.setResized_height_for_title(cb_resized_height_for_title.getValue());
						ps.setResized_width_for_table(cb_resized_width_for_table.getValue());
						ps.setResized_height_for_table(cb_resized_height_for_table.getValue());
						if(cb_dont_read_first_row.getValue().equalsIgnoreCase("Evet"))
						{
							ps.setDont_read_first_row(1);
						}
						else
						{
							ps.setDont_read_first_row(0);
						}
						if(cb_dont_read_first_column.getValue().equalsIgnoreCase("Evet"))
						{
							ps.setDont_read_first_column(1);
						}
						else
						{
							ps.setDont_read_first_column(0);
						}
						try 
						{
							dao.clearPreferredSettingsTable();
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						}
						int result=-1;
						try 
						{
							result=dao.insertIntoPreferredSettingsTable(ps);
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						}
						if(result<=0)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setTitle("işlem başarısız");
							alert.setHeaderText("hata oluştu");
							alert.setContentText("Hata Ayarlar kaydedilemedi");
							alert.showAndWait().orElse(null);
						}
						else
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("işlem başarılı");
							alert.setHeaderText("işlem başarıyla tamamlandı");
							alert.setContentText("Ayarlar başarıyla kaydedildi");
							alert.showAndWait().orElse(null);
						}
					}
					catch(Exception ex)
					{
						Alert alert=new Alert(AlertType.ERROR);
						alert.setTitle("işlem başarısız");
						alert.setHeaderText("hata oluştu");
						alert.setContentText("Hata Ayarlar kaydedilemedi");
						alert.showAndWait().orElse(null);
						System.out.println("Ayarları kaydetme aşamasında bir hata oluştu");
					}
		
				}
				
			};
			
			saveButton=new Button("Kaydet");
			saveButton.setPrefHeight(standart_element_height);
			saveButton.setPrefWidth(standart_element_width);
			saveButton.setLayoutX(base_x+x_dif*3);
			saveButton.setLayoutY(base_y+y_dif*19+10);
			pane.getChildren().add(saveButton);
			saveButton.setOnAction(savePreferredSettingsEventHandler);
			
			EventHandler<ActionEvent> goToProgramWindowEventHandler=new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent event) 
				{
					Group rootProgramWindow=new Group();
					Scene sceneProgramWindow=new Scene(rootProgramWindow);
					Stage stageProgramWindow=new Stage();
					stageProgramWindow.setScene(sceneProgramWindow);
					stageProgramWindow.getIcons().add(
							new Image(ProgramWindow.class
							.getResourceAsStream("hotelLogo.png")));
					
					
					stageProgramWindow.setTitle("Main Page");
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
			
			goToProgramWindowButton=new Button("Ana Sayfaya Dön");
			goToProgramWindowButton.setPrefHeight(standart_element_height);
			goToProgramWindowButton.setPrefWidth(standart_element_width);
			goToProgramWindowButton.setLayoutX(base_x+x_dif*3);
			goToProgramWindowButton.setLayoutY(base_y+y_dif*20+20);
			pane.getChildren().add(goToProgramWindowButton);
			goToProgramWindowButton.setOnAction(goToProgramWindowEventHandler);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
