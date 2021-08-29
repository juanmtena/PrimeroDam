package models;

public class Ubicacion implements IUbicacion {

    private String sCoordenadas; // PK

    public Ubicacion(String sCoordenadas) {
        setSCoordenadas(sCoordenadas);
    }

    public String getSCoordenadas() {
        return this.sCoordenadas;
    }

    public void setSCoordenadas(String sCoordenadas) {
        if (sCoordenadas.length() == COORDENADAS) {
            this.sCoordenadas = sCoordenadas;
        }
    }

    @Override
    public String toString() {
        String sResultado = "";

        sResultado += "##### UBICACION #####\n";
        sResultado += "Coordenadas: " + getSCoordenadas();

        return sResultado;
    }

    public boolean checkUbicacion() {
        boolean bExito = false;
        if (this.getSCoordenadas() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sCoordenadas == null) ? 0 : sCoordenadas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bExito = false;
        Ubicacion oUbicacion = (Ubicacion) obj;
        if (oUbicacion.getSCoordenadas() != null && this.getSCoordenadas() != null
                && this.getSCoordenadas().equals(oUbicacion.getSCoordenadas())) {
            bExito = true;
        }
        return bExito;
    }

}
