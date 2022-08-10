package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import view.utils.Constants;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 8/08/2022
 */
public class JPanelLateral extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton jButtonExit;
	private JButton jButtonCredits;
	private JButton jButtonMinimize;
	private JButton jButtonI1;
	private JButton jButtonI2;
	private JButton jButtonI3;
	private JLabel jLabelMTLogo;
	private JLabel jLabelUTPLogo;
	private JLabel jLabelVersion;
	
	private GridBagConstraints gbc;

	/** Constructor de JPanelLateral
	 * 
	 */
	public JPanelLateral() {
		super(new GridBagLayout());
		this.jButtonExit = new JButton("X");
		this.jButtonCredits = new JButton("?");
		this.jButtonMinimize = new JButton("-");
		this.jButtonI1 = new JButton("Informe 1");
		this.jButtonI2 = new JButton("Informe 2");
		this.jButtonI3 = new JButton("Informe 3");
		this.jLabelMTLogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_MTLOGO)).getImage()
				.getScaledInstance(200*JFrameMain.WIDTH_FRAME/1200, 120*JFrameMain.HEIGTH_FRAME/720, Image.SCALE_SMOOTH)));
		this.jLabelUTPLogo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_UTPLOGO)).getImage()
				.getScaledInstance(100*JFrameMain.WIDTH_FRAME/1200, 80*JFrameMain.HEIGTH_FRAME/720, Image.SCALE_SMOOTH)));
		this.jLabelVersion = new JLabel("V 1.0");
		this.gbc = new GridBagConstraints();
		init();
	}

	private void init() {
		this.setBackground(new Color(217,217,217));
		initPropButtons();
		gbc.weightx = 1;
		gbc.fill = 1;
		this.add(jButtonMinimize, gbc);
		gbc.gridx = 1;
		this.add(jButtonCredits, gbc);
		gbc.gridx = 2;
		this.add(jButtonExit, gbc);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets.top = 30;
		this.add(jLabelMTLogo, gbc);
		gbc.gridy = 2;
		this.add(jButtonI1, gbc);
		gbc.insets.top = 5;
		gbc.gridy = 3;
		this.add(jButtonI2, gbc);
		gbc.gridy = 4;
		this.add(jButtonI3, gbc);
		gbc.gridy = 5;
		gbc.weighty = 1;
		this.add(Box.createRigidArea(new Dimension(0,200*JFrameMain.HEIGTH_FRAME/720)), gbc);
		gbc.gridy = 6;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.insets.left = 20;
		gbc.insets.bottom = 20;
		this.add(jLabelUTPLogo, gbc);
		gbc.insets.left = 0;
		gbc.insets.right = 20;
		gbc.insets.bottom = 5;
		gbc.gridx = 2;
		this.add(jLabelVersion, gbc);
	
		
	}

	private void initPropButtons() {
		jButtonMinimize.setPreferredSize(new Dimension(100*JFrameMain.WIDTH_FRAME/1200,40*JFrameMain.HEIGTH_FRAME/720));
		jButtonCredits.setPreferredSize(new Dimension(100*JFrameMain.WIDTH_FRAME/1200,40*JFrameMain.HEIGTH_FRAME/720));
		jButtonExit.setPreferredSize(new Dimension(100*JFrameMain.WIDTH_FRAME/1200,40*JFrameMain.HEIGTH_FRAME/720));
		
		jButtonMinimize.addActionListener(JFrameMain.getInstance());
		jButtonCredits.addActionListener(JFrameMain.getInstance());
		jButtonExit.addActionListener(JFrameMain.getInstance());
		
		jButtonMinimize.setActionCommand(Constants.COMMAND_MINIMIZE_APP);
		jButtonCredits.setActionCommand(Constants.COMMAND_CREDITS_APP);
		jButtonExit.setActionCommand(Constants.COMMAND_EXIT_APP);
		
		jButtonMinimize.setBackground(new Color(191,191,191));
		jButtonCredits.setBackground(new Color(143,170,220));
		jButtonExit.setBackground(new Color(254,152,154));
		
		jButtonMinimize.setFocusable(false);
		jButtonCredits.setFocusable(false);
		jButtonExit.setFocusable(false);
		
		jLabelVersion.setFont(Constants.FONT_ARIAL_ROUNDED);
		
		jButtonMinimize.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		jButtonCredits.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		jButtonExit.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		
		jButtonMinimize.setForeground(Color.WHITE);
		jButtonCredits.setForeground(Color.WHITE);
		jButtonExit.setForeground(Color.WHITE);

		jButtonMinimize.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
		jButtonCredits.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
		jButtonExit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		
		jButtonMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonMinimize.setBackground(new Color(163,163,163));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonMinimize.setBackground(new Color(191,191,191));
			}
		});
		jButtonCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonCredits.setBackground(new Color(121,154,213));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonCredits.setBackground(new Color(143,170,220));
			}
		});
		jButtonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonExit.setBackground(new Color(254,110,113));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonExit.setBackground(new Color(254,152,154));
			}
		});
		
		jButtonI1.setBackground(new Color(191,191,191));
		jButtonI2.setBackground(new Color(191,191,191));
		jButtonI3.setBackground(new Color(191,191,191));
		
		jButtonI1.addActionListener(Controller.getInstance());
		jButtonI2.addActionListener(Controller.getInstance());
		jButtonI3.addActionListener(Controller.getInstance());
		
		jButtonI1.setActionCommand(Constants.COMMAND_REPORT1);
		jButtonI2.setActionCommand(Constants.COMMAND_REPORT2);
		jButtonI3.setActionCommand(Constants.COMMAND_REPORT3);
		
		jButtonI1.setBorderPainted(false);
		jButtonI2.setBorderPainted(false);
		jButtonI3.setBorderPainted(false);
		
		jButtonI1.setFocusable(false);
		jButtonI2.setFocusable(false);
		jButtonI3.setFocusable(false);
		
		jButtonI1.setPreferredSize(new Dimension(0,40*JFrameMain.HEIGTH_FRAME/720));
		jButtonI2.setPreferredSize(new Dimension(0,40*JFrameMain.HEIGTH_FRAME/720));
		jButtonI3.setPreferredSize(new Dimension(0,40*JFrameMain.HEIGTH_FRAME/720));
		
		jButtonI1.setForeground(Color.WHITE);
		jButtonI2.setForeground(Color.WHITE);
		jButtonI3.setForeground(Color.WHITE);
		
		jButtonI1.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		jButtonI2.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		jButtonI3.setFont(Constants.FONT_ARIAL_ROUNDED_B);
		
		jButtonI1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonI1.setBackground(new Color(163,163,163));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonI1.setBackground(new Color(191,191,191));
			}
		});
		jButtonI2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonI2.setBackground(new Color(163,163,163));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonI2.setBackground(new Color(191,191,191));
			}
		});
		jButtonI3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButtonI3.setBackground(new Color(163,163,163));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButtonI3.setBackground(new Color(191,191,191));
			}
		});
		
		
	}

}
