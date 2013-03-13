package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}
        
        @Test
        public void testShouldListAllCurrentProductsInTheCart()
        {
            List<String> itens = carrinho.getCurrentList();
            
            Assert.assertEquals(0, itens.size());
            
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            Produto copia = new Produto("Outro Livro", 50.00);
            carrinho.add(copia);
            
            itens = carrinho.getCurrentList();
            
            Assert.assertEquals(2, itens.size());
            
            Assert.assertTrue(itens.contains("Java em 24 horas"));
            Assert.assertTrue(itens.contains("Outro Livro"));
        }
        
        @Test
        public void testShouldAllowRemovingAProductFromTheCart()
        {
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            Produto copia = new Produto("Outro Livro", 50.00);
            carrinho.add(copia);
            
            carrinho.remove(original);
            
            List<String> itens = carrinho.getCurrentList();
            
            Assert.assertEquals(1, itens.size());
            
            Assert.assertFalse(itens.contains("Java em 24 horas"));
            Assert.assertTrue(itens.contains("Outro Livro"));
        }
        
        @Test
        public void testShouldCalculateTheTotalCartAmmount()
        {
            Produto original = new Produto("Java em 24 horas", 50.00);
            Produto copia = new Produto("Outro Livro", 150.00);
            Produto terceiro = new Produto("Mais um", 15.00);
            
            Assert.assertEquals(0.00, carrinho.getCurrentTotalPrice(), 0.1);
            
            carrinho.add(original);
            
            Assert.assertEquals(50.00, carrinho.getCurrentTotalPrice(), 0.1);
            
            carrinho.add(copia);
            
            Assert.assertEquals(200.00, carrinho.getCurrentTotalPrice(), 0.1);
            
            carrinho.add(terceiro);
            
            Assert.assertEquals(215.00, carrinho.getCurrentTotalPrice(), 0.1);
        }
        

}
