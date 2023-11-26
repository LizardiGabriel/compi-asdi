import java.util.List;
import java.util.Stack;

public class ASDI implements Parser{

    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;


    public ASDI(List<Token> tokens){
        Stack<Token> pilita = new Stack<Token>();
        pilita.push(new Token(TipoToken.EOF, "$"));
        pilita.push(new Token(TipoToken.NoTerminal, "Q"));
        Tablita M = new Tablita();
        
        //programa de analisis sintactico predictivo

        // ip apunta al primersimbolo de w
        this.tokens = tokens;
        while(pilita.peek().getTipo() != TipoToken.EOF) {
            preanalisis = tokens.get(i);
            //System.out.println(pilita.peek().getTipo());
            
            //System.out.println(preanalisis.getTipo());
            if (pilita.peek().getTipo() == preanalisis.getTipo()) {
                pilita.pop();
                i++;
            }else if(pilita.peek().getTipo() != TipoToken.NoTerminal) {
                hayErrores = true;
                break;
            }else if(M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()) == "--") {
                hayErrores = true;
                break;
            }else{
                //System.out.println("Sust: " + M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()));
                String aux[] = M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()).split(" ");
                pilita.pop();
                for(int j = aux.length - 1; j >= 0; j--) {
                    
                    if(aux[j].equals("SELECT")){
                        pilita.push(new Token(TipoToken.SELECT, "SELECT"));
                    }if(aux[j].equals("DISTINCT")){
                        pilita.push(new Token(TipoToken.DISTINCT, "DISTINCT"));
                    }if(aux[j].equals("FROM")){
                        pilita.push(new Token(TipoToken.FROM, "FROM"));
                    }if(aux[j].equals(",")){
                        pilita.push(new Token(TipoToken.COMA, ","));
                    }if(aux[j].equals("*")){
                        pilita.push(new Token(TipoToken.ASTERISCO, "*"));
                    }if(aux[j].equals(".")){
                        pilita.push(new Token(TipoToken.PUNTO, "."));
                    }if(aux[j].equals("id")){
                        pilita.push(new Token(TipoToken.IDENTIFICADOR, "IDENTIFICADOR"));
                    }if(aux[j].equals("D")){
                        pilita.push(new Token(TipoToken.NoTerminal, "D"));
                    }if(aux[j].equals("T")){
                        pilita.push(new Token(TipoToken.NoTerminal, "T"));
                    }if(aux[j].equals("P")){
                        pilita.push(new Token(TipoToken.NoTerminal, "P"));
                    }if(aux[j].equals("A")){
                        pilita.push(new Token(TipoToken.NoTerminal, "A"));
                    }if(aux[j].equals("A1")){
                        pilita.push(new Token(TipoToken.NoTerminal, "A1"));
                    }if(aux[j].equals("A2")){
                        pilita.push(new Token(TipoToken.NoTerminal, "A2"));
                    }if(aux[j].equals("A3")){
                        pilita.push(new Token(TipoToken.NoTerminal, "A3"));
                    }if(aux[j].equals("T1")){
                        pilita.push(new Token(TipoToken.NoTerminal, "T1"));
                    }if(aux[j].equals("T2")){
                        pilita.push(new Token(TipoToken.NoTerminal, "T2"));
                    }if(aux[j].equals("T3")){
                        pilita.push(new Token(TipoToken.NoTerminal, "T3"));   
                    }
                    //System.out.println(aux[j]);
                    
                }
                
            }
        }
        // X es el simbolo de la parte superior de la pila
        // mientras la pila no este vacía{
        // si X es no terminal, sacar de la pila y avanzar ip
        // si X es terminal -> error
        // si M[X, a] es una entrada de error -> error
        // si M[X, a] = Y1 Y2 ... Yk -> {
        //      enviar de salida la produccion X -> Y1 Y2 ... Yk, 
        //      sacar de la pila X y meter Yk, Yk-1, ..., Y1	en la pila con y1 en la parte superior
        // }
        // establecer X como el simbolo de la parte superior de la pila
        // }
        
    }

    @Override
    public boolean parse() {
        if(preanalisis.tipo == TipoToken.EOF && !hayErrores){
            System.out.println("Consulta correcta");
            return  true;
        }else {
            System.out.println("Se encontraron errores");
        }
        return false;
    }



    

}
