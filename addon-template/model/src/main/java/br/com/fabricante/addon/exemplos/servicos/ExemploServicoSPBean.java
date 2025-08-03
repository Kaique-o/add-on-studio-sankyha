package br.com.fabricante.addon.exemplos.servicos;

import br.com.sankhya.modelcore.MGEModelException;
import br.com.sankhya.modelcore.util.BaseSPBean;
import br.com.sankhya.ws.ServiceContext;
import com.google.gson.JsonObject;

import javax.ejb.SessionBean;
/*

        � obrigat�rio seguir o padr�o abaixo para criar Servi�os (similares � endpoints):

        A documenta��o � OBRIGAT�RIA!!!!!! Sem ela, o xdoclet n�o conseguir� gerar suas interfaces e o servi�o nunca ser� encontrado.

        1 - Nome da classe sempre termina com *SPBean.
        2 - @ejb.bean sempre ser� o Nome da classe, mas termina somente com *SP.
        3 - jndi-name sempre ser� o caminho completo para a classe, cujo nome seguir� o padr�o acima, e sempre ser� separado por "/".
        4 - type - Recomendado � stateless, caso deseje outro, consulte documenta��o.
        5 - transaction-type - Recomendado � "Container". Caso deseje outro, consulpe documenta��o.
        6 - view-type - Sempre ser� "remote".
        7 - @ejb.transaction - Recomendado � "Supports". Caso deseje outro, consulte documenta��o.
        8 - @ejb.util - Recomendado � false. Caso deseje outro, consulte documenta��o.


        IMPORTANTE: � necess�rio tamb�m editar o arquivo 'service-providers.xml'. Este arquivo est� em vc/src/main/WEB-INF/resources/service-providers.xml.
        Todo servi�o novo deve ser declarado neste arquivo, caso contr�rio, este n�o ser� localizado em tempo de execu��o.
 */


/**
 * @ejb.bean name="ExemploServicoSP"
 * jndi-name="br/com/fabricante/addon/exemplos/servicos/ExemploServicoSP"
 * type="Stateless"
 * transaction-type="Container"
 * view-type="remote"
 * @ejb.transaction type="Supports"
 * @ejb.util generate="false"
 */
public class ExemploServicoSPBean extends BaseSPBean implements SessionBean {

    /*
            A cria��o de um m�todo que ser� chamado (equivalente � um endpoint) deve seguir o padr�o abaixo.

            A documenta��o � OBRIGAT�RIA!!! Sem ela, o xdoclet n�o conseguir� gerar suas interfaces e este m�todo n�o ser� encontrado.

            1 - @ejb.interface-method - Sempre ser� "remote".
            2 - O par�metro br.com.sankhya.ws.ServiceContext � OBRIGAT�RIO. Esta � a assinatura padr�o do m�todo. Ex: public void meuMetodo(br.com.sankhya.ws.ServiceContext ctx) {...}

            Importante: O m�todo abaixo ser� chamado com URL/nome_projeto/service.sbr?serviceName=ExemploServicoSP.getAlgumaInfo, onde
            nome_projeto � o valor de 'rootProject.name' que est� no arquivo 'settings.gradle'.

    */

    /**
     * @throws MGEModelException
     * @ejb.interface-method tview-type="remote"
     */
    public void getAlgumaInfo(ServiceContext ctx) throws MGEModelException {
        JsonObject object = new JsonObject();
        object.addProperty("codparc", "123456");
        ctx.setJsonResponse(object);
    }
}
