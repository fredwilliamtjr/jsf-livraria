package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Livro livro = new Livro();
    private Integer autorID;

    public Integer getAutorID() {
        return autorID;
    }

    public void setAutorID(Integer autorID) {
        this.autorID = autorID;
    }

    public Livro getLivro() {
        return livro;
    }

    public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listaTodos();
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }

    public List<Livro> getLivros() {
        return new DAO<Livro>(Livro.class).listaTodos();
    }

    public void gravarAutor() {
        Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorID);
        this.livro.adicionaAutor(autor);
        System.out.println("Livro escrito por : " + autor.getNome());
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());

        if (livro.getAutores().isEmpty()) {
//            throw new RuntimeException("Livro deve ter pelo menos um Autor.");
            FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
            return;
        }

        new DAO<Livro>(Livro.class).adiciona(this.livro);
        this.livro = new Livro(); // última linha do método gravar.
    }

    public String formAutor() {
        System.out.println("Chamando formulario de Autor");
//        return "autor"; //Com esse retorno não mostra o endereço real na barra do navegador.
        return "autor?faces-redirect=true";

    }

    public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        String valor = value.toString();
        if (!valor.startsWith("1")) {
            throw new ValidatorException(new FacesMessage("ISBN, deve começar com numero 1 !!!"));
        }

    }

}
