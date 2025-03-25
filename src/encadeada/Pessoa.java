package encadeada;



public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private Pessoa proximo; // Referência para a próxima pessoa na cadeia

    // Métodos com encadeamento (method chaining)
    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pessoa setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public Pessoa setEmail(String email) {
        this.email = email;
        return this;
    }

    public Pessoa setProximo(Pessoa proximo) {
        this.proximo = proximo;
        return this;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", email='" + email + '\'' +
               '}';
    }

    
}
