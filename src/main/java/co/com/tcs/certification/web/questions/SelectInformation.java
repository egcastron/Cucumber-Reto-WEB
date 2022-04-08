package co.com.tcs.certification.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class SelectInformation implements Question {
    @Override
    public Object answeredBy(Actor actor) {

        List<String> listSelectedInfo = new ArrayList<>();

        listSelectedInfo.add(actor.recall("infoProd0").toString());
        listSelectedInfo.add(actor.recall("infoProd1").toString());
        listSelectedInfo.add(actor.recall("infoProd2").toString());

        return listSelectedInfo;
    }

    public static SelectInformation info(){
        return new SelectInformation();
    }
}
