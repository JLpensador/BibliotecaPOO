import java.util.ArrayList;

public class Livro {
    private String isbn;
    private String titulo;
    private int anoPublicacao;
    private Autor autor;
    private ArrayList<Exemplar> exemplares;

    public Livro(
            String isbn,
            String titulo,
            int anoPublicacao,
            Autor autor) {
        validarIsbn(isbn);
        validarTitulo(titulo);
        validarAno(anoPublicacao);
        if (autor == null) {
            throw new IllegalArgumentException(
                    "O autor é obrigatório.");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;

        exemplares = new ArrayList<>();
    }

    private void validarIsbn(String isbn) {

        if (isbn == null ||
                isbn.isBlank()) {

            throw new IllegalArgumentException(
                    "O ISBN é obrigatório.");
        }
    }

    private void validarTitulo(String titulo) {

        if (titulo == null ||
                titulo.isBlank()) {

            throw new IllegalArgumentException(
                    "O título é obrigatório.");
        }
    }

    private void validarAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException(
                    "O ano de publicação deve ser maior que zero.");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        validarTitulo(titulo);
        this.titulo = titulo;
    }

    public void setAnoPublicacao(
            int anoPublicacao) {
        validarAno(anoPublicacao);
        this.anoPublicacao = anoPublicacao;
    }

    public void adicionarExemplar(
            String codigo) {
        if (buscarExemplarPorCodigo(codigo) != null) {
            throw new IllegalArgumentException(
                    "Já existe um exemplar com esse código.");
        }
        Exemplar exemplar = new Exemplar(codigo);

        exemplares.add(exemplar);
    }

    public int getQuantidadeExemplares() {

        return exemplares.size();
    }

    public Exemplar buscarExemplarPorCodigo(
            String codigo) {

        for (Exemplar exemplar : exemplares) {

            if (exemplar
                    .getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return exemplar;
            }
        }

        return null;
    }

    public Exemplar buscarExemplarDisponivel() {

        for (Exemplar exemplar : exemplares) {

            if (exemplar.isDisponivel()) {

                return exemplar;
            }
        }

        return null;
    }

    public void listarExemplares() {

        if (exemplares.isEmpty()) {

            System.out.println(
                    "Nenhum exemplar cadastrado.");

            return;
        }

        System.out.println(
                "Exemplares do livro: " + titulo);

        for (Exemplar exemplar : exemplares) {

            exemplar.exibirDados();

            System.out.println(

                    "--------------------");
        }
    }

    public void exibirDados() {

        System.out.println(
                "ISBN: " + isbn);

        System.out.println(
                "Título: " + titulo);

        System.out.println(
                "Ano: " + anoPublicacao);

        System.out.println(
                "Autor: " + autor.getNome());

        System.out.println(
                "Quantidade de exemplares: "
                        + exemplares.size());
    }
}