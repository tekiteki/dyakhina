public class TrafficLights {
    private String[] lights = new String[3];

    //принимаем начальное состояние светофора
    public void setLights (String[] colours){
        //lights - массив из трех эл-ов: {горел до этого, горит сейчас, загорится следующим}
        lights[0] = colours[0];
        lights[1] = colours[1];
        lights[2] = colours[2];
    }

    //"переключаем" цвета
    public void switchLights () {
        //{*,кжз,*} --> {кжз,*,*} цвет, кот. горит сейчас, станет тем, кот.горел до этого
        lights[0] = lights[1];
        //случай {з,ж,к} или {к,ж,з} --> {ж,к,ж} или {ж,з,ж}
        if (lights[1] == "желтый") {
            lights[1] = lights[2];
            lights[2] = "желтый";
        }
        //случай {ж,з,ж} --> {з,ж,к}
        else if (lights[1] == "зеленый") {
            lights[1] = "желтый"; //lights[0]
            lights[2] = "красный";
        }
        //случай {ж,к,ж} --> {к,ж,з}
        else if (lights[1] == "красный") {
            lights[1] = "желтый"; //lights[0]
            lights[2] = "зеленый";
        }
    }

    public String getStatus (){
        return "до этого горел " + lights[0] + "\n" + "сейчас горит " +
                lights[1] + "\n" + "следующим загорится " + lights[2];
    }
}