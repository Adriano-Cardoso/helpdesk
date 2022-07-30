public class Usuario {

    public String nome;
    public String genero;
    public String idade;
    public String cpf;
    public double salario;

    public void imprimirInfos() {
        System.out.println("=============Usuário" + nome + "============");
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Genero: " + genero);
        System.out.println("CPF: " + cpf + "| Salario: " + salario);

    }

    public void realizarLancamento(double valor, String tipoLanc, String descricao) {
        System.out.println("Salario Inicial: " + salario);

        if (tipoLanc.equalsIgnoreCase("credito")){
            //Credito
            salario+= valor;
            System.out.println("Operaçao de credito de valor " + valor + "no salario ");


        } else {
            //Debito
            salario -= valor;
            System.out.println("Operaçao de debito de valor " + valor + " no salario ");
        }
        System.out.println("Descrição do lançamento: " + descricao);
    }
}

