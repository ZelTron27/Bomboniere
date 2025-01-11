package modelo;

public class Detalhe {
    private String nome;
    private String plataforma;
    private int anoLancamento;
    private String modoJogo;

 
    public Detalhe(String nome, String plataforma, int anoLancamento, String modoJogo) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.anoLancamento = anoLancamento;
        this.modoJogo = modoJogo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getModoJogo() {
        return modoJogo;
    }

    public void setModoJogo(String modoJogo) {
        this.modoJogo = modoJogo;
    }
}