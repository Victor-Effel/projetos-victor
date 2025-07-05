public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int qtdMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qtdMaxLojas];
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public String toString() {
        String info = "Shopping: " + nome + "\nEndereço: " + endereco + "\nLojas:\n";
        for (Loja loja : lojas) {
            if (loja != null) {
                info += loja + "\n";
            }
        }
        return info;
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
    if (tipo == null) return -1;
    int contador = 0;
    for (Loja loja : lojas) {
        if (loja != null) {
            if (tipo.equalsIgnoreCase("Cosmetico") && loja instanceof Cosmetico) {
                contador++;
            } else if (tipo.equalsIgnoreCase("Vestuário") && loja instanceof Vestuario) {
                contador++;
            } else if (tipo.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) {
                contador++;
            } else if (tipo.equalsIgnoreCase("Alimentacao") && loja instanceof Alimentacao) {
                contador++;
            } else if (tipo.equalsIgnoreCase("Informatica") && loja instanceof Informatica) {
                contador++;
            }
        }
    }
    if (!(tipo.equalsIgnoreCase("Cosmetico") || tipo.equalsIgnoreCase("Vestuário")
        || tipo.equalsIgnoreCase("Bijuteria") || tipo.equalsIgnoreCase("Alimentacao")
        || tipo.equalsIgnoreCase("Informatica"))) {
        return -1;
    }
    return contador;
}

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorSeguro = 0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica inf = (Informatica) loja;
                if (lojaMaisCara == null || inf.getSeguroEletronicos() > maiorSeguro) {
                    lojaMaisCara = inf;
                    maiorSeguro = inf.getSeguroEletronicos();
                }
            }
        }

        return lojaMaisCara;
    }
}
