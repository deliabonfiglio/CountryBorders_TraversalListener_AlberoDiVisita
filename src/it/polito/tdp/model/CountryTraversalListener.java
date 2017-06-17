package it.polito.tdp.model;

import org.jgrapht.*;
import org.jgrapht.event.*;
import org.jgrapht.graph.DefaultEdge;
import java.util.Map ;

public class CountryTraversalListener implements TraversalListener<Country, DefaultEdge> {

	private Graph<Country, DefaultEdge> graph ;
	private Map<Country,Country> map ;// punta sempre dal nuovo alla sorgente
	
	public CountryTraversalListener(Graph<Country, DefaultEdge> graph, Map<Country, Country> map) {
		super();
		this.graph = graph;
		this.map = map;
	}
	@Override
	public void edgeTraversed(EdgeTraversalEvent<Country, DefaultEdge> evento) {
		//evento.getEdge() è l'arco attraversato
		//arco: graph.getEdgeSource/Dest(arg0)
		
		/*se source è nuovo e target vecchio
		map.put(graph.getEdgeSource(evento.getEdge()), 
				graph.getEdgeTarget(evento.getEdge()));
		
		//altrimenti
		map.put(graph.getEdgeTarget(evento.getEdge()),
				graph.getEdgeSource(evento.getEdge()));
				*/
		Country c1= graph.getEdgeSource(evento.getEdge());
		Country c2 = graph.getEdgeTarget(evento.getEdge());
		
		//basta controllare se la mappa ha il vertice che sto considerando o meno
		if(!map.containsKey(c1)){ //c1 è il nuovo
			map.put(c1, c2);
		} else {
			map.put(c2, c1);// c2 è il nuovo
		}
	}
	@Override
	public void vertexFinished(VertexTraversalEvent<Country> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void vertexTraversed(VertexTraversalEvent<Country> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void connectedComponentFinished(ConnectedComponentTraversalEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void connectedComponentStarted(ConnectedComponentTraversalEvent arg0) {
		
	}

}