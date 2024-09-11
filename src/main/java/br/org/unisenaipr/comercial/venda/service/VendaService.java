package br.org.unisenaipr.comercial.venda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.unisenaipr.comercial.produto.entity.Produto;
import br.org.unisenaipr.comercial.produto.repository.ProdutoRepository;
import br.org.unisenaipr.comercial.venda.entity.ItemVenda;
import br.org.unisenaipr.comercial.venda.entity.Venda;
import br.org.unisenaipr.comercial.venda.repository.VendaRepository;
import jakarta.transaction.Transactional;

public class VendaService {
	
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Venda registrarVenda(List<ItemVenda> itensVenda) {
        double valorTotal = 0;

        for (ItemVenda item : itensVenda) {
            Produto produto = produtoRepository.findById(item.getProduto().getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new RuntimeException("Quantidade insuficiente em estoque para o produto: " + produto.getNome());
            }

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
            produtoRepository.save(produto);

            item.setPrecoTotal(item.getQuantidade() * produto.getPrecoVenda());
            valorTotal += item.getPrecoTotal();
        }

        Venda venda = new Venda();
        venda.setItens(itensVenda);
        venda.setValorTotal(valorTotal);
        venda.setDataHora(LocalDateTime.now());

        return vendaRepository.save(venda);
    }
}