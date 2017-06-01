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
public class ApiLeitura {
    
    //Atributos
    private int ocorrencias;
    
    //Construtores
    public ApiLeitura() {
    }

    public ApiLeitura(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    //Getters and Setters
    public int getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }    
    
}
