package com.anderson.service;

import com.anderson.http.leitura.ApiLeitura;
import com.anderson.http.leitura.MensagemErro;
import com.anderson.util.Util;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Anderson
 */
@Path("")
public class ApiService {
    
    @GET //Tipo de método Http
    @Path(value = "/ocorrencias") //Rota que acessa o método
    @Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")//Tipo de Retorno
    public Response contarOcorrencias(@QueryParam("url") String url, @QueryParam("criterio") String criterio) {
        
        //Pegar o texto do site pela Url
        String texto = Util.conteudoSite(url);
        
        //Verificar se o texto existe
        if (texto != null) {
            //Criar um objeto de leitura com o número de ocorrências do critério de busca no texto
            ApiLeitura leitura = new ApiLeitura(Util.contarOcorrencias(texto, criterio));
            
            //Verificar se o número de ocorrências é válido
            if (leitura.getOcorrencias() >= 0) {
                //Retornar o Json com o objeto de leitura com Status code OK
                return Response.ok().entity(leitura).build();
            }
        }
        //Se alguma das verificações falhar, Retorna um Json com mensaem de erro e Status code de BAD REQUEST
        return Response.status(Response.Status.BAD_REQUEST).entity(new MensagemErro("Erro ao fazer busca")).build();
    }
}
