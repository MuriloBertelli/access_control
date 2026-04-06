package br.com.murilobertelli.controleacesso;

import br.com.murilobertelli.controleacesso.model.Pessoa;
import br.com.murilobertelli.controleacesso.security.MonitorReferencias;

public class Main {
    public static void main(String[] args) {
   
        MonitorReferencias monitor = new MonitorReferencias("autorizacao.json");
        
        Pessoa mateus = new Pessoa("mateus", monitor);
        Pessoa joao = new Pessoa("joao", monitor);
        Pessoa alice = new Pessoa("alice_admin", monitor);

        System.out.println("--- Testes do Utilizador: Mateus ---");
        mateus.ler("sistema_logs");      // SUCESSO
        mateus.escrever("sistema_logs"); // ERRO
        mateus.excluir("diario_turma");  // SUCESSO

        System.out.println("\n--- Testes do Utilizador: Joao ---");
        joao.ler("notas_alunos");        // SUCESSO
        joao.escrever("notas_alunos");   // ERRO
        joao.ler("financeiro");          // ERRO (array vazio)

        System.out.println("\n--- Testes da Utilizadora: Alice (Admin) ---");
        alice.excluir("financeiro");     // SUCESSO
        alice.escrever("sistema_logs");  // SUCESSO
        alice.excluir("sistema_logs");   // ERRO (ela só tem r, w)
        
        System.out.println("\n--- Teste Extra: Utilizador Inexistente ---");
        Pessoa invasor = new Pessoa("hacker", monitor);
        invasor.ler("notas_alunos");     // ERRO
    }
}