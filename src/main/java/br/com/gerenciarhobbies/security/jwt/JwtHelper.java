package br.com.gerenciarhobbies.security.jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtHelper {

    @Value("${seguranca.autenticacao.jwt.segredo-base64}")
    private String segredo;

    public SecretKey obterSecretKey() {
        return Keys.hmacShaKeyFor(obterBytesSegredoApp());
    }

    public byte[] obterBytesSegredoApp() {
        return !StringUtils.isEmpty(segredo) ? obterBytesSegredo(segredo) : obterBytesSegredoBase64();
    }

    private byte[] obterBytesSegredo(String segredo) {
        return segredo.getBytes(StandardCharsets.UTF_8);
    }

    private byte[] obterBytesSegredoBase64() {
        return Decoders.BASE64.decode(segredo);
    }
}
