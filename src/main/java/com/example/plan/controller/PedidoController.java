/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.entity.Pedido;
import com.example.plan.serviceImpl.PedidoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author BRITNEY
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping
    public String indexPedido(Model model){
        model.addAttribute("pedido", pedidoService.readAll());
        return "pedido/listarPedido";
    }
    @GetMapping("/add")
    public String addPedido(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("pedido", new Pedido());
        return "pedido/addPedido";
    }
    @GetMapping("/save")
    public String savePedido(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("pedido", new Pedido());
        return "pedido/addPedido";
    }
    @PostMapping("/save")
    public String addPedido(@Valid @ModelAttribute Pedido pedido, BindingResult result, Model model, RedirectAttributes attributes ) {  
        pedidoService.create(pedido);
        return "redirect:/pedido";
    }

    @GetMapping("/edit/{id}")
    public String editarPedido(@PathVariable("id") int idpedido, Model model) {  
        Pedido pedido = pedidoService.read(idpedido);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("pedido", pedido);
        return "pedido/addPedido";
    }

    @GetMapping("/delete/{id}")
    public String deletePedido(@PathVariable("id") int idpedido) {  
       pedidoService.delete(idpedido);
        return "redirect:/pedido";
    }
}
