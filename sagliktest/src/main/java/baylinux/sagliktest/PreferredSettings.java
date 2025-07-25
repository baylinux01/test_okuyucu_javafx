package baylinux.sagliktest;

import java.util.List;

public class PreferredSettings 
{
	private String tesseract_data_path;
	private String tesseract_language;
	private int tesseract_page_seg_mode;
	private int tesseract_ocr_engine_mode;
	private int min_area_threshold_for_noise_for_title;
	private int min_area_threshold_for_noise_for_table;
	private int x_start;
	private int y_start;
	private int width_percentage_to_be_cut;
	private int height_percentage_to_be_cut;
	private int white_ratio_limit_value;
	private int row_number;
	private int column_number;
	private int dont_read_first_row;
	private int dont_read_first_column;
	private int erosion_degree;
	private int dilation_degree;
	private int horizontal_kernel_length_division_factor;
	private int vertical_kernel_length_division_factor;
	private int horizontal_erosion_iteration_number;
	private int vertical_erosion_iteration_number;
	private int horizontal_dilation_iteration_number;
	private int vertical_dilation_iteration_number;
	private int max_y_dif_for_intersection_points;
	private int cell_mat_width_crop_degree_factor;
	private int margin_x_left;
	private int margin_x_right;
	private int margin_y_up;
	private int margin_y_down;
	private String nearWords;
	private int resized_width_for_title;
	private int resized_height_for_title;
	private int resized_width_for_table;
	private int resized_height_for_table;
	private int draw_contours_thickness_for_title;
	private int draw_contours_thickness_for_table;
	private int cell_mat_downscale_factor;
	
	public String getTesseract_data_path() {
		return tesseract_data_path;
	}
	public void setTesseract_data_path(String tesseract_data_path) {
		this.tesseract_data_path = tesseract_data_path;
	}
	public String getTesseract_language() {
		return tesseract_language;
	}
	public void setTesseract_language(String tesseract_language) {
		this.tesseract_language = tesseract_language;
	}
	public int getTesseract_page_seg_mode() {
		return tesseract_page_seg_mode;
	}
	public void setTesseract_page_seg_mode(int tesseract_page_seg_mode) {
		this.tesseract_page_seg_mode = tesseract_page_seg_mode;
	}
	public int getTesseract_ocr_engine_mode() {
		return tesseract_ocr_engine_mode;
	}
	public void setTesseract_ocr_engine_mode(int tesseract_ocr_engine_mode) {
		this.tesseract_ocr_engine_mode = tesseract_ocr_engine_mode;
	}
	
