package pageRankSystem;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


import jade.content.lang.sl.SLCodec;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class OneShotBehaviourPageRank extends OneShotBehaviour {
	private static final long serialVersionUID = 1L;
	public static final int LIMITES=50;
	public void action() {
		// Creamos la espera de mensajes en modo bloqueante y con un filtro de tipo REQUEST
		ACLMessage msg=this.myAgent.blockingReceive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
		try
		{
			
			// Llamamos a nuestro método ordenarRelevancia(), que utilizamos para realizar la busqueda
			HashMap<Integer,Double> respuesta=ordenarRelevancia((DatosEntrada)msg.getContentObject());
			//Cuando la búsqueda ha finalizado, enviamos un mensaje de respuesta
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.addReceiver(msg.getSender());
			aclMessage.setOntology("OntologiaPageRank");
			aclMessage.setLanguage(new SLCodec().getName());
			aclMessage.setEnvelope(new Envelope());
			aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
			aclMessage.setContentObject((Serializable)respuesta);
			this.myAgent.send(aclMessage);
		}
		catch (UnreadableException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public HashMap<Integer,Double> ordenarRelevancia(DatosEntrada de){
		HashMap<Integer,Double> resultado=new HashMap<Integer,Double>();
		
		double pagerank[] = new double[10];
		double InitialPageRank;
		double OutgoingLinks=0; 
		double DampingFactor = 0.85; 
		double TempPageRank[] = new double[10];

		int ExternalNodeNumber;
		int InternalNodeNumber; 
		int k=1; 
		int ITERATION_STEP=1;

		InitialPageRank = 1/de.getNodes();

		

		// 0 Iteración
		for(k=0;k<de.getNodes();k++)
		{
			pagerank[k]=InitialPageRank;
		}   

		//System.out.printf("\n Valores PageRank Iniciales , 0th Step \n");
		

		while(ITERATION_STEP<=de.getIterations()) // Iteraciones
		{
			// Guarda el PageRank de todos los nodos en un array temporal
			for(k=0;k<de.getNodes();k++)
			{  
				TempPageRank[k]=pagerank[k];
				pagerank[k]=0;
			}

			for(InternalNodeNumber=0;InternalNodeNumber<de.getNodes();InternalNodeNumber++)
			{
				for(ExternalNodeNumber=0;ExternalNodeNumber<de.getNodes();ExternalNodeNumber++)
				{
					if(de.getMatrix()[ExternalNodeNumber][InternalNodeNumber] == 1)
					{ 
						k=0;
						OutgoingLinks=0;  // Cuenta el número de Links salientes para cada ExternalNode
						while(k<de.getNodes())
						{
							if(de.getMatrix()[ExternalNodeNumber][k] == 1 )
							{
								OutgoingLinks=OutgoingLinks+1; // Contador de Links Salientes
							}  
							k=k+1;  
						} 
						// Calcula el PageRank     
						pagerank[InternalNodeNumber]+=TempPageRank[ExternalNodeNumber]*(1/OutgoingLinks);    
					}
				}  
			}    

			//System.out.printf("\n Despues de la Iteracion "+ITERATION_STEP+"\n");

			for(k=0;k<de.getNodes();k++) 
				//System.out.printf("El Page Rank de "+k+" es :\t"+pagerank[k]+"\n"); 

			ITERATION_STEP = ITERATION_STEP+1;
		}

		// Añadimos el Factor de Damping al PageRank
		for(k=0;k<de.getNodes();k++)
		{
			pagerank[k]=(1-DampingFactor)+ DampingFactor*pagerank[k]; 
		} 

		// Mostramos PageRank
		//System.out.printf("\n Final Page Rank : \n"); 
		for(k=0;k<de.getNodes();k++)
		{
			resultado.put(k, pagerank[k]);
			//System.out.printf("El Page Rank de "+(k+1)+" is :\t"+pagerank[k]+"\n"); 
		}
		return resultado;

	}
}
