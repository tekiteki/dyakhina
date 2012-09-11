import java.util.Scanner;

public class TrafficLightsMain {
    public static void main (String[] args){
        TrafficLights tLights = new TrafficLights ();
        boolean switchAgain = true;
        //задаются цвета: горел до этого, горит сейчас, загорится следующим  {ж,к,ж}, {к,ж,з}, и т.п.
        /*при желании можно реализовать случайную комбинацию из возможных случайно выбирая первый цвет,
        в зависимости от первого случайно выбирая второй, и в зависимости от второго и первого - третий*/
        //можно оставить два цвета, а третий вычислять в методе setLights, в зависимости от двух цветов
        String[] colours = {"зеленый", "желтый", "красный"};
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