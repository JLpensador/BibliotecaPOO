public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private Exemplar exemplar;

    private boolean ativo;

    public Emprestimo(
            Usuario usuario,
            Livro livro,
            Exemplar exemplar) {

        if (usuario == null) {

            throw new IllegalArgumentException(
                    "O usuário é obrigatório.");
        }

        if (livro == null) {

            throw new IllegalArgumentException(
                    "O livro é obrigatório.");
        }

        if (exemplar == null) {

            throw new IllegalArgumentException(
                    "O exemplar é obrigatório.");
        }

        if (!usuario.isAtivo()) {
            throw new IllegalStateException(
                    "Usuário inativo não pode realizar empréstimos.");
        }
        if (!exemplar.isDisponivel()) {
            throw new IllegalStateException(
                    "O exemplar não está disponível.");
        }
        this.usuario = usuario;
        this.livro = livro;
        this.exemplar = exemplar;
        exemplar.emprestar();
        ativo = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void devolver() {

        if (!ativo) {

            throw new IllegalStateException(
                    "Este empréstimo já foi encerrado.");
        }

        exemplar.devolver();

        ativo = false;
    }

    public void exibirDados() {

        System.out.println(
                "=== EMPRÉSTIMO ===");

        System.out.println(
                "Usuário: "

                        + usuario.getNome());

        System.out.println(
                "Livro: "
                        + livro.getTitulo());

        System.out.println(
                "Exemplar: "
                        + exemplar.getCodigo());

        System.out.println(
                "Situação: "
                        + (ativo
                                ? "Em andamento"
                                : "Finalizado"));
    }
}