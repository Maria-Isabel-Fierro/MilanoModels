package Utiles;

import java.util.concurrent.TimeUnit;

public class Utilities {
    public static void esperar(int segundos){
        System.out.println("inicia espera de "+segundos);
        long start = System.nanoTime();
        long end= 0L;
        long microsegundos=0L;
        long tiempoTranscurrido =0L;

        do{
            end= System.nanoTime();
            microsegundos= end - start;
            tiempoTranscurrido = TimeUnit.SECONDS.convert(microsegundos,TimeUnit.NANOSECONDS);

        }while(tiempoTranscurrido<(long)segundos);

        System.out.println("Fin de la espera de "+segundos);
    }
}

