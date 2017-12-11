package pe.com.comtecsis.crud.bean;

public class Ubigeo {
    
    private Departament departament;
    private Province province;
    private District district;

    /**
     * @return the departament
     */
    public Departament getDepartament() {
	return departament;
    }

    /**
     * @param departament
     *            the departament to set
     */
    public void setDepartament(Departament departament) {
	this.departament = departament;
    }

    /**
     * @return the province
     */
    public Province getProvince() {
	return province;
    }

    /**
     * @param province
     *            the province to set
     */
    public void setProvince(Province province) {
	this.province = province;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
	return district;
    }

    /**
     * @param district
     *            the district to set
     */
    public void setDistrict(District district) {
	this.district = district;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Ubigeo [departament=");
	builder.append(departament);
	builder.append(", province=");
	builder.append(province);
	builder.append(", district=");
	builder.append(district);
	builder.append("]");
	return builder.toString();
    }

}
