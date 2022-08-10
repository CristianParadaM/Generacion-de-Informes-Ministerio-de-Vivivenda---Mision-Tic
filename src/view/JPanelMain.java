package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.utils.JTableReports;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 7/08/2022
 */
public class JPanelMain extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelSplash splash;
	private JPanelLateral jPanelLateral;
	private JPanelCentral jPanelCentral;

	/**
	 * Constructor de JPanelMain
	 * 
	 */
	public JPanelMain() {
		super(new BorderLayout());
		this.splash = new JPanelSplash();
		this.jPanelCentral = new JPanelCentral();
		this.jPanelLateral = new JPanelLateral();
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		this.add(splash, BorderLayout.CENTER);
	}

	/**
	 * Metodo que
	 * @return
	 */
	public void closeSplash() {
		setVisibleFalse();
		this.setLayout(new BorderLayout());
		jPanelLateral.setVisible(true);
		jPanelCentral.setVisible(true);
		this.add(jPanelLateral,BorderLayout.EAST);
		this.add(jPanelCentral, BorderLayout.CENTER);
	}

	private void setVisibleFalse() {
		for (int i = 0; i < this.getComponentCount(); i++) {
			this.getComponent(i).setVisible(false);
		}
	}

	public void createTable(ArrayList<Object[]> info, String[] columnNames, int type) {
		jPanelCentral.createTable(info, columnNames, type);
	}

	/** Metodo que
	 * @return
	 */
	public void showCredits() {
		jPanelCentral.showCredits();
	}
}
