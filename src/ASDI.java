import java.util.List;
import java.util.Stack;

public class ASDI implements Parser{

    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;


    public ASDI(List<Token> tokens){
        Stack<String> pilita = new Stack<String>();
        pilita.push("$");
        pilita.push("Q");
        
        //programa de analisis sintactico predictivo

        // ip apunta al primersimbolo de w
        this.tokens = tokens;
        preanalisis = this.tokens.get(i);
        while(pilita.peek() != "$") {
            if (pilita.peek() == preanalisis) {
                
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
