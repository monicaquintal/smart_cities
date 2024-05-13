package br.com.fiap.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_CATEGORIAS_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_CATEGORIAS_SEQ",
            sequenceName = "TBL_CATEGORIAS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Game> games;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + "'" +
                ", games=" + games +
                '}';
    }
}