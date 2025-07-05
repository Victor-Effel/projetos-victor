public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    // Construtor completo com estoque
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data dataFundacao, int qtdMaxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[qtdMaxProdutos];
    }

    // Construtor com salário -1 e estoque
    public Loja(String nome, int quantidadeFuncionarios,
                Endereco endereco, Data dataFundacao, int qtdMaxProdutos) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, qtdMaxProdutos);
    }

    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) return -1;
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) return 'P';
        if (quantidadeFuncionarios <= 30) return 'M';
        return 'G';
    }

    public String toString() {
        String info = "Loja: " + nome + " | Funcionários: " + quantidadeFuncionarios +
               " | Salário base: R$" + salarioBaseFuncionario +
               "\nEndereço: " + endereco +
               "\nData de fundação: " + dataFundacao +
               "\nProdutos no estoque:\n";

        for (Produto p : estoqueProdutos) {
            if (p != null) {
                info += p + "\n";
            }
        }

        return info;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public double getSalarioBaseFuncionario() { return salarioBaseFuncionario; }
    public Endereco getEndereco() { return endereco; }
    public Data getDataFundacao() { return dataFundacao; }
    public Produto[] getEstoqueProdutos() { return estoqueProdutos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) { this.salarioBaseFuncionario = salarioBaseFuncionario; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public void setDataFundacao(Data dataFundacao) { this.dataFundacao = dataFundacao; }
    public void setEstoqueProdutos(Produto[] estoqueProdutos) { this.estoqueProdutos = estoqueProdutos; }

    // === NOVOS MÉTODOS DA ETAPA 4 ===

    public void imprimeProdutos() {
        for (Produto p : estoqueProdutos) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }

    public boolean insereProduto(Produto p) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = p;
                return true;
            }
        }
        return false; // estoque cheio
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equalsIgnoreCase(nomeProduto)) {
                estoqueProdutos[i] = null;
                return true;
            }
        }
        return false; // produto não encontrado
    }
}
