/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anderson.http.leitura;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@XmlRootElement
public class MensagemErro {
    
    //Atributos
    private String erro;

    //Construtores
    public MensagemErro() {
    }

    public MensagemErro(String erro) {
        this.erro = erro;
    }
    
    //Getters and Setters
    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
    
}
