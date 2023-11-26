public class Tablita {
    private final String[][] table;

    public Tablita() {
        table = new String[11][8]; 
        //rellenar la tabla con --
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 8; j++){
                table[i][j] = "--";
            }
        }

        // rellenar la tabla
        table[getINT("Q")][getIT(TipoToken.SELECT)] = "Q -> SELECT D FROM T";
        table[getINT("A1")][getIT(TipoToken.FROM)] = "A1 -> E";
        table[getINT("A3")][getIT(TipoToken.FROM)] = "A3 -> E";
        table[getINT("D")][getIT(TipoToken.DISTINCT)] = "D -> DISTINCT P";
        table[getINT("D")][getIT(TipoToken.ASTERISCO)] = "D -> P";
        table[getINT("P")][getIT(TipoToken.ASTERISCO)] = "P -> *";
        table[getINT("A1")][getIT(TipoToken.COMA)] = "A1 -> , A";
        table[getINT("A3")][getIT(TipoToken.COMA)] = "A3 -> E";
        table[getINT("T1")][getIT(",")] = "T1 -> , T";
        table[getINT("T3")][getIT(",")] = "T3 -> E";

        table[getINT("D")][getIT("ID")] = "D -> P";
        table[getINT("P")][getIT("ID")] = "P -> A";
        table[getINT("A")][getIT("ID")] = "A -> A2 A1";
        table[getINT("A2")][getIT("ID")] = "A2 -> id A3";
        table[getINT("T")][getIT("ID")] = "T -> T2 T1";
        table[getINT("T2")][getIT("ID")] = "T2 -> id T3";
        table[getINT("T3")][getIT("ID")] = "T3 -> id";
        table[getINT("A3")][getIT(".")] = "A3 -> . id";
        table[getINT("T1")][getIT("$")] = "T1 -> E";
        table[getINT("T3")][getIT("$")] = "T3 -> E";

        
    }

    public String getRule(String state, TipoToken symbol) {
        return table[getINT(state)][getIT(symbol)];
    }

    // convertir el estado a un entero
    private int getINT(String state) {
        int ret = 11;
        if(state == "Q") ret = 0;
        if(state == "D") ret = 1;
        if(state == "P") ret = 2;
        if(state == "A") ret = 3;
        if(state == "A1") ret = 4;
        if(state == "A2") ret = 5;
        if(state == "A3") ret = 6;
        if(state == "T") ret = 7;
        if(state == "T1") ret = 8;
        if(state == "T2") ret = 9;
        if(state == "T3") ret = 10;

        return ret;

    }

    private int getIT(TipoToken symbol) {
        int ret = 0;
        if(symbol == TipoToken.SELECT) ret = 0;
        if(symbol == TipoToken.FROM) ret = 1;
        if(symbol == TipoToken.DISTINCT) ret = 2;
        if(symbol == TipoToken.ASTERISCO) ret = 3;
        if(symbol == TipoToken.COMA) ret = 4;
        if(symbol == TipoToken.IDENTIFICADOR) ret = 5;
        if(symbol == TipoToken.PUNTO) ret = 6;
        if(symbol == TipoToken.EOF) ret = 7;

        return ret;
    }
}