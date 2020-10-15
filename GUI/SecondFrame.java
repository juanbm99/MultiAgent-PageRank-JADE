package pageRankSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class SecondFrame extends JFrame {

	private JPanel contentPane;
	private JTextField[] campos;
	private boolean pulsado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame frame = new SecondFrame("5","5");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondFrame(String nwebs,String nIters) {
		setFont(new Font("Times New Roman", Font.BOLD, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setTitle("PageRank Multiagente");
		setBounds(100, 100, 823, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(22, 153, 88));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca la matriz de adyacencia", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(103, 29, 567, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setBounds(120, 86, 397, 216);
		
		panel_1.setLayout(new GridLayout(Integer.parseInt(nwebs), Integer.parseInt(nwebs)));
		JTextField[] textFields=new JTextField[Integer.parseInt(nwebs)*Integer.parseInt(nwebs)];
		for(int i=0;i<Integer.parseInt(nwebs)*Integer.parseInt(nwebs);i++) {
			textFields[i]=new JTextField();
			panel_1.add(textFields[i]);
		}
		
		
		JLabel lbWebj=new JLabel("Web i");
		lbWebj.setFont(new Font("Tahoma",Font.BOLD,16));
		lbWebj.setBounds(36,181,69,20);
		panel.add(lbWebj);
		
		JLabel lblWebJ = new JLabel("Web j");
		lblWebJ.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWebJ.setBounds(285, 50, 69, 20);
		panel.add(lblWebJ);
		
		JLabel lblNoHay = new JLabel("0: no hay conexión entre webs i-j");
		lblNoHay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoHay.setBounds(15, 318, 288, 20);
		panel.add(lblNoHay);
		
		JLabel lblHayConexin = new JLabel("1: hay conexión entre webs i-j");
		lblHayConexin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHayConexin.setBounds(15, 338, 253, 20);
		panel.add(lblHayConexin);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSiguiente.setBounds(346, 437, 131, 40);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent ae) {
				
				
				setCampos(textFields);
				
				dispose();
				
				//frmPagerankSystem.dispose();
				//SecondFrame();
			}
		});
	}

	public JTextField[] getCampos() {
		return campos;
	}

	public void setCampos(JTextField[] campos) {
		this.campos = campos;
	}
	
	

	public boolean isPulsado() {
		return pulsado;
	}

	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}
}
