package daily;

import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {


    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(10);
        System.out.println(spreadsheet.getValue("=5+7"));

        spreadsheet.setCell("A1",10);

        System.out.println(spreadsheet.getValue("=A1+6"));

        spreadsheet.setCell("B2",15);

        System.out.println(spreadsheet.getValue("=A1+B2"));

        spreadsheet.resetCell("A1");

        System.out.println(spreadsheet.getValue("=A1+B2"));
    }

    Map<String, Integer> map = new HashMap<>();

    public Spreadsheet(int rows) {

    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.put(cell, 0);
    }

    public int getValue(String rawFormula) {
        String formula = rawFormula.substring(1, rawFormula.length());

        String op1 = formula.split("\\+")[0];
        String op2 = formula.split("\\+")[1];

        int val1=0;
        int val2=0;
        if (Character.isDigit(op1.charAt(0))) {
            val1=Integer.parseInt(op1);
        }else{
            val1 = map.getOrDefault(op1, 0);
        }

        if (Character.isDigit(op2.charAt(0))) {
            val2=Integer.parseInt(op2);
        }else{
            val2 = map.getOrDefault(op2, 0);
        }
        return val1+val2;
    }
}
