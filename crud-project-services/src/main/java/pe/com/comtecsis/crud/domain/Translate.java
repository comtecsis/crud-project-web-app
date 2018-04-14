package pe.com.comtecsis.crud.domain;

import java.io.Serializable;

public class Translate implements Serializable {

    private static final long serialVersionUID = 6609099590960881220L;

    private String code;
    private String literal;

    /**
     * @return the code
     */
    public String getCode() {
	return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
	this.code = code;
    }

    /**
     * @return the literal
     */
    public String getLiteral() {
	return literal;
    }

    /**
     * @param literal
     *            the literal to set
     */
    public void setLiteral(String literal) {
	this.literal = literal;
    }

}
