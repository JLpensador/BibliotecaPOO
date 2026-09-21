public class Exemplar {
    private String codigo;
    private boolean disponivel;

    public Exemplar(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                    "O código do exemplar é obrigatório.");
        }

        this.codigo = codigo;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException(
                    "O exemplar não está disponível.");
        }
        disponivel = false;
    }

    public void devolver() {
        if (disponivel) {
            throw new IllegalStateException(
                    "O exemplar já está disponível.");
        }
        disponivel = true;
    }

    public void exibirDados() {
        System.out.println("Código do exemplar: " + codigo);
        if (disponivel) {
            System.out.println("Situação: Disponível");
        } else {
            System.out.println("Situação: Emprestado");
        }
    }
}