	public int getMin_area_threshold_for_noise_for_title() {
		return min_area_threshold_for_noise_for_title;
	}
	public void setMin_area_threshold_for_noise_for_title(int min_area_threshold_for_noise_for_title) {
		this.min_area_threshold_for_noise_for_title = min_area_threshold_for_noise_for_title;
	}
	public int getMin_area_threshold_for_noise_for_table() {
		return min_area_threshold_for_noise_for_table;
	}
	public void setMin_area_threshold_for_noise_for_table(int min_area_threshold_for_noise_for_table) {
		this.min_area_threshold_for_noise_for_table = min_area_threshold_for_noise_for_table;
	}
	public int getX_start() {
		return x_start;
	}
	public void setX_start(int x_start) {
		this.x_start = x_start;
	}
	public int getY_start() {
		return y_start;
	}
	public void setY_start(int y_start) {
		this.y_start = y_start;
	}
	public int getWidth_percentage_to_be_cut() {
		return width_percentage_to_be_cut;
	}
	public void setWidth_percentage_to_be_cut(int width_percentage_to_be_cut) {
		this.width_percentage_to_be_cut = width_percentage_to_be_cut;
	}
	public int getHeight_percentage_to_be_cut() {
		return height_percentage_to_be_cut;
	}
	public void setHeight_percentage_to_be_cut(int height_percentage_to_be_cut) {
		this.height_percentage_to_be_cut = height_percentage_to_be_cut;
	}
	public int getWhite_ratio_limit_value() {
		return white_ratio_limit_value;
	}
	public void setWhite_ratio_limit_value(int white_ratio_limit_value) {
		this.white_ratio_limit_value = white_ratio_limit_value;
	}
	public int getRow_number() {
		return row_number;
	}
	public void setRow_number(int row_number) {
		this.row_number = row_number;
	}
	public int getColumn_number() {
		return column_number;
	}
	public void setColumn_number(int column_number) {
		this.column_number = column_number;
	}
	public int getDont_read_first_row() {
		return dont_read_first_row;
	}
	public void setDont_read_first_row(int dont_read_first_row) {
		this.dont_read_first_row = dont_read_first_row;
	}
	public int getDont_read_first_column() {
		return dont_read_first_column;
	}
	public void setDont_read_first_column(int dont_read_first_column) {
		this.dont_read_first_column = dont_read_first_column;
	}
	public int getErosion_degree() {
		return erosion_degree;
	}
	public void setErosion_degree(int erosion_degree) {
		this.erosion_degree = erosion_degree;
	}
	public int getDilation_degree() {
		return dilation_degree;
	}
	public void setDilation_degree(int dilation_degree) {
		this.dilation_degree = dilation_degree;
	}
	public int getHorizontal_kernel_length_division_factor() {
		return horizontal_kernel_length_division_factor;
	}
	public void setHorizontal_kernel_length_division_factor(int horizontal_kernel_length_division_factor) {
		this.horizontal_kernel_length_division_factor = horizontal_kernel_length_division_factor;
	}
	public int getVertical_kernel_length_division_factor() {
		return vertical_kernel_length_division_factor;
	}
	public void setVertical_kernel_length_division_factor(int vertical_kernel_length_division_factor) {
		this.vertical_kernel_length_division_factor = vertical_kernel_length_division_factor;
	}
	public int getHorizontal_erosion_iteration_number() {
		return horizontal_erosion_iteration_number;
	}
	public void setHorizontal_erosion_iteration_number(int horizontal_erosion_iteration_number) {
		this.horizontal_erosion_iteration_number = horizontal_erosion_iteration_number;
	}
	public int getVertical_erosion_iteration_number() {
		return vertical_erosion_iteration_number;
	}
	public void setVertical_erosion_iteration_number(int vertical_erosion_iteration_number) {
		this.vertical_erosion_iteration_number = vertical_erosion_iteration_number;
	}
	public int getHorizontal_dilation_iteration_number() {
		return horizontal_dilation_iteration_number;
	}
	public void setHorizontal_dilation_iteration_number(int horizontal_dilation_iteration_number) {
		this.horizontal_dilation_iteration_number = horizontal_dilation_iteration_number;
	}
	public int getVertical_dilation_iteration_number() {
		return vertical_dilation_iteration_number;
	}
	public void setVertical_dilation_iteration_number(int vertical_dilation_iteration_number) {
		this.vertical_dilation_iteration_number = vertical_dilation_iteration_number;
	}
	public int getMax_y_dif_for_intersection_points() {
		return max_y_dif_for_intersection_points;
	}
	public void setMax_y_dif_for_intersection_points(int max_y_dif_for_intersection_points) {
		this.max_y_dif_for_intersection_points = max_y_dif_for_intersection_points;
	}
	public int getCell_mat_width_crop_degree_factor() {
		return cell_mat_width_crop_degree_factor;
	}
	public void setCell_mat_width_crop_degree_factor(int cell_mat_width_crop_degree_factor) {
		this.cell_mat_width_crop_degree_factor = cell_mat_width_crop_degree_factor;
	}
	
	public int getMargin_x_left() {
		return margin_x_left;
	}
	public void setMargin_x_left(int margin_x_left) {
		this.margin_x_left = margin_x_left;
	}
	public int getMargin_x_right() {
		return margin_x_right;
	}
	public void setMargin_x_right(int margin_x_right) {
		this.margin_x_right = margin_x_right;
	}
	public int getMargin_y_up() {
		return margin_y_up;
	}
	public void setMargin_y_up(int margin_y_up) {
		this.margin_y_up = margin_y_up;
	}
	public int getMargin_y_down() {
		return margin_y_down;
	}
	public void setMargin_y_down(int margin_y_down) {
		this.margin_y_down = margin_y_down;
	}
	public String getNearWords() {
		return nearWords;
	}
	public void setNearWords(String nearWords) {
		this.nearWords = nearWords;
	}
	public int getResized_width_for_title() {
		return resized_width_for_title;
	}
	public void setResized_width_for_title(int resized_width_for_title) {
		this.resized_width_for_title = resized_width_for_title;
	}
	public int getResized_height_for_title() {
		return resized_height_for_title;
	}
	public void setResized_height_for_title(int resized_height_for_title) {
		this.resized_height_for_title = resized_height_for_title;
	}
	public int getResized_width_for_table() {
		return resized_width_for_table;
	}
	public void setResized_width_for_table(int resized_width_for_table) {
		this.resized_width_for_table = resized_width_for_table;
	}
	public int getResized_height_for_table() {
		return resized_height_for_table;
	}
	public void setResized_height_for_table(int resized_height_for_table) {
		this.resized_height_for_table = resized_height_for_table;
	}
	public int getDraw_contours_thickness_for_title() {
		return draw_contours_thickness_for_title;
	}
	public void setDraw_contours_thickness_for_title(int draw_contours_thickness_for_title) {
		this.draw_contours_thickness_for_title = draw_contours_thickness_for_title;
	}
	public int getDraw_contours_thickness_for_table() {
		return draw_contours_thickness_for_table;
	}
	public void setDraw_contours_thickness_for_table(int draw_contours_thickness_for_table) {
		this.draw_contours_thickness_for_table = draw_contours_thickness_for_table;
	}
	public int getCell_mat_downscale_factor() {
		return cell_mat_downscale_factor;
	}
	public void setCell_mat_downscale_factor(int cell_mat_downscale_factor) {
		this.cell_mat_downscale_factor = cell_mat_downscale_factor;
	}
	
	
	
	
	
	
	
}
