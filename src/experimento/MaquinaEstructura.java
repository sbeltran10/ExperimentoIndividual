package experimento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaquinaEstructura {

	// Interfaz de las operaciones
	public interface Operaciones{
		
		public Nodo buscar(int idNodo);
		
		public boolean agregar(Nodo nuevoNodo);
		
	}
	
	// Clase generica nodo
	public class Nodo{
		private int id;
		
		public Nodo(int id){
			this.id = id;
		}
		
		public int getId(){
			return id;
		}
	}
	
	
	
	// Clase que representa al nodo de un arbol binario
	public class NodoArbolBinario extends Nodo{

		private NodoArbolBinario derecha;
		
		private NodoArbolBinario izquierda;
		
		public NodoArbolBinario(int id) {
			super(id);
		}

		public NodoArbolBinario getDerecha() {
			return derecha;
		}

		public void setDerecha(NodoArbolBinario derecha) {
			this.derecha = derecha;
		}

		public NodoArbolBinario getIzquierda() {
			return izquierda;
		}

		public void setIzquierda(NodoArbolBinario izquierda) {
			this.izquierda = izquierda;
		}
		
	}
	
	// Clase que representa a un arbol binario
	public class ArbolBinario implements Operaciones{

		private NodoArbolBinario raiz;
		
		public ArbolBinario(NodoArbolBinario nodoRaiz) {
			raiz = nodoRaiz;
		}
		
		
		
		public Nodo buscar(int idNodo) {
			 
			return buscar (raiz, idNodo);
		}
		
		private Nodo buscar(NodoArbolBinario x, int buscado)
		{
			if (x == null)
				return null;
			
			if (buscado > x.getId())
				return buscar(x.derecha, buscado);
			else if (buscado < x.getId())
				return buscar(x.izquierda, buscado);
			else
				return x;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {
			
			return agregar(raiz, nuevoNodo);
		}
		
		private boolean agregar(NodoArbolBinario x, Nodo agregado)
		{
			
			if (x.getId() < agregado.getId())
				if (x.izquierda != null)
					return agregar(x.izquierda, agregado);
				else
				{
					x.izquierda = x;
					return true;
				}
			else if (x.getId()> agregado.getId())
				if (x.derecha != null)
					return agregar(x.derecha, agregado);
				else
				{
					x.derecha = x;
					return true;
				}
			else//Son iguales y por ende ya existen; no reemplazo y retorno false
				return false;
		}
		
	}
	
	// Clase que representa a un nodo de un grafo
	public class NodoGrafo extends Nodo{
		
		private NodoGrafo fuente;
		private List<NodoGrafo> listaAdyacencia;
		
		public NodoGrafo(int id, NodoGrafo nodoFuente) {
			super(id);
			fuente = nodoFuente;
			listaAdyacencia = new ArrayList<>();
		}
		
		public List<NodoGrafo> getListaAdyacencia(){
			return listaAdyacencia;
		}
		
	}
	
	// Clase que representa a un grafo dirigido
	public class GrafoDirigido implements Operaciones{

		private NodoGrafo fuente;
		
		public GrafoDirigido(NodoGrafo nodoFuente) {
			fuente = nodoFuente;
		}
		
		@Override
		public Nodo buscar(int idNodo) {
			
			return null;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {
			
			return false;
		}
		
	}
	
	// Puede probar el funcionamiento de las operaciones en el main
	public static void main(String args[]){
		
	}
	
	public class NodoLista extends Nodo
	{
		public NodoLista(int id) {
			super(id);
		}
		private NodoLista siguiente;
		private int valor;
	}
	
	public class ListaEncadenada implements Operaciones
	{

		private NodoLista inicio;
		
		@Override
		public Nodo buscar(int idNodo) {
			
			NodoLista actual = inicio; 
			
			
			while (actual != null)
			{
				if (actual.getId() == idNodo)
					return actual;
				actual = actual.siguiente;
			}
			
			return null;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {

			NodoLista actual = inicio;
			
			while (actual.siguiente != null)
			{
				if (actual.getId() == nuevoNodo.getId())
					return false;
				actual = actual.siguiente;
			}

			//actual.siguiente es null, lo cambio por el unevo
			actual.siguiente = (NodoLista) nuevoNodo;
			
			return true;
		}

		
		
	}
	
}