Aluno.java

  package biblioteca;

public class Aluno extends Usuario {
    private String curso;
    private String turma;

    public Aluno(String nome, String cpf, String email, String curso, String turma) {
        super(nome, cpf, email);
        this.curso = curso;
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public void listarInformacoes() {
        System.out.println("[ALUNO] Nome: " + getNome() + " | CPF: " + getCpf() + 
                           " | Email: " + getEmail() + " | Curso: " + curso + " | Turma: " + turma);
    }
}
