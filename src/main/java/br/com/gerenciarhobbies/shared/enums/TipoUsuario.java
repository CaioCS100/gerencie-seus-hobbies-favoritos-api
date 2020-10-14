package br.com.gerenciarhobbies.shared.enums;

public enum TipoUsuario {
    ADMINISTRADOR(1, "Administrador"),
    USUARIO(2, "Usuário Normal");

    private Integer codigo;
    private String descricao;

    TipoUsuario(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
