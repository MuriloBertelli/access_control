package br.com.murilobertelli.controleacesso.security;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MonitorReferencias {
    private JSONObject baseAutorizacao;

    public MonitorReferencias(String nomeArquivoJson) {
        
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(nomeArquivoJson)) {
            
            if (is == null) {
                throw new IllegalArgumentException("Arquivo JSON não encontrado no classpath: " + nomeArquivoJson);
            }

            // Lê os bytes garantindo a codificação UTF-8
            String conteudo = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            this.baseAutorizacao = new JSONObject(conteudo);
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar a Base de Autorização: " + e.getMessage());
            this.baseAutorizacao = new JSONObject(); // Evita NullPointerException
        }
    }

    public boolean verificarAcesso(String usuario, String recurso, String acao) {
        if (!baseAutorizacao.has(usuario)) {
            return false;
        }

        JSONObject permissoesUsuario = baseAutorizacao.getJSONObject(usuario);

        if (!permissoesUsuario.has(recurso)) {
            return false;
        }

        JSONArray acoesPermitidas = permissoesUsuario.getJSONArray(recurso);

        for (int i = 0; i < acoesPermitidas.length(); i++) {
            if (acoesPermitidas.getString(i).equals(acao)) {
                return true; 
            }
        }

        return false; 
    }
}