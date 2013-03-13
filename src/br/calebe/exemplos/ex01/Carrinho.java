package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList<>();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}
        
        public void remove(Produto produto) {
            produtos.remove(produto);
        }
        
        public double getCurrentTotalPrice() {
            double total = 0.0;
            for(Produto p : produtos)
            {
                total += p.getPreco();
            }
            
            return total;
        }

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.size() == 0)
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public List<String> getCurrentList()
        {
            List<String> s = new ArrayList<>();
            
            for(Produto p : produtos)
            {
                s.add(p.getNome());
            }
            
            return s;
        }

}
