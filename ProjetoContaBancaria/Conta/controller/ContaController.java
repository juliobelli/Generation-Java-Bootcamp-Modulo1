package ProjetoContaBancaria.Conta.controller;

import ProjetoContaBancaria.Conta.model.Conta;
import ProjetoContaBancaria.Conta.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
    int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.visualizar();
        }else{
            System.out.println("\nA conta número: " +numero+ " Não foi encontrada!");
        }
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("Conta numero: " +conta.getNumero() + " cadastrada com sucesso!");

    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());
        if (buscaConta != null) {
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("\nA conta numero: " +conta.getNumero() + " foi atualizada com sucesso!");
        } else
            System.out.println("\nA conta numero: " +conta.getNumero() + " Não foi encontrada!");
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            if (listaContas.remove(conta) == true) {
                System.out.println("\nA conta numero: " + numero + "foi deletada com sucesso!");
            }
        } else {
            System.out.println("\nA conta numero: " + numero + " Não foi encontrada!");
        }
    }

    @Override
    public void sacar(int numero, float valor) {

    }

    @Override
    public void depositar(int numero, float valor) {

    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {

    }

    public int gerarNumero(){
        return ++ numero;
    }

    public Conta buscarNaCollection(int numero){
        for (var conta : listaContas) {
            if(conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }
}