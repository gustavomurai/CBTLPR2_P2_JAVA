import java.util.UUID;

public class Aluno {
    private UUID uuid;
    private String nome;
    private int idade;
    private String endereco;

    // Construtor gera UUID automaticamente
    public Aluno(String nome, int idade, String endereco) {
        this.uuid = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    // Setters
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ID: " + uuid.toString() +
               " | Nome: " + nome +
               " | Idade: " + idade +
               " | Endereço: " + endereco;
    }
}
