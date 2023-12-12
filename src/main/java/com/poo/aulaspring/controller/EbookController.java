package com.poo.aulaspring.controller;

import com.poo.aulaspring.DTO.EbookResponseDTO;
import com.poo.aulaspring.model.Ebook;
import com.poo.aulaspring.repository.EbookRepository;
import com.poo.aulaspring.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ebooks")
public class EbookController {

    private final EbookService ebookService;


    @Autowired
    private EbookRepository repository;

    @Autowired
    public EbookController(EbookService ebookService) {

        this.ebookService = ebookService;
    }

    @PostMapping
    public Ebook criarEbook(@RequestBody Ebook ebook){

        return ebookService.criarEbook(ebook);
    }

    @DeleteMapping("/{id}")
    public void excluirEbookPorId(@PathVariable long id) {
        ebookService.excluirEbookPorId(id);
    }

    @GetMapping("/{titulo}")
    public Ebook retornarEbookPeloTitulo(@PathVariable String titulo){
        return ebookService.retornarEbookPeloTitulo(titulo);
    }

    @GetMapping
    public List<EbookResponseDTO> getAll(){

        List<EbookResponseDTO> EbookList = repository.findAll().stream().map(EbookResponseDTO::new).toList();
        return EbookList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ebook> atualizarEbook(@PathVariable long id, @RequestBody Ebook ebookAtualizado) {
        Ebook ebookExistente = ebookService.obterEbookPorId(id);

        if (ebookExistente == null) {
            // Se o eBook não existe, retornar um ResponseEntity com status 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Atualizar os campos relevantes do eBook existente com os dados do eBook atualizado
        ebookExistente.setTitulo(ebookAtualizado.getTitulo());
        ebookExistente.setAutor(ebookAtualizado.getAutor());
        // Atualize outros campos conforme necessário

        // Chame o serviço para salvar o eBook atualizado no banco de dados
        Ebook ebookAtualizadoSalvo = ebookService.atualizarEbook(ebookExistente);

        // Retornar o eBook atualizado no corpo da resposta com status 200 OK
        return ResponseEntity.ok(ebookAtualizadoSalvo);
    }

}
