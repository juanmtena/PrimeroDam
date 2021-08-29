package models;

public abstract class Paquete_Ruta {

    private Ruta oRuta;
    private Paquete oPaquete;

    public Paquete_Ruta(Ruta oRuta, Paquete oPaquete) {
        setORuta(oRuta);
        setOPaquete(oPaquete);
    }

    public Ruta getORuta() {
        return this.oRuta;
    }

    public void setORuta(Ruta oRuta) {
        this.oRuta = oRuta;
    }

    public Paquete getOPaquete() {
        return this.oPaquete;
    }

    public void setOPaquete(Paquete oPaquete) {
        this.oPaquete = oPaquete;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oPaquete == null) ? 0 : oPaquete.hashCode());
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
        Paquete_Ruta other = (Paquete_Ruta) obj;
        if (oPaquete == null) {
            if (other.oPaquete != null)
                return false;
        } else if (!oPaquete.equals(other.oPaquete))
            return false;
        if (oRuta == null) {
            if (other.oRuta != null)
                return false;
        } else if (!oRuta.equals(other.oRuta))
            return false;
        return true;
    }

}
