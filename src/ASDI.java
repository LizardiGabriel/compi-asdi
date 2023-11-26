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
            preanalisis = this.tokens.get(i);
            if (pilita.peek().getTipo() == preanalisis.getTipo()) {
                pilita.pop();
                i++;
            }else if(pilita.peek().getTipo() != TipoToken.NoTerminal) {
                System.out.println("Error en sintaxis");
            }else if(M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()) == "--") {
                System.out.println("Error en sintaxis");
            }else{
                System.out.println(M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()));
                pilita.pop();
                String aux[] = M.getRule(pilita.peek().getLexema(), preanalisis.getTipo()).split(" ");
                for(int i = aux.length - 1; i >= 0; i--) {
                    if(aux[i] == "SELECT")
                        pilita.push(new Token(TipoToken.SELECT, "SELECT"));
                    if(aux[i] == "DISTINCT")
                        pilita.push(new Token(TipoToken.DISTINCT, "DISTINCT"));
                    if(aux[i] == "FROM")
                        pilita.push(new Token(TipoToken.FROM, "FROM"));
                    if(aux[i] == ",")
                        pilita.push(new Token(TipoToken.COMA, "COMA"));
                    if(aux[i] == "*")
                        pilita.push(new Token(TipoToken.ASTERISCO, "ASTERISCO"));
                    if(aux[i] == ".")
                        pilita.push(new Token(TipoToken.PUNTO, "PUNTO"));
                    if(aux[i] == "id")
                        pilita.push(new Token(TipoToken.IDENTIFICADOR, "IDENTIFICADOR"));
                    if(aux[i] == "E"){
                        //no hace nada
                    }
                       

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
