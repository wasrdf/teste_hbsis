package Controller;

import Business.CidadeBusiness;
import Business.CityBusiness;
import Business.CountryBusiness;
import Business.PrevisaoBusiness;
import Modelo.Cidade;
import Modelo.City;
import Modelo.Country;
import Modelo.Previsao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author washington
 */
@ManagedBean
@ViewScoped
public class CidadeController {

    private Cidade cidade;
    private CidadeBusiness cidadeBusiness;
    private List<Cidade> cidades;

    private CountryBusiness countryBusiness;
    private List<Country> countries;

    private CityBusiness cityBusiness;
    private List<City> cities;

    private String paisSelecionado;

    private PrevisaoBusiness previsaoBusiness;
    private Previsao previsao;

    private Integer cidadeSelecionada;

    public void iniciarProcesso() {
        this.cidade = new Cidade();
        this.cidades = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.countryBusiness = new CountryBusiness();
        this.cityBusiness = new CityBusiness();
        this.setCountries(countryBusiness.listarPaises());
        this.cidadeBusiness = new CidadeBusiness();
        this.setCidades(cidadeBusiness.listarCidades());

    }

    public void listarCidades() {
        this.setCities(cityBusiness.listarCidadePorPais(paisSelecionado));
    }

    public void limparCampos() {
        this.cidade = new Cidade();
        this.paisSelecionado = null;
    }

    public void inserirCidade() {
        cidadeBusiness = new CidadeBusiness();
        if (this.cidadeBusiness.inserirCidade(this.cidade)) {
            Util.Mensagem.saveMessage("Cidade cadastrada com sucesso!", "S");
            limparCampos();
            carregarCidadesCadastradas();
        } else {
            Util.Mensagem.saveMessage("Ocorreu um erro inesperado ao tentar salvar essa cidade", "");
        }
    }

    public void carregarCidadesCadastradas() {
        cidadeBusiness = new CidadeBusiness();
        setCidades(cidadeBusiness.listarCidades());
    }

    public void verificarPrevisao(Integer idCidade) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + "/previsao/detalhePrevisao.jsf?idCity=" + idCidade);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void carregarDetalhePrevisao() {
        cityBusiness = new CityBusiness();
        previsaoBusiness = new PrevisaoBusiness();
        City city = cityBusiness.obterCity(cidadeSelecionada);
        setCidade(new Cidade());
        getCidade().setCity(city);
        setPrevisao(previsaoBusiness.obterPrevisao(cidadeSelecionada));
    }

    public void paginaInicial() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + "/home/inicial.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public CidadeBusiness getCidadeBusiness() {
        return cidadeBusiness;
    }

    public void setCidadeBusiness(CidadeBusiness cidadeBusiness) {
        this.cidadeBusiness = cidadeBusiness;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(String paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }

    public Previsao getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Previsao previsao) {
        this.previsao = previsao;
    }

    public Integer getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(Integer cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

}
