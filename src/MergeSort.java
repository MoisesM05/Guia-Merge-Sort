import java.util.InputMismatchException;
import java.util.Scanner;

class MergeSort {

    public static void main(String args[]){//Main y el manejo de las excepciones para cuando el usuario digite los elemeentos.
        Scanner leer = new Scanner(System.in);
        boolean Continuar = true;

        do{
            try{
                System.out.println("Ingrese los elementos del arreglo");
                System.out.println("Puede ingresar maximo 10 elementos.");
       
                int arr[] = new int[10];//Se declara el arreglo.

                for(int n=0; n<arr.length; n++){//Lee los elementos del usuario.
                    System.out.println("Elemento "+(n+1)+": ");
                    arr[n]= leer.nextInt();
                }

                Continuar = false;//Cierra ciclo.
        
                System.out.println("Elementos dados");//Muestra los elementos introducidos
                Mostrar_arreglo(arr);
        
                MergeSort Metodos = new MergeSort();//Instancia del metodo
                Metodos.sort(arr, 0, arr.length - 1);//Llamamos al metodo Sort , orden los subarreglos.
        
                System.out.println("\nElementos ordenados");//Muestra el arreglo ordenado.
                Mostrar_arreglo(arr);

            }catch(InputMismatchException inputMismatchException){

                System.out.println("Solo puede digitar numeros, no letras!");
                System.out.println("-------------------------------------------------------\n");
                leer.nextLine();
            }

        }while(Continuar);

    }
       
    // Fusiona dos sub arrreglos arr[].
    // El primer sub arreglo sera arr[l+i]
    // El segundo sub arreglo es arr[m+1+j]
    public void merge(int arr[], int l, int m, int r){//Ordena los sub arreglos.
        // Aqui se encuentra el tamaño de los sub arreglo para luego fucionarlos
        int n1 = m - l + 1;
        int n2 = r - m;

        // Se crean arreglos temporales para la subdivision del arreglo , L izquierda y R derecha.
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Aqui se trasladan los datos de los sub arreglos a los otros arreglos temporales.
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Se fusionan los arreglos temporales

        // Se declaran los valores inciales de los iteradores para el primer arreglo y el segund.
        int i = 0, j = 0;

        // Indice inicial del sub arreglo fusionado
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Se copean los elementos restantes del arreglo L izquierda si hay o no y tambien se copean los de la derecha.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

       
        while (j < n2) {//Elementos restante de la derecha
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public void sort(int arr[], int l, int r)//Aqui se usa recursividad para poder ordenar las mitades de los arreglos
    // Se llama al metodo anterior para poder determinar los elementos separados.
    {
        if (l < r) {

            // Se encuentra la mitad del arreglo.
            int m = l + (r - l) / 2;

            // Se ordena la primera y la segunda mitad de los sub arreglos.
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Aqui se fusionan las mitades ordenadas llmando al metodo anterior merge.
            merge(arr, l, m, r);
        }
    }

    // Cree un metodo para imprimir el arreglo ordenado.
    static void Mostrar_arreglo(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
      
}
