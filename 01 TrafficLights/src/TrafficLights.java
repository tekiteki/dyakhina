public class TrafficLights {
    private String[] lights = new String[4];

    //принимаем начальное состояние светофора
    //lights - массив из четырех эл-ов, любые из ряда: жкжзжкжз... наприм. {к,ж,з,ж}
    //{горел до этого, горит сейчас, загорится следующим, загорится за следующим}
    public void setLights (String[] colours){
        lights[0] = colours[0];
        lights[1] = colours[1];
        if (lights[1] == "красный"){
            lights[2] = "желтый";
            lights[3] = "зеленый";
        }
        else if (lights[1] == "зеленый"){
            lights[2] = "желтый";
            lights[3] = "красный";
        }
        else if (lights[1] == "желтый" && lights[0] == "красный"){
            lights[2] = "зеленый";
            lights[3] = "желтый";
        }
        else if (lights[1] == "желтый" && lights[0] == "зеленый"){
            lights[2] = "красный";
            lights[3] = "желтый";
        }
    }

    //"переключаем" цвета
    public void switchLights () {
        //цвета сдвигаются, наприм. {ж,к,ж,з} --> {к,ж,з,ж}
        String temp = lights[0];
        lights[0] = lights[1];
        lights[1] = lights[2];
        lights[2] = lights[3];
        lights[3] = temp;
    }

    public String getStatus (){
        return "до этого горел " + lights[0] + "\n" + "сейчас горит " +
                lights[1] + "\n" + "следующим загорится " + lights[2];
    }
}
