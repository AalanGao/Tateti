package Model;

import java.util.Random;

public final class Tateti {
    private static Tateti instance;
    private Jugador[]     jugadores;
    private Casilla[][]   tablero;
    private static Random random  = new Random();

    private Tateti() {

        JugadorIA ia   = new JugadorIA();
        Jugador humano = new Jugador();

        this.jugadores    = new Jugador[2];
        this.jugadores[0] = humano;
        this.jugadores[1] = ia;

        this.tablero = new Casilla[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casillaAux = new Casilla();
                this.tablero[i][j] = casillaAux;
            }
        }
    }

    public static Tateti getInstance(){
        if(Tateti.instance == null){
            Tateti.instance = new Tateti();
        }

        return Tateti.instance;
    }

    private void colocarFicha(int[] posicion, Ficha tipoFicha){
        this.tablero[posicion[0]][posicion[1]].setTipoficha(tipoFicha);
    }

    public void comenzarJuego(){
        int i = 0;
        int jugadorAct = Tateti.getRandom(2);
        Ficha fichaAct = Ficha.CIRCULO;

        System.out.println("Bienvenido al Model.Tateti");

        this.estadoDelTablero();

        while (!this.hayGanador() && i<=9){
            // valido si la casilla esta disponible
            int[] posicion = this.jugadores[jugadorAct].elejirPosicion();
            Casilla casillaAct = this.tablero[posicion[0]][posicion[1]];
            while (!casillaAct.estaVacio()){
                posicion = this.jugadores[jugadorAct].elejirPosicion();
                casillaAct = this.tablero[posicion[0]][posicion[1]];
            }

            this.colocarFicha(posicion,fichaAct);
            this.estadoDelTablero();

            jugadorAct = jugadorAct == 0 ? 1 : 0;
            fichaAct = fichaAct == Ficha.CIRCULO ? Ficha.CRUZ : Ficha.CIRCULO;

            i++;
        }

        if (i == 9) {
            System.out.println("Empate");
        } else if (jugadorAct == 1){
            System.out.printf("Has ganado");
        } else {
            System.out.printf("Te gano la IA, suerte en la proxima.");
        }
    }

    private boolean hayGanador(){
        // Verificar filas y columnas
        for (int i = 0; i < this.tablero.length; i++) {
            // Verificar filas y columnas
            if ((!tablero[i][0].estaVacio() &&
                    tablero[i][0].getTipoficha() == tablero[i][1].getTipoficha() &&
                    tablero[i][0].getTipoficha() == tablero[i][2].getTipoficha()) ||
                        (!tablero[0][i].estaVacio() &&
                            tablero[0][i].getTipoficha() == tablero[1][i].getTipoficha() &&
                            tablero[0][i].getTipoficha() == tablero[2][i].getTipoficha())) {
                return true;
            }
        }
        // Verificar diagonales
        if ((!tablero[0][0].estaVacio() &&
                tablero[0][0].getTipoficha() == tablero[1][1].getTipoficha() &&
                tablero[0][0].getTipoficha() == tablero[2][2].getTipoficha()) ||
                (!tablero[0][2].estaVacio() &&
                        tablero[0][2].getTipoficha() == tablero[1][1].getTipoficha() &&
                        tablero[0][2].getTipoficha() == tablero[2][0].getTipoficha())) {
            return true;
        }

        return false;
    }

    private void estadoDelTablero(){
        for (int i = 0; i < this.tablero.length; i++) {
            for (Casilla casillaAct : this.tablero[i]) {
                if(casillaAct.getTipoficha() == Ficha.CRUZ){
                    System.out.print("[X] ");
                } else if (casillaAct.getTipoficha() == Ficha.CIRCULO) {
                    System.out.print("[O] ");
                }else {
                    System.out.print("[] ");
                }
            }
            System.out.println();
        }
    }

    public static int getRandom(int range) {
        return Tateti.random.nextInt(range);
    }


}
