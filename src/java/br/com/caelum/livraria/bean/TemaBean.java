/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fredw
 */
@ManagedBean
@SessionScoped //vive dentro da sessão Http
public class TemaBean implements Serializable {

    private String tema = "cupertino"; //tema padrão

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<String> getTemas() {
        return Arrays.asList("aristo", "black-tie", "blitzer", "bluesky", "casablanca", "cupertino", "dark-hive",
                "dot-luv", "eggplant", "excite-bike", "flick", "glass-x", "hot-sneaks", "humanity", "le-frog",
                "midnight", "mint-choc", "overcast", "pepper-grinder", "redmond", "rocket", "sam", "smoothness",
                "south-street", "start", "sunny", "swanky-purse", "trontastic", "ui-darkness", "ui-lightness", "vader");
    }    
    
}
