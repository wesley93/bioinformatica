/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bioinformatica.ultilitarios;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Alternativa {
    private int id;
    private int intQuestao;
    private String strAlternativa;
    private boolean booResposta;

    /**
     * @return the id
     */
    public int getIntId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setIntId(int id) {
        this.id = id;
    }

    /**
     * @return the intQuestao
     */
    public int getIntQuestao() {
        return intQuestao;
    }

    /**
     * @param intQuestao the intQuestao to set
     */
    public void setIntQuestao(int intQuestao) {
        this.intQuestao = intQuestao;
    }

    /**
     * @return the strAlternativa
     */
    public String getStrAlternativa() {
        return strAlternativa;
    }

    /**
     * @param strAlternativa the strAlternativa to set
     */
    public void setStrAlternativa(String strAlternativa) {
        this.strAlternativa = strAlternativa;
    }

    /**
     * @return the booResposta
     */
    public boolean isBooResposta() {
        return booResposta;
    }

    /**
     * @param booResposta the booResposta to set
     */
    public void setBooResposta(boolean booResposta) {
        this.booResposta = booResposta;
    }

}
