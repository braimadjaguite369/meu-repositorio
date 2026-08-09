import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Teste{
   public static void main(String[] arg){
    List<Integer> lista = new ArrayList<>(List.of(6, 3, 5, 12, 9, 15, 18, 15, 1, 0, 4, 21, 9));
    //List<Integer> listaOrdenada = new ArrayList<>();
    quickSortInPlace(lista);
    System.out.println(lista.toString());

    //Um pequeno teste da HashMap
    Map<String, Integer> produto = new HashMap<>();
    produto.put("Banana", 5000);
    System.out.println(produto.get("Banana"));
    
   }


  // Bubble Sort implementado com um ArrayList
  public static void bubbleSort(List<Integer> lista){
     for(int i = 0; i < lista.size() - 1; i++){
        boolean trocou = false;
        for(int j = 0; j < lista.size() - i - 1; j++){
           if(lista.get(j) > lista.get(j+1)){
              int temp = lista.get(j);
              lista.set(j, lista.get(j+1));
              lista.set(j+1, temp);
              // Poderia usar o "Collections.swap(lista, j, j+1);" que também faz a mesma coisa: trocar.
              trocou = true;
           }
        }
        if(!trocou){
           break;
        }
     }
  }

  //Bubble Sort implementado com um array tradicional fixo
  public static void bubbleSort(int[] lista){
     for(int i = 0; i < lista.length - 1; i++){
        boolean trocou = false;
        for(int j = 0; j < lista.length - i - 1; j++){
           if(lista[j] > lista[j+1]){
              int temp = lista[j];
              lista[j] = lista[j+1];
              lista[j+1] = temp;
              trocou = true;
           }
        }
        if(!trocou){
           break;
        }
     }
  }

  public static List<Integer> quickSort(List<Integer> lista){

     if(lista.size() <= 1){
        return lista;
     }

     int indiceMedio = lista.size() / 2;
     int pivo = lista.get(indiceMedio);

     List<Integer> menores = new ArrayList<>();
     List<Integer> maiores = new ArrayList<>();

     for(int i = 0; i < lista.size(); i++){
        if(i == indiceMedio){
           continue;
        }
        if(lista.get(i) <= pivo){
           menores.add(lista.get(i));
        } else{
           maiores.add(lista.get(i));
        }
     } 

     List<Integer> listaOrdenada = new ArrayList<>();
     listaOrdenada.addAll(quickSort(menores));
     listaOrdenada.add(pivo);
     listaOrdenada.addAll(quickSort(maiores));
   
     return listaOrdenada;
  }

  public static void quickSortInPlace(List<Integer> lista){
      if(lista == null || lista.size() <= 1){
         return;
      }
      executarQuickSort(lista, 0, lista.size() - 1);
  }

  private static void executarQuickSort(List<Integer> lista, int inicio, int fim){
     if(inicio < fim){
        int indicePivo = particionar(lista, inicio, fim);
        executarQuickSort(lista, inicio, indicePivo - 1);
        executarQuickSort(lista, indicePivo + 1, fim);
     }
  }

  private static int particionar(List<Integer> lista, int inicio, int fim){

      int pivo = lista.get(fim);
      int i = inicio - 1;

      for(int j = inicio; j < fim; j++){
         if(lista.get(j) <= pivo){
            i++;
            Collections.swap(lista, i, j);
         }
      }
      Collections.swap(lista, i+1, fim);
      return i + 1;
  }

  public static int pequisaBinaria(List<Integer> lista, int item){
     int menorIndice = 0;
     int maiorIndice = lista.size() - 1;
   
     while(menorIndice <= maiorIndice){
        int meio = menorIndice + (maiorIndice - menorIndice) / 2;
        int palpite = lista.get(meio);
        if(palpite == item){
           return meio;
        }
        if(palpite < item){
           menorIndice = meio + 1;
        } else{
           maiorIndice = meio - 1;
        }
     }
     return -1;
  }
}