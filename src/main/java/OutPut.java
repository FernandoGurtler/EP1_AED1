package main.java;

public class OutPut {
    private String outputIngenua;
    private String timeIngenua;
    private String outputLigada;
    private String timeLigada;


    public String getOutputLigada() {
        return outputLigada;
    }

    public void setOutputLigada(String outputLigada) {
        this.outputLigada = outputLigada;
    }

    public String getTimeLigada() {
        return timeLigada;
    }

    public void setTimeLigada(String timeLigada) {
        this.timeLigada = timeLigada;
    }

    public OutPut(StringBuilder outputIngenua, long timeIngenua, StringBuilder outputLigada, long timeLigada) {
        this.outputIngenua = outputIngenua.toString();
        this.timeIngenua = timeIngenua + " ms";
        this.outputLigada = outputLigada.toString();
        this.timeLigada = timeLigada + " ms";
    }

    public String getOutputIngenua() {
        return outputIngenua;
    }

    public void setOutputIngenua(String outputIngenua) {
        this.outputIngenua = outputIngenua;
    }

    public String getTimeIngenua() {
        return timeIngenua;
    }

    public void setTimeIngenua(String timeIngenua) {
        this.timeIngenua = timeIngenua;
    }
}
