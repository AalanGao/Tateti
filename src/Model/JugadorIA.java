package Model;

import static java.lang.Thread.sleep;

public class JugadorIA extends Jugador{
    @Override
    public int[] elejirPosicion() {
        int[] result = new int[2];
        System.out.println("La IA esta pensando...");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result[0] = Tateti.getRandom(3);
        result[1] = Tateti.getRandom(3);
        return result;
    }
}
