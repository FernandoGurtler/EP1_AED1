package main.java;

import main.java.pilha.Ingenua;
import main.java.pilha.ListaLigada.PilhaLigada;
import main.java.utils.PropertyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class AppStarter {

    static PropertyUtils propertyUtils = PropertyUtils.getInstance();


    public static void main(String[] args) throws IOException {
        setInputsAndOutputs();

        File folder = new File(propertyUtils.getProperty("input.entradas"));

        Arrays.stream(Objects.requireNonNull(folder.listFiles())).forEach(file -> {
            String entrada = readDocument(file.getAbsolutePath());
            entrada = entrada.replace("\n",";\n");
            String[] saida = entrada.split("\n");
            System.out.println("Fazendo a "+file.getName());

            Ingenua ingenua = new Ingenua();
            StringBuilder logIngenua = new StringBuilder();
            long antes = System.currentTimeMillis();
            for (String s : saida) {
                s=s.replace(";","");
                if (s.length()>1)
                    ingenua.add(Integer.parseInt(s));
                else logIngenua.append(ingenua.remove()).append("\n");
            }
            long totalIngenua = System.currentTimeMillis() - antes;

            PilhaLigada pilhaLigada = new PilhaLigada();
            StringBuilder logLigada = new StringBuilder();
            antes = System.currentTimeMillis();
            for (String s : saida) {
                s=s.replace(";","");
                if (s.length()>1)
                    pilhaLigada.add(Integer.parseInt(s));
                else logLigada.append(pilhaLigada.remove()).append("\n");
            }
            long totalLigada = System.currentTimeMillis() - antes;
            try {
                writeLog(new OutPut(logIngenua, totalIngenua,logLigada,totalLigada), file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Finalizado sem nenhuma exeption, verifique os logs e tempos em: " +propertyUtils.getProperty("output.logs"));
    }

    private static void setInputsAndOutputs() throws IOException {

        String path = ClassLoader.getSystemClassLoader().getResource("main/resources/").getPath();
        propertyUtils.setProperties("input.entradas", path + propertyUtils.getProperty("input.entradas"));
        propertyUtils.setProperties("output.logs", path + propertyUtils.getProperty("output.logs"));
        propertyUtils.setProperties("output.tempos", path+propertyUtils.getProperty("output.tempos"));
        Files.createDirectories(Paths.get(propertyUtils.getProperty("output.logs")));
        Files.createDirectories(Paths.get(propertyUtils.getProperty("output.tempos")));

    }


    private static String readDocument(String filename) {
        StringBuilder problem = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filename);
            while (fileReader.ready()) {
                problem.append(Character.toChars(fileReader.read()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return problem.toString();
    }

    private static int writeLog(OutPut outPut, String filename) throws IOException {

        String log = propertyUtils.getProperty("output.logs").concat(filename);
        String tempo = propertyUtils.getProperty("output.tempos").concat(filename);

        FileWriter fwLog = new FileWriter(log);
        FileWriter fwTime = new FileWriter(tempo);
        fwLog.write("Logs Ingenua:\n"+ outPut.getOutputIngenua()+"\n\n\n----------------------------------------------\n\n\n" +
                "Logs Ligada:\n"+ outPut.getOutputLigada() + "\n\n\n" +
                "Arquivos iguais: " +(outPut.getOutputIngenua().compareToIgnoreCase(outPut.getOutputLigada())==0?"Sim":"Não"));
        fwTime.write("Ingenua: 2"+ outPut.getTimeIngenua() +"\n" +
                "Ligada: "+ outPut.getTimeLigada());
        fwLog.flush();
        fwLog.close();
        fwTime.flush();
        fwTime.close();


        return 1;
    }

}
