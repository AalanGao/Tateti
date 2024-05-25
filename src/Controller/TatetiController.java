package Controller;

import Model.Tateti;

public final class TatetiController {
    private static TatetiController INSTANCE;

    private static Tateti tateti;

    private TatetiController(){
        tateti = Tateti.getInstance();
    }

    public static TatetiController getInstance(){
        if(TatetiController.INSTANCE == null){
            TatetiController.INSTANCE = new TatetiController();
        }
        return TatetiController.INSTANCE;
    }

    public void iniciar(){
        tateti.comenzarJuego();
    }
}
