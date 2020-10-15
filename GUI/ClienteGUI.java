package pageRankSystem;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;

public class ClienteGUI {

	private JFrame frmPagerankSystem;
	private JTextField[] campos;
	private JTextArea web=new JTextArea();
	private JTextArea iter=new JTextArea();
	//private JFrame f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI window = new ClienteGUI();
					window.frmPagerankSystem.setVisible(true);
					//window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public void iniciar() {
		try {
			ClienteGUI window = new ClienteGUI();
			window.frmPagerankSystem.setVisible(true);
			//window.f.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ClienteGUI() {
		try {
			frmPagerankSystem = new JFrame();
			frmPagerankSystem.setForeground(SystemColor.desktop);
			frmPagerankSystem.setTitle("PageRank Multiagente");
			frmPagerankSystem.setBounds(100, 100, 823, 549);
			frmPagerankSystem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frmPagerankSystem.getContentPane().setLayout(null);
			frmPagerankSystem.setBackground(Color.GREEN);
			initialize();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {

		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 16, 730, 187);
		panel_3.setBackground(new Color(22, 153, 88));

		JLabel img=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Portada.jpg")));
		
		panel_3.add(img);
		frmPagerankSystem.getContentPane().add(panel_3);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca el n\u00FAmero de iteraciones a realizar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(169, 331, 460, 67);
		frmPagerankSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);


		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(6, 22, 448, 38);
		panel_1.add(textArea_1);
		//setIter(textArea_1);



		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca el n\u00FAmero de webs a evaluar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(169, 230, 460, 67);
		frmPagerankSystem.getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 22, 448, 38);
		panel.add(textArea);
		//setWeb(textArea);
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSiguiente.setBounds(338, 432, 115, 45);
		frmPagerankSystem.getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setWeb(textArea);
				setIter(textArea_1);
				frmPagerankSystem.dispose();
				
				
				
				//frmPagerankSystem.dispose();
				//SecondFrame();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(22, 153, 88));
		panel_2.setBounds(0, 0, 801, 504);
		frmPagerankSystem.getContentPane().add(panel_2);
		frmPagerankSystem.setVisible(true);

	}

	

	public String getTextWeb() {
		return this.web.getText();
	}
	public String getTextIter() {
		return this.iter.getText();
	}
	
	public JTextField[] getCampos() {
		return campos;
	}

	public void setCampos(JTextField[] campos) {
		this.campos = campos;
	}


	public JTextArea getWeb() {
		return web;
	}


	public void setWeb(JTextArea web) {
		this.web = web;
	}


	public void setIter(JTextArea iter) {
		this.iter = iter;
	}


	public JFrame getFrmPagerankSystem() {
		return frmPagerankSystem;
	}


	public void setFrmPagerankSystem(JFrame frmPagerankSystem) {
		this.frmPagerankSystem = frmPagerankSystem;
	}
}



