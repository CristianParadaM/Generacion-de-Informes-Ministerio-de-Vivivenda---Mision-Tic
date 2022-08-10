package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import connection.ConnectionBD;
import view.JFrameMain;
import view.utils.Constants;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 8/08/2022
 */
public class Controller implements ActionListener {

	private ConnectionBD bd;
	private JFrameMain view;
	private static Controller controller = null;

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	private Controller() {
		this.bd = new ConnectionBD();
		view = JFrameMain.getInstance();
	}

	public void startApp() {
		view.initView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_REPORT1 -> report1();
		case Constants.COMMAND_REPORT2 -> report2();
		case Constants.COMMAND_REPORT3 -> report3();
		}
	}

	/**
	 * Metodo que
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void report3() {
		Object[] data = bd.consultToBD(Constants.QUERY_R3);
		view.createTable((ArrayList<Object[]>) data[0], (String[]) data[1], 3);
	}

	/**
	 * Metodo que
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void report2() {
		Object[] data = bd.consultToBD(Constants.QUERY_R2);
		view.createTable((ArrayList<Object[]>) data[0], (String[]) data[1], 2);
	}

	/**
	 * Metodo que
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void report1() {
		Object[] data = bd.consultToBD(Constants.QUERY_R1);
		view.createTable((ArrayList<Object[]>) data[0], (String[]) data[1], 1);
	}

}
