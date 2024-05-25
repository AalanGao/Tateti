package Model;

public final class Casilla {
    private Ficha tipoficha;

    public Ficha getTipoficha() {
        return tipoficha;
    }

    public void setTipoficha(Ficha tipoficha) {
        this.tipoficha = tipoficha;
    }

    public boolean estaVacio(){
        return tipoficha == null;
    }
}
