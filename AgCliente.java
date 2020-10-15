package pageRankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class AgCliente extends Agent {



	public void setup()
	{
		System.out.println("Soy el agente Cliente");
		addBehaviour(new OneShotBehaviour(this){
			public void action()
			{
				// Leemos el texto que introduce el usuario por pantalla y lo enviamos al agente Agente Inicio
				
				ClienteGUI gui=new ClienteGUI();
				while(gui.getTextWeb().isEmpty() && gui.getTextIter().isEmpty()) {}
				if(!Character.isDigit(gui.getTextWeb().charAt(0)) || gui.getTextWeb().equals("0") || gui.getTextWeb().equals("1")) {
					JOptionPane.showMessageDialog(null, "El número de webs no es un entero o es 0 o 1");

				}
				else if(!Character.isDigit(gui.getTextIter().charAt(0))|| Integer.parseInt(gui.getTextIter())<2) {
					JOptionPane.showMessageDialog(null, "El número de iteraciones no es un entero o es menor que 2");
				}
				else{
					SecondFrame sf=new SecondFrame(gui.getTextWeb(),gui.getTextIter());

					sf.setVisible(true);
					int matrix[][] = new int[Integer.parseInt(gui.getTextWeb())][Integer.parseInt(gui.getTextWeb())];
					DatosEntrada de=new DatosEntrada();

					de.setNodes(Integer.parseInt(gui.getTextWeb()));
					de.setIterations(Integer.parseInt(gui.getTextIter()));

					boolean correctos=false;
					while(!correctos) {
						correctos=true;
						for(int i=0;i<Integer.parseInt(gui.getTextWeb())*Integer.parseInt(gui.getTextWeb());i++) {

							if(sf.getCampos()==null) {
								correctos=false;
								break;
							}
							else if(sf.getCampos()[i].getText().isEmpty()) {
								
								correctos=false;
								break;
							}

						}
					}
					int sumador[]=new int[Integer.parseInt(gui.getTextWeb())];
					for(int i=0;i<Integer.parseInt(gui.getTextWeb());i++) {
						for(int j=0;j<Integer.parseInt(gui.getTextWeb());j++) {
							if(!Character.isDigit(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText().charAt(0)) ||
								(Integer.parseInt(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText())!=0 &&
									Integer.parseInt(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText())!=1)) {
								JOptionPane.showMessageDialog(null, "El elemento (" + i + "," + j + ") de la matriz no es un entero o no es ni 0 ni 1");
								System.exit(1);
							}
							if(i==j && Integer.parseInt(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText())!=0) {
								JOptionPane.showMessageDialog(null, "Los elementos de la diagonal principal deben ser 0");
								System.exit(1);
							}
							sumador[j]+=Integer.parseInt(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText());
							matrix[i][j]=Integer.parseInt(sf.getCampos()[i*Integer.parseInt(gui.getTextWeb())+j].getText());
						}
					}
					for(int i=0;i<Integer.parseInt(gui.getTextWeb());i++) {
						if(sumador[i]==0) {
							JOptionPane.showMessageDialog(null, "Las columnas deben contener al menos un 1");
							System.exit(1);
						}
					}
					de.setMatrix(matrix);
					Utils.enviarMensaje(this.myAgent, "Filtro PageRank", de);
					ACLMessage
					msg=blockingReceive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
					//Cuando el agente AgenteInicio responde, imprimimos su respuesta por pantalla
					try
					{
						HashMap<Integer,Double> pagerank=(HashMap<Integer,Double>)msg.getContentObject();
						ResultFrame rf=new ResultFrame();
						String sol="";
						for (Integer name: pagerank.keySet()){
							String key = name.toString();
							String value = pagerank.get(name).toString();
							sol=sol+"Page Rank of "+(Integer.parseInt(key)+1)+" is :\t"+value+"\n";
						}
						rf.setVisible(true);
						rf.getLblNewLabel().setText(sol);



					}
					catch (UnreadableException e)
					{
						e.printStackTrace();
					}
				}
			}
		});

	}




}

