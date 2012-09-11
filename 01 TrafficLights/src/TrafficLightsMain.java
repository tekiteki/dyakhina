import java.util.Scanner;

public class TrafficLightsMain {
    public static void main (String[] args){
        TrafficLights tLights = new TrafficLights ();
        boolean switchAgain = true;

        //зададим два цвета случ.образом: тот, что горел до этого, и тот, что горит сейчас
        String[] colours = new String[2];
        String[] colourNames = {"желтый", "красный", "зеленый"}; //возможные цвета
        int i = (int)(Math.random()*2); //от 0 до 2
        colours[0] = colourNames[i];
        if (i != 0){
            colours[1] = colourNames[0];
        }
        else {
            colours[1] = colourNames[(int)(Math.random()*2+0.99)]; //от 1 до 2
        }

        tLights.setLights (colours);

        while (switchAgain) {
            System.out.println(tLights.getStatus()); //выводим состояние светофора
            System.out.println("Продолжить? y/n");

            Scanner in = new Scanner(System.in);
            char yn;
            do {
                yn = in.next().charAt(0);
                if (yn == 'y') {
                    tLights.switchLights(); //переключаем цвета
                }
                else if (yn == 'n')
                    switchAgain = false;
                else
                    System.out.println("Введите \'y\' или \'n\'");
            }
            while((yn !='y')&&(yn !='n'));
        }

    }
}
