package br.uem.backendspringboot.functions;

import org.springframework.data.convert.Jsr310Converters;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Conversions {

    public LocalDate stringToLocalDateConverter(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            LocalDate localDate = LocalDate.parse(data, formatter);
            return localDate;
        } catch (DateTimeParseException e) {
            System.out.println("Erro na conversao: " + e.getMessage());
            return null;
        }
    }

    public String dateToString(Date data){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formatter.format(data);
            return dataFormatada;
        } catch (DateTimeParseException e) {
            System.out.println("Erro na conversao: " + e.getMessage());
            return null;
        }

    }
}
