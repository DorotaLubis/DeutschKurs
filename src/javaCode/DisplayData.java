package javaCode;

import java.util.ArrayList;
import java.util.Random;

public class DisplayData {

    private Random random = new Random();
    private ArrayList<Tasks> allPhraseFromLessons;
    private int randomInt;
    private String plDesc;
    private String geDesc;
    private int correctAns;
    private int wrongAns;
    private int percent;
    private String corrOrNotAns;
    private String geDescToLabel;
    private int oryginalListSize;

    public int getOryginalListSize() {
        return oryginalListSize;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public String geDescToLabel() {
        return geDescToLabel;
    }

    public String getCorrOrNotAns() {
        return corrOrNotAns;
    }

    public void displayAllData(String lesson){
     String partOfPathFromButton = lesson;
     String format = ".csv";
     String path = "src/resources/" + partOfPathFromButton + format;
     ReadDataToObject readDataToObject = new ReadDataToObject();

     correctAns = 0;
     wrongAns = 0;
     percent = 0;

     allPhraseFromLessons = readDataToObject.readFile(path);
     oryginalListSize = readDataToObject.getListSize();
     randomNextPhrase();
    }

    private int randomNumber(ArrayList<Tasks> list){
        int randomInt = random.nextInt(list.size());
        return randomInt;
    }

    private void collectPhraseFromList(ArrayList<Tasks> list, int random){
        String plPhrase = list.get(random).getDescPl();
        String gePhrase = list.get(random).getDescGe();

        plDesc = plPhrase;
        geDesc = gePhrase;
    }

    public String displayPlDesc(){
        if(plDesc == null){
            return "Koniec lekcji";
        }
        else{
            return plDesc;
        }
    }

    public void collectGeData(String gePhrase){
        if (allPhraseFromLessons.size() == 0){
            plDesc = "Koniec lekcji!";
            corrOrNotAns = "";
            geDescToLabel = "";
        }
        else {
            if (gePhrase.equals(geDesc)){
                removeCorrectAnswerFromList();
                correctAns++;
                corrOrNotAns = "Dobra odpowiedź!";
                geDescToLabel = "";
            }
            else {
                wrongAns++;
                corrOrNotAns = "Poprawna odpowiedź to:";
                geDescToLabel = geDesc;
            }
            percent = (100*correctAns)/(correctAns+wrongAns);
            randomNextPhrase();
        }
    }

    private void removeCorrectAnswerFromList(){
        allPhraseFromLessons.remove(randomInt);
    }

    private void randomNextPhrase(){
        if (allPhraseFromLessons.size() == 0) {
            plDesc = "Koniec lekcji!";
        }
        else {
            randomInt = randomNumber(allPhraseFromLessons); //losujemy wyrazenie
            collectPhraseFromList(allPhraseFromLessons, randomInt); //pobieramy wyrazenie z listy
        }
    }

    public String getCorrectAnsAsString(){
        String corrAns = "";
        corrAns = corrAns.valueOf(correctAns);
        return  corrAns;
    }

    public String getWrongAnsAsString(){
        String wrongAnswer = "";
        wrongAnswer = wrongAnswer.valueOf(wrongAns);
        return  wrongAnswer;
    }

    public String getPercentAsString(){
        String currentPercent = "";
        currentPercent = currentPercent.valueOf(percent);
        return percent+"%";
    }

}
