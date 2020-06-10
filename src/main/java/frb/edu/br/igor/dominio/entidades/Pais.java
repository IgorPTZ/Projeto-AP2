package frb.edu.br.igor.dominio.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Pais implements Serializable {
    private Long pais_id;

    private String pais;

    private Timestamp ultima_atualizacao;

    public Pais() {

    }

    public Pais(Long pais_id) {
        this.pais_id = pais_id;
    }

    public Pais(Long pais_id, String pais, Timestamp ultima_atualizacao) {
        this.pais_id = pais_id;
        this.pais = pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Timestamp getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(pais_id, pais.pais_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais_id);
    }
}
