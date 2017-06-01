package com.anderson.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anderson
 */
public class Util {

    public static String conteudoSite(String url) {
        try {
            //Lê o conteúdo do site e o passa para um Stream
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

            //Variável auxiliar
            String aux;

            //Texto inicial
            String texto = "";

            //Laço que lê cada linha do site e o passa para o auxiliar
            while ((aux = in.readLine()) != null) {

                //Adiciona o texto auxiliar ao definitivo
                texto += aux;
            }

            //Retorna o conteúdo como String
            return texto;

        } catch (Exception e) {
            //Se acontecer algum erro, retorna null
            return null;
        }
    }

    //Método para a contagem de palavras numa String
    public static int contarOcorrencias(String texto, String criterio) {

        try {

            //Cria uma expressão regular com o critério da busca
            Pattern pattern = Pattern.compile(criterio);

            //Cria um Matcher que irá analisar o texto com base no Pattern
            Matcher matcher = pattern.matcher(texto);

            //Laço para contar o número de ocorrências
            int contador = 0;
            while (matcher.find()) {
                contador++;
            }
            return contador;

        } catch (Exception e) {
            //Se acontecer algum erro, retorna -1
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Util.contarOcorrencias(conteudoSite("http://www.google.com/"), "a"));

    }

}
