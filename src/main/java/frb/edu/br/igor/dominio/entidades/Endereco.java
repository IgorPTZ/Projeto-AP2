package frb.edu.br.igor.dominio.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Endereco implements Serializable {

    private Long endereco_id;

    private String endereco;

    private String endereco2;

    private String bairro;

    private Cidade cidade;

    private String cep;

    private String telefone;

    private Timestamp ultima_atualizacao;

    public Endereco() {
    }

    public Endereco(Long endereco_id, String endereco, String endereco2, String bairro, Cidade cidade, String cep, String telefone, Timestamp ultima_atualizacao) {
        this.endereco_id = endereco_id;
        this.endereco = endereco;
        this.endereco2 = endereco2;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        Endereco endereco = (Endereco) o;
        return Objects.equals(endereco_id, endereco.endereco_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco_id);
    }
}
