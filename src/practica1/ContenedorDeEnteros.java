package practica1;

public class ContenedorDeEnteros {
    // Atributos
    private int cont; // Tamaño del contenedor
    private Node first; // Primer nodo del contenedor
    
    // Clase privada
    private class Node {
        // Atributos
        int value; // Valor del nodo
        Node next = null;
        
        // Constructor
        public Node(int val, Node ne){
            value = val;
            next = ne;
        }
    }
    
    // Constructor por defecto que crea contenedores vacíos
    public ContenedorDeEnteros(){
        cont = 0;
        first = null;
    }
    
    // @return el tamaño del contenedor
    public int cardinal(){
        return cont;
    }
    
    // @return boolean si el valor pasado por parámetro se ha insertado
    public boolean insertar(int ele){
        if(buscar(ele)) { // Se busca si el elemento se encuentra ya que no puede haber valores repetidos
            return false;
        }else{ // Si no se encuentra, se crea un nodo con el valor pasado por parámetro
            cont++;
            first = new Node(ele, first); 
            return true;
        }
    }
    
    // @return boolean si el valor pasado por parámetro se ha extraído  
    public boolean extraer(int ele) {
        // Comprobamos si el elemento se encuentra en la primera posición
        if (first != null && first.value == ele) {
            first = first.next;
            cont--;
            return true;
        }
        Node actual = first;
        Node helper = first;
        while(actual != null){
            if (actual.value == ele) {
                helper.next = actual.next;
                cont--;
                return true;
            }
            // Se actualizan los nodos
            helper = actual;
            actual = actual.next;

        }
        return false; 
    }
    
    // @return boolean si el valor pasado por parámetro pertenece al contenedor
    public boolean buscar(int ele){
        Node actual = first;
        while(actual != null){
            if (actual.value == ele) { // Si el nodo actual contiene el valor
                return true;
            }else{
                actual = actual.next; // Sino el actual será el siguiente
            }
        }
        return false;
    }
    
    // @void deja al contenedor sin ningún elemento
    public void vaciar(){
        first = null;
        cont = 0;
    }
    
    // @return vector de enteros con los elementos del contenedor
    public int[] elementos(){
        int[] result = new int[cont];
        Node actual = first;
        for (int i = 0; i < cont; i++) {
            result[i] = actual.value;
            actual = actual.next;
        }
        return result;
    }
    
}