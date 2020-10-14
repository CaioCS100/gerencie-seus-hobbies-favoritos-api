package br.com.gerenciarhobbies.domain.converter;

import br.com.gerenciarhobbies.shared.enums.TipoSexo;

import javax.persistence.AttributeConverter;

import static br.com.gerenciarhobbies.util.VerificadorUtil.naoEstaNulo;

public class TipoSexoConvert implements AttributeConverter<TipoSexo, String> {
    @Override
    public String convertToDatabaseColumn(TipoSexo tipoSexo) {
        return naoEstaNulo(tipoSexo) ? tipoSexo.getCodigo() : null;
    }

    @Override
    public TipoSexo convertToEntityAttribute(String codigo) {
        return naoEstaNulo(codigo) ? TipoSexo.obterPorCodigo(codigo) : null;
    }
}
