package pageRankSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textField=new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultFrame frame = new ResultFrame();
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
	public ResultFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PageRank Multiagente");
		setBounds(100, 100, 823, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(22, 153, 88));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultados PageRank", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(153, 65, 506, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 15));
		textArea.setBounds(15, 101, 476, 194);
		panel.add(textArea);
		setLblNewLabel(textArea);
		JButton btnSiguiente = new JButton("Finalizar");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSiguiente.setBounds(347, 437, 131, 40);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent ae) {
				dispose();
				//frmPagerankSystem.dispose();
				//SecondFrame();
		}
	
		});
	

		}

	public JTextArea getLblNewLabel() {
		return textField;
	}

	public void setLblNewLabel(JTextArea lblNewLabel) {
		this.textField=lblNewLabel;
	}
}
