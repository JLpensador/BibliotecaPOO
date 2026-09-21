import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo.");
        }
        if (buscarLivroPorIsbn(livro.getIsbn()) != null) {
            throw new IllegalArgumentException("Já existe um livro com esse ISBN.");
        }
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }
        if (buscarUsuarioPorMatricula(usuario.getMatricula()) != null) {
            throw new IllegalArgumentException("Já existe um usuário com essa matrícula.");
        }
        usuarios.add(usuario);
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equalsIgnoreCase(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorMatricula(String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equalsIgnoreCase(matricula)) {
                return usuario;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("=== LIVROS DA BIBLIOTECA ===");
        for (Livro livro : livros) {
            livro.exibirDados();
            System.out.println("---------------------------");
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("=== USUÁRIOS DA BIBLIOTECA ===");
        for (Usuario usuario : usuarios) {
            usuario.exibirDados();
            System.out.println("-----------------------------");
        }
    }

    public int getQuantidadeLivros() {
        return livros.size();
    }

    public int getQuantidadeUsuarios() {
        return usuarios.size();
    }

    public class TesteBiblioteca {
        public static void main(String[] args) {
            System.out.println("=== CRIANDO AUTORES ===");
            Autor autor1 = new Autor("A001", "Machado de Assis", "Brasileira");
            Autor autor2 = new Autor("A002", "George Orwell", "Britânica");

            System.out.println("\n=== CRIANDO LIVROS ===");
            Livro livro1 = new Livro("9788535910663", "Dom Casmurro", 1899, autor1);
            Livro livro2 = new Livro("9780451524935", "1984", 1949, autor2);

            System.out.println("\n=== CRIANDO EXEMPLARES ===");
            livro1.adicionarExemplar("EX001");
            livro1.adicionarExemplar("EX002");
            livro1.adicionarExemplar("EX003");
            livro2.adicionarExemplar("EX004");
            livro2.adicionarExemplar("EX005");

            System.out.println("\n=== CRIANDO USUÁRIOS ===");
            Usuario usuario1 = new Usuario("2026001", "Ana Silva", "ana@email.com");
            Usuario usuario2 = new Usuario("2026002", "Carlos Santos", "carlos@email.com");

            System.out.println("\n=== CRIANDO BIBLIOTECA ===");
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.adicionarLivro(livro1);
            biblioteca.adicionarLivro(livro2);
            biblioteca.adicionarUsuario(usuario1);
            biblioteca.adicionarUsuario(usuario2);

            System.out.println();
            biblioteca.listarLivros();
            System.out.println();
            biblioteca.listarUsuarios();

            System.out.println("\n=== REALIZANDO EMPRÉSTIMO ===");
            Exemplar exemplar = livro1.buscarExemplarDisponivel();
            Emprestimo emprestimo = new Emprestimo(usuario1, livro1, exemplar);
            emprestimo.exibirDados();

            System.out.println("\nExemplar disponível?");
            System.out.println(exemplar.isDisponivel());

            System.out.println("\n=== DEVOLUÇÃO ===");
            emprestimo.devolver();
            emprestimo.exibirDados();

            System.out.println("\nExemplar disponível?");
            System.out.println(exemplar.isDisponivel());

            System.out.println("\n=== FIM DOS TESTES ===");
        }
    }
}