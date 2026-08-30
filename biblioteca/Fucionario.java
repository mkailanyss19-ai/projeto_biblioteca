Fucionario.java

  package biblioteca;

public class Funcionario extends Usuario {
    private String cargo;

    public Funcionario(String nome, String cpf, String email, String cargo) {
        super(nome, cpf, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void listarInformacoes() {
        System.out.println("[FUNCIONÁRIO] Nome: " + getNome() + " | CPF: " + getCpf() + 
                           " | Email: " + getEmail() + " | Cargo: " + cargo);
    }
}
