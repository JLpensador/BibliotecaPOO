public class Autor {
    private String codigo;
    private String nome;
    private String nacionalidade;

    public Autor(String codigo, String nome, String nacionalidade) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código não pode ser vazio.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (nacionalidade == null || nacionalidade.isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade não pode ser vazia.");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        if (nacionalidade == null || nacionalidade.isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade não pode ser vazia.");
        }
        this.nacionalidade = nacionalidade;
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Nacionalidade: " + nacionalidade);
    }
}