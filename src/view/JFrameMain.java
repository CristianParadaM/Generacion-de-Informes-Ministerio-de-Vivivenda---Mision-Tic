package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import view.utils.Constants;
import view.utils.IEvent;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 7/08/2022
 */
public class JFrameMain extends JFrame implements IEvent, ActionListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH_MAXIMUM = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int HEIGTH_MAXIMUM = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final int WIDTH_FRAME = 1200 * WIDTH_MAXIMUM / 1920;
	public static final int HEIGTH_FRAME = 720 * HEIGTH_MAXIMUM / 1080;
	private JPanelMain jPanelMain;
	private static JFrameMain frameMain = null;

	public static JFrameMain getInstance() {
		if (frameMain == null) {
			frameMain = new JFrameMain();
		}
		return frameMain;
	}

	/**
	 * Constructor de JFrameMain
	 */
	private JFrameMain() {
		super();
		init();
	}

	/**
	 * Metodo que
	 */
	private void init() {
		this.setSize(WIDTH_FRAME, HEIGTH_FRAME);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon(getClass().getResource(Constants.PATH_LOGO_APP)).getImage());
	}

	/**
	 * Metodo que
	 * 
	 */
	public void initView() {
		this.jPanelMain = new JPanelMain();
		this.getContentPane().add(jPanelMain);
		this.setVisible(true);
	}

	@Override
	public void iEvent(String command) {
		switch (command) {
		case Constants.COMMAND_CLOSE_SPLASH -> jPanelMain.closeSplash();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.COMMAND_EXIT_APP -> System.exit(1);
		case Constants.COMMAND_MINIMIZE_APP -> this.setState(JFrame.ICONIFIED);
		case Constants.COMMAND_CREDITS_APP -> jPanelMain.showCredits();
		}
	}

	public void createTable(ArrayList<Object[]> info, String[] columnNames, int type) {
		jPanelMain.createTable(info, columnNames, type);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.setLocation(e.getXOnScreen() - this.getWidth()/2,
				e.getYOnScreen());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
