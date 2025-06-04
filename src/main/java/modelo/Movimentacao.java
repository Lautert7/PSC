package modelo;

import java.time.LocalDateTime;

public class Movimentacao {
    
    
    private int id;
    private String tipo;
    private LocalDateTime dataMovimentacao;
    private int quantidade;
    private int id_produto;
    
    public Movimentacao(){
        
    }
    
    public Movimentacao(int id, String tipo, LocalDateTime dataMovimentacao, int quantidade, int id_produto){
        this.id = id;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
        
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
}
