package br.com.murilobertelli.controleacesso.model;

import br.com.murilobertelli.controleacesso.security.MonitorReferencias;

public class Pessoa {
    private String nome;
    private MonitorReferencias monitor;

    public Pessoa(String nome, MonitorReferencias monitor) {
        this.nome = nome;
        this.monitor = monitor;
    }

    public void ler(String recurso) {
        if (monitor.verificarAcesso(this.nome, recurso, "r")) {
            System.out.println("[SUCESSO] Leitura do recurso '" + recurso + "' concluída.");
        } else {
            System.out.println("[ERRO] Acesso negado. Não tem permissão para LER o recurso '" + recurso + "'.");
        }
    }

    public void escrever(String recurso) {
        if (monitor.verificarAcesso(this.nome, recurso, "w")) {
            System.out.println("[SUCESSO] Escrita no recurso '" + recurso + "' concluída.");
        } else {
            System.out.println("[ERRO] Acesso negado. Não tem permissão para ESCREVER no recurso '" + recurso + "'.");
        }
    }

    public void excluir(String recurso) {
        if (monitor.verificarAcesso(this.nome, recurso, "d")) {
            System.out.println("[SUCESSO] Exclusão do recurso '" + recurso + "' concluída.");
        } else {
            System.out.println("[ERRO] Acesso negado. Não tem permissão para EXCLUIR o recurso '" + recurso + "'.");
        }
    }
}