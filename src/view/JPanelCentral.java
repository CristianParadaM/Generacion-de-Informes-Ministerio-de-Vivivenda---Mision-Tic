package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.utils.Constants;
import view.utils.JTableReports;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 8/08/2022
 */
public class JPanelCentral extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelTittle;
	private JLabel jLabelWClogo;
	private JLabel jLabelCredits;
	private JPanel jPanelTop;
	private JPanel jPanelCenter;
	private GridBagConstraints gbc;
	private JTableReports jTableReports;
	private String tittle;
	private boolean reload;

	/**
	 * Constructor de JPanelCentral
	 */
	public JPanelCentral() {
		super(new GridBagLayout());
		this.jLabelWClogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_WCIMG)).getImage().getScaledInstance(
				668 * JFrameMain.WIDTH_FRAME / 1200, 539 * JFrameMain.HEIGTH_FRAME / 720, Image.SCALE_SMOOTH)));
		this.gbc = new GridBagConstraints();
		this.jPanelTop = new JPanel(new GridLayout());
		this.tittle = Constants.WELCOME_TITTLE;
		this.jLabelCredits = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_CRIMG)).getImage().getScaledInstance(
				468 * JFrameMain.WIDTH_FRAME / 1200, 539 * JFrameMain.HEIGTH_FRAME / 720, Image.SCALE_SMOOTH)));
		this.jLabelTittle = new JLabel(tittle, JLabel.CENTER);
		this.jPanelCenter = new JPanel(new GridLayout(1, 1));
		init();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void init() {
		initPropComp();
		this.setBackground(new Color(65, 99, 183));
		gbc.weightx = 1;
		gbc.fill = 1;
		this.add(jPanelTop, gbc);

		gbc.weighty = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(20 * JFrameMain.HEIGTH_FRAME / 720, 10 * JFrameMain.WIDTH_FRAME / 1200,
				20 * JFrameMain.HEIGTH_FRAME / 720, 10 * JFrameMain.WIDTH_FRAME / 1200);
		this.add(jPanelCenter, gbc);
		initAnimationTittle();
	}

	private void initAnimationTittle() {
		new Thread(() -> {
			String letters;
			try {
				while (true) {
					letters = "";
					Thread.sleep(3000);
					reload = false;
					for (int i = 0; i < tittle.length(); i++) {
						if (!reload) {
							letters += tittle.charAt(i);
							Thread.sleep(100);
							jLabelTittle.setText(letters);
						} else {
							jLabelTittle.setText(tittle);
						}
					}
					letters = tittle;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	/**
	 * Metodo que
	 */
	private void initPropComp() {
		this.jPanelTop.setBackground(new Color(238, 34, 105));
		this.jPanelTop.add(jLabelTittle);
		this.jPanelTop.setSize(new Dimension(0, 40 * JFrameMain.HEIGTH_FRAME / 720));
		this.jPanelTop.setPreferredSize(new Dimension(0, 40 * JFrameMain.HEIGTH_FRAME / 720));
		
		this.jLabelTittle.addMouseMotionListener(JFrameMain.getInstance());
		
		this.jLabelTittle.setFont(Constants.FONT_ARIAL_ROUNDED_T);
		this.jLabelTittle.setForeground(Color.WHITE);

		this.jPanelCenter.setBackground(Color.WHITE);
		this.jPanelCenter.setBorder(new LineBorder(Color.BLACK, 5));

		this.jPanelCenter.add(jLabelWClogo);
	}

	public void createTable(ArrayList<Object[]> info, String[] columnNames, int type) {
		this.getComponent(1).setVisible(false);
		this.remove(1);
		this.jPanelCenter = new JPanel(new GridLayout(1, 1));
		this.jPanelCenter.setBackground(Color.WHITE);
		this.jPanelCenter.setBorder(new LineBorder(Color.BLACK, 5));
		jTableReports = new JTableReports(info, columnNames);
		this.jPanelCenter.add(jTableReports);
		this.add(jPanelCenter, gbc);

		switch (type) {
		case 1:
			tittle = Constants.REPORT1_TITTLE;
			reload = true;
			break;
		case 2:
			tittle = Constants.REPORT2_TITTLE;
			reload = true;
			break;
		case 3:
			tittle = Constants.REPORT3_TITTLE;
			reload = true;
			break;
		}
	}

	public void showCredits() {
		this.getComponent(1).setVisible(false);
		this.remove(1);
		this.jPanelCenter = new JPanel(new GridLayout(1, 1));
		this.jPanelCenter.setBackground(Color.WHITE);
		this.jPanelCenter.setBorder(new LineBorder(Color.BLACK, 5));
		jLabelCredits.setVisible(true);
		this.jPanelCenter.add(jLabelCredits);
		this.add(jPanelCenter, gbc);
		reload = true;
		tittle = Constants.CREATOR_TITTLE;
	}

}
