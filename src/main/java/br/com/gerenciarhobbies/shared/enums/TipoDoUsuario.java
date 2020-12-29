package br.com.gerenciarhobbies.shared.enums;

public enum TipoDoUsuario {
    ADMINISTRADOR(1L, "Administrador"),
    COMUM(2L, "Comum");

    private Long codigo;
    private String descricao;

    TipoDoUsuario(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
