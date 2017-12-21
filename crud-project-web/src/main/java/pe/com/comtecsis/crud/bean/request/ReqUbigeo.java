package pe.com.comtecsis.crud.bean.request;

public class ReqUbigeo {
    private String idUbigeo;

    /**
     * @return the idUbigeo
     */
    public String getIdUbigeo() {
	return idUbigeo;
    }

    /**
     * @param idUbigeo
     *            the idUbigeo to set
     */
    public void setIdUbigeo(String idUbigeo) {
	this.idUbigeo = idUbigeo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("DeleteUbigeo [idUbigeo=");
	builder.append(idUbigeo);
	builder.append("]");
	return builder.toString();
    }

}
