package parsing;

public class Valute {
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;

    public Valute(String numCode, String charCode, int nominal, String name, double value){
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Valute(){

    }

    @Override
    public String toString(){
        String res = "";
        //res += "--------------------\n";
        //res += "Charcode: " + this.charCode + "\n";
        res += this.nominal + " " + this.name + " = " + this.value + " российских рубля." + "\n";
        return res;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
