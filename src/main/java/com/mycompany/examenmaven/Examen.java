/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examenmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author estudios
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //conectarse al documento de la pagina web
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();

            //titulo del documento
            String titulo = doc.title();
            System.out.println(titulo);
            // Resultado: Vigo, España Pronóstico del tiempo y condiciones meteorológicas - The Weather Channel | Weather.com

            //Seleccionamos el elemento de la clase today_nowcard-phrase y cogemos su contenido
            Elements estadoCielo = doc.select("div.today_nowcard-phrase");
            System.out.println(estadoCielo.eachText());
            //Muestra [Parcialmente nublado]

            //Seleccionamos el elemento de la clase today_nowcard-temp y cogemos su contenido
            Elements temperatura = doc.select("div.today_nowcard-temp");
            System.out.println(temperatura.eachText());
            //Resultado: 11º

        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
