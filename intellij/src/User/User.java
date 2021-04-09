package User;

/**
 * Rappresenta un utente del gioco
 */
public class User {

    /**
     * il nome dell'utente
     */
    private String nome;

    /*  1 = Bianco
        0 = Nero
       */

    private int colore;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getColore() {
        return colore;
    }

    public void setColore(int colore) {
        this.colore = colore;
    }


}
