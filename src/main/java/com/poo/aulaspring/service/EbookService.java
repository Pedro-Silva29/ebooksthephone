package com.poo.aulaspring.service;

import com.poo.aulaspring.model.Ebook;
import com.poo.aulaspring.repository.EbookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EbookService {

    private final EbookRepository ebookRepository;

    @Autowired
    public EbookService(EbookRepository ebookRepository){

        this.ebookRepository = ebookRepository;
    }
    public Ebook criarEbook(Ebook ebook) {

        return ebookRepository.save(ebook);
    }

    public void excluirEbookPorId(long id) {
        ebookRepository.deleteById(id);
    }

    public Ebook obterEbookPorId(long id) {
        return ebookRepository.findById(id).orElse(null);
    }

    public Ebook atualizarEbook(Ebook ebookAtualizado) {
        // Verifique se o eBook com o ID fornecido já existe no banco de dados
        Ebook ebookExistente = ebookRepository.findById(ebookAtualizado.getId()).orElse(null);

        // Se o eBook existir, atualize suas propriedades
        if (ebookExistente != null) {
            ebookExistente.setTitulo(ebookAtualizado.getTitulo());
            ebookExistente.setAutor(ebookAtualizado.getAutor());
            // Atualize outras propriedades conforme necessário

            // Salve as alterações no banco de dados
            return ebookRepository.save(ebookExistente);
        } else {
            // Se o eBook não existir, você pode optar por lançar uma exceção ou retornar null
            // Neste exemplo, estou lançando uma exceção para indicar que o eBook não foi encontrado
            throw new EntityNotFoundException("Ebook não encontrado com ID: " + ebookAtualizado.getId());
        }
    }
    public Ebook retornarEbookPeloTitulo(String titulo){

        return ebookRepository.findByTitulo(titulo);
    }
}
