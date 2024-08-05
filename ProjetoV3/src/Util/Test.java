package Util;


public class Test {
    public static void main(String[] args){
        String data = ("2003-03-26");
        System.out.println(Util.formatData(data));
        
        String data2 = ("26/03/2003");
        System.out.println(Util.stringToDate(data2, "dd/MM/yyyy"));
    }
}
