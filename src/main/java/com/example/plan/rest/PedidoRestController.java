/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.rest;

import com.example.plan.entity.Pedido;
import com.example.plan.serviceImpl.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BRITNEY
 */
@RestController
@RequestMapping("/pedido")
public class PedidoRestController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public List<Pedido> getPosts() {
        return pedidoService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable int id) {
        Pedido pedido = pedidoService.read(id);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable int id) {        
        pedidoService.delete(id);
    }

    @PutMapping("/edit")
    public Pedido editPedido(@RequestBody Pedido pedido) {  
        //Autor aut = new Autor(autor.getId(),autor.getNombres(),autor.getApellidos(), autor.getEstado());        
        return pedidoService.update(pedido);
    }
}
