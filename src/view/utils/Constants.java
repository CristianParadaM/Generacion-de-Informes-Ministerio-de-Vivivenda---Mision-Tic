package view.utils;

import java.awt.Font;

import view.JFrameMain;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 7/08/2022
 */
public class Constants {
	
	//COMMANDS
	public static final String COMMAND_CLOSE_SPLASH = "COMMAND_CLOSE_SPLASH";
	public static final String COMMAND_EXIT_APP = "COMMAND_EXIT_APP";
	public static final String COMMAND_MINIMIZE_APP = "COMMAND_MINIMIZE_APP";
	public static final String COMMAND_CREDITS_APP = "COMMAND_HELP_APP";
	public static final String COMMAND_REPORT1 = "COMMAND_REPORT1";
	public static final String COMMAND_REPORT2 = "COMMAND_REPORT2";
	public static final String COMMAND_REPORT3 = "COMMAND_REPORT3";
	
	//QUERYS
	public static final String QUERY_R1 = "SELECT ID_LIDER, NOMBRE, PRIMER_APELLIDO, CIUDAD_RESIDENCIA FROM LIDER \r\n"
			+ "ORDER BY CIUDAD_RESIDENCIA";
	public static final String QUERY_R2 = "SELECT ID_PROYECTO, CONSTRUCTORA, NUMERO_HABITACIONES, CIUDAD FROM PROYECTO \r\n"
			+ "WHERE CLASIFICACION = 'Casa Campestre' AND CIUDAD IN ('Santa Marta','Cartagena','Barranquilla')";
	public static final String QUERY_R3 = "SELECT C.ID_COMPRA, P.CONSTRUCTORA, P.BANCO_VINCULADO FROM COMPRA C \r\n"
			+ "JOIN PROYECTO P ON P.ID_PROYECTO = C.ID_PROYECTO\r\n"
			+ "WHERE C.PROVEEDOR = 'Homecenter' AND P.CIUDAD = 'Salento'";
	
	
	//PATHS
	public static final String PATH_MTLOGO = "/res/mtlogo.png";
	public static final String PATH_UTPLOGO = "/res/utplogo.png";
	public static final String PATH_WCIMG = "/res/welcomeimg.png";
	public static final String PATH_LOGO_APP = "/res/iconapp.png";
	public static final String PATH_CRIMG = "/res/creditsimg.png";
	
	//STRINGS
	public static final String STRING_CREDITS = "V 1.0";
	public static final String WELCOME_TITTLE = "BIENVENIDO(A) AL SISTEMA DE GENERACION DE INFORMES - MINISTERIO DE VIVIENDA";
	public static final String REPORT1_TITTLE = "INFORME 1: LISTADO DE LIDERES ORDENADOS POR CIUDAD";
	public static final String REPORT2_TITTLE = "INFORME 2: LISTADO DE PROYECTOS DE CASA CAMPESTRE EN BARR, SANT Y CART";
	public static final String REPORT3_TITTLE = "INFORME 3: LISTADO DE COMPRAS PARA LA CIUDAD SALENTO EN HOMECENTER";
	public static final String CREATOR_TITTLE = "CREADOR DE LA APLICACION";
	
	//FONTS
	public static final Font FONT_ARIAL_ROUNDED = new Font("Arial Rounded MT Bold", Font.PLAIN, 28*JFrameMain.WIDTH_FRAME/1200);
	public static final Font FONT_ARIAL_ROUNDED_B = new Font("Arial Rounded MT Bold", Font.BOLD, 15*JFrameMain.WIDTH_FRAME/1200);
	public static final Font FONT_ARIAL_ROUNDED_T = new Font("Arial Rounded MT Bold", Font.BOLD, 18*JFrameMain.WIDTH_FRAME/1200);
	public static final Font FONT_ARIAL_TABLE = new Font("Arial", Font.PLAIN, 18*JFrameMain.WIDTH_FRAME/1200);
	public static final Font FONT_ARIAL_TABLE_H = new Font("Arial", Font.BOLD, 15*JFrameMain.WIDTH_FRAME/1200);

	
	
}
