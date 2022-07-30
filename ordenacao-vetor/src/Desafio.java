public class Desafio {

    public static void main(String[] args){

        //10, 202, 3, 1044, 5, 18, 22, 989, 171
        int vetor[] = {10, 202, 202 , 3, 1044, 5, 18, 22, 989, 171};
        int aux = 0;

        for (int i=0; i<vetor.length; i++){
            for (int d=0; d< vetor.length; d++){
                if (vetor[i] < vetor[d]){
                    aux = vetor[i];
                    vetor[i] = vetor[d];
                    vetor[d] = aux;

                }
            }
        }


        for (int i=0; i<vetor.length; i++){
            System.out.println(vetor[i] + " ");
        }

    }
}
