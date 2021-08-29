package models;

public class Ruta_Parada {

    private Ruta oRuta;
    private Parada oParada;

    public Ruta_Parada(Ruta oRuta, Parada oParada) {
        setoRuta(oRuta);
        setoParada(oParada);
    }

    public Ruta getoRuta() {
        return oRuta;
    }

    public void setoRuta(Ruta oRuta) {
        this.oRuta = oRuta;
    }

    public Parada getoParada() {
        return oParada;
    }

    public void setoParada(Parada oParada) {
        this.oParada = oParada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oParada == null) ? 0 : oParada.hashCode());
        result = prime * result + ((oRuta == null) ? 0 : oRuta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ruta_Parada other = (Ruta_Parada) obj;
        if (oParada == null) {
            if (other.oParada != null)
                return false;
        } else if (!oParada.equals(other.oParada))
            return false;
        if (oRuta == null) {
            if (other.oRuta != null)
                return false;
        } else if (!oRuta.equals(other.oRuta))
            return false;
        return true;
    }

}
