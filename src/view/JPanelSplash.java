package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

import view.utils.Constants;
import view.utils.IEvent;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 7/08/2022
 */
public class JPanelSplash extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanelContainer;
	private JLabel JPanelBlack;
	private JPanel jPanelCenter;
	private JPanel jPanelBottom;
	private JLabel jLabelMTLogo;
	private JLabel jLabelUTPLogo;
	private JLabel jLabelCredits;
	private JProgressBar jProgressBar;
	private GridBagConstraints gbc;
	private IEvent iEvent;

	/**
	 * Constructor de JPanelSplash
	 */
	public JPanelSplash() {
		super();
		this.gbc = new GridBagConstraints();
		this.jPanelContainer = new JPanel(new BorderLayout());
		this.jPanelCenter = new JPanel(new GridBagLayout());
		this.JPanelBlack = new JLabel("█");
		this.jPanelBottom = new JPanel(new GridBagLayout());
		this.jLabelMTLogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_MTLOGO)).getImage()
				.getScaledInstance(JFrameMain.WIDTH_FRAME / 7 * 2, JFrameMain.HEIGTH_FRAME / 3, Image.SCALE_SMOOTH)));
		this.jLabelUTPLogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_UTPLOGO)).getImage()
				.getScaledInstance(JFrameMain.WIDTH_FRAME / 9, JFrameMain.HEIGTH_FRAME / 8, Image.SCALE_SMOOTH)));
		this.jLabelCredits = new JLabel(Constants.STRING_CREDITS, JLabel.RIGHT);
		this.jProgressBar = new JProgressBar();
		this.iEvent = JFrameMain.getInstance();
		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setLayout(null);
		initComponents();
		this.jPanelContainer.add(jPanelCenter, BorderLayout.CENTER);
		this.jPanelContainer.add(jPanelBottom, BorderLayout.SOUTH);
		this.add(JPanelBlack).setBounds(0, 0, JFrameMain.WIDTH_FRAME, JFrameMain.HEIGTH_FRAME);
		this.add(jPanelContainer).setBounds(0, 0, JFrameMain.WIDTH_FRAME, JFrameMain.HEIGTH_FRAME);
		this.JPanelBlack.setFont(new Font("Arial", Font.BOLD, 1670 * JFrameMain.WIDTH_FRAME / 1200));
		this.JPanelBlack.setForeground(Color.BLACK);
		initPres();
	}

	private void initPres() {
		new Thread(() -> {
			try {
				Thread.sleep(100);
				for (int i = 255; i > 0; i--) {
					this.JPanelBlack.setForeground(new Color(0, 0, 0, i));
					Thread.sleep(5);

				}
				this.JPanelBlack.setForeground(new Color(0, 0, 0, 0));
				for (int i = 0; i <= 100; i++) {
					jProgressBar.setValue(i);
					Thread.sleep(10);
				}
				iEvent.iEvent(Constants.COMMAND_CLOSE_SPLASH);
			} catch (InterruptedException e) {
			}
		}).start();
	}

	/**
	 * Metodo que
	 * 
	 */
	private void initComponents() {
		this.jPanelCenter.setBackground(Color.WHITE);
		gbc.insets.bottom = 30;
		this.jPanelCenter.add(jLabelMTLogo, gbc);
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = 1;
		gbc.insets.bottom = 0;
		gbc.insets.left = 100;
		gbc.insets.right = 100;

		this.jProgressBar.setPreferredSize(new Dimension(0, 40*JFrameMain.HEIGTH_FRAME/720));
		this.jProgressBar.setBorderPainted(false);
		this.jProgressBar.setOpaque(false);
		this.jProgressBar.setUI(new BasicProgressBarUI() {

			@Override
			protected void paintDeterminate(Graphics g, JComponent c) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				paintProgress(c, g);
				paintBackGround(c, g2d);
			}

			private void paintProgress(JComponent c, Graphics g2d) {
				g2d.setColor(new Color(64, 99, 183));
				g2d.fillRoundRect(0, 0, (int) (c.getWidth() * progressBar.getPercentComplete() - 10), c.getHeight(), 50,
						50);
			}

			private void paintBackGround(JComponent c, Graphics2D g2d) {
				g2d.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRoundRect(1, 1, c.getWidth() - 2, c.getHeight() - 2, 50, 50);
			}

		});

		this.jPanelCenter.add(jProgressBar, gbc);
		this.jPanelBottom.setBackground(Color.WHITE);
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.fill = 0;
		gbc.insets.left = 30;
		gbc.insets.bottom = 30;
		this.jPanelBottom.add(jLabelUTPLogo, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		gbc.fill = 1;
		this.jPanelBottom.add(Box.createRigidArea(new Dimension(300 * JFrameMain.WIDTH_FRAME / 1200, 1)), gbc);

		this.jLabelCredits.setFont(Constants.FONT_ARIAL_ROUNDED);
		this.jLabelCredits.setForeground(Color.BLACK);
		gbc.gridx = 2;
		gbc.weightx = 0;
		gbc.fill = 0;
		gbc.insets.bottom = 0;
		gbc.insets.right = 30;
		gbc.insets.left = 0;
		this.jPanelBottom.add(jLabelCredits, gbc);

	}
}
