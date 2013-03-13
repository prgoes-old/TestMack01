/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 30936871
 */
public class ProdutoTest {
    
    private Produto produto;
    
    @Test
    public void testShouldBeCreatedWithNameAndPrice()
    {
        produto = new Produto("Nome", 10.0);
        
        Assert.assertEquals("Nome", produto.getNome());
        Assert.assertEquals(10.0, produto.getPreco(), 0.01);
    }
    
    @Test
    public void testShouldBeEqualToAnotherProductWithTheSameName()
    {
        produto = new Produto("Nome", 10.0);
        
        Produto outroProduto = new Produto("Outro Nome", 10.0);
        
        Assert.assertFalse(produto.equals(outroProduto));
        
        outroProduto = new Produto("Nome", 12.0);
        
        Assert.assertTrue(produto.equals(outroProduto));        
    }
    
    
    
}
