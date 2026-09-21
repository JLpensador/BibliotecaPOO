public class Usuario {
    private String matricula;
    private String nome;
    private String email;
    private boolean ativo;

    public Usuario(
            String matricula,
            String nome,
            String email) {
        validarMatricula(matricula);
        validarNome(nome);
        validarEmail(email);
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        ativo = true;
    }

    private void validarMatricula(
            String matricula) {
        if (matricula == null ||

                matricula.isBlank()) {

            throw new IllegalArgumentException(
                    "A matrícula é obrigatória.");
        }
    }

    private void validarNome(String nome) {

        if (nome == null ||
                nome.isBlank()) {

            throw new IllegalArgumentException(
                    "O nome é obrigatório.");
        }
    }

    private void validarEmail(String email) {

        if (email == null ||
                email.isBlank()) {

            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {

        validarEmail(email);

        this.email = email;
    }

    public void ativar() {

        ativo = true;
    }

    public void desativar() {

        ativo = false;
    }

    public void exibirDados() {

        System.out.println(
                "Matrícula: " + matricula);

        System.out.println(
                "Nome: " + nome);

        System.out.println(
                "E-mail: " + email);

        System.out.println("Situação: "
                + (ativo ? "Ativo" : "Inativo"));
    }
}