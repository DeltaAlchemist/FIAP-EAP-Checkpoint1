package br.com.fiap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco implements Serializable {

    // Constructors
    public Endereco() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Endereco(String rua, Integer numero, String cep, String complemento, String bairro,
                    String cidade, String uf) {
        this();
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    private Long id;

    @Column(name = "ds_rua", length = 50, nullable = false)
    private String rua;

    @Column(name = "nr_endereco")
    private Integer numero;

    @Column(name = "nr_cep", length = 12, nullable = false)
    private String cep;

    @Column(name = "ds_complemento", length = 20)
    private String complemento;

    @Column(name = "ds_bairro", length = 20, nullable = false)
    private String bairro;

    @Column(name = "ds_cidade", length = 30, nullable = false)
    private String cidade;

    @Column(name = "ds_uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;


    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    // Getters / Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    // Methods
    @Override
    public String toString() {
        return "\n" + this.getRua() + "\n" + this.getNumero() + "\n" + this.getComplemento() + "\n" +
                this.getBairro() + "\n" + this.getCidade() + "\n" + this.getUf() + " - " + this.getCep();
    }
}
