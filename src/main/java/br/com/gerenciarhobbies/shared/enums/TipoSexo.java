package br.com.gerenciarhobbies.shared.enums;

import static br.com.gerenciarhobbies.util.VerificadorUtil.estaVazioOuNulo;

public enum TipoSexo {
    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private String codigo;
    private String descricao;

    TipoSexo(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoSexo obterPorCodigo(String codigo) {
        if (estaVazioOuNulo(codigo))
            return null;

        for (TipoSexo tipoSexo : TipoSexo.values()) {
            if (tipoSexo.getCodigo().equals(codigo))
                return tipoSexo;
        }

        return null;
    }
}
