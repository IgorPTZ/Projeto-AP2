package frb.edu.br.igor.controladores.util;

import frb.edu.br.igor.dominio.entidades.Pais;
import frb.edu.br.igor.infra.repositorios.PaisRepositorio;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.Map;

@FacesConverter(value="paisConverter")
public class PaisConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

        if(value == null || !value.matches("\\d+")) {
            return null;
        }

        return this.getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value != null && !value.equals("")) {
            Pais pais = (Pais) value;

            if(pais.getPais_id() != null) {
                this.addAttribute(uiComponent, pais);
                return pais.getPais_id().toString();
            }
        }

        return null;
    }

    private Map<String, Object> getAttributesFrom(UIComponent componente) {
        return componente.getAttributes();
    }

    private void addAttribute(UIComponent componente, Pais pais) {
        this.getAttributesFrom(componente).put(pais.getPais_id().toString(), pais);
    }
}
